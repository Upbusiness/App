/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;
import java.util.List;
 import java.util.ArrayList;
/**
 *
 * @author Rafael Recalcatti
 */
public class Util {
      public static String desfazLista(List<String> lista,String separador){
       String str=new String(); 
        
        
         for(int i=0;i<lista.size();i++){
            
            str+=lista.get(i);
            if(i!=lista.size()-1){
                   str+=separador; 
            }
         }
        return str;
    }
        public static List<String> criaLista(String str,String separador){
        List<String> lista=new ArrayList<String>();
           int tamanhoArray=0;
           int i=0,j=0;
         while(i<str.length()){
          if(str.substring(i,i+1).equals(separador)){
             i++;
             tamanhoArray++;
               }else
          i++;
         }
         tamanhoArray+=1;  
         String str2[]=new String[tamanhoArray];
        
         while(j<tamanhoArray){
         str2=str.split(separador);
         lista.add(str2[j].trim());
         j++;
         }
       
         return lista;
        }
        
     public List<String> criaSubLista(List<String>lista,String valor){
         List<String>lista2=new ArrayList<String>();
         
          for(int i=0;i<lista.size();i++){
              
              if(lista.get(i).contains(valor)){
                  lista2.add(lista.get(i));
              }
          }
              return lista2;   
     }
     
    
    public static void imprimeLista(List<String>lista){
    for (int i=0;i<lista.size();i++){
        System.out.println(lista.get(i));
    
    }

}
      public void imprimeListaInteger(List<Integer>lista){
    for (int i=0;i<lista.size();i++){
        System.out.println(lista.get(i));
    
    }

}
    

}

     

