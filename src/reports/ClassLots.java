/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reports;

/**
 *
 * @author Rafael recalcatti
 */
public class ClassLots {
    
  private  String id_lot;
  private  String num_lot;
  private  String date_reg;
  private  String date_prod;
  private  String date_exp;
  private  int qtd_insert;
  private  int packs;

    public ClassLots(String id_lot, String num_lot, String date_reg, String date_prod, String date_exp, int qtd_insert, int packs) {
        
        this.id_lot = id_lot;
        this.num_lot = num_lot;
        this.date_reg = date_reg;
        this.date_prod = date_prod;
        this.date_exp = date_exp;
        this.qtd_insert = qtd_insert;
        this.packs = packs;
        
        
    }

  
    /**
     * @return the id_lot
     */
    public String getId_lot() {
        return id_lot;
    }

    /**
     * @param id_lot the id_lot to set
     */
    public void setId_lot(String id_lot) {
        this.id_lot = id_lot;
    }

    /**
     * @return the num_lot
     */
    public String getNum_lot() {
        return num_lot;
    }

    /**
     * @param num_lot the num_lot to set
     */
    public void setNum_lot(String num_lot) {
        this.num_lot = num_lot;
    }

    /**
     * @return the date_reg
     */
    public String getDate_reg() {
        return date_reg;
    }

    /**
     * @param date_reg the date_reg to set
     */
    public void setDate_reg(String date_reg) {
        this.date_reg = date_reg;
    }

    /**
     * @return the date_prod2016
     */
    public String getDate_prod() {
        return date_prod;
    }

    /**
     * @param date_prod2016 the date_prod2016 to set
     */
    public void setDate_prod(String date_prod2016) {
        this.date_prod = date_prod2016;
    }

    /**
     * @return the date_exp
     */
    public String getDate_exp() {
        return date_exp;
    }

    /**
     * @param date_exp the date_exp to set
     */
    public void setDate_exp(String date_exp) {
        this.date_exp = date_exp;
    }

    /**
     * @return the qtd_insert
     */
    public int getQtd_insert() {
        return qtd_insert;
    }

    /**
     * @param qtd_insert the qtd_insert to set
     */
    public void setQtd_insert(int qtd_insert) {
        this.qtd_insert = qtd_insert;
    }

    /**
     * @return the packs
     */
    public int getPacks() {
        return packs;
    }

    /**
     * @param packs the packs to set
     */
    public void setPacks(int packs) {
        this.packs = packs;
    }

    
}
