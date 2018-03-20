/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reports;

import java.util.Collection;
import java.util.Vector;



/**
 *
 * @author Rafael recalcatti
 */
public class ProductFactory{
    @SuppressWarnings("unchecked")
    public static Collection generateDB(){
        
        Vector v = new Vector();
        
        v.add(new ClassLots("R45464l", "L0090OP", "2016-10-09", "2016-10-09", "2017-10-09", 24, 2));
        
        
        return v;
    }
    
}
