
package controller;

import java.sql.SQLException;
import model.DAOMilitar;

/**
 *
 * @author Luiz Ferreira
 * @since 26/08/2017
 */
public class Exclui {
      
    public static void excluirMilitar(String nome) throws SQLException, ClassNotFoundException{
        DAOMilitar.deletarMilitarCPF(nome);
        
    }
    
}
