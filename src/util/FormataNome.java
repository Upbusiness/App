/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author Rafael
 */
public  class FormataNome {
    /**
     * Passa primeira letra da palavra para maiúscula
     * @param String
     * @return String
     */
     
    public static String formataNome(String nome){
       String nome2=""; 
        int i=1;
         nome2+=nome.toUpperCase().charAt(0);
         while(i<nome.length()){
            
             if(nome.charAt(i)==' '){
                 nome2+=" "+nome.toUpperCase().charAt(i+1); 
                 i++;
            
                 }else
             
            nome2+=nome.toLowerCase().charAt(i);
             i++;
             }
        
      return nome2;  
        
    }

}
