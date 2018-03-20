package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import static util.Moeda.DINHEIRO_REAL;
import static util.Moeda.mascaraDinheiro;
import xml.NewXML;

class MyModelJtableProductsReserveControl extends AbstractTableModel {

    String[] colNames = null;
    String[] arg1 = {"","Bloqueado","Código Barra ", "Descrição", "Categoria", "Custo Unitário", "Custo Total", "Preço Unitário", "Preço Total", "Estoque", "Und.", "Abaixo min.", "Repor"};
    String[] arg2 = {"","Bloqueado","Código Barra ", "Descrição", "Categoria", "Estoque", "Und.", "Abaixo min.", "Repor"};
    String[] arg3 = {"","Bloqueado","Código Barra ", "Descrição", "Categoria", "Observações", "Estoque", "Und.", "Abaixo min.", "Repor"};
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    @SuppressWarnings("empty-statement")
    public MyModelJtableProductsReserveControl(boolean selected, boolean isFinanceView, boolean isObservationView, String arg) {
        System.out.println("ARG ON MYMODEL>>>>>" + arg);
        try {
            String SQL = null;
            if (isFinanceView) {

                colNames = arg1;
                SQL = ("SELECT p.`prod_bar_code_product` AS bar_code,"
                        + " p.`prod_isActive`,"
                        + " p.`prod_description_product` AS description,"
                        + " p.`idtbl_unity_measure` AS unity_measure,"
                        + " c.`description_category` AS category,"
                        + " p.`prod_price_purchase_product` AS cost,"
                        + "(p.`prod_price_purchase_product` * p.`prod_reserve_actual_product`) AS cost_total,"
                        + "(p.`prod_price_sale_actual_product` * p.`prod_reserve_actual_product`) AS price_total,"
                        + " p.`prod_reserve_actual_product` AS reserve_actual,"
                        + " p.`prod_reserve_maximum_product` AS reserve_max ,"
                        + " p.`prod_reserve_minimum_product` AS reserve_min,"
                        + " p.`prod_price_sale_actual_product` AS price,"
                        + "(p.`prod_reserve_maximum_product` - p.`prod_reserve_actual_product`)AS saldo "
                        + "FROM tbl_product p INNER JOIN tbl_category_product c ON p.`idtbl_category_product` = c.`idtbl_category_product` " + arg);

            } else if ((!isFinanceView) && (!isObservationView)) {

                colNames = arg2;
                SQL = ("SELECT p.`prod_bar_code_product` AS bar_code,"
                        + " p.`prod_isActive`,"
                        + " p.`prod_description_product` AS description,"
                        + " p.`idtbl_unity_measure` AS unity_measure,"
                        + " c.`description_category` AS category,"
                        + " p.`prod_reserve_actual_product` AS reserve_actual,"
                        + " p.`prod_reserve_maximum_product` AS reserve_max ,"
                        + " p.`prod_reserve_minimum_product` AS reserve_min,"
                        + "(p.`prod_reserve_maximum_product` - p.`prod_reserve_actual_product`)AS saldo "
                        + "FROM tbl_product p INNER JOIN tbl_category_product c ON p.`idtbl_category_product` = c.`idtbl_category_product` " + arg);

            } else if ((isObservationView) && (!isFinanceView)) {

                colNames = arg3;
                SQL = ("SELECT p.`prod_bar_code_product` AS bar_code,"
                        + " p.`prod_isActive`,"
                        + " p.`prod_description_product` AS description,"
                        + " p.`idtbl_unity_measure` AS unity_measure,"
                        + " c.`description_category` AS category,"
                        + " p.`prod_reserve_actual_product` AS reserve_actual,"
                        + " p.`prod_observation` AS observation,"
                        + " p.`prod_reserve_maximum_product` AS reserve_max ,"
                        + " p.`prod_reserve_minimum_product` AS reserve_min,"
                        + "(p.`prod_reserve_maximum_product` - p.`prod_reserve_actual_product`)AS saldo "
                        + "FROM tbl_product p INNER JOIN tbl_category_product c ON p.`idtbl_category_product` = c.`idtbl_category_product`  " + arg);
            }
            System.err.println("SQL:::::"+SQL);
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(SQL);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(SQL);
            int i = 0;

            while (rs.next()) {

                Double v1 = rs.getDouble("reserve_min");
                Double v2 = rs.getDouble("reserve_actual");
                Double v3 = rs.getDouble("saldo");

                if (isFinanceView) {

                    data[i][1] = (rs.getBoolean("prod_isActive") ? "NÃO" : "SIM");
                    data[i][2] = rs.getString("bar_code");
                    data[i][3] = rs.getString("description");
                    data[i][4] = rs.getString("category");
                    data[i][5] = mascaraDinheiro(rs.getDouble("cost"), DINHEIRO_REAL);
                    data[i][6] = mascaraDinheiro(rs.getDouble("cost_total"), DINHEIRO_REAL);
                    data[i][7] = mascaraDinheiro(rs.getDouble("price"), DINHEIRO_REAL);
                    data[i][8] = mascaraDinheiro(rs.getDouble("price_total"), DINHEIRO_REAL);
                    if ((v2 % 1 == 0) && (!rs.getString("unity_measure").equals("KG"))) {
                        data[i][9] = v2.intValue();
                    } else {
                        data[i][9] = rs.getString("reserve_actual").replace(".", ",");
                    }
                    data[i][10] = rs.getString("unity_measure");
                    if (v2 <= v1) {
                        data[i][11] = ("SIM");
                    } else {
                        data[i][11] = ("NÃO");
                    }

                    if ((v2 % 1 == 0) && (!rs.getString("unity_measure").equals("KG"))) {
                        data[i][12] = v3.intValue();
                    } else {
                        data[i][12] = rs.getString("saldo").replace(".", ",");
                    }

                    data[i][0] = selected;

                } else if ((!isFinanceView) && (!isObservationView)) {

                    data[i][1] = (rs.getBoolean("prod_isActive") ? "NÃO" : "SIM");
                    data[i][2] = rs.getString("bar_code");
                    data[i][3] = rs.getString("description");
                    data[i][4] = rs.getString("category");

                    if (v2 % 1 == 0 && !rs.getString("unity_measure").equals("KG")) {
                        data[i][5] = v2.intValue();
                    } else {
                        data[i][5] = rs.getString("reserve_actual").replace(".", ",");
                    }
                    data[i][6] = rs.getString("unity_measure");
                    if (v2 <= v1) {
                        data[i][7] = ("SIM");
                    } else {
                        data[i][7] = ("NÃO");
                    }

                    if (v2 % 1 == 0 && !rs.getString("unity_measure").equals("KG")) {
                        data[i][8] = v3.intValue();
                    } else {
                        data[i][8] = rs.getString("saldo").replace(".", ",");
                    }

                    data[i][0] = selected;

                } else if ((!isFinanceView) && (isObservationView)) {

                    data[i][1] = (rs.getBoolean("prod_isActive") ? "NÃO" : "SIM");
                    data[i][2] = rs.getString("bar_code");
                    data[i][3] = rs.getString("description");
                    data[i][4] = rs.getString("category");
                    data[i][5] = rs.getString("observation");

                    if (v2 % 1 == 0 && !rs.getString("unity_measure").equals("KG")) {
                        data[i][6] = v2.intValue();
                    } else {
                        data[i][6] = rs.getString("reserve_actual").replace(".", ",");
                    }
                    data[i][7] = rs.getString("unity_measure");

                    if (v2 <= v1) {
                        data[i][8] = ("SIM");
                    } else {
                        data[i][8] = ("NÃO");
                    }

                    if (v2 % 1 == 0 && !rs.getString("unity_measure").equals("KG")) {
                        data[i][9] = v3.intValue();
                    } else {
                        data[i][9] = rs.getString("saldo").replace(".", ",");
                    }

                    data[i][0] = selected;
                }

                i++;
            }

            
        } catch (SQLException | java.lang.ArrayIndexOutOfBoundsException ex) {
            System.err.println("ERROR ON MYMODEL::" + ex);
            ////newXML.generateLog(ex.toString());
            Logger.getLogger(MyModelJtableProductsReserveControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getColumnName(int param) {
        return colNames[param];
    }

    @Override
    public int getRowCount() {
        return data.length;
    }

    @Override
    public int getColumnCount() {
        return data[0].length;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 0;
    }

    @Override
    public Class getColumnClass(int column) {
        Class klass = String.class;

        if (column == 0) {
            klass = Boolean.class;
        }

        return klass;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 0) {
            data[row][col] = (Boolean) value;
        }
    }
}

public class TableChecked_JtableProductsReserveControl {
}


//~ Formatted by Jindent --- http://www.jindent.com
