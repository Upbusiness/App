/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Rafiusks
 */
public class DimensionFrame {
    
    
    public static int getPixel(char arg ){
        
    Toolkit tk = Toolkit.getDefaultToolkit();  
    Dimension d = tk.getScreenSize(); 
    
    if(arg == 'w'){
    System.out.println("Screen width = " + d.width); 
    return d.width;
    
    }else if(arg == 'h')
    System.out.println("Screen height = " + d.height);  
    return d.height;
  
}
   
    public static Dimension getDimension(){
        
    Toolkit tk = Toolkit.getDefaultToolkit();  
    Dimension d = tk.getScreenSize(); 
    
   

    return d;
    
      }
}
