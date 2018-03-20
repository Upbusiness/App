

package action;

import org.jdesktop.beansbinding.Converter;

/**
 * Converter between marital status code and its human-readable representation.
 *
 * @author Jan Stola
 */
public class TypeProductionConverter extends Converter<Integer, String> {

    @Override
    public String convertForward(Integer arg) {
        String value = null;
        switch (arg) {
            case 0: value="T-Terceiros"; break;
            case 1: value="P-Propia"; break;                        
        }
        return value;
    }

    @Override
    public Integer convertReverse(String arg) {
        int value = 0;
        if (null != arg) switch (arg) {
            case "T-Terceiros":
                value = 0;
                break;
            case "P-Propia":
                value = 1;
                break;
        }
        
        return value;
    }

}
