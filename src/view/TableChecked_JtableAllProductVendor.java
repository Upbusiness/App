package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import xml.NewXML;

class MyModelJtableAllProductVendor extends AbstractTableModel {

    String[] colNames = {"", "CÓDIGO ", "DESCRIÇÂO"};
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableAllProductVendor(String arg) {

        try {

            String SQL;
            int i;

            if (arg == null) {

                SQL = ("SELECT t.`prod_bar_code_product`, t.`prod_description_product` FROM tbl_product t ORDER BY t.`prod_description_product`;");
                stmt = Conn.connect().createStatement();
                rs = stmt.executeQuery(SQL);
                rs.last();
                data = new Object[rs.getRow()][colNames.length];
                rs = stmt.executeQuery(SQL);
                i = 0;

            } else {

                SQL = ("SELECT t.`prod_bar_code_product`, t.`prod_description_product` FROM tbl_product t WHERE t.`prod_description_product` LIKE ? ORDER BY t.`prod_description_product`;");
                ps = Conn.connect().prepareStatement(SQL);
                ps.setString(1, arg);
                rs = ps.executeQuery();
                rs.last();
                data = new Object[rs.getRow()][colNames.length];
                rs = ps.executeQuery();
                i = 0;

            }

            while (rs.next()) {

                data[i][1] = rs.getString("prod_bar_code_product");
                data[i][2] = rs.getString("prod_description_product");
                data[i][0] = false;
                i++;
            }
        } catch (SQLException ex) {
            System.err.println("ERROR::" + ex);
            //newXML.generateLog(ex.toString());
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

public class TableChecked_JtableAllProductVendor {
}


//~ Formatted by Jindent --- http://www.jindent.com
