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

class MyModelJtableClosuresCashier extends AbstractTableModel {

    String[] colNames = {
        "Código",
        "Data Abertura",
        "Hora Abertura",
        "Data Fechamento",
        "Hora Fechamento",
        "Fechado",
        "Terminal",
        "Turno",
        "Usuário Inicial",
        "Usuário Final",
        "Valor Inicial"};
    

    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    DecimalFormat v = new DecimalFormat("0.00");
    DecimalFormat v2 = new DecimalFormat("0.000");
    private static final NewXML newXML = new NewXML();

    public MyModelJtableClosuresCashier(char terminal) {

        try {

            stmt = Conn.connect().createStatement();
            String sql = ("SELECT "
                    + "t.`idtbl_cashier`, "
                    + "t.`idtbl_user`, "
                    + "t.`user_end`, "
                    + "TIME_FORMAT(t.`hour_opening_cashier`,'%H:%i:%s') AS hour_openinig, "
                    + "DATE_FORMAT(t.`hour_opening_cashier`,'%d/%m/%Y') AS date_opening, "
                    + "TIME_FORMAT(t.`hour_close_cashier`,'%H:%i:%s') AS hour_closure, "
                    + "DATE_FORMAT(t.`hour_close_cashier`,'%d/%m/%Y') AS date_closure, "
                    + "t.`value_initial`, "
                    + "t.`isClosed`, "
                    + "t.`turn_operate`, "
                    + "t.`idtbl_terminal` "
                    + "FROM tbl_cashier t ORDER BY t.`hour_opening_cashier` DESC;");

            rs = stmt.executeQuery(sql);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(sql);
            int i = 0;

            while (rs.next()) {

                data[i][0] = rs.getString("idtbl_cashier");
                data[i][1] = rs.getString("date_opening");
                data[i][2] = rs.getString("hour_openinig");
                data[i][3] = rs.getString("date_closure");
                data[i][4] = rs.getString("hour_closure");
                data[i][5] = ((rs.getBoolean("isClosed")) ? "SIM" : "NÃO");
                data[i][6] = rs.getString("idtbl_terminal");
                data[i][7] = rs.getString("turn_operate");
                data[i][8] = rs.getString("idtbl_user");
                data[i][9] = rs.getString("user_end");
                data[i][10] = v.format(rs.getDouble("value_initial"));

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

public class Table_JtableClosuresCashier {
}
