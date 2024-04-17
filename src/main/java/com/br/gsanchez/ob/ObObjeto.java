package com.br.gsanchez.ob;

import com.br.gsanchez.engine.Processador;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class ObObjeto {
    
    protected int x, y;
    protected int velX, velY;
    protected int id; // 1 = Jogador, 2 = Inimigos...
    protected int vida;
    protected Processador proces;
    protected int largura, altura;

    public ObObjeto() {
    }

    public ObObjeto(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public ObObjeto(int x, int y, int id, int vida, Processador proces) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.vida = vida;
        this.proces = proces;
    }
    
    public ObObjeto(int x, int y, int velX, int velY, int id, int vida, Processador proces) {
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;
        this.id = id;
        this.vida = vida;
        this.proces = proces;
    }

    public ObObjeto(int x, int y, int id, int vida, Processador proces, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.vida = vida;
        this.proces = proces;
        this.largura = largura;
        this.altura = altura;
    }

    public ObObjeto(int x, int y, int velX, int velY, int id, int vida, Processador proces, int largura, int altura) {
        this.x = x;
        this.y = y;
        this.velX = velX;
        this.velY = velY;
        this.id = id;
        this.vida = vida;
        this.proces = proces;
        this.largura = largura;
        this.altura = altura;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getHitBox();
    public abstract void colisao();
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
