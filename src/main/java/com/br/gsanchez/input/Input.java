package com.br.gsanchez.input;

import com.br.gsanchez.engine.Processador;
import com.br.gsanchez.ob.ObNave;
import com.br.gsanchez.ob.ObObjeto;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter {

    private Processador proces;
    private boolean lP = false;
    private boolean rP = false;
    private boolean tP = false;

    public Input(Processador proces) {
        this.proces = proces;
    }

    public Input() {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int tecla = e.getKeyCode();
        for (int i = 0; i < proces.getObjeto().size(); i++) {
            if (proces.getObjeto().get(i) instanceof ObNave) {
                ObNave tempObjeto = (ObNave) proces.getObjeto().get(i);
                if (tempObjeto.getId() == 1) {
                    if (tecla == KeyEvent.VK_W) {
                        tempObjeto.setVelY(0);
                    }
                    if (tecla == KeyEvent.VK_S) {
                        tempObjeto.setVelY(0);
                    }
                    if (tecla == KeyEvent.VK_D) {
                        if (lP == true) {
                            tempObjeto.setVelX(-5);
                        } else {
                            tempObjeto.setVelX(0);
                        }
                        rP = false;
                    }
                    if (tecla == KeyEvent.VK_A) {
                        if (rP == true) {
                            tempObjeto.setVelX(5);
                        } else {
                            tempObjeto.setVelX(0);
                        }
                        lP = false;
                    }
                    if (tecla == KeyEvent.VK_SPACE) {
                        tP = false;
                    }
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int tecla = e.getKeyCode();
        for (int i = 0; i < proces.getObjeto().size(); i++) {
            if (proces.getObjeto().get(i) instanceof ObNave) {
                ObNave tempObjeto = (ObNave) proces.getObjeto().get(i);
                if (tecla == KeyEvent.VK_W) {
                    tempObjeto.setVelY(-5);
                }
                if (tecla == KeyEvent.VK_S) {
                    tempObjeto.setVelY(5);
                }
                if (tecla == KeyEvent.VK_D) {
                    tempObjeto.setVelX(5);
                    rP = true;
                }
                if (tecla == KeyEvent.VK_A) {
                    tempObjeto.setVelX(-5);
                    lP = true;
                }
                if (tecla == KeyEvent.VK_SPACE && tP == false) {
                    tempObjeto.atirar();
                    tP = true;
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

}
