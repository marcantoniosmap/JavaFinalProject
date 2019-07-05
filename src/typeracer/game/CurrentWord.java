
package typeracer.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class CurrentWord implements tickAndRender{
    
    public String currentString="";
    private final Color backgroundColor= new Color(82,122,132);
    
    
    @Override
    public void tick()
    {
        
    }
    @Override
    public void render(Graphics g)
    {
        //initializing the box
       g.setColor(backgroundColor);
       g.fillRect(156,500,588,62);
       g.setColor(new Color(242,242,242));
       g.setFont(new Font("Menlo Regular",0,25));
       g.drawString(currentString, 190, 540);
       
    }
}
