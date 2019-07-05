
package typeracer.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter{
    
    public handler handler;
    
    public KeyInput(handler handler) {
    this.handler = handler;
  
    }
 
  public void keyPressed(KeyEvent e) {
      char key = e.getKeyChar();
      
       if (handler.countdown.startingCount<1)
       {
            if (key==KeyEvent.VK_ESCAPE)
          {
              System.exit(1);
          }
          else if (key==KeyEvent.VK_BACK_SPACE)
          {
              if (!handler.currentWord.currentString.isEmpty()||handler.currentWord.currentString.length()>0)
              {
                  handler.currentWord.currentString=handler.currentWord.currentString.substring(0,handler.currentWord.currentString.length()-1 );

              }
          }
          else if (key==65535 || handler.currentWord.currentString.length()>30){}

          else if (key == KeyEvent.VK_SPACE)
          {
              handler.check();
          }
          else if (key==KeyEvent.VK_ENTER)
          {
              handler.newline();
          }

          else
          {
              handler.currentWord.currentString+=key;

          }
       }
  }

}
