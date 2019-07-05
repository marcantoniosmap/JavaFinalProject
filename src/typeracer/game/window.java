
package typeracer.game;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
/**
 *
 * @author MarcAntonio
 */
public class window extends Canvas{
 
    
    private static final long serialVersionID= -240840600533728354L;
    
    public window (int width, int height, String title, TyperacerGame game)
    {
        //creating new window
        JFrame frame = new JFrame(title);
        
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width,height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();

    }
}
