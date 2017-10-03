
package controller;

import java.sql.SQLException;
import model.DAOMilitar;
import model.Militar;

/**
 * @author Luiz Ferreira
 * @since 26/08/2017
 */
public class Altera {
    
    public static Militar buscarClienteCPF(String cpf) throws SQLException, ClassNotFoundException {
        Militar cli = new Militar();
        cli = DAOMilitar.buscarMilitarCPF(cpf);
        return cli;
    }

    public static void alteraCliente(Militar cli) throws SQLException, ClassNotFoundException {
        DAOMilitar.alterarMilitarCPF(cli);
    }
    
}
