/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rafiusk
 */
public final class PreencheTabela extends AbstractTableModel{

    private int rownum;
    private DecimalFormat cd_3 = new DecimalFormat("0.000");
    private DecimalFormat cd_2 = new DecimalFormat("0.00");
    private static final String[] colNames = {"Item", "Descrição","UN", "Qtd", "Preço", "% Contribuição", "Total"};
    private ArrayList<Object[]> ResultSets;
    private ResultSetMetaData metaData;

  

    public PreencheTabela(ResultSet results) throws Exception {
       setResult(results);
    }

    public int getRowCount() {
        return ResultSets.size();
    }

    public int getColumnCount() {
        return colNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        Object[] row = ResultSets.get(rowIndex);

        return row[columnIndex];

    }
    @Override
public String getColumnName(int param){

    return colNames[param];
}

public void setResult(ResultSet rs)throws SQLException{

    ResultSets=new ArrayList<Object[]>();

    while(rs.next()){

        Object[] row={

            rs.getString("number_iten"),
            rs.getString("prod_description_product"),
            rs.getString("idtbl_unity_measure"),
            rs.getString("product_quantity"),
            rs.getString("product_price"),
            rs.getString("prod_percentage_contribution_product"),
            rs.getDouble("valor_total")       
     

        };
        ResultSets.add(row);
        }
    fireTableStructureChanged();
    }
    public void deleteRow(int row){

        ResultSets.remove(row);
        fireTableRowsDeleted(row, row);
}
}
