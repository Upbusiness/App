package view;

//~--- non-JDK imports --------------------------------------------------------
import action.AccountClient;
import action.Bean;
import action.Client;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import xml.NewXML;

class MyModelJtableAccountClient extends AbstractTableModel {

    String[] colNames = {"","CÓD. CONTA","CÓD.CUPOM","CLIENTE","DATA VENDA","TIPO CONTA","VALOR R$","SITUAÇÃO"};
    DecimalFormat v = new DecimalFormat("0.00");
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableAccountClient(Object aClient) {

        try {
                        
            String sql = ((aClient == null) ?
                      "SELECT t.`idtbl_account`, t.`idtbl_coupon`, ct.`name_client`, tp.`description_type_payment_coupon`, DATE_FORMAT(t.`date_account`,'%d/%m/%Y %H:%i %V') AS `_date_account`, t.`value_account`, t.`status_acount` FROM tbl_account t INNER JOIN tbl_type_payment_coupon tp ON t.`idtbl_coupon` = tp.`idtbl_coupon` INNER JOIN tbl_client ct ON t.`idtbl_client` = ct.`idtbl_client`WHERE t.`idtbl_client` != ? ORDER BY t.`date_account` DESC;" 
                    : "SELECT t.`idtbl_account`, t.`idtbl_coupon`, ct.`name_client`, tp.`description_type_payment_coupon`, DATE_FORMAT(t.`date_account`,'%d/%m/%Y %H:%i %V') AS `_date_account`, t.`value_account`, t.`status_acount` FROM tbl_account t INNER JOIN tbl_type_payment_coupon tp ON t.`idtbl_coupon` = tp.`idtbl_coupon` INNER JOIN tbl_client ct ON t.`idtbl_client` = ct.`idtbl_client`WHERE t.`idtbl_client` = ? ORDER BY t.`date_account` DESC;");
            Object id = ((aClient == null) ? "0" : aClient);
            ps = Conn.connect().prepareStatement(sql);           
            ps.setObject(1, id);
            rs = ps.executeQuery();
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = ps.executeQuery();
            int i = 0;

            while (rs.next()) {

                data[i][0] = false;
                data[i][1] = rs.getString("idtbl_account");
                data[i][2] = rs.getString("idtbl_coupon");
                data[i][3] = rs.getString("name_client");
                data[i][4] = rs.getString("_date_account");                   
                data[i][5] = rs.getString("description_type_payment_coupon");
                data[i][6] = v.format(rs.getDouble("value_account"));
                data[i][7] = (rs.getInt("status_acount") == 0 ? "ABERTA" : rs.getInt("status_acount") == 1 ? "PAGA" : rs.getInt("status_acount") == 2 ? "VENCIDA" : "STATUS INVÁLIDO");   
                i++;
            }

        } catch (SQLException | java.lang.NullPointerException | java.lang.ArrayIndexOutOfBoundsException ex) {
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
        
        return (Arrays.toString(data).replace("[", "").replace("]", "").isEmpty() ? 0 : data[0].length);
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

public class Table_JtableAccountClient {
    
}
