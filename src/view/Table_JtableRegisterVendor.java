package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import xml.NewXML;

class MyModelJtableRegisterVendor extends AbstractTableModel {

    String[] colNames = {"CÓDIGO ", "NOME FORNECEDOR", "FONE FORNECEDOR", "CEL. FORNECEDOR"};
    ;
        PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableRegisterVendor(String arg) {

        try {
            String SQL;
            if (arg == null) {
                SQL = ("SELECT t.`idtbl_vendor`, t.`ven_name`, t.`ven_phone`, t.`ven_celular` FROM tbl_vendor t ORDER BY  t.`ven_name`;");
            } else {
                SQL = ("SELECT t.`idtbl_vendor`, t.`ven_name`, t.`ven_phone`, t.`ven_celular` FROM tbl_vendor t " + arg);
            }
            System.err.println("SQL:::" + SQL);
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(SQL);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(SQL);
            int i = 0;

            while (rs.next()) {

                data[i][0] = rs.getString("idtbl_vendor");
                data[i][1] = rs.getString("ven_name");
                data[i][2] = rs.getString("ven_phone");
                data[i][3] = rs.getString("ven_celular");

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

        return klass;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (col == 0) {
            data[row][col] = value;
        }
    }
}

public class Table_JtableRegisterVendor {
}





//~ Formatted by Jindent --- http://www.jindent.com
