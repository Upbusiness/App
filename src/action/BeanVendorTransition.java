/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

/**
 *
 * @author Rafael Recalcatti
 */
public class BeanVendorTransition {
    
    
    
    private static String code;
    private static String description;
    private static Object bean;
    private static boolean control;

    /**
     * @return the code
     */
    public static String getCode() {
        return code;
    }

    /**
     * @param aCode the code to set
     */
    public static void setCode(String aCode) {
        code = aCode;
    }

    /**
     * @return the description
     */
    public static String getDescription() {
        return description;
    }

    /**
     * @param aDescription the description to set
     */
    public static void setDescription(String aDescription) {
        description = aDescription;
    }

    /**
     * @return the bean
     */
    public static Object getBean() {
        return bean;
    }

    /**
     * @param aBean the bean to set
     */
    public static void setBean(Object aBean) {
        bean = aBean;
    }

    /**
     * @return the control
     */
    public static boolean isControl() {
        return control;
    }

    /**
     * @param aControl the control to set
     */
    public static void setControl(boolean aControl) {
        control = aControl;
    }
    
}
