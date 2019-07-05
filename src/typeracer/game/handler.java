
package typeracer.game;

import java.awt.Graphics;
import java.time.Instant;
import java.util.LinkedList;
import typeracer.game.TyperacerGame.GameState;

public class handler implements tickAndRender{
    
    public LinkedList<GameWords> object = new LinkedList<GameWords>();
    public int count;
    public int wordsDone=0;
    public CurrentWord currentWord= new CurrentWord();
    public WPM wpm=new WPM(this);
    public CountDown countdown= new CountDown(this);
    public boolean start = false;
    public int finalWpm=0;
    private boolean repeat = true;
    
    
    public void initializeHandler()
    {
       countdown.countdown(10);
         
    }
    public void resetGame()
    {
        wpm.reset();
        object.clear();
        count=0;
        wordsDone=0;
        currentWord.currentString="";
        start=false;
        repeat = true;
        //initializeHandler();
        
        
    }
    
    public void tick()
    {
        if (TyperacerGame.current==GameState.Game &&repeat)
        {
            initializeHandler();
            repeat = false;
        }
        if (countdown.startingCount<1)
        {
            start=true;
            currentWord.tick();
            wpm.tick();
            countdown.tick();
            if (object.get(count).word.contentEquals("    ")) count++;
            object.get(count).currentType=true;
            for (int i = 0; i<object.size();i++)
            {
                object.get(i).tick();
                
            }
        }
            
    }
    
    public void render(Graphics g)
    {
        countdown.render(g);
        currentWord.render(g);
        wpm.render(g);
        for (int i =0; i<object.size();i++)
        {
            if (object.get(i).getY()<500)
            object.get(i).render(g);
        }
        
    }
      public void RiseUpALine()
    {
        
        for (int i = 0; i<object.size();i++)
            {
                if (object.get(i).typed)
                {
                    object.get(i).render=false;
                }
                else
                {
                    object.get(i).setY(object.get(i).getY()-50);
                }
            }
    }
    public void check()
    {
        //if it is true
        if (currentWord.currentString.contentEquals(object.get(count).word))
        {
            if (count+1==object.size())
            {
                wordsDone++;
                finalWpm=wpm.StopCount();
                TyperacerGame.current= GameState.FinishPage;
                
                resetGame();
            }
            else if ((!object.get(count+1).word.contentEquals("\n")))
            {
                currentWord.currentString = "";
                object.get(count).wrong=false;
                object.get(count).typed=true;
                count++;
                wordsDone++;
            }
            
        }
        else
        {
            object.get(count).wrong=true;
        }
    }
  
    public void newline()
    {
        if (currentWord.currentString.contentEquals(object.get(count).word))
        {
            //if game is finished
            if (count+1==object.size())
            {
                wordsDone++;
                finalWpm=wpm.StopCount();
                TyperacerGame.current= GameState.FinishPage;
                resetGame();
            }
            
            else if (object.get(count+1).word.contentEquals("\n"))
            {   
                currentWord.currentString = "";
                object.get(count).wrong=false;
                object.get(count).typed=true;
                RiseUpALine();
                count=count+2;
                wordsDone++;
            }
            
            
        }
         else
        {
            object.get(count).wrong=true;
        }
    }
    public void addObject(GameWords object)
    {
        this.object.add(object);
    }
    
}
