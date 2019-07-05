
package typeracer.game;

import java.util.*;

public class JavaCodesLibrary {
    
    public LinkedList<String[]> JavaData = new LinkedList<>();
    public LinkedList<String[]> CplusplusData = new LinkedList<String[]>();
    public LinkedList<String[]> PythonData = new LinkedList<String[]>();
    
    
    private String JavafirstText[]= {"public", "class","KeyInput", "extends", "KeyAdapter{","\n",
                            "    ","public","handler","handler;","\n",
                            "    ", "public","KeyInput(handler","handler){","\n",
                            "    ", "this.handler","=","handler;","\n",
                            "    ","}","\n",
                            "    ","public","void","KeyPressed","(KeyEvent","e){","\n",
                            "    ","    ","char","key=","e.getKeyChar();","\n",
                            "    ","    ","if","(key","==","KeyEvent.VK_ESCAPE)"};
    
    private String JavasecondText[]={"public", "class", "NumberDigits{","\n",
                            "    ","public","static","void","main(String[]","args){","\n",
                            "    ","    ","int","count=0," ,"num=3452;","\n",
                            "    ","    ","while(num" ,"!=", "0)","\n",
                            "    ","    ","{","\n",
                            "    ","    ","    ","num", "/=","10;","\n",
                            "    ","    ","    ","++count;","\n",
                            "    ","    ","}","\n",
                            "    ","    ","System.out.println(","count);"};
    
    
    private String cFirstText[]={"#include","<iostream>","\n",
                                  "using","namespace","std;","\n",
                                  "int","main(){","\n",
                                  "    ","int","a=5,","b=10,","temp;","\n",
                                  "    ","cout","<<","'Before","Swapping'","<<","endl;","\n",
                                  "    ","cout","<<","'a='","<<","a","<<","',b=","<<","b","<<","endl","\n",
                                  "    ","temp=a;","\n",
                                  "    ","a=b;","\n",
                                  "    ","b=temp;","\n",
                                  "    ","cout","<<","'After","Swapping'","<<","endl;","\n",
                                  "    ","cout","<<","'a='","<<","a","<<","',b=","<<","b","<<","endl","\n",
                                  "    ","return","0;"};
    
    private String [] PythonFirstText={"class","ComplexNumber:","\n",
                                        "    ","def","__init__(","self,","r=0,","i=0):","\n",
                                        "    ","    ","self.real","=","r","\n",
                                        "    ","    ","self.imag","=","i","\n",
                                        "    ","def","getData(self):","\n",
                                        "    ","    ","print(","'{0}+{1}j'.format(","self.real,self.imag))"};
    
    private String [] JavaThirdText ={"This","is","another","java","text!","\n",
                                       "Happy","playing"
    };
   
    public JavaCodesLibrary()
    {
        JavaData.add(JavafirstText);
        //JavaData.add(JavasecondText);
       // JavaData.add(JavaThirdText);
        PythonData.add(PythonFirstText);
        CplusplusData.add(cFirstText);
        
        
    }
  }
