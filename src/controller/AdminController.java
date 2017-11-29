
package controller;

import model.Admin;

/**
 * @author Luiz Ferreira
 * @since 24/11/2017
 * Controller para operações relacionadas ao operador do sistema
 */
public class AdminController {
    public static boolean login(String username, String password) {
        Admin admin = new Admin("admin","admin");
        if(!username.equals("admin"))
            return false;
        return admin.login(password);
    }
}
