/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.game.manager;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.kikijoli.game.maps.Tmap;
import com.kikijoli.game.util.Constantes;
import java.util.ArrayList;
import net.dermetfan.gdx.scenes.scene2d.ui.ScrollPaneSnapAction.Indicator;

/**
 *
 * @author troïmaclure
 */
public class MessageManager {

    public static BitmapFont segoe = new BitmapFont(new FileHandle("font/segoeui.fnt"));
    public static ArrayList<Indicator> indicators = new ArrayList<>();

    public static void addIndicator(float x, float y, String message, Texture texture) {
    }

    public static void drawIndicators() {

    }

    private static ArrayList<Indicator> getIndicators() {
        return (ArrayList<Indicator>) indicators.clone();
    }

}
