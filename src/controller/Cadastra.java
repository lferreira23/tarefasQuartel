
package controller;

import model.Militar;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.DAOMilitar;

/**
 * @author Luiz Ferreira
 * @since 26/08/2017
 */

public class Cadastra {
     public static void receberMilitar(Militar sold) throws SQLException, ClassNotFoundException {
        if(sold.getIdade()< 18){
            JOptionPane.showMessageDialog(null,"Militar menor de idade!!!!");
        }
        else{
            DAOMilitar.cadastrarNovoMilitar(sold);
            JOptionPane.showMessageDialog(null,"Dados do militar gravados com sucesso");
        }
    }
    
}
