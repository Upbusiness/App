package view;

//~--- non-JDK imports --------------------------------------------------------
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.AbstractTableModel;
import model.Conn;
import util.Moeda;
import xml.NewXML;

class MyModelJtableDetailedReport extends AbstractTableModel {

    String[] colNames = {"", "Cód Controle", "Usuário Inicial", "Usuário Final", "Data Abertura", "Hora Abertura", "Data Fechamento", "Hora Fechamento", "Valor Inicial", "Fechado", "Turno", "Terminal"};
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableDetailedReport(boolean selected) {

        try {

            String SQL = ("SELECT t.`idtbl_cashier`,"
                    + " t.`idtbl_user`,"
                    + " t.`user_end`,"
                    + " DATE_FORMAT(t.`hour_opening_cashier`,'%d/%m/%Y') AS date_opening,"
                    + " DATE_FORMAT(t.`hour_opening_cashier`,'%h:%i:%s') AS time_opening,"
                    + " DATE_FORMAT(t.`hour_close_cashier`,'%d/%m/%Y') AS date_close,"
                    + " DATE_FORMAT(t.`hour_close_cashier`,'%h:%i:%s') AS time_closing,"
                    + " t.`value_initial`,"
                    + " t.`isClosed`,"
                    + " t.`turn_operate`,"
                    + " t.`idtbl_terminal`"
                    + "  FROM tbl_cashier t ORDER BY t.`hour_opening_cashier` DESC;");

            stmt = Conn.connect().createStatement();
            rs = stmt.executeQuery(SQL);
            rs.last();
            data = new Object[rs.getRow()][colNames.length];
            rs = stmt.executeQuery(SQL);
            int i = 0;

            while (rs.next()) {

                if (!selected) {
                    data[i][1] = rs.getString("idtbl_cashier");
                    data[i][2] = rs.getString("idtbl_user");
                    data[i][3] = rs.getString("user_end");
                    data[i][4] = rs.getString("date_opening");
                    data[i][5] = rs.getString("time_opening");
                    data[i][8] = Moeda.mascaraDinheiro(rs.getDouble("value_initial"), Moeda.DINHEIRO_REAL);
                    if (rs.getBoolean("isClosed")) {
                        data[i][9] = "SIM";
                        data[i][6] = rs.getString("date_close");
                        data[i][7] = rs.getString("time_closing");
                    } else {
                        data[i][9] = "NÂO";
                        data[i][6] = "";
                        data[i][7] = "";
                    }
                    data[i][10] = rs.getString("turn_operate");
                    data[i][11] = rs.getString("idtbl_terminal");
                    data[i][0] = selected;
                } else {
                    data[i][1] = rs.getString("idtbl_cashier");
                    data[i][2] = rs.getString("idtbl_user");
                    data[i][3] = rs.getString("user_end");
                    data[i][4] = rs.getString("date_opening");
                    data[i][5] = rs.getString("time_opening");
                    data[i][8] = Moeda.mascaraDinheiro(rs.getDouble("value_initial"), Moeda.DINHEIRO_REAL);
                    if (rs.getBoolean("isClosed")) {
                        data[i][9] = "SIM";
                        data[i][6] = rs.getString("date_close");
                        data[i][7] = rs.getString("time_closing");
                    } else {
                        data[i][9] = "NÂO";
                        data[i][6] = "";
                        data[i][7] = "";
                    }
                    data[i][10] = rs.getString("turn_operate");
                    data[i][11] = rs.getString("idtbl_terminal");
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

public class TableChecked_JtableDetailedReport {
}


//~ Formatted by Jindent --- http://www.jindent.com
