
package typeracer.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

public class CountDown implements tickAndRender{
    
    
    public int startingCount;
    public handler handler;
    public long count=0;
    static int interval;
    static Timer timer;
    int delay = 1000;
    int period = 1000;

    public CountDown(handler handler)
    {
        startingCount=10;
        this.handler= handler;
    }
    public void countdown(int a)
    {
        timer = new Timer();
        interval=a;
        startingCount=10;
        delay = 1000;
        period = 1000;

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                startingCount=(setInterval());

            }
        }, delay, period);
    }
    public void tick()
    {
  
    }
    private static final int setInterval() {
    if (interval == 1)
        timer.cancel();
    return --interval;
}

    public void render(Graphics g)
    {
        g.setColor(Color.white);
        g.setFont(new Font("Arial",0,50));
        if (interval >1)g.drawString(startingCount+"",400, 80);
        else g.drawString("START"+"",360, 80);
        
    }
}

        
        


 