
package typeracer.game;

import java.awt.Color;
import java.awt.Font;
import java.time.*;
import java.awt.Graphics;

public class WPM implements tickAndRender{
   
   public Instant first;
   private Instant second;
   private int wordsperminute=0;
   private handler handler;
   private int WordsDone=0;
   private boolean countDone;
   private boolean countStart;
    
    public WPM(handler handler)
    {
        this.handler= handler;
        countDone= false;
        first=Instant.now();
        countStart=true;
    }
    public void reset()
    {
        countDone = false;
        countStart=true;
        WordsDone=0;
        wordsperminute=0;
    }
    
    public void tick()
    {
        if (countStart) 
        {
            first=Instant.now();
            countStart=false;
        }
        if (handler.start)
        {
        WordsDone=handler.wordsDone;
        second=Instant.now();
        Duration duration = Duration.between(first, second);
        long seconds= duration.getSeconds();
        double time = seconds/60.0;
        double temp = WordsDone/time;
        wordsperminute= (int)temp;
        }
    }
    
    public int StopCount()
    {
        countDone= true;
        return wordsperminute;
    }
    public void render(Graphics g)
    {
         g.setColor(Color.white);
         g.setFont(new Font("Arial",0,18));
         g.drawString("CODE PER MINUTE:  "+wordsperminute,600, 80);
        
    }
}
