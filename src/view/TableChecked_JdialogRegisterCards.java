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

class MyModelJtableRegisterCards extends AbstractTableModel {

    String[] colNames = {"", "COD. CAD. CARTÃO", "NOME CARTÃO", "TIPO CARTÃO", "MENSALIDADE"};
    PreparedStatement ps;
    Statement stmt;
    ResultSet rs;
    Object[][] data;
    private static final NewXML newXML = new NewXML();

    public MyModelJtableRegisterCards(boolean selected) {

        String SQL = "SELECT t.`idtbl_cards`, t.`name_card`, t.`type_card`, t.`equipment_card`, t.`tariff_card`, t.`isActive_card`, t.`expiring_date_card`, t.`account` FROM tbl_cards t;";

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
                    data[i][1] = rs.getString("idtbl_cards");
                    data[i][2] = rs.getString("name_card");
                    data[i][3] = rs.getString("type_card");
                    data[i][4] = Moeda.mascaraDinheiro(rs.getDouble("tariff_card"), Moeda.DINHEIRO_REAL);
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

public class TableChecked_JdialogRegisterCards {
}


//~ Formatted by Jindent --- http://www.jindent.com
