package com.br.gsanchez.ob;

import com.br.gsanchez.engine.Processador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ObProjetil extends ObObjeto {

    public ObProjetil(int x, int y, int id, int vida, Processador proces) {
        super(x, y, id, vida, proces);
    }

    public ObProjetil(int x, int y, int velX, int velY, int id, int vida, Processador proces, int largura, int altura) {
        super(x, y, velX, velY, id, vida, proces, largura, altura);
    }

    @Override
    public void tick() {
        y += velY;
        colisao();
        if (vida <= 0) {
            proces.removeObjeto(this);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 4, 8);
    }

    @Override
    public Rectangle getHitBox() {
        return new Rectangle(x, y, 4, 8);
    }

    @Override
    public void colisao() {
        if(this.getHitBox().intersectsLine(0, 0, largura, 0)){
            proces.removeObjeto(this);
        }
        if(this.getHitBox().intersectsLine(0, altura, largura, altura)){
            proces.removeObjeto(this);
        }
        if(this.getHitBox().intersectsLine(0, 0, 0, altura)){
            proces.removeObjeto(this);
        }
        if(this.getHitBox().intersectsLine(largura, 0, largura, altura)){
            proces.removeObjeto(this);
        }
        for (int i = 0; i < proces.getObjeto().size(); i++) {
            ObObjeto tempObjeto = proces.getObjeto().get(i);
            if (tempObjeto.getId() != this.id) {
                if (tempObjeto.getHitBox().intersects(this.getHitBox())) {
                    this.vida--;
                }
            }
        }
    }
}

