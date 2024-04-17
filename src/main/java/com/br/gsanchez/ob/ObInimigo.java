package com.br.gsanchez.ob;

import com.br.gsanchez.engine.Processador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ObInimigo extends ObObjeto {

    public ObInimigo() {
    }

    public ObInimigo(int x, int y, int velX, int velY, int id, int vida, Processador proces, int largura, int altura) {
        super(x, y, velX, velY, id, vida, proces, largura, altura);
    }

    private long a = 0;
    
    @Override
    public void tick() {
        x += velX;
        y += velY;
        colisao();
        if(System.currentTimeMillis() > a){
            atirar();
            a = (long) (System.currentTimeMillis() + Math.floor(Math.random()*(3000-1000+1)+1000));
        }
        if (vida <= 0) {
            proces.removeObjeto(this);
        }
    }

    @Override
    public void render(Graphics g) {
        Color corInimigo = new Color(246, 0, 147, 255);
        g.setColor(corInimigo);
        g.fillRect(x - 16, y + 21, 3, 9);
        g.fillRect(x - 13, y + 18, 3, 6);
        g.fillRect(x - 10, y + 9, 3, 3);
        g.fillRect(x - 10, y + 15, 3, 15);
        g.fillRect(x - 7, y + 12, 3, 6);
        g.fillRect(x - 7, y + 21, 3, 6);
        g.fillRect(x - 7, y + 30, 6, 3);
        g.fillRect(x - 4, y + 15, 3, 12);
        g.fillRect(x - 1, y + 15, 3, 12);
        g.fillRect(x + 2, y + 15, 3, 12);
        g.fillRect(x + 2, y + 30, 6, 3);
        g.fillRect(x + 5, y + 12, 3, 6);
        g.fillRect(x + 5, y + 21, 3, 6);
        g.fillRect(x + 8, y + 9, 3, 3);
        g.fillRect(x + 8, y + 15, 3, 15);
        g.fillRect(x + 11, y + 18, 3, 6);
        g.fillRect(x + 14, y + 21, 3, 9);
        /*
        g.setColor(Color.white);
        g.drawRect(x - 17, y, 33, 33);

        g.drawRect(x - 75, y, 150, 150);
        */
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getVelX() {
        return velX;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public int getVelY() {
        return velY;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }

    @Override
    public Rectangle getHitBox() {
        return new Rectangle(x - 17, y, 33, 33);
    }

    @Override
    public void colisao() {
        if (this.getHitBox().intersects(new Rectangle(0, altura - 200, largura, altura))) {
            proces.setP(0);
        }
        if (this.getHitBox().intersectsLine(0, 0, 0, altura)) {
            this.setVelX((-1) * velX);
            this.setY(y + 100);
        }
        if (this.getHitBox().intersectsLine(largura - 16, 0, largura - 16, altura)) {
            this.setVelX((-1) * velX);
            this.setY(y + 100);
        }
        for (int i = 0; i < proces.getObjeto().size(); i++) {
            ObObjeto tempObjeto = proces.getObjeto().get(i);
            if (tempObjeto.getId() != this.id && tempObjeto.getId() != 4) {
                if (tempObjeto.getHitBox().intersects(this.getHitBox())) {
                    this.vida--;
                }
            }
        }
    }

    public void atirar() {
        ObProjetil proj = new ObProjetil(x, y + 34, 0, 5, 4, 2, proces, largura, altura);
        proces.addObjeto(proj);
    }
}
