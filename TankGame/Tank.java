
import java.awt.Toolkit;
import static java.lang.Math.abs;
import javax.swing.JComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mehdi
 */
public class Tank extends JComponent {
     private int x , y , armor=100 , powerUps=3 , power=50 ;
     private float ang ;
     private boolean isDeath , isAvailable;
     private Toolkit t = getToolkit();
     private double widthUnit = t.getScreenSize().getWidth()/13;

    
     Tank (int x ,  int y , int angle )
{
    this.x = x ; 
    this.y = y ;
    ang = angle ;
   
}
    
    
    
    public  void moveRight()
{
    if(((x+10>widthUnit)&&(x+10<4*widthUnit))||((x+10>9*widthUnit)&&(x+10<12*widthUnit)))
   x += 10;
}
    
    public  void moveLeft()
{
     if(((x-10>widthUnit)&&(x-10<4*widthUnit))||((x-10>9*widthUnit)&&(x-10<12*widthUnit)))
   x -= 10;
}

    public  int getX()
{
  return x;
}
        
    public  int getY()
{
  return y;
}
    
    public void rotateCW()
    {
        if(getX()<7*widthUnit)
        if((ang+1<=0)&&(ang+1>=-90))
        ang+=1;
        if(getX()>7*widthUnit)
        if((ang-1<=90)&&(ang-1>=0))
            ang-=1;
    }
    
        public void rotateCCW()
    {
        if(getX()<7*widthUnit)
        if((ang-1<=0)&&(ang-1>=-90))
        ang-=1;
        
        if(getX()>7*widthUnit)
            if((ang+1<=90)&&(ang+1>=0))
       
            ang+=1;
        
    }
        
        public double getAngleRadian()
        {
            
            return Math.toRadians(ang);
            
            
        }
        
                public double getAngleDegree()
        {
            
            return abs(ang);
            
        }
        

                
        public void Enable()
        {
            isAvailable = true;
        }
        
        public void Disable()
        {
            isAvailable = false;
        }
        
    public boolean isAvailable()
    {
        return isAvailable;
    }
    
    public void damaged()
    {
       armor -= 10; 
    }
    
    public int getArmor()
    {
        return armor;
    }
    
    public int getPowerUps()
    {
        return powerUps;
    }
    
    public void usePowerUps()
    {
        powerUps-=1;
    }
    
    public int getPower()
    {
        return power;
    }
    
    public void adjustPower()
    {
        if((power+1>0)&&(power+1<=100))
        power+=5;
    }
    
        public void reducePower()
    {
        if((power-1>0)&&(power-1<=100))
        power-=5;
    }


}



