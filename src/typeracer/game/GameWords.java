/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeracer.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author MarcAntonio
 */
public class GameWords implements tickAndRender{
    protected float x,y;
    public String word;
    public boolean typed=false;
    public boolean wrong=false;
    public boolean currentType=false;
    public boolean render=true;
    private Color active=new Color(242,242,242);
    
    
    public GameWords(String word,float x, float y)
    {
        this.x=x;
        this.y=y;
        this.word=word;
    }
    
    public void tick()
    {
        if (currentType) active = Color.green;
        if (typed) active=Color.gray;
        if (wrong) active=Color.red;
        
        
        
    }
    public void render(Graphics g)
    {
        if(render)
        {
            g.setColor(active);
            g.setFont(new Font("Menlo Regular",0,22));
            g.drawString(word, (int)x, (int)y);
        }
        
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
    
    
    
}
