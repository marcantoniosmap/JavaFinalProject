
package typeracer.game;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class TxtReader {
    
    
    private Scanner x;
    private Formatter y;
    public int[] average= new int[3];
    public int[] totalPlayed= new int[3];
    public int[] bestScore= new int[3];
    
    public TxtReader()
    {
        try{
            x = new Scanner (new File("ScoresData.txt"));
        }
        catch( Exception e)
        {
            System.out.println("Could not find file");
        }
        int i =0;
        while(x.hasNext())
        {
            try{
            average[i]= Integer.parseInt(x.next());
            totalPlayed[i]= Integer.parseInt(x.next());
            bestScore[i]= Integer.parseInt(x.next());
            }
            catch( Exception e)
            {
                System.out.println("Could not read file");
            }
            i++;
        }x.close();
    }
    public void writeFile()
    {
        try {
            y = new Formatter ("ScoresData.txt");
        }
        catch (Exception e)
        {
            System.out.println("Error writing file");
        }
        for (int i = 0; i < 3; i++) {
            String a= Integer.toString(average[i])+" ";
            String b= Integer.toString(totalPlayed[i])+" ";
            String c= Integer.toString(bestScore[i]);
            y.format("%s%s%s%n",a,b,c);
        }
        y.close();
        
    }
    
}
