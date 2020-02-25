
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mehdi
 */
public class Nature {
    private int wind , gravity ;
    Random rand = new Random();
    public Nature(int wind , int gravity)
    {
        this.wind = wind;
        this.gravity = gravity;
    }
    
    
    public void makeWind()
    {
        wind = rand.nextInt()%50;
        
    }
    public int getWind()
    {
        return wind ;
    }
    
    public int gravity()
    {
        return gravity ;
    }
    
    public int setGravity()
    {
       return gravity ; 
    }
    
}
