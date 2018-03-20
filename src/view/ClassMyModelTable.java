/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.util.List;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author User
 */
public class ClassMyModelTable {
    
    private static MyModelJtableGeneric myModelJtableGeneric;
    private static TableColumnModel columnModel;
    private static int col_order;
    private static String ordernate = null;
    private static int count_click = 0;
    
    public static void popTable(final JTable table, final String sql,  final String[] header, final List<Object> arg, final boolean isChecked){
        
    
     try {
                        
                    columnModel = table.getColumnModel();
                    columnModel.addColumnModelListener(new TableColumnModelListener() {

                 @Override
                 public void columnAdded(TableColumnModelEvent e) {
                   
                 }

                 @Override
                 public void columnRemoved(TableColumnModelEvent e) {
                    
                 }

                        @Override
                        public void columnMoved(TableColumnModelEvent e) {

                            int indice = e.getFromIndex();
                            String campo = columnModel.getColumn(indice).getIdentifier().toString();
                            System.err.println("Col clicked::" + campo);
                            col_order = indice;
                            int pos_end = sql.indexOf("FROM");

                            String[] cols_name = sql.substring(6, pos_end).split(",");
                            count_click++;
                            System.err.println("N° Clickes:::" + count_click);
                            ordernate = cols_name[indice];
                            ordernate = ordernate.substring(0, ordernate.indexOf("AS"));
                                                       
                            if (ordernate != null) {

                                if (count_click == 1) {
                                    ordernate = " ORDER BY"+ ordernate +" DESC;";
                                }
                                if (count_click == 2) {
                                    ordernate = " ORDER BY"+ ordernate+";";
                                    count_click = 0;
                                }
                            }
                            System.err.println("ARGS::" + arg);
                            System.err.println("TABLE ORDENATE FOR:::"+ordernate);
                            pop_table(table, sql + ordernate, header, arg, isChecked);

                        }

                 @Override
                 public void columnMarginChanged(ChangeEvent e) {
                     
                     
                 }

                 @Override
                 public void columnSelectionChanged(ListSelectionEvent e) {
                     
                 }
             });
                    
                  pop_table(table, sql, header, arg, isChecked);
                            
                } catch (Exception ex) {
                    System.err.println("ERROR::" + ex);
                    ////newXML.generateLog(ex.toString());
                }
    
    }
    
    private static void pop_table(JTable table, String sql,String[] header, List<Object> arg, boolean isChecked){
        
        System.err.println("SQL ON POP::::"+sql);
        myModelJtableGeneric = new MyModelJtableGeneric( sql, header, arg, isChecked );
        table.setModel(myModelJtableGeneric);
        table.requestFocus(true);
        
    }
}
