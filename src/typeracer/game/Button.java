
package typeracer.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

//Button object that creates the c++ java and python button
public class Button implements tickAndRender{
    private int x=0,y=0,wpm,average,id;
    private String text;
    private Color color;
    public static TxtReader reader = new TxtReader();
    
    
    //constructor
    public Button(String text,int id,int x,int y,Color color)
    {
        this.text=text;
        this.x= x;
        this.y=y;
        this.id = id;
        this.color = color;

    }
    //adding new data to be shown in the button
    public void addNew(int newWpm)
    {
        reader.average[id] =(reader.average[id] * reader.totalPlayed[id]+newWpm)/(reader.totalPlayed[id]+1);
        reader.totalPlayed[id]=reader.totalPlayed[id]+1;
        if (newWpm > reader.bestScore[id])reader.bestScore[id]= newWpm;
      
    }
    //updating the data
    public void tick()
    {
        wpm = reader.bestScore[id];
        average = reader.average[id];
    }
    
    public void render(Graphics g)
    {
       g.setColor(color);
       g.fillRect(x,y,150,150);
       g.setColor(Color.white);
       g.setFont(new Font("Menlo Regular",0,25));
       g.drawString(text, x+25, y+50);
       g.setFont(new Font("Menlo Regular",0,13));
       g.drawString("BEST: "+wpm, x+25, y+70);
       g.drawString("AVERAGE"+average, x+25, y+90);
    }
    
    
}
