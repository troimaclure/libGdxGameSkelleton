/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.game.shader;

import com.badlogic.gdx.files.FileHandle;
import com.kikijoli.game.manager.ShaderManager;

/**
 *
 * @author troïmaclure
 */
public class InvertColorShader extends AbstractShader {

    public InvertColorShader() {
        super(new FileHandle("glsl/invert_color/vertex.glsl"), new FileHandle("glsl/invert_color/frag.glsl"));
    }

    @Override
    public void step(float rawTime) {
    }

}
