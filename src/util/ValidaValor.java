/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author Rafael
 */
public class ValidaValor {


    public String validarValor(String prefixo){
      String[] letras = {"a","b","c","d","e","f","g","h","i","j","k","l","m",
      "n","o","p","q","r","s","t","u","v","x","w","y","ç","=","-","_",";",":","'"};
     char c[]={'+','/','[',']','{','}','|','*','&','^','(',')','%','$','#','@'
             ,'!','`','´','~','\\','?','<','>','"','¨'};
      
      for(int i = 0;i<c.length;i++){
        prefixo = prefixo.toLowerCase().replace(c[i],' ');

      }
       for(int i = 0;i<letras.length;i++){
        prefixo = prefixo.toLowerCase().replaceAll(letras[i],"");
      }

      return prefixo.trim().replaceAll(",", ".");



    }

}
