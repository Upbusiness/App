/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael
 */
public class DateActual {

    public static void main(String a[]) {
        System.out.println(setDate(new Date(), "MM/Y"));
    }

    public static String setDate(Date date, String formato) {
        DateFormat FORMATO = new SimpleDateFormat(formato);
        return FORMATO.format(date);
    }

    public static String setHour(Date date) {

        return new Time(date.getTime()).toString();
    }

    public static String weekYear(Date data) {

        Calendar cal = new GregorianCalendar();
        cal.setTime(data);
        return String.valueOf(cal.get(Calendar.WEEK_OF_YEAR));

    }

    public static String incrementTime(Time time, int interval) {
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
        long t = time.getTime();
        return formatador.format(new Time(t + (60000 * interval)));

    }

    public static void validImputTime(javax.swing.JFormattedTextField jFormattedTextField) {

        int hour;
        int minute;

        hour = Integer.parseInt(jFormattedTextField.getText().replaceAll("_", "0").substring(0, 2));
        minute = Integer.parseInt(jFormattedTextField.getText().replaceAll("_", "0").substring(3, 5));

        if ((hour > 23) || (minute > 59) ) {

            JOptionPane.showMessageDialog(null, "Hora inválida!", "ERRO!!!", JOptionPane.ERROR_MESSAGE);
            jFormattedTextField.setValue("00:00");
            jFormattedTextField.requestFocus(true);

        }
    }
}
