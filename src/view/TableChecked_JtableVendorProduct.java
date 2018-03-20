package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import xml.NewXML;

class MyModelJtableVendorProduct extends AbstractTableModel {

    String[] colNames = {"", "CÓD. FORN ", "NOME FORNECEDOR"};
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableVendorProduct(boolean selected, String arg) {

        try {

            String SQL = ("SELECT t.`idtbl_vendor`, t.`prod_bar_code_product`, v.`ven_name` FROM tbl_product_vendor t INNER JOIN tbl_vendor v ON v.`idtbl_vendor` = t.`idtbl_vendor` WHERE t.`prod_bar_code_product` =" + arg);

            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(SQL);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(SQL);
            int i = 0;

            while (rs.next()) {

                data[i][1] = rs.getString("idtbl_vendor");
                data[i][2] = rs.getString("ven_name");
                data[i][0] = selected;

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

public class TableChecked_JtableVendorProduct {
}


//~ Formatted by Jindent --- http://www.jindent.com
