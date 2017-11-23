package model;


/**
 * Classe que define todas as informaçoes do militar
 * @author Luiz Ferreira
 * @since 26/08/2017
 */
public class Militar {

    private Integer codigo;
    private String nome;
    private String cpf;
    private String rg;
    private String estado;
    private String Sexo;
    private String nascimento;
    private String Soldado;
    private int idade;
    private boolean Descascar;  
    private boolean LimparBanheiro;
    private boolean LimparCozinha;
    private boolean CozinharArmoco;
    private boolean CozinharJanta;
    private boolean AlimentarCavalos;
    private boolean LimparEstabulos;
    private boolean RecarregarArmamento;
    private boolean TrocarEncanamento;
    private boolean LevantarBandeira;
    private String  Penalidades;
    private String  Patente;
    private int     Contador;
     public Militar(){
        
    }

    public Militar(Integer codigo, String nome, String cpf, String rg, String estado, String Sexo, String nascimento, String Soldado, int idade, boolean Descascar, boolean LimparBanheiro, boolean LimparCozinha, boolean CozinharArmoco, boolean CozinharJanta, boolean AlimentarCavalos, boolean LimparEstabulos, boolean RecarregarArmamento, boolean TrocarEncanamento, boolean LevantarBandeira, String Penalidades, String Patente, int contador) {
        this.codigo = codigo;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.estado = estado;
        this.Sexo = Sexo;
        this.nascimento = nascimento;
        this.Soldado = Soldado;
        this.idade = idade;
        this.Descascar = Descascar;
        this.LimparBanheiro = LimparBanheiro;
        this.LimparCozinha = LimparCozinha;
        this.CozinharArmoco = CozinharArmoco;
        this.CozinharJanta = CozinharJanta;
        this.AlimentarCavalos = AlimentarCavalos;
        this.LimparEstabulos = LimparEstabulos;
        this.RecarregarArmamento = RecarregarArmamento;
        this.TrocarEncanamento = TrocarEncanamento;
        this.LevantarBandeira = LevantarBandeira;
        this.Penalidades = Penalidades;
        this.Patente = Patente;
        this.Contador = contador;
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

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSoldado() {
        return Soldado;
    }

    public void setSoldado(String Soldado) {
        this.Soldado = Soldado;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isDescascar() {
        return Descascar;
    }

    public void setDescascar(boolean Descascar) {
        this.Descascar = Descascar;
    }

    public boolean isLimparBanheiro() {
        return LimparBanheiro;
    }

    public void setLimparBanheiro(boolean LimparBanheiro) {
        this.LimparBanheiro = LimparBanheiro;
    }

    public boolean isLimparCozinha() {
        return LimparCozinha;
    }

    public void setLimparCozinha(boolean LimparCozinha) {
        this.LimparCozinha = LimparCozinha;
    }

    public boolean isCozinharArmoco() {
        return CozinharArmoco;
    }

    public void setCozinharArmoco(boolean CozinharArmoco) {
        this.CozinharArmoco = CozinharArmoco;
    }

    public boolean isCozinharJanta() {
        return CozinharJanta;
    }

    public void setCozinharJanta(boolean CozinharJanta) {
        this.CozinharJanta = CozinharJanta;
    }

    public boolean isAlimentarCavalos() {
        return AlimentarCavalos;
    }

    public void setAlimentarCavalos(boolean AlimentarCavalos) {
        this.AlimentarCavalos = AlimentarCavalos;
    }

    public boolean isLimparEstabulos() {
        return LimparEstabulos;
    }

    public void setLimparEstabulos(boolean LimparEstabulos) {
        this.LimparEstabulos = LimparEstabulos;
    }

    public boolean isRecarregarArmamento() {
        return RecarregarArmamento;
    }

    public void setRecarregarArmamento(boolean RecarregarArmamento) {
        this.RecarregarArmamento = RecarregarArmamento;
    }

    public boolean isTrocarEncanamento() {
        return TrocarEncanamento;
    }

    public void setTrocarEncanamento(boolean TrocarEncanamento) {
        this.TrocarEncanamento = TrocarEncanamento;
    }

    public boolean isLevantarBandeira() {
        return LevantarBandeira;
    }

    public void setLevantarBandeira(boolean LevantarBandeira) {
        this.LevantarBandeira = LevantarBandeira;
    }

    public String getPenalidades() {
        return Penalidades;
    }

    public void setPenalidades(String Penalidades) {
        this.Penalidades = Penalidades;
    }

    public String getPatente() {
        return Patente;
    }

    public void setPatente(String Patente) {
        this.Patente = Patente;
    }

    public int getContador() {
        return Contador;
    }

    public void setContador(int contador) {
        this.Contador = contador;
    }
     
}