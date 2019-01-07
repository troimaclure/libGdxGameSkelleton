/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.era.manager;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.kotcrab.vis.ui.layout.GridGroup;
import com.kotcrab.vis.ui.widget.VisTextButton;
import com.kotcrab.vis.ui.widget.VisWindow;

/**
 *
 * @author troïmaclure
 */
public class StageManager {

    public static Stage stage;
    public static VisWindow window = new VisWindow("Choix des constructions");

    public static Stage getStage() {
        return stage;
    }

    public static void initialize() {
        stage = new Stage();
//        stage.addActor(new VisScrollPane(new VisTable(true)));
////        stage.addActor(new VisDialog("coucou")); 
//
//        window.setX(stage.getWidth() - 300);
//        window.setHeight(stage.getHeight());
//        window.setY(stage.getHeight());
//        window.setWidth(300);
//
//        init();
//        stage.addActor(window);
    }

    public static void tour() {
        stage.act();
        stage.draw();
    }

    private static void init() {

        GridGroup group = new GridGroup(64, 8);

        group.addActor(new VisTextButton("one column"));
        group.addActor(new VisTextButton("one row"));

        group.addActor(new VisTextButton("one row"));
        group.addActor(new VisTextButton("grid"));
        group.addActor(new VisTextButton("one column"));
        group.addActor(new VisTextButton("one row"));

        group.addActor(new VisTextButton("one row"));
        group.addActor(new VisTextButton("grid"));
        group.addActor(new VisTextButton("one column"));
        group.addActor(new VisTextButton("one row"));

        group.addActor(new VisTextButton("one row"));
        group.addActor(new VisTextButton("grid"));
        group.addActor(new VisTextButton("one column"));
        group.addActor(new VisTextButton("one row"));

        group.addActor(new VisTextButton("one row"));
        group.addActor(new VisTextButton("grid"));
        group.addActor(new VisTextButton("one column"));
        group.addActor(new VisTextButton("one row"));

        group.addActor(new VisTextButton("one row"));
        group.addActor(new VisTextButton("grid"));
        group.addActor(new VisTextButton("one column"));
        group.addActor(new VisTextButton("one row"));

        group.addActor(new VisTextButton("one row"));
        group.addActor(new VisTextButton("grid"));
        group.addActor(new VisTextButton("one column"));
        group.addActor(new VisTextButton("one row"));

        group.addActor(new VisTextButton("one row"));
        group.addActor(new VisTextButton("grid"));
        group.addActor(new VisTextButton("one column"));
        group.addActor(new VisTextButton("one row"));

        group.addActor(new VisTextButton("one row"));
        group.addActor(new VisTextButton("grid"));
        group.addActor(new VisTextButton("one column"));
        group.addActor(new VisTextButton("one row"));

        group.setX(50);
        group.setSize(300, stage.getHeight());

        window.add(group);

    }

}
