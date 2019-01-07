package com.kikijoli.era;

import com.badlogic.gdx.Game;
import com.kikijoli.era.maps.Tmap;
import com.kotcrab.vis.ui.VisUI;
import de.tomgrill.gdxdialogs.core.GDXDialogs;
import de.tomgrill.gdxdialogs.core.GDXDialogsSystem;

public class Era extends Game {

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
