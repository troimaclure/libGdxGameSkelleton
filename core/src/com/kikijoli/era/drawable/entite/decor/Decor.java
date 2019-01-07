/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.era.drawable.entite.decor;

import com.kikijoli.era.drawable.entity.Entity;

/**
 *
 * @author troïmaclure
 */
public abstract class Decor extends Entity {

    public Decor(String path, int srcX, int srcY, int srcWidth, int srcHeight) {
        super(path, srcX, srcY, srcWidth, srcHeight);
    }

}
