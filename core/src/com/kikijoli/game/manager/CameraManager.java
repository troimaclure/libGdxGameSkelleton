/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.game.manager;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.kikijoli.game.listeners.GeneralKeyListener;
import static com.kikijoli.game.maps.Tmap.worldCoordinates;
import com.kikijoli.game.util.Constantes;

/**
 *
 * @author troïmaclure
 */
public class CameraManager {

    public static OrthographicCamera camera;

    public static void initialize(int x, int y) {
        camera = new OrthographicCamera(Constantes.SCREENWIDTH, Constantes.SCREENHEIGHT);
        camera.position.x = x;
        camera.position.y = y;
        camera.update();

    }

    public static void tour() {
        camera.unproject(worldCoordinates);
        if (GeneralKeyListener.KeyLeft) {
            camera.translate(-5, 0);
        } else if (GeneralKeyListener.KeyRight) {
            camera.translate(5, 0);
        }
        if (GeneralKeyListener.KeyDown) {
            camera.translate(0, -5);
        } else if (GeneralKeyListener.KeyUp) {
            camera.translate(0, 5);
        }
        camera.update();
    }
}
