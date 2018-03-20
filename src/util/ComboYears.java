/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import groovy.swing.binding.JComboBoxMetaMethods;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import static view.JDialogRegisterVendor_3_1.jComboProductsVendor;

/**
 *
 * @author Rafael Recalcatti
 */
public class ComboYears {
    
    private static final ArrayList<Integer> listYears = new ArrayList<>();
    
    public ComboYears(){
        
        years();
        
    }
    public static ArrayList<Integer> years(){
              
        
        int currentYear = Integer.parseInt(DateActual.setDate(new Date(), "YYYY"));
          
        for(int i = 5; i != 0; i-- ){
         
            listYears.add(currentYear - i);
            
        }
        for(int i = 0; i <= 5; i++ ){
         
            listYears.add(currentYear + i);
            
        }
        return listYears;
    }
     
}
