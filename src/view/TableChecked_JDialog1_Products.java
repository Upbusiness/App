package view;

//~--- non-JDK imports --------------------------------------------------------
import model.Conn;

//~--- JDK imports ------------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;
import xml.NewXML;

class MyModelJTableCheked extends AbstractTableModel {

    String[] colNames = {"", "CÓD. CATEGORIA ", "DESCRIÇÃO CATEGORIA", "PERCENTAGEM MÉDIA LUCRO"};
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJTableCheked(boolean selected) {
        String SQL = "SELECT t.`idtbl_category_product`,t.`description_category` , AVG(p.`prod_percentage_profit_product`)AS media FROM tbl_category_product t INNER JOIN tbl_product p ON p.`idtbl_category_product` = t.`idtbl_category_product` GROUP BY t.`idtbl_category_product` ORDER BY t.`description_category`";

        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(SQL);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(SQL);

            int i = 0;

            while (rs.next()) {

                data[i][1] = rs.getString("idtbl_category_product");
                data[i][2] = rs.getString("description_category");
                data[i][3] = rs.getString("media");
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

public class TableChecked_JDialog1_Products {
}



//~ Formatted by Jindent --- http://www.jindent.com
