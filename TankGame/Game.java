
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;






public class Game extends JComponent {
    
    Image back1 , back2 , back3 , tank1 , tank2 , ball , fire , wall , pipe1 , pipe2 , fireBall,fighter , death1 ,death2 , win1 , win2;
    private Toolkit t = getToolkit();
    private Tank t1 , t2 ;
    private int width=(int)t.getScreenSize().getWidth() , height=(int)t.getScreenSize().getHeight() ;
    private Shot b;
    private Blast blast ;
    private Plane plane ;
    boolean powerFire;
    
public Game (Tank tank1 , Tank tank2 , Shot ball , Blast blast , Plane plane)
{
    t1 = tank1 ;
    t2 = tank2 ;
    b = ball ;
    this.blast = blast;
    this.plane = plane ;
    
   
}

    

    public void paint(Graphics g) {
        back1 = t.getImage("src/images/back1.png");
        tank1 = t.getImage("src/images/tank1.png");
        tank2 = t.getImage("src/images/tank2.png");
        wall = t.getImage("src/images/wall.png");
        pipe1 = t.getImage("src/images/pipe1.png");
        pipe2 = t.getImage("src/images/pipe2.png");
        ball = t.getImage("src/images/ball.png");
        fire = t.getImage("src/images/blast.png");
        fighter = t.getImage("src/images/fighter.png");
        death1 = t.getImage("src/images/wrecked1.png");
        death2 = t.getImage("src/images/wrecked2.png");
        win1 = t.getImage("src/images/win1.png");
        win2=t.getImage("src/images/win2.png");
        fireBall = t.getImage("src/images/powerBall.png");
        
        
        Graphics2D g2 = (Graphics2D)g;
       
               
        g2.drawImage(back1,0, 0,width , height, this);
      g2.drawImage(fighter,plane.getX(),plane.getY(), this);
      
      
      if((t1.getArmor()>0)&&(t2.getArmor()>0) )
      {
        g2.drawImage(tank1 , t1.getX()  , t1.getY() ,this);
        g2.rotate(t1.getAngleRadian(), t1.getX()+35, t1.getY()+12);
        g2.drawImage(pipe1 , t1.getX()+35 , t1.getY()+10 ,this);
        g2.rotate(-t1.getAngleRadian(), t1.getX()+35, t1.getY()+12);
        g2.drawImage(tank2 , t2.getX() , t2.getY() , this);
        g2.rotate(t2.getAngleRadian(), t2.getX()-5+pipe2.getWidth(this), t2.getY()+12+pipe2.getHeight(this));
        g2.drawImage(pipe2 , t2.getX()-4 , t2.getY()+12 ,this);
        g2.rotate(-t2.getAngleRadian(), t2.getX()-5+pipe2.getWidth(this), t2.getY()+12+pipe2.getHeight(this));
      }
      if((t1.getArmor()==0)&&(t2.getArmor()>0))
      {
           g2.drawImage(death1 , t1.getX()  , t1.getY() ,this);
        
        g2.drawImage(tank2 , t2.getX() , t2.getY() , this);
        g2.rotate(t2.getAngleRadian(), t2.getX()-5+pipe2.getWidth(this), t2.getY()+12+pipe2.getHeight(this));
        g2.drawImage(pipe2 , t2.getX()-4 , t2.getY()+12 ,this);
        g2.rotate(-t2.getAngleRadian(), t2.getX()-5+pipe2.getWidth(this), t2.getY()+12+pipe2.getHeight(this));
        g2.drawImage(win2, width/2-win2.getWidth(this)/2,height/2-win2.getHeight(this)/2 ,this);
        
      }
       if((t2.getArmor()==0)&&(t1.getArmor()>0))
      {
          g2.drawImage(tank1 , t1.getX()  , t1.getY() ,this);
          g2.rotate(t1.getAngleRadian(), t1.getX()+35, t1.getY()+12);
        g2.drawImage(pipe1 , t1.getX()+35 , t1.getY()+10 ,this);
        g2.rotate(-t1.getAngleRadian(), t1.getX()+35, t1.getY()+12);
        g2.drawImage(win1, width/2-win1.getWidth(this)/2,height/2-win1.getHeight(this)/2 ,this);
        g2.drawImage(death2 , t2.getX() , t2.getY() , this);
      }
        
        
        g2.drawImage(wall , width/2-wall.getWidth(this)/2 , (int)(height*7.5)/10 ,this);
        if(b.givePowerFire()==true)
        g2.drawImage(fireBall, b.getX(),b.getY(), this);
        else
            g2.drawImage(ball, b.getX(),b.getY(), this);
        g2.drawImage(fire, blast.getX(), blast.getY(),this);
        
        
    }


  

    



    
    
    
    


}



