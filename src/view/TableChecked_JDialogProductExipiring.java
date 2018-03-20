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

class MyModelJTableProductExipiring extends AbstractTableModel {

    String[] colNames = {"", "CÓD. BARRA", "LOTE", "DESCRIÇÃO", "DATA PRODUÇÃO", "DATA VALIDADE", "VENCIDO", "DIAS P/ VENCER", "VERIFICADO", "QTD RESTANTE", "UN"};
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJTableProductExipiring(boolean isSelected) {

        String SQL = "SELECT t.`prod_bar_code_product`, t.`prod_description_product`,(i.`inv_quantity_insert` - i.`inv_value_used`) AS quantity_remainder, i.`inv_verify_expiring`, DATE_FORMAT(CURRENT_DATE(),'%d/%m/%Y') AS actual_day, DATE_FORMAT(i.`inv_date_production`,'%d/%m/%Y') AS inv_date_production, DATE_FORMAT(i.`inv_date_expiring`,'%d/%m/%Y') AS inv_date_expiring, ((UNIX_TIMESTAMP(i.`inv_date_expiring`) - UNIX_TIMESTAMP(CURRENT_DATE()))/60)/24/60 AS days_for_use, i.`inv_lot`,t.`idtbl_unity_measure` FROM tbl_product t INNER JOIN tbl_reserve_in i ON t.`prod_bar_code_product` = i.`prod_bar_code_product`  WHERE  DATE_ADD(i.`inv_date_expiring`, INTERVAL -" + BeanTbl.getPar() + " DAY) <= CURRENT_DATE()  AND  t.`prod_isActive` = 1  AND i.`inv_isControlExpiring` = 1 AND  i.`inv_isClosed` = 0 ORDER BY i.`inv_date_expiring`;";

        try {
            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(SQL);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(SQL);

            int i = 0;

            while (rs.next()) {

                data[i][1] = rs.getString("prod_bar_code_product");
                data[i][2] = rs.getString("inv_lot");
                data[i][3] = rs.getString("prod_description_product");
                data[i][4] = rs.getString("inv_date_production");
                data[i][5] = rs.getString("inv_date_expiring");
                if (rs.getInt("days_for_use") > 0) {
                    data[i][6] = "NÃO";
                } else {
                    data[i][6] = "SIM";
                }
                data[i][7] = rs.getInt("days_for_use");
                if (rs.getBoolean("inv_verify_expiring")) {
                    data[i][8] = "SIM";
                } else {
                    data[i][8] = "NÃO";
                }
                data[i][9] = rs.getDouble("quantity_remainder");
                data[i][10] = rs.getString("idtbl_unity_measure");
                data[i][0] = isSelected;

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

public class TableChecked_JDialogProductExipiring {
}


//~ Formatted by Jindent --- http://www.jindent.com
