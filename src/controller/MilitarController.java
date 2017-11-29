
package controller;

import dao.DAOMilitar;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.EnumPenalidade;
import model.Militar;
import model.LogAtividade;

/**
 * @author Luiz Ferreira
 * @since 24/11/2017
 * Controller para tela de gerenciamento de dados do Militar
 */
public class MilitarController {
    public static void CadastrarMilitar(Militar militar) {
        if(militar.getIdade() < 18){
            JOptionPane.showMessageDialog(null,"Militar menor de idade!","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        else {
            boolean result;
            try {
                result = DAOMilitar.cadastrarMilitar(militar);
            } catch(Exception ex) {
                ex.printStackTrace();
                result = false;
            }
            
            if(result)
                JOptionPane.showMessageDialog(null,"Militar cadastrado com sucesso.","Sucesso",JOptionPane.PLAIN_MESSAGE);
            else
                JOptionPane.showMessageDialog(null,"Não foi possível cadastrar o militar.","Erro",JOptionPane.ERROR_MESSAGE);

        }
    }
    
    public static void alterarMilitar(Militar militar) {
        boolean result;
        try {
            result = DAOMilitar.alterarMilitar(militar);
        }catch(Exception ex) {
            ex.printStackTrace();
            result = false;
        }
        
        if(result)
            JOptionPane.showMessageDialog(null,"Dados do militar alterados com sucesso.","Sucesso",JOptionPane.PLAIN_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"Não foi possível alterar os dados do militar.","Erro",JOptionPane.ERROR_MESSAGE);
    }
    
    public static Militar buscarMilitar(int codigo) {
        Militar militar = null;
        try {
            militar = DAOMilitar.buscarMilitar(codigo);
        } catch (SQLException ex) {
            Logger.getLogger(MilitarController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MilitarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return militar;
    }
    
    public static Militar buscarMilitarCPF(String cpf) {
        Militar militar = null;
        try {
            militar = DAOMilitar.buscarMilitarCPF(cpf);
        } catch (SQLException ex) {
            Logger.getLogger(MilitarController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MilitarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return militar;
    }
    
    public static Militar buscarMilitarRG(String rg, String estado) {
        Militar militar = null;
        try {
            militar = DAOMilitar.buscarMilitarRG(rg,estado);
        } catch (SQLException ex) {
            Logger.getLogger(MilitarController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MilitarController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return militar;
    }
    
    public static void excluirMilitar(Militar militar) {
        boolean result;
        try {
            result = DAOMilitar.excluirMilitar(militar.getCodigo());
        }
        catch(Exception ex) {
            result = false;
        }
        
        if(result)
            JOptionPane.showMessageDialog(null,"Registro de militar excluído com sucesso","Sucesso",JOptionPane.PLAIN_MESSAGE);
        else
            JOptionPane.showMessageDialog(null,"Registro não encontrado","Aviso",JOptionPane.WARNING_MESSAGE);
    }
    
    public static List<Militar> listarMilitares() {
        List<Militar> militares;
        try {
            militares = DAOMilitar.listarMilitares();
        }
        catch(Exception ex) {
            militares = new ArrayList<>();
        }
        return militares;
    }
    
    public static boolean logExecucaoAtividade(Militar militar, boolean atividadesRealizadas, int grauPenalidade, Date data) {
        if(!atividadesRealizadas) {
            if(grauPenalidade >= EnumPenalidade.getCount()) {
                JOptionPane.showMessageDialog(null,"Penalidade máxima já atribuída para este militar","Aviso",JOptionPane.WARNING_MESSAGE);
                return false;
            }

            militar.setGrauPenalidade(grauPenalidade);
            alterarMilitar(militar);
        }
        
        boolean result;
        try {
            result = DAOMilitar.logExecucaoAtividade(militar,atividadesRealizadas,grauPenalidade,data);
        }
        catch(Exception ex) {
            result = false;
            JOptionPane.showMessageDialog(null,"Não foi possível aumentar a penalidade","Aviso",JOptionPane.WARNING_MESSAGE);
        }
        return result;
    }
    
    public static List<LogAtividade> listarAtividadesExecutadas(Militar militar) {
        List<LogAtividade> penalidades;
        try {
            penalidades = DAOMilitar.listarAtividadesExecutadas(militar);
        }
        catch(Exception ex) {
            penalidades = new ArrayList<>();
        }
        return penalidades;
    }
    
}
