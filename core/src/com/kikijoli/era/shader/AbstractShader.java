/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.era.shader;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.kikijoli.era.drawable.entity.Entity;

/**
 *
 * @author troïmaclure
 */
public abstract class AbstractShader extends ShaderProgram {

    public Entity entite;
    public boolean global;

    public AbstractShader(FileHandle vertexShader, FileHandle fragmentShader) {
        super(vertexShader, fragmentShader);
        this.global = true;
    }

    public AbstractShader(FileHandle vertexShader, FileHandle fragmentShader, Entity entite) {
        super(vertexShader, fragmentShader);
        this.entite = entite;
    }

    public abstract void step(float rawTime);

}
