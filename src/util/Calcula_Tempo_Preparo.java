/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafiusk
 */
public class Calcula_Tempo_Preparo {


    

    public static String actualTime(String Hr){


List<Object> list = new ArrayList<Object>();

      Integer valor = Hr.length();
      list.add(Hr.substring(0,valor-4));
      list.add(Hr.substring(valor-4,valor-2));
      list.add(Hr.substring(valor-2,valor));
      
      


//list.add(hr.length());

//System.out.println(list);

        return list.toString();
    }
}
