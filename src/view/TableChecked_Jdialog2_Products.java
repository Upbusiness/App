package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import xml.NewXML;

class MyModel_3 extends AbstractTableModel {

    String[] colNames = {"", "COD. CAT ", "NOME CATEGORIA", "DESCRIÇÂO"};
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModel_3(boolean selected, List<String> listaArg) {

        String SQL = "SELECT t.`idtbl_category_product`, t.`description_category`, t.`observation_category` FROM tbl_category_product t ORDER BY t.`description_category`;";

        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(SQL);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(SQL);

            int i = 0;

            while (rs.next()) {
                int r = 0;

                if (!selected) {
                    data[i][1] = rs.getString("idtbl_category_product");
                    data[i][2] = rs.getString("description_category");
                    data[i][3] = rs.getString("observation_category");
                    data[i][0] = listaArg.contains(rs.getString("idtbl_category_product"));
                } else {
                    data[i][1] = rs.getString("idtbl_category_product");
                    data[i][2] = rs.getString("description_category");
                    data[i][3] = rs.getString("observation_category");
                    data[i][0] = selected;
                }
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

public class TableChecked_Jdialog2_Products {
}


//~ Formatted by Jindent --- http://www.jindent.com
