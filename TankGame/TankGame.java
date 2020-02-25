
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import static java.lang.Math.abs;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.j3d.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.swing.JFrame;
import sun.applet.Main;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


 



public class TankGame extends JFrame{
   static private Random rand = new Random();
   
   
   static int wind = rand.nextInt()%100 ;
    static int power = 0 ;
    static int r1 = (rand.nextInt()%100);
    static int r2 = (rand.nextInt()%100);
    static double t=0;
    static boolean fired = false ,powerFire=false;
static int x0 , y0 ;
static double tetha;
static Blast blast = new Blast();
    static Nature nature = new Nature(0,10);
    static FullScreen s1 = new FullScreen();
    static int widthUnit = s1.getScreenWidth()/23;
    static int heightUnit = s1.getScreenHeight()/20;
        static Tank t1 = new Tank(r1+widthUnit*4,heightUnit*15,0);
    static Tank t2 = new Tank(r2+widthUnit*18,heightUnit*15,0);
    static Shot shot = new Shot();
    static Plane plane = new Plane();
    static Game game = new Game(t1,t2,shot,blast,plane);

    
    public static void main(String[] args) throws InterruptedException {
    
        

    
    final JFrame gameFrame = new JFrame("Made by MXII");
    gameFrame.setSize(s1.getScreenWidth(),s1.getScreenHeight());
    gameFrame.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		} );
   
    Panels p1 = new Panels(t1,t2,giveActivatedTank(),nature);
   
 
    gameFrame.setLayout(new BorderLayout());
    gameFrame.add(game , BorderLayout.CENTER);
    gameFrame.add(p1 , BorderLayout.NORTH);
    gameFrame.setResizable(false);
    gameFrame.setVisible(true);
    gameFrame.requestFocusInWindow();
    gameFrame.addKeyListener(KeyBoardListener);
    p1.addKeyListener(KeyBoardListener);
    
     
    t1.Enable();
    t2.Disable();
   
   
    while((t1.getArmor()>0)&&(t2.getArmor()>0))
    {
      
      
     if (fired == true)
     {
         shot.fire(t, x0, y0, tetha , giveActivatedTank().getPower(), nature.getWind(), 10);
         t+=0.5;
         if(shot.getY()>15.5*heightUnit)
         {
             
             blast.setX(shot.getX()-50);
             blast.setY(shot.getY()-50);
             TimeUnit.MILLISECONDS.sleep(100);
             blast.setX(10000);
             blast.setY(10000);
             
             fired = false ;
             t=0;
             if(abs(shot.getX()-(t1.getX()+30))<50)
                 t1.damaged();
             if(abs(shot.getX()-(t2.getX()+30))<50)
                 t2.damaged();
             shot.setX(10000);
             shot.setY(10000);
             nature.makeWind();
             rotateActivision();
         }
     }
     
     if ((shot.givePowerFire() == true))
     {
         
         shot.fire(t, x0, y0, tetha , giveActivatedTank().getPower(), nature.getWind(), 10);
         t+=0.5;
         if(shot.getY()>15.5*heightUnit)
         {
             
             blast.setX(shot.getX()-50);
             blast.setY(shot.getY()-50);
             TimeUnit.MILLISECONDS.sleep(100);
             blast.setX(10000);
             blast.setY(10000);
             
             shot.disablePowerFire();
             t=0;
             if(abs(shot.getX()-(t1.getX()+30))<50)
             {t1.damaged();
                 t1.damaged();}
             if(abs(shot.getX()-(t2.getX()+30))<50)
             {t2.damaged();
                 t2.damaged();}
             shot.setX(10000);
             shot.setY(10000);
             nature.makeWind();
             rotateActivision();
         }
     }
     
     
    TimeUnit.MILLISECONDS.sleep(100);
    plane.moveRight();
     game.repaint();
     
     
     p1.update(giveActivatedTank());
     
     
   
    
    
    
    }
    
    
    
    
    
    
    
    
    }
    
    
    
    

 
public static KeyListener KeyBoardListener = new KeyListener()
{
    @Override
    public void keyPressed(KeyEvent args0) 
    {
    int key = args0.getKeyCode();

    if(key == KeyEvent.VK_LEFT)
    {
        giveActivatedTank().moveLeft();
        game.repaint();

    }
    if(key == KeyEvent.VK_RIGHT)
    {
        giveActivatedTank().moveRight();
        game.repaint();
    }
        if(key == KeyEvent.VK_UP)
    {
       giveActivatedTank().rotateCCW();
       game.repaint();
    }
        
                if(key == KeyEvent.VK_D)
    {
       giveActivatedTank().adjustPower();
       game.repaint();
    }
                
                        if(key == KeyEvent.VK_A)
    {
       giveActivatedTank().reducePower();
       game.repaint();
    }
        
            if(key == KeyEvent.VK_DOWN)
    {
        giveActivatedTank().rotateCW();
        game.repaint();
    }
            if(key == KeyEvent.VK_ENTER)
                {
                    fired = true;
            x0 = giveActivatedTank().getX();
            y0= giveActivatedTank().getY();
            if(giveActivatedTank().getX()>11*widthUnit)
               tetha = 180-giveActivatedTank().getAngleDegree(); 
            else
            {
            tetha = giveActivatedTank().getAngleDegree();
            x0+=10;
            }
         
        
        
    }
            
                        if(key == KeyEvent.VK_E)
                {
                    if(giveActivatedTank().getPowerUps()>0)
                    {
                    shot.enablePowerFire();
                    giveActivatedTank().usePowerUps();
                    
            x0 = giveActivatedTank().getX();
            y0= giveActivatedTank().getY();
            if(giveActivatedTank().getX()>11*widthUnit)
               tetha = 180-giveActivatedTank().getAngleDegree(); 
            else
            {
            tetha = giveActivatedTank().getAngleDegree();
            x0+=10;
            }
                    }
        
        
    }
   game.repaint();

    }   

    @Override
    public void keyReleased(KeyEvent args0) 
    {
    
    }

    @Override
    public void keyTyped(KeyEvent args0) {
  

    }
    }; 
    
    public static Tank giveActivatedTank()
    {
        if (t1.isAvailable()&&!t2.isAvailable())
            return t1;
        else if(!t1.isAvailable()&&t2.isAvailable())
            return t2;
        else return t1;
    }
    

    
    public static void rotateActivision()
    {
        if(t1.isAvailable())
        {
            t1.Disable();
            t2.Enable();
        }
        else
        {
            t1.Enable();
            t2.Disable();
        }
    }
    ////////////////////////////////


    /////////////////////////////////
}
