/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeracer.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author MarcAntonio
 */
public class backgroundAnimation implements tickAndRender{
    
    private Random random = new Random();
    private String []binaryLibrary={"1010010101010010 01001010101010101010101010100100101 101101010010101 100101010101001",
                                    "1110100 01011000010101101010101001 101001010101 1010100100101110001 1001010111100001",
                                    "111 10010100010 110011010100101010 10101011110000101100100101 01110010001100001 0001",
    };
   
    
    public void tick()
    {
     
    }
    public void render(Graphics g)
    {
        g.setColor(new Color(17,35,45));
        g.setFont(new Font("Menlo Regular",0,18));
        for (int i = 1; i < 50; i++) {
            g.drawString(binaryLibrary[random.nextInt(3)],2,18*i);
        }
        
    }
    
}
