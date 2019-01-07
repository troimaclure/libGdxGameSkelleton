package com.kikijoli.game;

import com.badlogic.gdx.Game;
import com.kikijoli.game.maps.Tmap;
import com.kotcrab.vis.ui.VisUI;

public class GameSkeleton extends Game {

    @Override
    public void create() {
        VisUI.load();
        setScreen(new Tmap());
    }

    @Override
    public void render() {
        super.render();
    }

}
