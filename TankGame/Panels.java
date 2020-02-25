
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mehdi
 */
public class Panels extends JPanel {
    private Tank t1 , t2 , t0 ;
    private int windPower;
    JLabel tank1armor;
    JLabel tank2armor;
    JLabel tank1powerups;
    JLabel tank2powerups;
    JLabel power;
    JLabel wind;
   
    JLabel angle;
    private Nature nature;
    
    public Panels(Tank tank1 , Tank tank2 , Tank actTank , Nature nat)
    {
        t1 = tank1;
        t2 = tank2;
        t0 = actTank;
        nature = nat ;
        setSize(300,800);
            tank1armor = new JLabel("Player 1 Armor:"+t1.getArmor()+"        ");
         tank2armor = new JLabel("Player 2 Armor:"+t2.getArmor()+"        ");
         tank1powerups = new JLabel("Player 1 PowerUps:"+t1.getPowerUps()+"            ");
         tank2powerups = new JLabel("            Player 2 PowerUps:"+t2.getPowerUps()+"        ");
         power = new JLabel();
         wind = new JLabel("wind:"+10);
        this.windPower=windPower;
        angle = new JLabel("Angle is:"+t0.getAngleDegree());
        
        add(tank1armor);
        add(tank1powerups);
        
        add(wind);
       add(power);
        add(angle);
        
        add(tank2powerups);
        add(tank2armor);
        
    }
    
    public void update(Tank activeTank)
    {
       
       tank1armor.setText("Player 1 Armor:"+t1.getArmor()+"        ");
       tank2armor.setText("Player 2 Armor:"+t2.getArmor()+"        ");
       tank1powerups.setText("Player 1 PowerUps:"+t1.getPowerUps()+"            ");
       tank2powerups.setText("            Player 2 PowerUps:"+t2.getPowerUps()+"        ");
       angle.setText("Angle:"+activeTank.getAngleDegree());
       wind.setText("Wind:"+nature.getWind());
       power.setText("Power:"+activeTank.getPower());
       
    }
    
    public int getPower()
    {
        return Integer.parseInt(power.getText());
    }
    
    
    
    
}
