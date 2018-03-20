

package action;

import java.util.ArrayList;
import java.util.List;
import org.jdesktop.beansbinding.Converter;


public  class FornecedorConverter extends Converter<Integer, String> {

private List<String> valor = new ArrayList<>();
private List<Integer> cod = new ArrayList<>();
    

    @Override
    public Integer convertReverse(String arg) {
      
      // valor = ClassNotaFiscal.nameFornecedor();
        
       // cod = ClassNotaFiscal.codFornecedor();
        
        int value = 0;
       for(int i = 0; i < cod.size(); i++){
            
            if(valor.get(i).equals(arg)){
              
             value = cod.get(i);
            
             
            }
       }
       
        return value;
       

}

    @Override
    public String convertForward(Integer arg) {
         
        //valor = ClassNotaFiscal.nameFornecedor();
        
        //cod = ClassNotaFiscal.codFornecedor();
        
        
        String value = null;
      
        for(int i = 0; i < cod.size(); i++){
            
            if(cod.get(i).equals(arg)){
               
             value = valor.get(i);
             
             
            }
            
        }
       
        return value;
    }
}
