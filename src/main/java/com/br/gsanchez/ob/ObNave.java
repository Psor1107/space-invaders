package com.br.gsanchez.ob;

import com.br.gsanchez.engine.Processador;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class ObNave extends ObObjeto {

    public ObNave() {
    }

    public ObNave(int x, int y, int id, int vida, Processador proces, int largura, int altura) {
        super(x, y, id, vida, proces, largura, altura);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        colisao();
        if (vida <= 0) {
            proces.removeObjeto(this);
            proces.setP(0);
        }
    }

    @Override
    public void render(Graphics g) {
        Color corNaveD = new Color(234, 255, 55);
        g.setColor(corNaveD);
        g.fillRect(x - 33, y + 35, 5, 5);
        g.fillRect(x - 18, y + 25, 5, 5);
        g.fillRect(x - 13, y + 60, 5, 5);
        g.fillRect(x - 8, y + 55, 5, 5);
        g.fillRect(x - 8, y + 45, 5, 5);
        g.fillRect(x - 3, y + 35, 5, 10);
        g.fillRect(x + 2, y + 45, 5, 5);
        g.fillRect(x + 2, y + 55, 5, 5);
        g.fillRect(x + 7, y + 60, 5, 5);
        g.fillRect(x + 12, y + 25, 5, 5);
        g.fillRect(x + 27, y + 35, 5, 5);

        Color corNave = new Color(107, 26, 248);
        g.setColor(corNave);
        g.fillRect(x - 33, y + 40, 5, 15);
        g.fillRect(x - 33, y + 50, 65, 5);
        g.fillRect(x - 23, y + 45, 15, 15);
        g.fillRect(x - 18, y + 30, 5, 15);
        g.fillRect(x - 13, y + 40, 10, 5);
        g.fillRect(x - 8, y + 20, 5, 20);
        g.fillRect(x - 3, y + 0, 5, 35);
        g.fillRect(x - 3, y + 45, 5, 5);
        g.fillRect(x - 3, y + 55, 5, 10);
        g.fillRect(x + 2, y + 20, 5, 25);
        g.fillRect(x + 7, y + 40, 5, 20);
        g.fillRect(x + 12, y + 30, 5, 30);
        g.fillRect(x + 17, y + 45, 5, 15);
        g.fillRect(x + 27, y + 40, 5, 15);
        //g.setColor(Color.white);
        //g.drawRect(x - 33, y, 65, 65);
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
        return new Rectangle(x-33, y, 65, 65);
    }

    @Override
    public void colisao() {
        if (this.getHitBox().intersectsLine(0, altura-(altura/4), largura, altura-(altura/4))) {
            this.setY(altura-(altura/4));
        }
        if (this.getHitBox().intersectsLine(0, altura - 40, largura, altura - 40)) {
            this.setY(altura - 104);
        }
        if (this.getHitBox().intersectsLine(0, 0, 0, altura)) {
            this.setX(33);
        }
        if (this.getHitBox().intersectsLine(largura - 16, 0, largura - 16, altura)) {
            this.setX(largura - 64 - 16 + 33);
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

    public void atirar() {
        proces.addObjeto(new ObProjetil(x - 3, y - 16, 0, -12, 3, 2, proces, largura, altura));
    }

}
