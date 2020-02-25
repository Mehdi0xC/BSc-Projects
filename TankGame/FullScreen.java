
import java.awt.Toolkit;
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
public class FullScreen extends JComponent {
      private Toolkit t = getToolkit();
      


public int getScreenHeight()
{
    
return (int) t.getScreenSize().getHeight();

}

public int getScreenWidth()
{
return (int) t.getScreenSize().getWidth();
}



}