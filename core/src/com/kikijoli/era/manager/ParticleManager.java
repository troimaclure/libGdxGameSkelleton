/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.era.manager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.kikijoli.era.maps.Tmap;
import static com.kikijoli.era.maps.Tmap.spriteBatch;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author troïmaclure
 */
public class ParticleManager {

    private static HashMap<String, ParticleEffect> particles = new HashMap<>();
    private static ArrayList<ParticleEffect> particleEffects = new ArrayList<>();

    public static ParticleEffect addParticle(String path, float x, float y, float scale) {
        ParticleEffect efft = null;
        if (!particles.containsKey(path)) {
            efft = new ParticleEffect();
            efft.load(Gdx.files.internal(path), Gdx.files.internal(""));
            particles.put(path, efft);
        } else {
            efft = new ParticleEffect(particles.get(path));
        }

        efft.reset(true);
        efft.scaleEffect(scale);

        efft.getEmitters().first().setPosition(x, y);
        particleEffects.add(efft);
        return efft;
    }

    public static ArrayList<ParticleEffect> getParticleEffects() {
        return (ArrayList<ParticleEffect>) particleEffects.clone();
    }

    public static void tour(float delta) {
        Color c = spriteBatch.getColor();

        ParticleManager.getParticleEffects().stream().map((par) -> {
            par.update(delta);
            return par;
        }).map((par) -> {
            par.draw(Tmap.spriteBatch);
            return par;
        }).filter((par) -> (par.isComplete())).forEachOrdered((par) -> {
            particleEffects.remove(par);
        });
        spriteBatch.setColor(c);
    }
}
