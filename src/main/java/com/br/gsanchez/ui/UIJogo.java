package com.br.gsanchez.ui;

import com.br.gsanchez.engine.Inicio;
import com.br.gsanchez.engine.Jogo;

import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import javax.swing.*;


public class UIJogo extends Canvas {

    private JFrame janela;
    private Inicio context;
    private int largura, altura;
    private int fase = 0;
    
    public UIJogo(int largura, int altura, Jogo jogo, Inicio context) {
        this.context = context;
        this.largura = largura;
        this.altura = altura;
        
        janela = new JFrame("Space Invaders");
        
        janela.setPreferredSize(new Dimension(largura, altura));
        janela.setMaximumSize(new Dimension(largura, altura));
        janela.setMinimumSize(new Dimension(largura, altura));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
        janela.setLocationRelativeTo(null);
        janela.add(jogo);
        janela.setVisible(true);
    }

    public void vitoria() {
        if (fase == 0 ){
            URL imageUrl = ClassLoader.getSystemResource("Fase1.png");
            JLabel picLabel = new JLabel(new ImageIcon(imageUrl));
            AWTEventListener myListener = new AWTEventListener() {

                @Override
                public void eventDispatched(AWTEvent event) {
                    if (event instanceof KeyEvent) {
                        ((KeyEvent) event).consume();
                    }
                }
            };
            Toolkit.getDefaultToolkit().addAWTEventListener(myListener, AWTEvent.KEY_EVENT_MASK);
            JOptionPane.showMessageDialog(null, picLabel, "Vitoria", JOptionPane.PLAIN_MESSAGE, null);
            Toolkit.getDefaultToolkit().removeAWTEventListener(myListener);

            fase++;
            context.insereInimigos2();
            return;
        }
        if (fase == 1){
            URL imageUrl = ClassLoader.getSystemResource("Fase2.png");
            JLabel picLabel = new JLabel(new ImageIcon(imageUrl));
            AWTEventListener myListener = new AWTEventListener() {

                @Override
                public void eventDispatched(AWTEvent event) {
                    if (event instanceof KeyEvent) {
                        ((KeyEvent) event).consume();
                    }
                }
            };
            Toolkit.getDefaultToolkit().addAWTEventListener(myListener, AWTEvent.KEY_EVENT_MASK);
            JOptionPane.showMessageDialog(null, picLabel, "Vitoria", JOptionPane.PLAIN_MESSAGE);
            Toolkit.getDefaultToolkit().removeAWTEventListener(myListener);
            fase++;
            context.insereInimigos3();
            return;
        }
        if (fase >= 2){
            URL imageUrl = ClassLoader.getSystemResource("Win.png");
            JLabel picLabel = new JLabel(new ImageIcon(imageUrl));
            AWTEventListener myListener = new AWTEventListener() {

                @Override
                public void eventDispatched(AWTEvent event) {
                    if (event instanceof KeyEvent) {
                        ((KeyEvent) event).consume();
                    }
                }
            };
            Toolkit.getDefaultToolkit().addAWTEventListener(myListener, AWTEvent.KEY_EVENT_MASK);
            JOptionPane.showMessageDialog(null, picLabel, "Win", JOptionPane.PLAIN_MESSAGE);
            Toolkit.getDefaultToolkit().removeAWTEventListener(myListener);

            janela.dispose();
            new UIY(new Inicio());
            context.stop();
        }
        
    }
    
        public void derrota() {
            URL imageUrl = ClassLoader.getSystemResource("Lose.png");
            JLabel picLabel = new JLabel(new ImageIcon(imageUrl));
            AWTEventListener myListener = new AWTEventListener() {

                @Override
                public void eventDispatched(AWTEvent event) {
                    if (event instanceof KeyEvent) {
                        ((KeyEvent) event).consume();
                    }
                }
            };
            Toolkit.getDefaultToolkit().addAWTEventListener(myListener, AWTEvent.KEY_EVENT_MASK);
            JOptionPane.showMessageDialog(null, picLabel, "Derrota", JOptionPane.PLAIN_MESSAGE);
            Toolkit.getDefaultToolkit().removeAWTEventListener(myListener);

            janela.dispose();

            new UIY(new Inicio());
            context.stop();
    }

    public int getLargura() {
        return largura;
    }

    public int getAltura() {
        return altura;
    }

    public int getFase() {
        return fase;
    }
    
}
