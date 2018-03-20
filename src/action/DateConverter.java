

package action;

import org.jdesktop.beansbinding.Converter;
import util.FormatDate;


public  class DateConverter extends Converter<String, String> {

    @Override
    public String convertForward(String value) {
        
         
         return FormatDate.formatDateSQL(value);
    }

    @Override
    public String convertReverse(String value) {
       
        
        return FormatDate.formatDate(value);
        
    }


}
