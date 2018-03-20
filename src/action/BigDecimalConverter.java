package action;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jdesktop.beansbinding.Converter;
import static util.Moeda.DINHEIRO_REAL;
import static util.Moeda.mascaraDinheiro;
import xml.NewXML;

/**
 *
 * @author rogerio
 */
public abstract class BigDecimalConverter extends Converter<String, String> {

    private static final DecimalFormat v = new DecimalFormat("0.00");
    private static final NewXML newXML = new NewXML();

    public String convertForward(BigDecimal value) {
        return String.valueOf(value);
    }

    @Override
    public String convertReverse(String value) {

        String regex = "[0-9]";
        String valorAtual = value;
        String CaracterDigitado = "0";
        try {
            CaracterDigitado = value.substring(value.length() - 1, value.length() - 0);
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            CaracterDigitado = value.substring(value.length() - 0, value.length() - 0);
        }

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(CaracterDigitado);
        boolean b = m.matches();
        if (b == false) {
            try {
                valorAtual = value.substring(0, value.length() - 1);
            } catch (java.lang.StringIndexOutOfBoundsException e) {
                valorAtual = value.substring(0, value.length() - 0);
            }
        }
        String valorAtualReplaced = valorAtual.replace(".", "");

//separe os doois ultimos digitos
        String centavos = "";
        try {
            centavos = valorAtualReplaced.substring(valorAtualReplaced.length() - 1, valorAtualReplaced.length() - 0);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
        String decimal = "";
        try {
            decimal = valorAtualReplaced.substring(valorAtualReplaced.length() - 2, valorAtualReplaced.length() - 1);
        } catch (java.lang.StringIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
        }
//a parte restante é a parte inteira
        String inteira = "";
        try {
            inteira = valorAtualReplaced.substring(0, valorAtualReplaced.length() - 2);
        } catch (java.lang.StringIndexOutOfBoundsException e) {
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
        BigDecimal bd = new BigDecimal(valorSaida);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);

        return mascaraDinheiro(bd.doubleValue(), DINHEIRO_REAL);

    }
}
