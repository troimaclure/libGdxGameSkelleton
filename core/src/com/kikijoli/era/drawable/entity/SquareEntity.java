/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kikijoli.era.drawable.entity;

import com.kikijoli.era.interfaces.ICreate;
import com.kikijoli.era.util.Constantes;

/**
 *
 * @author Administrateur
 */
public class SquareEntity extends Entity<SquareEntity> implements ICreate<SquareEntity> {

    public SquareEntity(int srcX, int srcY) {
        super("sprite/square.png", srcX, srcY, Constantes.TILESIZE, Constantes.TILESIZE);
    }

    @Override
    public SquareEntity create(float x, float y) {
        return new SquareEntity((int) x, (int) y);
    }

}
