//AUTHOR : MarcAmtonio
package typeracer.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class TyperacerGame extends Canvas implements Runnable{
    
    private static final long serialVersionID= -240840600533728354L;

    public static final int WIDTH = 900, HEIGHT=WIDTH/12*9;
    private Thread thread;
    private boolean running = false;
    private handler handler;
    private backgroundAnimation animation = new backgroundAnimation();
    private TextRenderer textRenderer;
    private Menu menu;
    
    //Types of Game States
    public static enum GameState
    {
        Menu,ChooseCode,Game,Help,FinishPage
    };
    //set so that the game starts on the menu
    public static GameState current=GameState.Menu;
    
    //constructor
    public TyperacerGame()
    { 
        
        handler = new handler();
        textRenderer = new TextRenderer(handler);
        menu = new Menu(this,handler,textRenderer);
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(menu);
        new window(WIDTH,HEIGHT,"My Typing Game",this);
        handler.initializeHandler();
    }
    
    //start the Thread
    public synchronized void start()
    {
        thread= new Thread(this);
        thread.start();
        running= true;
    }
    
    public synchronized void stop()
    {
        try{
            thread.join();
            running = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
 @Override
    public void run()
    {
        //Game Algorithm
        this.requestFocus();
        long lastTime= System.nanoTime();
        double amountOfTicks=60.0;
        double ns= 1000000000/amountOfTicks;
        double delta = 0;
        long timer= System.currentTimeMillis();
        while(running)
        {
            long now= System.nanoTime();
            delta+= (now-lastTime)/ ns;
            lastTime = now;
            while(delta >= 1)
            {
                tick();
                delta--;
            }
            if (running)  
                render();
            
            if (System.currentTimeMillis()-timer>1000)
            {
                timer += 1000;
            }
        }
        stop();
    }
    //tick method
    private void tick()
    {
        animation.tick();
        if(current == GameState.Game)
        {
            handler.tick();
        }
        else 
        {
            menu.tick();
        }
    }
    //method that deals with rendering object to the screen
    private void render()
    {
        BufferStrategy bs= this.getBufferStrategy();
        if (bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(new Color(26,48,56));
        g.fillRect(0,0,WIDTH,HEIGHT);
        
        animation.render(g);
        if (current == GameState.Game)
        {
            
            handler.render(g);
        }
        else
        {
            menu.render(g);
        }
        g.dispose();
        bs.show();
    }
    //main function
    public static void main(String[] args) {
        new TyperacerGame();
    }
    
}
