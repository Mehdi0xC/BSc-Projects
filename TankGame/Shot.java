
import java.awt.Toolkit;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import java.util.concurrent.TimeUnit;
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
public class Shot extends JComponent {
    private int x=10000 , y=10000  ;
    private double angle ;
    private Toolkit t = getToolkit();
    private int height = (int) t.getScreenSize().getHeight();
    private int width = (int) t.getScreenSize().getWidth();
    private boolean powerFire;
    
    public void fire(double time ,int xPos , int yPos , double pipeAngleDegree , int power , int wind , int gravity) throws InterruptedException
    {
      double  t=time;
      angle=Math.toRadians(pipeAngleDegree); 
      
        setX((int)(power*cos(angle)*t+(wind*t)+xPos));
        setY((int)(0.5*gravity*pow(t,2)-power*sin(angle)*t+yPos));
    }
    
    
    
    public int getX()
    {
        return x ;
    }
    
       public int getY()
    {
        return y ;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }
    
    public void enablePowerFire()
    {
        powerFire=true;
    }
     public void disablePowerFire()
    {
        powerFire=false;
    }
     public boolean givePowerFire()
     {
         return powerFire;
     }
}
