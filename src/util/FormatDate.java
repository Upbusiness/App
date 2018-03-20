/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author Rafael
 */
public class FormatDate {
    
    
    public static String formatDate(String data){
        String date = new String();
            System.err.println("DATA IN::"+data);
            date+=data.substring(6,10);
            date+="-"+data.substring(3,5)+"-";
            date+=data.substring(0,2);
            System.err.println("DATA OUT::"+date);
        
       return date;
    } 

     public static String formatDateSQL(String data){
        String date =new String();

            date+=data.substring(8,10);
            date+="/"+data.substring(5,7);
            date+="/"+data.substring(0,4);



       return date;
}
}
