package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import xml.NewXML;

class MyModelJtableMovementCashier extends AbstractTableModel {

    String[] colNames = {"Data\\Hora", "Usuário", "Turno","Terminal","Valor Usado","Tipo Operação","Descrição Operação"};
    DecimalFormat v = new DecimalFormat("0.00");
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableMovementCashier(String terminal, String type) {

        try {

                String sql = "SELECT DATE_FORMAT(date_opening,'%d/%m/%Y %H:%i:%s') AS date_hour,(SELECT c.`idtbl_user` FROM tbl_user u WHERE u.`idtbl_user` = c.`idtbl_user`) AS user, value_used, turn_opening_cashier, terminal_opening_cashier, description_opening, type_opening FROM tbl_opening_cashier t INNER JOIN tbl_cashier c ON c.`idtbl_cashier` = t.`idtbl_cashier` WHERE t.`idtbl_cashier` = (SELECT c.`idtbl_cashier` FROM tbl_cashier c WHERE idtbl_terminal = ? AND isClosed = 0) AND t.`type_opening` = ?;";
                ps = Conn.connect().prepareStatement(sql);
                ps.setString(1, terminal);
                ps.setString(2,type);

                   
            rs = ps.executeQuery();
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = ps.executeQuery();
            int i = 0;

            while (rs.next()) {

                data[i][0] = rs.getString("date_hour");
                data[i][1] = rs.getString("user");
                data[i][2] = rs.getString("turn_opening_cashier");
                data[i][3] = rs.getString("terminal_opening_cashier");
                data[i][4] = "R$ "+v.format(rs.getDouble("value_used"));
                data[i][5] = (rs.getInt("type_opening") == 1 ? "Retirada" : "Inserção");
                data[i][6] = rs.getString("description_opening");
                
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

public class Table_JtableMovementCashier {
}
