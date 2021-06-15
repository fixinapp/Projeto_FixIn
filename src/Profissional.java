import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

// Classe "Profissional" responsável por armazenar em objetos os dados
// de cadastro dos profissionais utilizados pela classe "BancoDados"
public class Profissional {
    // Variável responsável por armazenar o ID do profissional
    private final int profID;

    // Variável responsável por armazenar o nome fantasia do profissional
    private String profNomeFantasia;

    // Variável responsável por armazenar uma breve descrição dos serviços do profissional
    private String profServicos;

    // Variável responsável por armazenar o nome do profissional
    private String profNome;

    // Variável responsável por armazenar o sobrenome do profissional
    private String profSobrenome;

    // Variável responsável por armazenar o sexo do profissional
    private String profSexo;

    // Objeto LocalDate responsável por armazenar a data de nascimento do profissional
    private LocalDate profDataNasc;

    // ArrayList de objetos Endereco declarado como "profEndereco"
    // responsável por armazenar os possíveis endereços cadastrados pelo profissional
    private ArrayList<Endereco> profEndereco = new ArrayList<Endereco>();

    // ArrayList de objetos Classificacao declarado como "profAval"
    // responsável por armazenar as possíveis avaliações recebidas pelo profissional
    private ArrayList<Classificacao> profAval = new ArrayList<Classificacao>();

    // HashSet de elementos do tipo "String" responsável por armazenar
    // valores únicos dos métodos de pagamento cadastrados pelo profissional
    private HashSet<String> profPagamentos = new HashSet<String>();

    // HashSet de elementos do tipo "String" responsável por armazenar
    // valores únicos das tags cadastradas pelo profissional
    private HashSet<String> profTags = new HashSet<String>();

    // Lista de elementos do tipo "String" dos possíveis métodos de pagamento
    // que podem ser adicionados no HashSet "profPagamentos"
    private List<String> pagamentosDisponiveis = Arrays.asList("Cartão Crédito","Cartão Débito","Transferência","Cheque","PIX","Boleto","Dinheiro");

    // Lista de elementos do tipo "String" das possíveis tags
    // que podem ser adicionadas no HashSet "profTags"
    private List<String> tagsDisponiveis = Arrays.asList(
            "Acabamentos","Arquiteto(a)","Automação Residencial","Azulejista","Carpintaria",
            "Decoração","Elétrica","Engenheiro(a) Civil","Gesso e Dry Wall","Hidráulica",
            "Infraestrutura","Jardinagem","Marmoraria","Movelaria","Pintura",
            "Revestimentos","Serralheria","Vidraçaria"
            );


    // ###################### Método Construtor da Classe "Profissional" ###################### //

    // Construtor definindo o ID do profissional gerado pelo banco de dados
    public Profissional(int ID) {
        profID = ID;
    }

    // ################################################################################### //


    // ###################### Método de Cadastro Básico da Classe "Profissional" ###################### //

    // Método para o cadatro básico do cliente definindo as variáveis
    // "profNomeFantasia", "profServicos", "profNome", "profSobrenome",
    // "profSexo", e "profDataNascimento" por meio dos argumentos recebidos
    public void cadastroBasicoProf(String nomeFantasia, String servicos, String nome, String sobrenome, String sexo, LocalDate dataNasc) {
        setProfNomeFantasia(nomeFantasia);
        setProfServicos(servicos);
        setProfNome(nome);
        setProfSobrenome(sobrenome);
        setProfSexo(sexo);
        setProfDataNasc(dataNasc);
    }

    // ################################################################################### //


    // ###################### Manipulação dos Dados do Profissional ###################### //

    // Método para adicionar endereços ao profissional por meio dos argumentos recebidos
    public void addEndereco(String nomeEndereco, int cep, String rua, int numero, String complemento, String bairro, String cidade, String estado) {
        // Instanciando um novo objeto do tipo "Endereco" ao
        // ArrayList chamado "profEndereco"
        profEndereco.add(new Endereco());

        // Calculando o índice da última posição do Arraylist
        int i = profEndereco.size()-1;

        // Adicionando os dados no índice calculado do Arraylist
        profEndereco.get(i).setNomeCadastroEndereco(nomeEndereco);
        profEndereco.get(i).setNumeroCep(cep);
        profEndereco.get(i).setNomeRua(rua);
        profEndereco.get(i).setNumeroEndereco(numero);
        profEndereco.get(i).setComplemento(complemento);
        profEndereco.get(i).setBairro(bairro);
        profEndereco.get(i).setCidade(cidade);
        profEndereco.get(i).setEstado(estado);
    }

    // Método para remover endereço "indiceRemover" do cliente
    public void removerEndereco(int indiceRemover) {
        if (indiceRemover < profEndereco.size()){
            profEndereco.remove(indiceRemover);
        }
    }

    // Método para adicionar avaliação ao profissional por meio dos argumentos recebidos
    public void addAval(int valorAvaliacao, int idAvaliador, String comentario) {
        profAval.add(new Classificacao(valorAvaliacao,idAvaliador,profID,comentario));
    }

    // Método para remover avaliação "indiceRemover" do profissional
    public void removerAval(int indiceRemover) {
        if (indiceRemover < profAval.size()){
            profAval.remove(indiceRemover);
        }
    }

    // Métodos para adicionar o pagamento de "pagamentosDisponiveis" com indice "indicePagamento"
    public void addPagamento(int indicePagamento) {
        profPagamentos.add(pagamentosDisponiveis.get(indicePagamento));
    }

    // Métodos para remover o pagamento com indice "indicePagamento"
    public void removerPagamento(int indiceRemover) {
        if (profPagamentos.contains(pagamentosDisponiveis.get(indiceRemover))) {
            profPagamentos.remove(indiceRemover);
        }
    }

    /// Métodos para adicionar a tag de "tagsDisponiveis" com indice "indiceTags"
    public void addProfTags(int indiceTags) {
        profTags.add(tagsDisponiveis.get(indiceTags));
    }

    // Métodos para remover a tag com indice "indicePagamento"
    public void removerProfTags(int indiceRemover) {
        if (profTags.contains(tagsDisponiveis.get(indiceRemover))) {
            profTags.remove(indiceRemover);
        }
    }

    // ################################################################################### //


    // ###################### Impressão da Ficha e Cabeçalho do Profissional ###################### //

    // Método para impressão da ficha completa do profissional
    // apresentando todos os dados relevantes armazenados
    public void mostrarFichaProf() {
        System.out.println("************************** Ficha Completa de Cadastro - Profissional (" + getProfID() + ") **************************");

        System.out.println("--- Dados Profissionais:");
        System.out.println("Nome Fantasia: " + getProfNomeFantasia());
        System.out.println("Descrição dos serviços: " + getProfServicos());

        // Invoca o método "mostrarTodosProfTags()" para apresentar todas as tags cadastradas
        mostrarTodosProfTags();
        System.out.println();

        System.out.println("--- Dados Pessoais:");
        System.out.println("ID: " + getProfID() + "   Nome: " + getProfNome() + "   Sobrenome: " + getProfSobrenome());
        System.out.println("Sexo: " + getProfSexo() + "   Idade: " + getProfissionalIdade() + " anos");
        System.out.println();

        System.out.println("--- Localização:");

        // Invoca o método "mostrarTodosEndereco()" para apresentar todos os endereços cadastrados
        mostrarTodosEndereco();

        System.out.println("--- Formas de Pagamento:");

        // Invoca o método "mostrarTodosPagamento()" para apresentar todos os métodos de pagamentos
        mostrarTodosPagamento();
        System.out.println();

        System.out.println("--- Avaliações: " + getMediaAvaliacao() + " Estrelas (" + getTotalAvaliacao() + " avaliações)");

        // Invoca o método "mostrarTodosAval()" para apresentar todas as avaliações recebidas
        mostrarTodosAval();

        System.out.println("********************************************************************************************************************\n");
    }

    // Método para impressão do cabeçalho do profissional
    // apresentando os dados resumidos armazenados
    public void mostrarCabecalhoProf () {
        // Caso ainda não haja avaliação
        if (profAval.size() <= 0) {
            System.out.println("Nome Fantasia: " + getProfNomeFantasia() + " (Nenhuma Avaliação)");
        } else {
            System.out.println("Nome Fantasia: " + getProfNomeFantasia() + " (" + getMediaAvaliacao() + " Estrelas, " + getTotalAvaliacao() +" avaliações)");
        }
        System.out.print("Tags: ");

        // Invoca o método "mostrarTodosProfTags()" para apresentar todas as tags cadastradas
        mostrarTodosProfTags();

        System.out.println("Descrição dos serviços: " + getProfServicos());
        System.out.print("Formas de Pagamento: ");

        // Invoca o método "mostrarTodosPagamento()" para apresentar todos os métodos de pagamentos
        mostrarTodosPagamento();
        System.out.println();
    }

    // Método para mostrar a avaliação de "indiceMostrar"
    public void mostrarAval(int indiceMostrar) {
        // Definindo o tipo de formatação para o objeto LocalDate
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd LLLL yyyy");

        // String dataFormatada recebendo a informação extraída do localDate "DataAvaliacao"
        // utilizando o formato definido anteriormente
        String dataFormatada = profAval.get(indiceMostrar).getDataAvaliacao().format(formato);

        // Caso ainda não haja avaliação
        if (profAval.size() <= 0) {
            System.out.println("Nenhuma avaliação para ser mostrada.");
        } else {
            System.out.println("Avaliação [" + indiceMostrar + "]:");
            System.out.println("Nota: " + profAval.get(indiceMostrar).getValorAvaliacao() +
                    " - ID Avaliado: " + profID +
                    "   ID Avaliador: " + profAval.get(indiceMostrar).getIdAvaliador() +
                    " Data: " + dataFormatada
            );
            // Caso haja algum comentário armazenado na avaliação
            if (!profAval.get(indiceMostrar).getComentario().equals("")) {
                System.out.println("Comentario: " + profAval.get(indiceMostrar).getComentario());
            }
        }
        System.out.println();
    }

    // Método para mostrar o endereço de "indiceMostrar"
    public void mostrarEndereco(int indiceMostrar) {
        System.out.println("Nome do Endereço: " + profEndereco.get(indiceMostrar).getNomeCadastroEndereco());
        System.out.println("Rua: "+ profEndereco.get(indiceMostrar).getNomeRua()+", nº " + profEndereco.get(indiceMostrar).getNumeroEndereco());
        System.out.println("Complemento: " + profEndereco.get(indiceMostrar).getComplemento() + "   Bairro: " + profEndereco.get(indiceMostrar).getBairro());
        System.out.println("CEP: " + profEndereco.get(indiceMostrar).getNumeroCep() + "  Cidade: " + profEndereco.get(indiceMostrar).getCidade() + "   Estado: " + profEndereco.get(indiceMostrar).getEstado());
        System.out.println();
    }

    // Método para mostrar todos os endereços armazenados
    public void mostrarTodosEndereco() {
        // Caso ainda não haja endereços
        if (profEndereco.size() <= 0) {
            System.out.println("Nenhum endereço para ser mostrado.");
        } else {
            for (int i = 0; i < profEndereco.size(); i++) {
                mostrarEndereco(i);
            }
        }
    }

    // Método para mostrar todos as avaliações armazenadas
    public void mostrarTodosAval() {
        // Caso ainda não haja avaliação
        if (profAval.size() <= 0) {
            System.out.println("Nenhuma avaliação para ser mostrada.");
        } else {
            // Laço que percorre todos as avaliações cadastradas em "profAval"
            for (int i = 0; i < profAval.size(); i++) {
                mostrarAval(i);
            }
        }
    }

    // Método para mostrar todos os métodos de pagamentos armazenadas
    public void mostrarTodosPagamento() {
        // Caso não haja um método de pagamento
        if (profPagamentos.size() <= 0) {
            System.out.println("Nenhum método de pagamento para ser mostrado.");
        } else {
            // Laço que percorre todos os métodos de pagamento em "profPagamentos"
            for (String s : profPagamentos) {
                System.out.print("[" + s + "] ");
            }
        }
        System.out.println();
    }

    // Método para mostrar todos as tags armazenadas
    public void mostrarTodosProfTags() {
        // Caso não haja nenhuma tag
        if (profTags.size() <= 0) {
            System.out.println("Nenhuma tag para ser mostrada.");
        } else {
            // Laço que percorre todos as tags em "profTags"
            for (String s : profTags) {
                System.out.print("[" + s + "] ");
            }
        }
        System.out.println();
    }

    // ################################################################################### //


    // ###################### Getters e Setters da Classe "Profissional" ###################### //

    public String getMediaAvaliacao(){
        double somaAvaliacao = 0;

        if (profAval.size() <= 0) {
            return "-1";
        } else {
            for (int i = 0; i < profAval.size(); i++) {
                somaAvaliacao += profAval.get(i).getValorAvaliacao();
            }
        }
        return String.format("%2.1f",(somaAvaliacao / profAval.size()));
    }

    public int getProfID() {
        return profID;
    }

    public String getProfNome() {
        return profNome;
    }

    public void setProfNome(String profNome) {
        this.profNome = profNome;
    }

    public String getProfSobrenome() {
        return profSobrenome;
    }

    public void setProfSobrenome(String profSobrenome) {
        this.profSobrenome = profSobrenome;
    }

    public String getProfSexo() {
        return profSexo;
    }

    public void setProfSexo(String profSexo) {
        this.profSexo = profSexo;
    }

    public LocalDate getProfDataNasc() {
        return profDataNasc;
    }

    public void setProfDataNasc(LocalDate profDataNasc) {
        this.profDataNasc = profDataNasc;
    }

    public String getProfNomeFantasia() {
        return profNomeFantasia;
    }

    public void setProfNomeFantasia(String profNomeFantasia) {
        this.profNomeFantasia = profNomeFantasia;
    }

    public String getProfServicos() {
        return profServicos;
    }

    public void setProfServicos(String profServicos) {
        this.profServicos = profServicos;
    }

    public ArrayList<Endereco> getProfEndereco() {
        return profEndereco;
    }

    public void setProfEndereco(ArrayList<Endereco> profEndereco) {
        this.profEndereco = profEndereco;
    }

    public ArrayList<Classificacao> getProfAval() {
        return profAval;
    }

    public void setProfAval(ArrayList<Classificacao> profAval) {
        this.profAval = profAval;
    }

    public HashSet<String> getProfPagamentos() {
        return profPagamentos;
    }

    public void setProfPagamentos(HashSet<String> profPagamentos) {
        this.profPagamentos = profPagamentos;
    }

    public HashSet<String> getProfTags() {
        return profTags;
    }

    public void setProfTags(HashSet<String> profTags) {
        this.profTags = profTags;
    }

    public void setPagamentosDisponiveis(List<String> pagamentosDisponiveis) {
        this.pagamentosDisponiveis = pagamentosDisponiveis;
    }

    public void setTagsDisponiveis(List<String> tagsDisponiveis) {
        this.tagsDisponiveis = tagsDisponiveis;
    }

    public List<String> getPagamentosDisponiveis() {
        return pagamentosDisponiveis;
    }

    public List<String> getTagsDisponiveis() {
        return tagsDisponiveis;
    }

    public int getProfissionalIdade() {
        return Period.between(getProfDataNasc(), LocalDate.now()).getYears();
    }

    public int getTotalAvaliacao() {
        return profAval.size();
    }

    public int getQtdEndereco () {
        return profEndereco.size();
    }

    // ################################################################################### //
}
