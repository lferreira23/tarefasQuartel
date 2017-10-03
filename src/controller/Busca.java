package controller;

import model.Militar;
import java.sql.SQLException;
import model.DAOMilitar;

/**
 * @author Luiz Ferreira
 * @since 26/08/2017
 */
public class Busca {
     public static Militar localizaMilitar(String nome) throws SQLException, ClassNotFoundException{
        Militar sold = new Militar();
        sold = DAOMilitar.buscarMilitarCPF(nome);
        return sold;
    
      }
}
