/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeracer.game;

import java.awt.Graphics;

/**
 *
 * @author MarcAntonio
 */
public interface tickAndRender {
    
    public void tick();
    public void render(Graphics g);
}
