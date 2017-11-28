
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.EnumPatente;
import model.EnumTarefa;
import model.Militar;

/**
 * @author Luiz Ferreira
 * @since 26/08/2017
 * Classe para executar persistência dos dados do Militar
 */

public class DAOMilitar {
    private static String TABLE_NAME = "MILITAR";
    public static boolean cadastrarMilitar(Militar militar) throws SQLException, ClassNotFoundException {
        Connection conexao = ConnectionManager.getConnection();
        String sql = "INSERT INTO " + TABLE_NAME
                +"(nome,cpf,rg,estado,sexo,nascimento,patente"
                +",descascar_batatas,limpar_banheiro,limpar_cozinha"
                +",cozinhar_almoco,cozinhar_janta,alimentar_cavalos"
                +",limpar_estabulos,recarregar_armamento,trocar_encanamento"
                +",levantar_bandeira) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, militar.getNome());
        stmt.setString(2, militar.getCpf());
        stmt.setString(3, militar.getRg());
        stmt.setString(4, militar.getEstado());
        stmt.setString(5, ""+militar.getSexo());
        stmt.setDate(6, new java.sql.Date(militar.getNascimento().getTime()));
        stmt.setInt(7, militar.getPatente().ordinal());
        for(int i = 0; i < EnumTarefa.values().length; ++i) {
            int val = militar.fazAtividade(EnumTarefa.values()[i]) ? 1 : 0; //conversão de boolean para inteiro
            stmt.setInt(8+i, val);
        }
        
        return stmt.executeUpdate() > 0;
    }
    
    private static Militar buscarMilitarAux(String sql) throws SQLException {
        Connection conexao = ConnectionManager.getConnection();
        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Militar militar = null;
        if(rs.next()) {
            militar = new Militar();
            militar.setCodigo(rs.getInt("codigo"));
            militar.setNome(rs.getString("nome"));
            militar.setCpf(rs.getString("cpf"));
            militar.setRg(rs.getString("rg"));
            militar.setEstado(rs.getString("estado"));
            militar.setSexo(rs.getString("sexo").toUpperCase().charAt(0));
            militar.setNascimento(new Date(rs.getDate("nascimento").getTime()));
            militar.setPatente(EnumPatente.values()[rs.getInt("patente")]);
            militar.setAtividade(EnumTarefa.DESCASCAR_BATATAS, rs.getInt("descascar_batatas") != 0);
            militar.setAtividade(EnumTarefa.LIMPAR_BANHEIRO, rs.getInt("limpar_banheiro") != 0);
            militar.setAtividade(EnumTarefa.LIMPAR_COZINHA, rs.getInt("limpar_cozinha") != 0);
            militar.setAtividade(EnumTarefa.COZINHAR_ALMOCO, rs.getInt("cozinhar_almoco") != 0);
            militar.setAtividade(EnumTarefa.COZINHAR_JANTA, rs.getInt("cozinhar_janta") != 0);
            militar.setAtividade(EnumTarefa.ALIMENTAR_CAVALOS, rs.getInt("alimentar_cavalos") != 0);
            militar.setAtividade(EnumTarefa.LIMPAR_ESTABULOS, rs.getInt("limpar_estabulos") != 0);
            militar.setAtividade(EnumTarefa.RECARREGAR_ARMAMENTO, rs.getInt("recarregar_armamento") != 0);
            militar.setAtividade(EnumTarefa.TROCAR_ENCANAMENTO, rs.getInt("trocar_encanamento") != 0);
            militar.setAtividade(EnumTarefa.LEVANTAR_BANDEIRA, rs.getInt("levantar_bandeira") != 0);
        }
        return militar;
    }
    
    public static Militar buscarMilitar(int codigo) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE codigo = '" + codigo + "'";
        return buscarMilitarAux(sql);
    }
    
    //Metodo para buscar um militar por CPF
    public static Militar buscarMilitarCPF(String cpf) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE cpf = '" + cpf + "'";
        return buscarMilitarAux(sql);
    }
    
    //Método para buscar um militar por RG
    public static Militar buscarMilitarRG(String rg, String estado) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM " + TABLE_NAME + " WHERE rg = '" + rg + "' AND estado = '" + estado + "'";
        return buscarMilitarAux(sql);
    }
     
    public static boolean alterarMilitar(Militar militar) throws SQLException, ClassNotFoundException {
        String sql;
        Connection conexao = ConnectionManager.getConnection();
        
        sql = "UPDATE " + TABLE_NAME + " SET "
                + "nome = ?, cpf = ?, rg = ?, estado = ?, sexo = ?, nascimento = ?, patente = ?"
                +", descascar_batatas = ?, limpar_banheiro = ?, limpar_cozinha = ?"
                +", cozinhar_almoco = ?, cozinhar_janta = ?, alimentar_cavalos = ?"
                +", limpar_estabulos = ?,recarregar_armamento = ?, trocar_encanamento = ?"
                +", levantar_bandeira = ?"
                +" WHERE codigo = ?";
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, militar.getNome());
        stmt.setString(2, militar.getCpf());
        stmt.setString(3, militar.getRg());
        stmt.setString(4, militar.getEstado());
        stmt.setString(5, ""+militar.getSexo());
        stmt.setDate(6, new java.sql.Date(militar.getNascimento().getTime()));
        stmt.setInt(7, militar.getPatente().ordinal());
        for(int i = 0; i < EnumTarefa.values().length; ++i) {
            int val = militar.fazAtividade(EnumTarefa.values()[i]) ? 1 : 0; //conversão de boolean para inteiro
            stmt.setInt(8+i, val);
        }
        stmt.setInt(18,militar.getCodigo());
        return stmt.executeUpdate() > 0;
    }
    
    //metodo para excluir um militar
    public static boolean excluirMilitar(int codigo) throws SQLException, ClassNotFoundException {
        Connection conexao = ConnectionManager.getConnection();
        Statement stmt = conexao.createStatement();
        String sql = "DELETE FROM " + TABLE_NAME + " WHERE codigo = '" + codigo + "'";
        return stmt.executeUpdate(sql) > 0;
    }
    
    public static List<Militar> listarMilitares() throws SQLException {
        Connection conexao = ConnectionManager.getConnection();
        String sql = "SELECT * FROM " + TABLE_NAME;
        Statement stmt = conexao.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        ArrayList<Militar> list = new ArrayList<Militar>();
        while(rs.next()) {
            Militar militar = new Militar();
            militar.setCodigo(rs.getInt("codigo"));
            militar.setNome(rs.getString("nome"));
            militar.setCpf(rs.getString("cpf"));
            militar.setRg(rs.getString("rg"));
            militar.setEstado(rs.getString("estado"));
            militar.setSexo(rs.getString("sexo").toUpperCase().charAt(0));
            militar.setNascimento(new Date(rs.getDate("nascimento").getTime()));
            militar.setPatente(EnumPatente.values()[rs.getInt("patente")]);
            militar.setAtividade(EnumTarefa.DESCASCAR_BATATAS, rs.getInt("descascar_batatas") != 0);
            militar.setAtividade(EnumTarefa.LIMPAR_BANHEIRO, rs.getInt("limpar_banheiro") != 0);
            militar.setAtividade(EnumTarefa.LIMPAR_COZINHA, rs.getInt("limpar_cozinha") != 0);
            militar.setAtividade(EnumTarefa.COZINHAR_ALMOCO, rs.getInt("cozinhar_almoco") != 0);
            militar.setAtividade(EnumTarefa.COZINHAR_JANTA, rs.getInt("cozinhar_janta") != 0);
            militar.setAtividade(EnumTarefa.ALIMENTAR_CAVALOS, rs.getInt("alimentar_cavalos") != 0);
            militar.setAtividade(EnumTarefa.LIMPAR_ESTABULOS, rs.getInt("limpar_estabulos") != 0);
            militar.setAtividade(EnumTarefa.RECARREGAR_ARMAMENTO, rs.getInt("recarregar_armamento") != 0);
            militar.setAtividade(EnumTarefa.TROCAR_ENCANAMENTO, rs.getInt("trocar_encanamento") != 0);
            militar.setAtividade(EnumTarefa.LEVANTAR_BANDEIRA, rs.getInt("levantar_bandeira") != 0);
            list.add(militar);
        }
        return list;
    }
}
