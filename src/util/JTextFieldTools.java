/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import action.Bean;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;
import xml.NewXML;

/**
 *
 * @author Rafael
 */
public class JTextFieldTools {

    //public static final NewXML newXML = new NewXML();
    /**
     * Impede a digitação de caracteres ou letras em campos de números
     *
     * @param jtextfield
     */
    public static void validarValor(javax.swing.JTextField jtextfield) {
        String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "ê", "é", "è", "á", "ã", "à",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "x", "w", "y", "ç", "=", "-", "_", ";", ":", "'"};
        String[] caracteres = {",", ".", "/", "[", "]", "{", "}", "|", "*", "&", "^", "(", ")", "%", "$", "#", "@", "!", "`", "´", "~", "\\", "?", "<", ">", "\"", "¨"};

        String prefixo = jtextfield.getText();
        System.err.println("FORMATOU JTEXT!!!!!!!");
        for (int i = 0; i < caracteres.length; i++) {
            prefixo = prefixo.toLowerCase().replace(caracteres[i], "");

        }
        for (String letra : letras) {
            prefixo = prefixo.toLowerCase().replaceAll(letra, "");
        }
        if (prefixo.startsWith(".")) {
            prefixo = "";
        }

        jtextfield.setText(prefixo.trim());

    }

    public static void validarBarCode(javax.swing.JTextField jtextfield) {
        String[] letras = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "ê", "é", "è", "á", "ã", "à",
            "n", "o", "q", "r", "s", "t", "u", "v", "x", "w", "y", "ç", "=", "-", "_", ";", ":", "'"};
        char c[] = {',', '.', '/', '[', ']', '{', '}', '|', '*', '&', '^', '(', ')', '%', '$', '#', '@', '!', '`', '´', '~', '\\', '?', '<', '>', '"', '¨'};

        String prefixo = jtextfield.getText();

        for (int i = 0; i < c.length; i++) {
            prefixo = prefixo.toLowerCase().replace(c[i], ' ');

        }
        for (String letra : letras) {
            prefixo = prefixo.toLowerCase().replaceAll(letra, "");
        }
        if (prefixo.startsWith(".")) {
            prefixo = "";
        }

        jtextfield.setText(prefixo.trim());

    }

    /**
     * Impede a digitação de caracteres invalidos no DB
     *
     * @param jtextfield
     */
    public static void invalidCaracter(javax.swing.JTextField jtextfield) {
        String[] caracterNotValid = {"ê", "é", "è", "á", "ã", "à", "ç", "í", "ì", "ó", "ò", "ú", "ù", "õ"};
        String[] carcterValid = {"e", "e", "e", "a", "a", "a", "c", "i", "i", "o", "o", "u", "u", "o"};
        char c[] = {'+', '/', '[', ']', '{', '}', '|', '*', '&', '^', '%', '$', '#', '@', '!', '`', '´', '~', '\\', '?', '<', '>', '"', '¨'};
        String prefixo = jtextfield.getText();
        for (int i = 0; i < c.length; i++) {
            prefixo = prefixo.replace(c[i], ' ');

        }
        for (int i = 0; i < caracterNotValid.length; i++) {
            prefixo = prefixo.replaceAll(caracterNotValid[i], carcterValid[i]);
            prefixo = prefixo.replaceAll(caracterNotValid[i].toUpperCase(), carcterValid[i].toUpperCase());
        }
        if (prefixo.startsWith(".")) {
            prefixo = "";
        }

        jtextfield.setText(prefixo.trim());

    }

    public static String invalidCaracterString(String value) {
        String[] caracterNotValid = {"ê", "é", "è", "á", "ã", "à", "ç", "í", "ì", "ó", "ò", "ú", "ù", "õ", "ô", "/", "'", ",", "ñ"};
        String[] carcterValid = {"e", "e", "e", "a", "a", "a", "c", "i", "i", "o", "o", "u", "u", "o", "o", " ", " ", ".", "n"};
        char c[] = {'+', '/', '[', ']', '{', '}', '|', '*', '&', '^', '%', '$', '#', '@', '!', '`', '´', '~', '\\', '?', '<', '>', '"', '¨'};
        String prefixo = value;

        for (int i = 0; i < caracterNotValid.length; i++) {
            prefixo = prefixo.replaceAll(caracterNotValid[i], carcterValid[i]);
            prefixo = prefixo.replaceAll(caracterNotValid[i].toUpperCase(), carcterValid[i].toUpperCase());
        }

        return prefixo;

    }

    /**
     * Passa primeira letra da palavra para maiúscula
     *
     * @param entrada
     * @return String
     */
    public static String formatName(String entrada) {

        String saida = "";
        int i = 1;

        if (!entrada.isEmpty()) {
            if (entrada.charAt(0) != ' ') {
                saida += entrada.toUpperCase().charAt(0);
            }
            while (i < entrada.length() && entrada.length() != 0) {

                if (entrada.charAt(i) == ' ' && i < entrada.length() - 1) {

                    saida += " " + (entrada.toUpperCase().charAt(i + 1));
                    i++;

                } else {
                    saida += entrada.toLowerCase().charAt(i);
                }
                i++;

            }

            return saida.replaceAll("  ", " ");
        }
        return null;
    }

    /**
     * Passa datas no formato dd/MM/yyyy para yyyy-MM-dd
     *
     * @param data
     * @return String
     */
    public static String formatDate(String data) {
        String date = new String();

        date += data.substring(6, 10);
        date += "-" + data.substring(3, 5) + "-";
        date += data.substring(0, 2);

        return date;
    }

    /**
     * Passa datas no formato yyyy-MM-dd para dd/MM/yyyy
     *
     * @param data
     * @return String
     */
    public static String formatDateSQL(String data) {
        String date = new String();

        date += data.substring(8, 10);
        date += "/" + data.substring(5, 7);
        date += "/" + data.substring(0, 4);

        return date;
    }

    /**
     * Insere mascaras em JFormatedTextField
     *
     * @param formato
     * @param character
     * @return String
     */
    public static MaskFormatter mask(String formato, boolean character) {
        MaskFormatter mask = null;
        try {
            mask = new MaskFormatter(formato);
            if (character) {
                mask.setPlaceholderCharacter('_');
            }

        } catch (ParseException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }

        return mask;
    }

    /**
     * Para inserir apenas números double(0.00) em um JTextField
     *
     * @param jtextfield
     */
    public static void formatJTextNumber(javax.swing.JTextField jtextfield) {

        if ("".equals(jtextfield.getText())) {
            jtextfield.setText("0,00");
        }
        String regex = "[0-9]";
        String valorAtual = jtextfield.getText();
        String CaracterDigitado;
        try {
            CaracterDigitado = jtextfield.getText().substring(jtextfield.getText().length() - 1, jtextfield.getText().length() - 0);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
            CaracterDigitado = jtextfield.getText().substring(jtextfield.getText().length() - 0, jtextfield.getText().length() - 0);
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(CaracterDigitado);
        boolean b = m.matches();
        if (b == false) {
            try {
                valorAtual = jtextfield.getText().substring(0, jtextfield.getText().length() - 1);
            } catch (java.lang.StringIndexOutOfBoundsException ex) {
                System.err.println("ERROR::" + ex);
                ////newXML.generateLog(ex.toString());
                valorAtual = jtextfield.getText().substring(0, jtextfield.getText().length() - 0);
            }
        }
        String valorAtualReplaced = valorAtual.replace(",", "");

//separe os doois ultimos digitos
        String centavos = "";
        try {
            centavos = valorAtualReplaced.substring(valorAtualReplaced.length() - 1, valorAtualReplaced.length() - 0);
            if (centavos == null) {
                centavos = "0";
            }
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }
        String decimal = "";
        try {
            decimal = valorAtualReplaced.substring(valorAtualReplaced.length() - 2, valorAtualReplaced.length() - 1);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }
//a parte restante é a parte inteira
        String inteira;
        try {
            inteira = valorAtualReplaced.substring(0, valorAtualReplaced.length() - 2);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
            inteira = "0";
        }
//reconfigure os jtext
        String separator = ",";
        String valorSaida;

//configura a parte inteira
        if (inteira.equals("") == true) {
            inteira = "0";
        }
        int length = inteira.length();
        String subInteira = inteira.substring(0, 1);
        if (length == 2 && subInteira.equals("0") == true) {
            inteira = inteira.substring(1);
        }
//configura o valor de saída
        valorSaida = inteira + separator + decimal + centavos;
        jtextfield.setText(valorSaida);

    }

    public static String formatJTextNumberString(String value) {

        String regex = "[0-9]";
        String valorAtual = value;
        String CaracterDigitado = "0";
        try {
            CaracterDigitado = value.substring(value.length() - 1, value.length() - 0);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
            CaracterDigitado = value.substring(value.length() - 0, value.length() - 0);
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(CaracterDigitado);
        boolean b = m.matches();
        if (b == false) {
            try {
                valorAtual = value.substring(0, value.length() - 1);
            } catch (java.lang.StringIndexOutOfBoundsException ex) {
                System.err.println("ERROR::" + ex);
                ////newXML.generateLog(ex.toString());
                valorAtual = value.substring(0, value.length() - 0);
            }
        }
        String valorAtualReplaced = valorAtual.replace(",", "");

//separe os doois ultimos digitos
        String centavos = "";
        try {
            centavos = valorAtualReplaced.substring(valorAtualReplaced.length() - 1, valorAtualReplaced.length() - 0);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }
        String decimal = "";
        try {
            decimal = valorAtualReplaced.substring(valorAtualReplaced.length() - 2, valorAtualReplaced.length() - 1);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }
//a parte restante é a parte inteira
        String inteira = "";
        try {
            inteira = valorAtualReplaced.substring(0, valorAtualReplaced.length() - 2);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
            inteira = "0";
        }
//reconfigure os jtext
        String separator = ",";
        String valorSaida = "";

//configura a parte inteira
        if (inteira.equals("") == true) {
            inteira = "0";
        }
        int length = inteira.length();
        String subInteira = inteira.substring(0, 1);
        if (length == 2 && subInteira.equals("0") == true) {
            inteira = inteira.substring(1);
        }
//configura o valor de saída
        valorSaida = inteira + separator + decimal + centavos;
        return valorSaida;

    }

    public static void formatJTextNumber2(javax.swing.JTextField jtextfield) {

        String regex = "[0-9]";
        String valorAtual = jtextfield.getText();
        String CaracterDigitado = "0";
        if ("".equals(jtextfield.getText())) {
            jtextfield.setText("0.00");
        }
        try {
            CaracterDigitado = jtextfield.getText().substring(jtextfield.getText().length() - 1, jtextfield.getText().length() - 0);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
            CaracterDigitado = jtextfield.getText().substring(jtextfield.getText().length() - 0, jtextfield.getText().length() - 0);
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(CaracterDigitado);
        boolean b = m.matches();
        if (b == false) {
            try {
                valorAtual = jtextfield.getText().substring(0, jtextfield.getText().length() - 1);
            } catch (java.lang.StringIndexOutOfBoundsException ex) {
                System.err.println("ERROR::" + ex);
                ////newXML.generateLog(ex.toString());
                valorAtual = jtextfield.getText().substring(0, jtextfield.getText().length() - 0);
            }
        }
        String valorAtualReplaced = valorAtual.replace(".", "");

//separe os doois ultimos digitos
        String centavos = "";
        try {
            centavos = valorAtualReplaced.substring(valorAtualReplaced.length() - 1, valorAtualReplaced.length() - 0);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }
        String decimal = "";
        try {
            decimal = valorAtualReplaced.substring(valorAtualReplaced.length() - 2, valorAtualReplaced.length() - 1);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }
//a parte restante é a parte inteira
        String inteira = "";
        try {
            inteira = valorAtualReplaced.substring(0, valorAtualReplaced.length() - 2);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
            inteira = "0";
        }
//reconfigure os jtext
        String separator = ".";
        String valorSaida = "";

//configura a parte inteira
        if (inteira.equals("") == true) {
            inteira = "0";
        }
        int length = inteira.length();
        String subInteira = inteira.substring(0, 1);
        if (length == 2 && subInteira.equals("0") == true) {
            inteira = inteira.substring(1);
        }
//configura o valor de saída
        valorSaida = inteira + separator + decimal + centavos;
        jtextfield.setText(valorSaida);

    }

    /**
     * Valida datas inserida em um JFormatedTextField
     *
     * @param jFormattedTextField
     * @param isAutoInsert
     * @return
     */
    public static boolean validImputDate(javax.swing.JFormattedTextField jFormattedTextField, boolean isAutoInsert) {

        int year = 0;
        int day = 0;
        int month = 0;

        if (!(jFormattedTextField.getText().contains("_"))) {

            year = Integer.parseInt(jFormattedTextField.getText().substring(6, 10));
            day = Integer.parseInt(jFormattedTextField.getText().substring(0, 2));
            month = Integer.parseInt(jFormattedTextField.getText().substring(3, 5));

        }

        if ((jFormattedTextField.getText().equals("__/__/____")) && (isAutoInsert)) {

            jFormattedTextField.setValue(DateActual.setDate(new Date(), "d/m/yyyy"));

        } else if ((jFormattedTextField.getText().contains("_")) || (!(year % 4 == 0) && (day == 29) && (month == 2))) {

            JOptionPane.showMessageDialog(null, "Data inválida!", "ERRO!!!", JOptionPane.ERROR_MESSAGE);
            jFormattedTextField.setValue(null);
            jFormattedTextField.requestFocus(true);
            return false;

        } else {

            int diaIn = 0;
            int mesIn = 0;
            int anoIn = 0;

            if (!jFormattedTextField.getText().contains("_")) {

                try {

                    diaIn = Integer.parseInt(jFormattedTextField.getText(0, 2));
                    mesIn = Integer.parseInt(jFormattedTextField.getText(3, 2));
                    anoIn = Integer.parseInt(jFormattedTextField.getText(6, 4));
                    int dia = 0;

                    switch (mesIn) {

                        case 1:

                            dia = 31;
                            break;

                        case 2:

                            dia = 29;
                            break;

                        case 3:

                            dia = 31;
                            break;

                        case 4:

                            dia = 30;
                            break;

                        case 5:

                            dia = 31;
                            break;

                        case 6:

                            dia = 30;
                            break;

                        case 7:

                            dia = 31;
                            break;

                        case 8:

                            dia = 31;
                            break;

                        case 9:

                            dia = 30;
                            break;

                        case 10:

                            dia = 31;
                            break;

                        case 11:

                            dia = 30;
                            break;

                        case 12:

                            dia = 31;
                            break;

                    }

                    if (diaIn > dia) {

                        JOptionPane.showMessageDialog(null, "Data inválida!", "ERRO!!!", JOptionPane.ERROR_MESSAGE);
                        jFormattedTextField.setValue(null);
                        jFormattedTextField.requestFocus(true);
                        return false;

                    }

                } catch (BadLocationException ex) {

                    System.err.println("ERROR::" + ex);
                    ////newXML.generateLog(ex.toString());

                }
                if (diaIn > 31 || mesIn > 12 || anoIn > 2999 || diaIn == 00 || mesIn == 00 || anoIn == 0000) {

                    JOptionPane.showMessageDialog(null, "Data inválida!", "ERRO!!!", JOptionPane.ERROR_MESSAGE);
                    jFormattedTextField.setValue(null);
                    jFormattedTextField.requestFocus(true);
                    return false;
                }
            }
        }
        return true;
    }

    public static void formatJTextNumberReserveValue(JTextField jtextfield) {

        if ("".equals(jtextfield.getText())) {
            jtextfield.setText("0.000");
        }
        String regex = "[0-9]";
        String valorAtual = jtextfield.getText();
        String CaracterDigitado;
        try {
            CaracterDigitado = jtextfield.getText().substring(jtextfield.getText().length() - 1, jtextfield.getText().length() - 0);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
            CaracterDigitado = jtextfield.getText().substring(jtextfield.getText().length() - 0, jtextfield.getText().length() - 0);
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(CaracterDigitado);
        boolean b = m.matches();
        if (b == false) {
            try {

                valorAtual = jtextfield.getText().substring(0, jtextfield.getText().length() - 1);
            } catch (java.lang.StringIndexOutOfBoundsException ex) {
                System.err.println("ERROR::" + ex);
                ////newXML.generateLog(ex.toString());
                valorAtual = "";
            }
        }
        String valorAtualReplaced = valorAtual.replace(".", "");

//separe os doois ultimos digitos
        String centavos = "";
        try {
            centavos = valorAtualReplaced.substring(valorAtualReplaced.length() - 1, valorAtualReplaced.length() - 0);

            if (centavos == null) {
                centavos = "0.000";
            }
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }
        String decimal = "";
        try {
            decimal = valorAtualReplaced.substring(valorAtualReplaced.length() - 2, valorAtualReplaced.length() - 1);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {

            ////newXML.generateLog(ex.toString());
        }

        String centesimo = "";
        try {
            centesimo = valorAtualReplaced.substring(valorAtualReplaced.length() - 3, valorAtualReplaced.length() - 2);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }
//a parte restante é a parte inteira
        String inteira;
        try {
            inteira = valorAtualReplaced.substring(0, valorAtualReplaced.length() - 3);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
            inteira = "0";
        }
//reconfigure os jtext
        String separator = ".";
        String valorSaida;

//configura a parte inteira
        if (inteira.equals("") == true) {
            inteira = "0";
        }
        int length = inteira.length();
        String subInteira = inteira.substring(0, 1);
        if (length == 2 && subInteira.equals("0") == true) {
            inteira = inteira.substring(1);
        }
//configura o valor de saída 
        valorSaida = inteira + separator + centesimo + decimal + centavos;
        jtextfield.setText(valorSaida);
    }

    public static void formatJTextNumberFractional(JTextField jtextfield) {

        if ("".equals(jtextfield.getText())) {
            jtextfield.setText("0,00");
        }
        String regex = "[0-9]";
        String valorAtual = jtextfield.getText();
        String CaracterDigitado;
        try {
            CaracterDigitado = jtextfield.getText().substring(jtextfield.getText().length() - 1, jtextfield.getText().length() - 0);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
            CaracterDigitado = jtextfield.getText().substring(jtextfield.getText().length() - 0, jtextfield.getText().length() - 0);
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(CaracterDigitado);
        boolean b = m.matches();
        if (b == false) {
            try {

                valorAtual = jtextfield.getText().substring(0, jtextfield.getText().length() - 1);
            } catch (java.lang.StringIndexOutOfBoundsException ex) {
                System.err.println("ERROR::" + ex);
                ////newXML.generateLog(ex.toString());
                valorAtual = "";
            }
        }
        String valorAtualReplaced = valorAtual.replace(",", "");

//separe os doois ultimos digitos
        String centavos = "";
        try {
            centavos = valorAtualReplaced.substring(valorAtualReplaced.length() - 1, valorAtualReplaced.length() - 0);

            if (centavos == null) {
                centavos = "0,00";
            }
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }
        String decimal = "";
        try {
            decimal = valorAtualReplaced.substring(valorAtualReplaced.length() - 2, valorAtualReplaced.length() - 1);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {

            ////newXML.generateLog(ex.toString());
        }

        String centesimo = "";
        try {
            centesimo = valorAtualReplaced.substring(valorAtualReplaced.length() - 3, valorAtualReplaced.length() - 2);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
        }
//a parte restante é a parte inteira
        String inteira;
        try {
            inteira = valorAtualReplaced.substring(0, valorAtualReplaced.length() - 3);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
            inteira = "0";
        }
//reconfigure os jtext
        String separator = ",";
        String valorSaida;

//configura a parte inteira
        if (inteira.equals("") == true) {
            inteira = "0";
        }
        int length = inteira.length();
        String subInteira = inteira.substring(0, 1);
        if (length == 2 && subInteira.equals("0") == true) {
            inteira = inteira.substring(1);
        }
//configura o valor de saída 
        valorSaida = inteira + separator + centesimo + decimal + centavos;
        jtextfield.setText(valorSaida);
    }

    /**
     * Abre um JOption pane com entrada de tipo password que se fecha com ENTER
     * no campo
     *
     * @param c
     * @return String
     */
    public static String enterCodeAcsses(Component c) {

        JPasswordField passwordField = new JPasswordField(12);
        passwordField.setFont(new java.awt.Font("Dialog", 1, 18));
        passwordField.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 15), new java.awt.Color(102, 102, 102))); // NOI18N
        passwordField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Object[] options = {passwordField};
        final JOptionPane pane = new JOptionPane("Entre com o código de acesso:", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        final JDialog dialog = pane.createDialog(c, "Acesso Restrito.");

        passwordField.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }

            private void passwordFieldActionPerformed(ActionEvent evt) {

                dialog.dispose();

            }

        });

        // jPanel.add(passwordField);
        //passwordField.requestFocus(true);
        dialog.show();
        return (passwordField.getText());
    }
    
    public static String enterCPF(Component c) {

        System.out.println("BEAN:::::::::::::"+Bean.getBean());
        JFormattedTextField cpfField = new JFormattedTextField(Mascaras.maskCPF());
        cpfField.setText((Bean.getBean() == null ? "" : Bean.getBean().toString()));
        cpfField.setFont(new java.awt.Font("Dialog", 1, 18));
        cpfField.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 15), new java.awt.Color(102, 102, 102))); // NOI18N
        cpfField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Object[] options = {cpfField};
        final JOptionPane pane = new JOptionPane("Entre com o CPF do cliente:", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        final JDialog dialog = pane.createDialog(c, "Consulta de Cliente");

        cpfField.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }

            private void passwordFieldActionPerformed(ActionEvent evt) {

                dialog.dispose();

            }

        });

        // jPanel.add(passwordField);
        //passwordField.requestFocus(true);
        dialog.show();
        return (cpfField.getText());
    }
    
    /**
     * Abre um JOption pane com entrada de tipo text que so aceita valores numericos e que se fecha com ENTER no campo
     *
     * @param c
     * @return String
     */
    public static String enterValue(Component c){
         
        final JTextField jTextField = new JTextField("0,00",12);
        jTextField.setFont(new java.awt.Font("Dialog", 1, 18));
        jTextField.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 15), new java.awt.Color(102, 102, 102))); // NOI18N
        jTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Object[] options = {jTextField};
        final JOptionPane pane = new JOptionPane("Entre com o valor do desconto R$:", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        final JDialog dialog = pane.createDialog(c, "Desconto Pagamento.");

        jTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTextFieldTools.formatJTextNumber(jTextField);
            }
        });
        jTextField.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialog.dispose();
            }

        });

        // jPanel.add(passwordField);
        //passwordField.requestFocus(true);
        dialog.show();
        return (jTextField.getText());
    }
}
