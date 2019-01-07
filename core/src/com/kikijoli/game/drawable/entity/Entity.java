/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.game.drawable.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.kikijoli.game.abstracts.AbstractAction;
import com.kikijoli.game.automation.None;
import com.kikijoli.game.buisiness.AbstractBuisiness;
import com.kikijoli.game.interfaces.ICreate;
import com.kikijoli.game.interfaces.IDrawable;
import com.kikijoli.game.shader.AbstractShader;
import com.kikijoli.game.util.TextureUtil;

/**
 *
 * @author troïmaclure
 */
public abstract class Entity<T> extends Sprite implements IDrawable, ICreate<T> {

    public AbstractAction action = new None();
    public AbstractShader shader;
    public boolean visible = true;
    public AbstractBuisiness buisiness;
    public Body body;

    public Entity(String path, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(TextureUtil.getTexture(path), srcX, srcY, srcWidth, srcHeight);
        this.setX(srcX);
        this.setY(srcY);
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(this.getTexture(), this.getX(), this.getY(), this.getWidth(), this.getHeight());
    }

}
