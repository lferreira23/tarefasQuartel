
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * @author Luiz Ferreira
 * @since 26/08/2017
 */

public class DAOMilitar {
     static ResultSet rs;
    static Connection conexao;
    static Statement comandos;
    
    public static boolean cadastrarNovoMilitar(Militar milit) throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        comandos =  conexao.createStatement();
        sql = "INSERT INTO soldado VALUES(" 
                + milit.getCodigo()+","
                +"'"+ milit.getNome() +"',"  
                +"'"+ milit.getCpf() +"',"
                +"'"+ milit.getRg() + "',"
                +"'"+ milit.getEstado() + "',"
                +"'"+ milit.getSexo() + "',"
                +"'"+ milit.getNascimento() + "',"
                +"'"+ milit.getPatente()+"',"
                + milit.getIdade()+","
                + milit.isAlimentarCavalos()+ ","
                + milit.isCozinharArmoco()+ ","
                + milit.isCozinharJanta()+ ","
                + milit.isDescascar()+ ","
                + milit.isLevantarBandeira()+ ","
                + milit.isLimparBanheiro()+ ","
                + milit.isLimparCozinha()+ ","
                + milit.isRecarregarArmamento()+ ","
                + milit.isTrocarEncanamento()+ ","
                + milit.isLimparEstabulos()+ ")";
                
        return comandos.executeUpdate(sql) > 0;
    }
    
    //Metodo para buscar um militar pelo seu cpf
    public static Militar buscarMilitarCPF(String nome) throws SQLException, ClassNotFoundException{
        String sql;
        Militar milit = new Militar();
        conexao = getConnection();
        comandos = conexao.createStatement();
        sql = "SELECT * FROM soldado WHERE nome_sold = '" + nome + "'";
        rs = comandos.executeQuery(sql);
       
            while(rs.next()){
                
                milit.setCodigo(Integer.parseInt(rs.getString("codigo")));
                milit.setNome(rs.getString("nome_sold"));
                milit.setCpf(rs.getString("cpf_sold"));
                milit.setRg(rs.getString("rg_sold"));
                milit.setEstado(rs.getString("estado_sold"));
                milit.setSexo(rs.getString("sexo_sold"));
                milit.setNascimento(rs.getString("nascimento"));
                milit.setPatente(rs.getString("patente_sold"));
                milit.setIdade(Integer.parseInt(rs.getString("idade_sold")));  
                milit.setAlimentarCavalos(rs.getBoolean("alimentar"));
                milit.setCozinharArmoco(rs.getBoolean("cozinhar_almoço"));
                milit.setCozinharJanta(rs.getBoolean("cozinhar_jantar"));
                milit.setDescascar(rs.getBoolean("descascar"));
                milit.setLevantarBandeira(rs.getBoolean("bandeira")); 
                milit.setLimparBanheiro(rs.getBoolean("banheiro"));
                milit.setLimparCozinha(rs.getBoolean("limpar_cozinha"));
                milit.setRecarregarArmamento(rs.getBoolean("armamento"));
                milit.setTrocarEncanamento(rs.getBoolean("encanamento"));
                milit.setLimparEstabulos(rs.getBoolean("estabulos"));   
            }
        
        return milit;
    }
    //metodo para excluir um militar selecionado pelo cpf
    public static void deletarMilitarCPF(String nome) throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
        comandos = conexao.createStatement();
        sql = "DELETE FROM soldado WHERE nome_sold = '" + nome + "'";
        
        if(comandos.executeUpdate(sql)>0)
            JOptionPane.showMessageDialog(null,"Registro excluido com sucesso");
        else
            JOptionPane.showMessageDialog(null,"Registro não encontrado");
    }
    
    //metodo para estabelecer a conezão com o BD Negocio
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Connection con;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/quartel", "quartel", "123456");
        return con;
    }
   
    public static void alterarMilitarCPF(Militar milit) throws SQLException, ClassNotFoundException {
        String sql;
        conexao = getConnection();
         Statement stmt = conexao.createStatement();
        sql = "UPDATE soldado SET "
                + "  cpf_sold = '" + milit.getCpf() + "'"
                + ", nome_sold = '" + milit.getNome()+ "'"
                + ", rg_sold = '" + milit.getRg()+ "'"
                + ", estado_sold = '" + milit.getEstado()+ "'"
                + ", sexo_sold = '" + milit.getSexo()+ "'"
                + ", nascimento = '" + milit.getNascimento()+ "'"
                + ", patente_sold = '" + milit.getPatente()+ "'"
                + ", idade_sold = " + milit.getIdade()
                + ", alimentar = " + milit.isAlimentarCavalos()
                + ", cozinhar_almoço = " + milit.isCozinharArmoco()
                + ", cozinhar_jantar = " + milit.isCozinharJanta()
                + ", descascar = " + milit.isDescascar()
                + ", bandeira = " + milit.isLevantarBandeira()
                + ", banheiro = " + milit.isLimparBanheiro()
                + ", limpar_cozinha = " + milit.isLimparCozinha()
                + ", armamento = " + milit.isRecarregarArmamento()
                + ", encanamento = " + milit.isTrocarEncanamento()
                + ", estabulos = " + milit.isLimparEstabulos()
                + " WHERE nome_sold = '" + milit.getNome() + "'";
        
         if(stmt.executeUpdate(sql) > 0)
             JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
    }
    
}
