package com.kikijoli.era.manager;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.kikijoli.era.drawable.entity.Entity;
import com.kikijoli.era.maps.Tmap;
import static com.kikijoli.era.maps.Tmap.spriteBatch;
import static com.kikijoli.era.maps.Tmap.worldCoordinates;
import com.kikijoli.era.shader.ClickShader;
import java.util.ArrayList;

/**
 *
 * @author troïmaclure
 */
public class EntiteManager {

    public static ArrayList<Entity> entites = new ArrayList<>();
    public static Entity currentBuild;

    public static ArrayList<Entity> getEntites() {
        return (ArrayList<Entity>) entites.clone();
    }

    public static void addEntite(Entity entite) {
        entites.add(entite);
        BodyDef bd = new BodyDef();
        bd.position.set(entite.getX() + entite.getWidth() / 2, entite.getY() + entite.getHeight() / 2);
        bd.type = BodyDef.BodyType.DynamicBody;
        Body d = Tmap.world.createBody(bd);

        entite.body = d;
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(entite.getWidth() / 2, entite.getHeight() / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 500f;
        Fixture fixture = entite.body.createFixture(fixtureDef);

        // Shape is the only disposable of the lot, so get rid of it
        shape.dispose();
    }

    public static void tour() {
        Color c = spriteBatch.getColor();

        entites.stream().forEach((Entity entite) -> {
            spriteBatch.setShader(entite.shader);

            if (entite.visible) {
                entite.draw(spriteBatch);
            }
            if (entite.action != null) {
                entite.action.act();
            }
            if (entite.buisiness != null) {
                entite.buisiness.act();
            }
            spriteBatch.setShader(ShaderManager.defaultShader);
        });
        if (EntiteManager.currentBuild != null) {
            EntiteManager.currentBuild.setPosition(worldCoordinates.x, worldCoordinates.y);
            EntiteManager.currentBuild.draw(spriteBatch);
        }
        spriteBatch.setColor(c);
    }

    public static void clickHover() {
        if (currentBuild != null) {
            EntiteManager.addEntite((Entity) EntiteManager.currentBuild.create(Tmap.worldCoordinates.x, Tmap.worldCoordinates.y));
        }
        Rectangle r = new Rectangle(Tmap.worldCoordinates.x, Tmap.worldCoordinates.y, 1, 1);
        getEntites().stream().filter((entite) -> (entite.getBoundingRectangle().overlaps(r))).forEachOrdered((entite) -> {
            entite.shader = new ClickShader(entite, entite.shader);
        });
    }

    public static void rightClick() {
        EntiteManager.currentBuild = null;
    }

}
