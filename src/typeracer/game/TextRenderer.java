/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package typeracer.game;

import java.util.Random;

/**
 *
 * @author MarcAntonio
 */
public class TextRenderer {
    
    private handler handler;
    private Random r= new Random();
    public int location_x=25;
    public int location_y=150;
    public JavaCodesLibrary javaCodesLibrary= new JavaCodesLibrary();
    
    public TextRenderer( handler handler)
    {
        this.handler= handler;
    }
    
    public void gameCpluplusRun()
    {
        location_x=25;location_y=150;
        String [] word = javaCodesLibrary.CplusplusData.get(r.nextInt(javaCodesLibrary.CplusplusData.size()));
                for (int i =0;i<word.length;i++){
   
                    handler.addObject(new GameWords(word[i],location_x,location_y));
                    if(word[i].contentEquals("\n"))
                    {
                        location_x=25;
                        location_y+=50;
                    }
                    else if (word[i].contentEquals("    "))
                    {
                        location_x+=50;
                    }
                    else location_x+=((word[i].length()*15));
        }
    }
    public void gameJavaRun()
    {
        location_x=25;location_y=150;
        String [] word = javaCodesLibrary.JavaData.get(r.nextInt(javaCodesLibrary.JavaData.size()));
                for (int i =0;i<word.length;i++){
   
                handler.addObject(new GameWords(word[i],location_x,location_y));
            if(word[i].contentEquals("\n"))
            {
                location_x=25;
                location_y+=50;
            }
            else if (word[i].contentEquals("    "))
            {
                location_x+=50;
            }
            else location_x+=((word[i].length()*15));
        }
    }
    public void gamePythonRun()
    {
        location_x=25;location_y=150;
        String [] word = javaCodesLibrary.PythonData.get(r.nextInt(javaCodesLibrary.PythonData.size()));
                for (int i =0;i<word.length;i++){
   
                handler.addObject(new GameWords(word[i],location_x,location_y));
            if(word[i].contentEquals("\n"))
            {
                location_x=25;
                location_y+=50;
            }
            else if (word[i].contentEquals("    "))
            {
                location_x+=50;
            }
            else location_x+=((word[i].length()*15));
        }
    }
    
}
