/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.game.shader;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.kikijoli.game.drawable.entity.Entity;

/**
 *
 * @author troïmaclure
 */
public class WaveShader extends AbstractShader {

    public float amplitudeWave = 2.075f;
    public float angleWave = 360.0f;
    public float angleWaveSpeed = 2f;
    public final float PI2 = 3.1415926535897932384626433832795f * 2.0f;

    public WaveShader() {
        super(new FileHandle("glsl/wave/vertex.glsl"), new FileHandle("glsl/wave/frag.glsl"));
    }

    public WaveShader(Entity entite) {
        super(new FileHandle("glsl/wave/vertex.glsl"), new FileHandle("glsl/wave/frag.glsl"), entite);
    }

    @Override
    public void step(float rawTime) {
        final float dt = Gdx.graphics.getRawDeltaTime();
        angleWave += dt * angleWaveSpeed;
        while (angleWave > PI2) {
            angleWave -= PI2;
        }
        this.begin();
        this.setUniformf("waveData", angleWave, amplitudeWave);
        this.end();
    }
}
