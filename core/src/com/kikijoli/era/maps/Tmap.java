/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.era.maps;

import box2dLight.Light;
import box2dLight.PointLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kikijoli.era.drawable.entity.SquareEntity;
import com.kikijoli.era.listeners.GeneralKeyListener;
import com.kikijoli.era.manager.CameraManager;
import static com.kikijoli.era.manager.CameraManager.camera;
import com.kikijoli.era.manager.EntiteManager;
import com.kikijoli.era.manager.MessageManager;
import com.kikijoli.era.manager.ParticleManager;
import com.kikijoli.era.manager.ShaderManager;
import com.kikijoli.era.manager.StageManager;
import com.kikijoli.era.util.Constantes;
import java.util.ArrayList;

/**
 *
 * @author troïmaclure
 */
public class Tmap implements Screen {

    public static World world;
    public static RayHandler ray;
    public static ArrayList<Light> lights = new ArrayList<>();
    public static ShapeRenderer shapeRenderer;
    public static SpriteBatch spriteBatch;
    public static Vector3 worldCoordinates = new Vector3();
    public static Stage stage;
    public static FPSLogger fps;
    public static Light light;
    public static Light light2;

    public Tmap() {
    }

    @Override
    public void show() {
        fps = new FPSLogger();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
        spriteBatch = new SpriteBatch();
        StageManager.initialize();
        Gdx.input.setInputProcessor(new InputMultiplexer(StageManager.getStage(), new GeneralKeyListener()));
        light = new PointLight(getRay(), 2500, Color.WHITE, 800, 50, 50);
        light.setXray(true);
        light2 = new PointLight(getRay(), 2500, Color.WHITE, 400, 50, 50);
        light2.setSoft(true);
        CameraManager.initialize(Constantes.TILESIZE * 15, Constantes.TILESIZE * 10);
        test();

    }

    @Override
    public void render(float delta) {
        fps.log();

        world.step(delta, 0, 0);
        ShaderManager.step();
        Gdx.gl.glClearColor(Color.GRAY.r, Color.GRAY.g, Color.GRAY.b, Color.GRAY.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        worldCoordinates = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        CameraManager.tour();

        spriteBatch.setProjectionMatrix(camera.combined);
        shapeRenderer.setProjectionMatrix(camera.combined);
        getRay().setCombinedMatrix(camera.combined,
                camera.position.x, camera.position.y,
                camera.viewportWidth * camera.zoom,
                camera.viewportHeight * camera.zoom);

        spriteBatch.begin();
        MessageManager.drawIndicators();
        EntiteManager.tour();
        ParticleManager.tour(delta);

        spriteBatch.flush();
        spriteBatch.end();
        getRay().updateAndRender();

    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }

    public static RayHandler getRay() {
        if (ray == null) {
            RayHandler.useDiffuseLight(true);
            RayHandler.setGammaCorrection(true);
            ray = new RayHandler(getWorld());
//            ray.setAmbientLight(new Color(0.5f, 0.5f, 0.5f, 1.0f));
        }
        return ray;
    }

    public static World getWorld() {
        if (world == null) {
            world = new World(new Vector2(0, 0), true);

        }
        return world;
    }

    private void test() {
        EntiteManager.currentBuild = new SquareEntity(0, 0);
        getRay().setAmbientLight(Color.BLACK);

        this.ray.setCulling(true);

    }

}
