import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Classe "Cliente" responsável por armazenar em objetos os dados
// de cadastro dos clientes utilizados pela classe "BancoDados"
public class Cliente {
    // Variável responsável por armazenar o ID do cliente
    private final int clienteID;

    // Variável responsável por armazenar o nome do cliente
    private String clienteNome;

    // Variável responsável por armazenar o sobrenome do cliente
    private String clienteSobrenome;

    // Variável responsável por armazenar o sexo do cliente
    private String clienteSexo;

    // Objeto LocalDate responsável por armazenar a data de nascimento do cliente
    private LocalDate clienteDataNascimento;

    // ArrayList de objetos Endereco declarado como "clienteEndereco"
    // responsável por armazenar os possíveis endereços cadastrados pelo cliente
    private ArrayList<Endereco> clienteEndereco = new ArrayList<Endereco>();

    // ArrayList de objetos Classificacao declarado como "clienteAval"
    // responsável por armazenar as possíveis avaliações recebidas pelo cliente
    private ArrayList<Classificacao> clienteAval = new ArrayList<Classificacao>();


    // ###################### Método Construtor da Classe "Cliente" ###################### //

    // Construtor definindo o ID do cliente gerado pelo banco de dados
    public Cliente(int ID) {
        clienteID = ID;
    }

    // ################################################################################### //


    // ###################### Método de Cadastro Básico da Classe "Cliente" ###################### //

    // Método para o cadatro básico do cliente definindo as variáveis
    // "clienteNome", "clienteSobrenome", "clienteSexo", e "clienteDataNascimento"
    // por meio dos argumentos recebidos
    public void cadastroBasicoCliente(String nome, String sobrenome, String sexo, LocalDate dataNasc) {
        setClienteNome(nome);
        setClienteSobrenome(sobrenome);
        setClienteSexo(sexo);
        setClienteDataNascimento(dataNasc);
    }

    // ################################################################################### //


    // ###################### Manipulação dos Dados do Cliente ###################### //

    // Método para adicionar endereços ao cliente por meio dos argumentos recebidos
    public void addEndereco (String nomeEndereco, int cep, String rua, int numero, String complemento, String bairro, String cidade, String estado) {
        // Instanciando um novo objeto do tipo "Endereco" ao
        // ArrayList chamado "clienteEndereco"
        clienteEndereco.add(new Endereco());

        // Calculando o índice da última posição do Arraylist
        int i = clienteEndereco.size()-1;

        // Adicionando os dados no índice calculado do Arraylist
        clienteEndereco.get(i).setNomeCadastroEndereco(nomeEndereco);
        clienteEndereco.get(i).setNumeroCep(cep);
        clienteEndereco.get(i).setNomeRua(rua);
        clienteEndereco.get(i).setNumeroEndereco(numero);
        clienteEndereco.get(i).setComplemento(complemento);
        clienteEndereco.get(i).setBairro(bairro);
        clienteEndereco.get(i).setCidade(cidade);
        clienteEndereco.get(i).setEstado(estado);
    }

    // Método para remover endereço "indiceRemover" do cliente
    public void removerEndereco (int indiceRemover) {
        if (indiceRemover < clienteEndereco.size()){
            clienteEndereco.remove(indiceRemover);
        }
    }

    // Método para adicionar avaliação ao cliente por meio dos argumentos recebidos
    public void addAval(int valorAvaliacao, int idAvaliador, String comentario) {
        clienteAval.add(new Classificacao(valorAvaliacao,idAvaliador,clienteID,comentario));
    }

    // Método para remover avaliação "indiceRemover" do cliente
    public void removerAval(int indiceRemover) {
        if (indiceRemover < clienteAval.size()){
            clienteAval.remove(indiceRemover);
        }
    }

    // ################################################################################### //


    // ###################### Impressão da Ficha e Cabeçalho do Cliente ###################### //

    // Método para impressão da ficha completa do cliente
    // apresentando todos os dados relevantes armazenados
    public void mostrarFichaCliente () {
        System.out.println("************************** Ficha Completa de Cadastro - Cliente (" + getClienteID() + ") **************************");

        System.out.println("--- Dados Pessoais:");
        System.out.println("ID: " + getClienteID() + "   Nome: " + getClienteNome() + "   Sobrenome: " + getClienteSobrenome());
        System.out.println("Sexo: " + getClienteSexo() + "   Idade: " + getClienteIdade() + " anos");
        System.out.println();

        System.out.println("--- Localização:");

        // Invoca o método "mostrarTodosEndereco()" para apresentar todos os endereços cadastrados
        mostrarTodosEndereco();

        System.out.println("--- Avaliações: " + getMediaAvaliacao() + " Estrelas (" + getTotalAvaliacao() + " avaliações)");

        // Invoca o método "mostrarTodosAval()" para apresentar todas as avaliações recebidas
        mostrarTodosAval();

        System.out.println("********************************************************************************************************************\n");
    }

    // Método para impressão do cabeçalho dos clientes
    // apresentando os dados resumidos armazenados
    public void mostrarCabecalhoCliente () {
        // Caso ainda não haja avaliação
        if (clienteAval.size() <= 0) {
            System.out.println("ID: " + getClienteID() + " Nome: " + getClienteNome() + " " + getClienteSobrenome() +", " + getClienteIdade() + " anos (Nenhuma Avaliação)");
        } else {
            System.out.println("ID: " + getClienteID() + " Nome: " + getClienteNome() + " " + getClienteSobrenome() +", " + getClienteIdade() + " anos (" + getMediaAvaliacao() + " Estrelas, " + getTotalAvaliacao() +" avaliações)");
        }
    }

    // Método para mostrar a avaliação de "indiceMostrar"
    public void mostrarAval(int indiceMostrar) {
        // Definindo o tipo de formatação para o objeto LocalDate
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd LLLL yyyy");

        // String dataFormatada recebendo a informação extraída do localDate "DataAvaliacao"
        // utilizando o formato definido anteriormente
        String dataFormatada = clienteAval.get(indiceMostrar).getDataAvaliacao().format(formato);

        // Caso não haja nenhuma avaliação
        if (clienteAval.size() <= 0) {
            System.out.println("Nenhuma avaliação para ser mostrada.");
        } else {
            System.out.println("Avaliação [" + indiceMostrar + "]:");
            System.out.println("Nota: " + clienteAval.get(indiceMostrar).getValorAvaliacao() +
                    " - ID Avaliado: " + clienteID +
                    "   ID Avaliação: " + clienteAval.get(indiceMostrar).getIdAvaliador() +
                    " Data: " + dataFormatada
                    );

            // Caso haja algum comentário armazenado na avaliação
            if (!clienteAval.get(indiceMostrar).getComentario().equals("")) {
                System.out.println("Comentario: " + clienteAval.get(indiceMostrar).getComentario());
            }
        }
        System.out.println();
    }

    // Método para mostrar o endereço de "indiceMostrar"
    public void mostrarEndereco (int indiceMostrar) {
        System.out.println("Nome do Endereço: " + clienteEndereco.get(indiceMostrar).getNomeCadastroEndereco());
        System.out.println("Rua: "+ clienteEndereco.get(indiceMostrar).getNomeRua()+", nº " + clienteEndereco.get(indiceMostrar).getNumeroEndereco());
        System.out.println("Complemento: " + clienteEndereco.get(indiceMostrar).getComplemento() + "   Bairro: " + clienteEndereco.get(indiceMostrar).getBairro());
        System.out.println("CEP: " + clienteEndereco.get(indiceMostrar).getNumeroCep() + "  Cidade: " + clienteEndereco.get(indiceMostrar).getCidade() + "   Estado: " + clienteEndereco.get(indiceMostrar).getEstado());
    }

    // Método para mostrar todos os endereços armazenados
    public void mostrarTodosEndereco () {
        // Caso ainda não haja endereços
        if (clienteEndereco.size() <= 0) {
            System.out.println("Nenhum endereço para ser mostrado.");
        } else {
            // Laço que percorre todos os endereços cadastrados em "clienteEndereco"
            for (int i = 0; i < clienteEndereco.size(); i++) {
                System.out.println("Informações do endereço nº " + i);
                mostrarEndereco(i);
                System.out.println();
            }
        }
    }

    // Método para mostrar todos as avaliações armazenadas
    public void mostrarTodosAval() {
        // Caso ainda não haja avaliação
        if (clienteAval.size() <= 0) {
            System.out.println("Nenhuma avaliação para ser mostrada.");
        } else {
            // Laço que percorre todos as avaliações cadastradas em "clienteAval"
            for (int i = 0; i < clienteAval.size(); i++) {
                mostrarAval(i);
            }
        }
    }

    // ################################################################################### //


    // ###################### Getters e Setters da Classe "Cliente" ###################### //

    public String getMediaAvaliacao(){
        double somaAvaliacao = 0;

        if (clienteAval.size() <= 0) {
            return "-1";
        } else {
            for (int i = 0; i < clienteAval.size(); i++) {
                somaAvaliacao += clienteAval.get(i).getValorAvaliacao();
            }
        }
        return String.format("%2.1f",(somaAvaliacao / clienteAval.size()));
    }

    public int getClienteID() {
        return clienteID;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }

    public String getClienteSobrenome() {
        return clienteSobrenome;
    }

    public void setClienteSobrenome(String clienteSobrenome) {
        this.clienteSobrenome = clienteSobrenome;
    }

    public String getClienteSexo() {
        return clienteSexo;
    }

    public void setClienteSexo(String clienteSexo) {
        this.clienteSexo = clienteSexo;
    }

    public LocalDate getClienteDataNascimento() {
        return clienteDataNascimento;
    }

    public void setClienteDataNascimento(LocalDate clienteDataNascimento) {
        this.clienteDataNascimento = clienteDataNascimento;
    }

    public int getClienteIdade() {
        return Period.between(getClienteDataNascimento(), LocalDate.now()).getYears();
    }

    public ArrayList<Endereco> getClienteEndereco() {
        return clienteEndereco;
    }

    public void setClienteEndereco(ArrayList<Endereco> clienteEndereco) {
        this.clienteEndereco = clienteEndereco;
    }

    public ArrayList<Classificacao> getClienteAval() {
        return clienteAval;
    }

    public void setClienteAval(ArrayList<Classificacao> clienteAval) {
        this.clienteAval = clienteAval;
    }

    public int getTotalAvaliacao() {
        return clienteAval.size();
    }

    public int getQtdEndereco () {
        return clienteEndereco.size();
    }

    // ################################################################################### //
}
