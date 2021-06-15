import java.time.LocalDate;

// Classe "Classificacao" responsável por armazenar em objetos os dados
// de avaliação utilizados pelas classes "Cliente" e "Profissional"
public class Classificacao {
    // Variável responsável por armazenar o valor da avaliação
    private int valorAvaliacao;

    // Variável responsável por armazenar o ID único do avaliador
    private int idAvaliador;

    // Variável responsável por armazenar o ID único do avaliado
    private int idAvaliacao;

    // Variável responsável por armazenar a String do comentário, caso exista
    private String comentario;

    // Variável responsável por armazenar a data da avaliação
    private LocalDate dataAvaliacao;

    // ###################### Método Construtor da Classe "Endereco" ###################### //

    // Método construtor da classe "Classificacao" responsavel por atribuir os valores
    // de cada variável presente na classe por meio dos argumentos recebidos
    public Classificacao(int valorAvaliacao, int idAvaliador, int idAvaliacao, String comentario) {
        this.valorAvaliacao = valorAvaliacao;
        this.idAvaliador = idAvaliador;
        this.idAvaliacao = idAvaliacao;
        this.comentario = comentario;
        dataAvaliacao = LocalDate.now();
    }

    // ################################################################################### //


    // ###################### Getters e Setters da Classe "Classificacao" ###################### //

    public int getValorAvaliacao() {
        return valorAvaliacao;
    }

    public void setValorAvaliacao(int valorAvaliacao) {
        this.valorAvaliacao = valorAvaliacao;
    }

    public int getIdAvaliador() {
        return idAvaliador;
    }

    public void setIdAvaliador(int idAvaliador) {
        this.idAvaliador = idAvaliador;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDate getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDate dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    // ################################################################################### //
}
