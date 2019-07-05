
package typeracer.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import typeracer.game.TyperacerGame.GameState;

public class Menu extends MouseAdapter implements tickAndRender{
    
    private TyperacerGame game;
    private handler handler;
    private Random r = new Random();
    private Font font1 =new Font("Menlo Regular",0,80);
    private Font font2 =new Font("Menlo Regular",0,35);
    private Color color1= new Color(26,48,56);
    private String []title ={"<!CODERACER>","< CODERACER>","<! ODERACER>","<!C DERACER>","<!CO ERACER>","<!COD RACER>"
                            ,"<!CODE ACER>","<!CODER CER>","<!CODERA ER>","<!CODERAC R>","<!CODERACE >"};
    private int ticking=1, index = 0;
    private TextRenderer textRenderer;
    private Button codeButton1,codeButton2,codeButton3;
    private String currentCodeString="";
    private int showWpmFinish=0,average;
    public enum code {cplusplus,java,python,no};
    public static code currentCode= code.no;
    public boolean finished=true;
  
    public Menu (TyperacerGame game,handler handler,TextRenderer textRenderer)
    {
        
        this.game= game;
        this.handler= handler;
        this.textRenderer=textRenderer;
        codeButton1= new Button("C++",0,65,200,new Color(85,130,177));
        codeButton2= new Button("Java",1,365,200,new Color(188,93,40));
        codeButton3= new Button("Python",2,665,200,new Color(255,209,65));

    }
    
    @Override
    public void mousePressed (MouseEvent e)
    {
        int mx = e.getX();
        int my = e.getY();
        if (TyperacerGame.current==GameState.Menu)
        {
            if (mouseOver(mx,my,310, 245, 250, 64))
            {
                TyperacerGame.current= GameState.ChooseCode;
                return;
            }
            
            //help
            if (mouseOver(mx,my,310, 365, 250, 64))
            {
                TyperacerGame.current=GameState.Help;
            }
            //quit
            if (mouseOver(mx,my,310, 485, 250, 64))
            {
                Button.reader.writeFile();
                System.exit(1);
            }
        }
        else if (TyperacerGame.current==GameState.ChooseCode)
        {
            //c++
            if (mouseOver(mx,my,65,200,150,150))
            {
                TyperacerGame.current = GameState.Game;
                currentCode=code.cplusplus;
                textRenderer.gameCpluplusRun();
                
            }
   
            //JAVA
            if (mouseOver(mx,my,365,200,150,150))
            {
                TyperacerGame.current = GameState.Game;
                currentCode=code.java;
                textRenderer.gameJavaRun();
            }
            //PYTHON
            if (mouseOver(mx,my,665,200, 150,150))
            {
                TyperacerGame.current = GameState.Game;
                currentCode=code.python;
                textRenderer.gamePythonRun();
            }
            
            //backButton
            if (mouseOver(mx,my,310, 485, 250, 64))
            {
                TyperacerGame.current=GameState.Menu;
            }
        }
        else if (TyperacerGame.current==GameState.Help)
        {
            //backButton
            if (mouseOver(mx,my,310, 485, 250, 64))
            {
                TyperacerGame.current=GameState.Menu;
            }
        }
        else if (TyperacerGame.current==GameState.FinishPage)
        {
            if (mouseOver(mx,my,310, 485, 250, 64))
            {
                TyperacerGame.current=GameState.Menu;
                Refresh();
            }
        }
    }
    
    
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height)
    {
        if (mx >x && mx < x+width)
        {
            if (my>y && my < y +height)
            {
                return true;
            }
            else return false;
        }else return false;
    }
    public void Refresh()
    {
        if (null!=currentCode) switch (currentCode) {
            case cplusplus:
                codeButton1.addNew(showWpmFinish);
                break;
            case java:
                codeButton2.addNew(showWpmFinish);
                break;
            case python:
                codeButton3.addNew(showWpmFinish);
                break;
            default:
                break;
        }

    }
    public void tick()
    {
        
        if (game.current == GameState.ChooseCode)
        {
            codeButton1.tick();
            codeButton2.tick();
            codeButton3.tick();
        }
        ticking++;
        if (ticking%30==0)
        {
            if (index==10) index =0;
            else index++;
            ticking=1;
        }
    }
    public void render (Graphics g)
    {
        finished = true;
        if (game.current == GameState.Menu)
        {
            finished = true;
            g.setFont(font1);
            g.setColor(Color.white);
            g.drawString(title[index], 160, 200);
            
            
            g.fillRoundRect(310, 245, 250, 64, 10, 10);
            g.fillRoundRect(310, 365, 250, 64,10,10);
            g.fillRoundRect(310, 485, 250, 64,10,10);
            
            g.setColor(color1);
            g.setFont(font2);
            g.drawString("START", 385, 290);
            g.drawString("HELP", 395, 410);
            g.drawString("QUIT", 395, 530);
        }
        else if (game.current == GameState.Help)
        {
            finished = true;
            g.setFont(font1);
            g.setColor(Color.white);
            g.drawString(title[index], 160, 200);
            g.setFont(font2);
            g.drawString("HOW TO PLAY CODERACER", 220, 260);
            g.setFont(new Font("Menlo Regular",0,22));
            g.drawString("When the countdown start, type the active word", 160, 330);
            g.drawString("Use ENTER to procced to the next line", 160, 380);
            g.drawString("ENJOY PLAYING!", 160, 430);
            
            g.fillRoundRect(310, 485, 250, 64,10,10);
            g.setColor(color1);
            g.setFont(font2);
            g.drawString("MENU", 395, 530);
            
        }
        else if (game.current== GameState.ChooseCode)
        {
            finished = true;
            codeButton1.render(g);
            codeButton2.render(g);
            codeButton3.render(g);
            
            g.fillRoundRect(310, 485, 250, 64,10,10);
            g.setColor(color1);
            g.setFont(font2);
            g.drawString("MENU", 395, 530);
            
        }
        else if (game.current == GameState.FinishPage)
        {
            
            if (finished)
            {
                showWpmFinish= handler.finalWpm;
                finished = false;
            }
            
            g.setFont(font1);
            g.setColor(Color.white);
            g.drawString(title[index], 160, 200);
            if (currentCode==code.cplusplus)
            {
                currentCodeString="C ++";
            }
            else if (currentCode==code.java)
            {
                currentCodeString="Java";
            }
            else if (currentCode==code.python)
            {
                currentCodeString="Python";
            }
            g.setFont(font2);
            g.setColor(Color.white);
            g.drawString("You just coded in "+currentCodeString,200,300);
            g.drawString("Your Code / minute was "+showWpmFinish,200,360);
            g.fillRoundRect(310, 485, 250, 64,10,10);
            g.setColor(color1);
            g.setFont(font2);
            g.drawString("MENU", 395, 530);
        }
        
    }
    
}
