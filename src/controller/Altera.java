
package controller;

import java.sql.SQLException;
import model.DAOMilitar;
import model.Militar;

/**
 * @author Luiz Ferreira
 * @since 26/08/2017
 */
public class Altera {
    
    public static void alteraCliente(Militar milit) throws SQLException, ClassNotFoundException {
        DAOMilitar.alterarMilitarCPF(milit);
    }
    
}
