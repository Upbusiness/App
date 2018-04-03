/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package action;

/**
 *
 * @author Rafael Recalcatti
 */
public class Login {
    
    
    private static int idLogin;
    private static String nameUser;

    /**
     * @return the idLogin
     */
    public static int getIdLogin() {
        return idLogin;
    }

    /**
     * @param idLogin the idLogin to set
     */
    public static void setIdLogin(int idLogin) {
        Login.idLogin = idLogin;
    }

    /**
     * @return the nameUser
     */
    public static String getNameUser() {
        return nameUser;
    }

    /**
     * @param aNameUser the nameUser to set
     */
    public static void setNameUser(String aNameUser) {
        nameUser = aNameUser;
    }
    
}
