package com.br.gsanchez.engine;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Jogo extends Canvas implements Runnable {
    
    private boolean ativo;
    private Processador proces;
    private double taxaUpdate = 1.0d/30.0d;
    
    private long proxStats;
    private int fps, ups;
    
    private int largura, altura;

    public Jogo(int altura, int largura, boolean ativo, Processador proces) {
        this.proces = proces;
        this.ativo = ativo;
        this.altura = altura;
        this.largura = largura;
    }
    
    @Override
    public void run() {
        ativo = true;
        double acumulador = 0;
        long tempoAtual, ultimoUpdate = System.currentTimeMillis();
        
        while(ativo){
            tempoAtual = System.currentTimeMillis();
            double ultimoRender = (tempoAtual - ultimoUpdate) / 1000d;
            acumulador += ultimoRender;
            ultimoUpdate = tempoAtual;
            
            while(acumulador > taxaUpdate){
                update();
                acumulador -= taxaUpdate;
            }
            render();
            printStatus();
        }
    }
    
    private void printStatus(){
        if(System.currentTimeMillis() > proxStats){
            System.out.println(String.format("UPS = %d, FPS = %d", fps, ups));
            fps = 0; ups = 0;
            proxStats = System.currentTimeMillis() + 1000;
        }
    }
    
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.black);
        g.fillRect(0, 0, altura, largura);
        g.setColor(Color.white);
        g.drawLine(0, altura+(altura/3), largura, altura+((altura/3)));
        
        proces.render(g);
        
        g.dispose();
        bs.show();
        fps++;
    }
    
    private void update(){
        proces.tick();
        ups++;
    }
    
}
