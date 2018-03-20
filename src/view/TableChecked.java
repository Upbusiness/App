package view;

//~--- non-JDK imports --------------------------------------------------------
import action.BeanTbl;
import model.Conn;

//~--- JDK imports ------------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.AbstractTableModel;
import xml.NewXML;

class MyModel extends AbstractTableModel {

    String[] colNames = {"", "Cod. Barra", "Descrição", "Valor R$", "Qntd", ""};
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModel() {
        System.err.println("BEAN PAR NO MyMode::l" + BeanTbl.getPar());
        String SQL = "SELECT `prod_inv_isSelected`, `prod_bar_code_product`, `prod_inv_description_product`, `prod_inv_cost_price`, `prod_inv_quantity`,`idtbl_product_invoice` FROM tbl_product_invoice WHERE idtbl_invoice = '" + BeanTbl.getPar() + "';";
        System.err.println("SQL::" + SQL);
        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(SQL);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(SQL);

            int i = 0;

            while (rs.next()) {
                int r = 0;

                data[i][1] = rs.getString("prod_bar_code_product");
                data[i][2] = rs.getString("prod_inv_description_product");
                data[i][3] = rs.getString("prod_inv_cost_price");
                data[i][4] = rs.getString("prod_inv_quantity");
                data[i][5] = rs.getString("idtbl_product_invoice");
                data[i][0] = rs.getBoolean("prod_inv_isSelected");

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

public class TableChecked {
}


//~ Formatted by Jindent --- http://www.jindent.com
