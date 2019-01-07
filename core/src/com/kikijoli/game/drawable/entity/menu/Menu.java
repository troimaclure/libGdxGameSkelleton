/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.game.drawable.entity.menu;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.kikijoli.game.interfaces.IDrawable;
import java.util.ArrayList;

/**
 *
 * @author Administrateur
 */
public class Menu extends Vector2 implements IDrawable {

    ArrayList<MenuItem> menuItems = new ArrayList<>();

    @Override
    public void draw(SpriteBatch batch) {
        menuItems.forEach((menuItem) -> {
            menuItem.draw(batch, this);
        });
    }

}
