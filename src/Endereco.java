// Classe "Endereco" responsável por armazenar em objetos os dados
// de endereço utilizados pelas classes "Cliente" e "Profissional"
public class Endereco {
    // Variável responsável por armazenar o nome do cadastro do endereço
    private String nomeCadastroEndereco;

    // Variável responsável por armazenar o cep do endereço
    private int numeroCep;

    // Variável responsável por armazenar o nome da rua do endereço
    private String nomeRua;

    // Variável responsável por armazenar o número do endereço
    private int numeroEndereco;

    // Variável responsável por armazenar o complemento do endereço
    private String complemento;

    // Variável responsável por armazenar o nome do bairro do endereço
    private String bairro;

    // Variável responsável por armazenar o nome da cidade do endereço
    private String cidade;

    // Variável responsável por armazenar o nome do estado do endereço
    private String estado;

    // ###################### Método Construtor da Classe "Endereco" ###################### //

    public Endereco() {}

    // ################################################################################### //


    // ###################### Getters e Setters da Classe "Endereco" ###################### //

    public String getNomeCadastroEndereco() {
        return nomeCadastroEndereco;
    }

    public void setNomeCadastroEndereco(String nomeCadastroEndereco) {
        this.nomeCadastroEndereco = nomeCadastroEndereco;
    }

    public int getNumeroCep() {
        return numeroCep;
    }

    public void setNumeroCep(int numeroCep) {
        this.numeroCep = numeroCep;
    }

    public String getNomeRua() {
        return nomeRua;
    }

    public void setNomeRua(String nomeRua) {
        this.nomeRua = nomeRua;
    }

    public int getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(int numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // ################################################################################### //
}
