package model;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;


/**
 * Classe que define todas as informaçoes do militar
 * @author Luiz Ferreira
 * @since 26/08/2017
 */
public class Militar {

    private int codigo;
    private String nome;
    private String cpf;
    private String rg;
    private String estado;
    private char sexo;
    private Date nascimento;
    private EnumPatente patente;
    private boolean tarefas[];
    private int grauPenalidade;
    
    private int idade;
    
    //Encontrado na Internet
    private void calcularIdade() {
        LocalDate dataNascimento = nascimento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        idade = Period.between(dataNascimento, LocalDate.now()).getYears();
    }
    
    public Militar() {
        this.tarefas = new boolean[EnumTarefa.values().length];
        
    }

    public Militar(int codigo, String nome, String cpf, String rg, String estado, char sexo, Date nascimento, String Penalidades, EnumPatente patente) {        
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.estado = estado;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.tarefas = new boolean[EnumTarefa.values().length];
        calcularIdade();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getNascimento() {
        return nascimento;
    }
    
    public int getIdade() {
        return idade;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
        calcularIdade();
    }
    
    public void setPatente(EnumPatente patente) {
        this.patente = patente;
    }
    
    public EnumPatente getPatente() {
        return patente;
    }

    public boolean fazAtividade(EnumTarefa tarefa) {
        return tarefas[tarefa.ordinal()];
    }
    
    public void setAtividade(EnumTarefa tarefa, boolean valor) {
        this.tarefas[tarefa.ordinal()] = valor;
    }
    
    public void setGrauPenalidade(int grauPenalidade) {
        this.grauPenalidade = grauPenalidade;
    }
    
    public int getGrauPenalidade() {
        return grauPenalidade;
    }
    
}