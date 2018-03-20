package view;

//~--- non-JDK imports --------------------------------------------------------
import model.Conn;

//~--- JDK imports ------------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.table.AbstractTableModel;
import xml.NewXML;

class MyModelJTableChekedSales extends AbstractTableModel {
    
    DecimalFormat v = new DecimalFormat("0.00");
    String[] colNames = {"", "Cód. Pedido ", "Data","Hora","Cancelado","Fechado","Total R$","Desconto R$","Usuário"};
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJTableChekedSales(boolean selected, String sql) {
        

        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(sql);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(sql);

            int i = 0;

            while (rs.next()) {

                data[i][1] = rs.getString("idtbl_coupon");
                data[i][2] = rs.getString("date_coupon");
                data[i][3] = rs.getString("hour_coupon");
                data[i][4] = rs.getString("isCanceled");
                data[i][5] = rs.getString("isClosed");
                data[i][6] = v.format(rs.getDouble("total_coupon"));
                data[i][7] = v.format(rs.getDouble("discount_coupon"));
                data[i][8] = rs.getString("idtbl_user");
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

public class TableChecked_JDialog_Consult_Sale {
}



//~ Formatted by Jindent --- http://www.jindent.com
