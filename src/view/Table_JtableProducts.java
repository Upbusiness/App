package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import xml.NewXML;

class MyModelJtableProducts extends AbstractTableModel {

    String[] colNames = {"CÓDIGO BARRA", "DESCRIÇÃO", "ESTOQUE"};

    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableProducts(String arg, int isViewActive) {

        try {

            String SQL;

            if ((arg == null) && (isViewActive != -1)) {

                SQL = ("SELECT t.`prod_bar_code_product`, t.`prod_description_product`, t.`prod_reserve_actual_product` FROM tbl_product t  WHERE prod_isActive = ? ORDER BY prod_description_product;");
                ps = Conn.connect().prepareStatement(SQL);
                ps.setInt(1, isViewActive);

            } else if ((arg == null) && (isViewActive == -1)) {

                SQL = ("SELECT t.`prod_bar_code_product`, t.`prod_description_product`, t.`prod_reserve_actual_product` FROM tbl_product t  ORDER BY prod_description_product;");
                ps = Conn.connect().prepareStatement(SQL);

            } else if ((arg != null) && (isViewActive != -1)) {

                SQL = ("SELECT t.`prod_bar_code_product`, t.`prod_description_product`, t.`prod_reserve_actual_product` FROM tbl_product t WHERE t.`idtbl_category_product` IN( ? ) AND  prod_isActive = ? ORDER BY prod_description_product;");
                ps = Conn.connect().prepareStatement(SQL);
                ps.setString(1, arg);
                ps.setInt(2, isViewActive);

            } else if ((arg == null) && (isViewActive == -1)) {

                SQL = ("SELECT t.`prod_bar_code_product`, t.`prod_description_product`, t.`prod_reserve_actual_product` FROM tbl_product t WHERE t.`idtbl_category_product` IN( ? ) ORDER BY prod_description_product;");
                ps = Conn.connect().prepareStatement(SQL);
                ps.setString(1, arg);

            }

            System.err.println("isACTIVE::::::" + isViewActive);
            rs = ps.executeQuery();
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = ps.executeQuery();
            int i = 0;

            while (rs.next()) {

                data[i][0] = rs.getString("prod_bar_code_product");
                data[i][1] = rs.getString("prod_description_product");
                data[i][2] = rs.getString("prod_reserve_actual_product");
                i++;
            }

        } catch (SQLException | java.lang.NullPointerException | java.lang.ArrayIndexOutOfBoundsException ex) {
            System.err.println("ERROR::" + ex);
            ////newXML.generateLog(ex.toString());
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
        return col == 10;
    }

    @Override
    public Class getColumnClass(int column) {
        Class klass = String.class;

        return klass;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 0) {
            data[row][col] = value;
        }
    }
}

public class Table_JtableProducts {
}
