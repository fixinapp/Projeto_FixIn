import java.util.*;

// Classe "BancoDados" responsável por gerar, manipular e apresentar
// objetos da classe "Cliente" e "Profissional"
public class BancoDados {
    // Instanciando objeto responsável por gerar números aleatórios
    Random rng = new Random();

    // Instanciando objeto do tipo HashMap que utilizad o ID do cliente
    // como chave e um objeto do tipo Cliente como valor responsável por
    // gerenciar o banco de cadastro de clientes
    HashMap<Integer,Cliente> clienteCadastros = new HashMap<Integer,Cliente>();

    // Instanciando objeto do tipo HashMap que utilizad o ID do profissional
    // como chave e um objeto do tipo Profissional como valor responsável por
    // gerenciar o banco de cadastro de profissionais
    HashMap<Integer,Profissional> profCadastros = new HashMap<Integer,Profissional>();


    // ###################### Método Construtor da Classe "Cliente" ###################### //

    public BancoDados() {}

    // ################################################################################### //


    // ###################### Métodos de manipulação da Classe "BancoDados" ###################### //

    // Método para adicionar clientes
    public void addCliente() {
        // Variável local lógica para controlar o loop de ID únicos
        boolean uniqueID;

        // Variável local de ID do cliente inicialmente recebendo valor 0
        int clienteID = 0;

        // Definindo a variável de controle como falso
        uniqueID = false;

        // Laço de repetição enquanto a variável de ID único se mantiver falsa
        while (!uniqueID) {
            // Gerando um ID para o cliente entre 1 e 1000000
            clienteID = 1000000 - rng.nextInt(999999);

            // Caso não exista o ID gerado, variável uniqueID recebe
            // verdadeira, encerrando o laço de repetição
            if (!clienteCadastros.containsKey(clienteID)){
                uniqueID = true;
            }
        }
        // Adicionando uma entrada ao HashMap "clienteCadastros" utilizando
        // "clienteID" como chave e, um novo objeto do tipo "Cliente", como valor
        clienteCadastros.put(clienteID, new Cliente(clienteID));
    }

    // Método para remover clientes baseado no argumento "clienteID"
    public void removerCliente(int clienteID) {
        clienteCadastros.remove(clienteID);
    }

    // Método para adicionar profissionais
    public void addProf() {
        // Variável local lógica para controlar o loop de ID únicos
        boolean uniqueID;

        // Variável local de ID do profissional inicialmente recebendo valor 0
        int profID = 0;

        // Definindo a variável de controle como falso
        uniqueID = false;

        // Laço de repetição enquanto a variável de ID único se mantiver falsa
        while (!uniqueID) {
            // Gerando um ID para o profissional entre 1 e 1000000
            profID = 1000000 - rng.nextInt(999999);

            // Caso não exista o ID gerado, variável uniqueID recebe
            // verdadeira, encerrando o laço de repetição
            if (!profCadastros.containsKey(profID)){
                uniqueID = true;
            }
        }
        // Adicionando uma entrada ao HashMap "profCadastros" utilizando
        // "profID" como chave e, um novo objeto do tipo "Profissional", como valor
        profCadastros.put(profID, new Profissional(profID));
    }

    // Método para remover profissionais baseado no argumento "profID"
    public void removerProf(int profID) {
        profCadastros.remove(profID);
    }

    // ################################################################################### //

    // ###################### Métodos de busca da Classe "BancoDados" ###################### //

    // Método para buscar e mostrar clientes com nome "clienteNome"
    public void buscaNomeCliente (String clienteNome) {
        // Inicializando variável contadora de resultados
        int resultados = 0;

        // Laço percorrendo cada cliente cadastrado presente em "clienteCadastros"
        for (int indiceClientes: clienteCadastros.keySet()) {
            // Caso nome do cliente seja igual "clienteNome"
            if (clienteCadastros.get(indiceClientes).getClienteNome().equals(clienteNome)) {
                // Apresenta o cabeçalho do cliente
                clienteCadastros.get(indiceClientes).mostrarCabecalhoCliente();
                System.out.println();

                // Incrementa contador de resultados
                resultados++;
            }
        }
        // Apresentando variável contadora de resultados
        System.out.println("Total de resultados: " + resultados);
    }

    // Método para buscar e mostrar clientes na cidade "clienteCidade"
    public void buscaCidadeCliente (String clienteCidade) {
        // Inicializando variável local contadora de resultados
        int resultados = 0;

        // Laço percorrendo cada cliente cadastrado presente em "clienteCadastros"
        for (int indiceClientes: clienteCadastros.keySet()) {
            // Laço percorrendo cada endereço do cliente "indiceClientes"
            for (int indiceEnderecos = 0; indiceEnderecos < clienteCadastros.get(indiceClientes).getQtdEndereco(); indiceEnderecos++) {
                // Caso algum dos endereços contenha a cidade "clienteCidade"
                if (clienteCadastros.get(indiceClientes).getClienteEndereco().get(indiceEnderecos).getCidade().equals(clienteCidade)) {
                    // Apresenta o cabeçalho do cliente
                    clienteCadastros.get(indiceClientes).mostrarCabecalhoCliente();
                    System.out.println();
                    // Incrementa contador de resultados
                    resultados++;

                    // Interromper o laço de repetição interno
                    break;
                }
            }
        }
        // Apresentando variável contadora de resultados
        System.out.println("Total de resultados: " + resultados);
    }

    // Método para buscar e mostrar clientes com média de avaliação
    // maior ou igual a "valorMediaCliente"
    public void buscaMediaAvalCliente (int valorMediaCliente) {
        // Inicializando variável local contadora de resultados
        int resultados = 0;

        // Laço percorrendo cada cliente cadastrado presente em "clienteCadastros"
        for (int indiceCliente: clienteCadastros.keySet()) {
            // Caso a média do cliente "indiceCliente" seja maior ou igual a "valorMediaCliente"
            if (Double.parseDouble(clienteCadastros.get(indiceCliente).getMediaAvaliacao().replace(",",".")) >= valorMediaCliente) {
                // Apresenta o cabeçalho do cliente
                clienteCadastros.get(indiceCliente).mostrarCabecalhoCliente();
                System.out.println();

                // Incrementa contador de resultados
                resultados++;
            }
        }
        // Apresentando variável contadora de resultados
        System.out.println("Total de resultados: " + resultados);
    }

    // Método para buscar e mostrar profissionais com nome fantasia "profNomeFantasia"
    public void buscaNomeFantasiaProf(String profNomeFantasia) {
        // Inicializando variável local contadora de resultados
        int resultados = 0;

        // Laço percorrendo cada profissional cadastrado presente em "profCadastros"
        for (int indiceProf: profCadastros.keySet()) {
            // Caso o profissional tenha o nome fantasia "profNomeFantasia"
            if (profCadastros.get(indiceProf).getProfNome().equals(profNomeFantasia)) {
                // Apresenta o cabeçalho do profissional
                profCadastros.get(indiceProf).mostrarCabecalhoProf();
                System.out.println();

                // Incrementa contador de resultados
                resultados++;
            }
        }
        // Apresentando variável contadora de resultados
        System.out.println("Total de resultados: " + resultados);
    }

    // Método para buscar e mostrar profissionais na cidade "profCidade"
    public void buscaCidadeProf (String profCidade) {
        // Inicializando variável local contadora de resultados
        int resultados = 0;

        // Laço percorrendo cada profissional cadastrado presente em "profCadastros"
        for (int indiceProf: profCadastros.keySet()) {
            // Laço percorrendo cada endereço cadastrado no profissional "indiceProf"
            for (int indiceEnderecos = 0; indiceEnderecos < profCadastros.get(indiceProf).getQtdEndereco(); indiceEnderecos++) {
                // Caso o endereço cadastrado contenha a cidade "profCidade"
                if (profCadastros.get(indiceProf).getProfEndereco().get(indiceEnderecos).getCidade().equals(profCidade)) {
                    // Apresenta o cabeçalho do profissional
                    profCadastros.get(indiceProf).mostrarCabecalhoProf();
                    System.out.println();

                    // Incrementa contador de resultados
                    resultados++;

                    // Interromper o laço de repetição interno
                    break;
                }
            }
        }
        // Apresentando variável contadora de resultados
        System.out.println("Total de resultados: " + resultados);
    }

    // Método para buscar e mostrar profissionais com a tag "tipoTag"
    public void buscaTagsProf (String tipoTag) {
        // Inicializando variável local contadora de resultados
        int resultados = 0;

        // Laço percorrendo cada profissional cadastrado presente em "profCadastros"
        for (int indiceProf: profCadastros.keySet()) {
            // Laço percorrendo cada tag cadastrada no profissional "indiceProf"
            for (int indiceTag = 0; indiceTag < profCadastros.get(indiceProf).getProfTags().size(); indiceTag++) {
                // Caso contenha a tag "tipoTag"
                if (profCadastros.get(indiceProf).getProfTags().contains(tipoTag)) {
                    // Apresenta o cabeçalho do profissional
                    profCadastros.get(indiceProf).mostrarCabecalhoProf();
                    System.out.println();

                    // Incrementa contador de resultados
                    resultados++;

                    // Interromper o laço de repetição interno
                    break;
                }
            }
        }
        // Apresentando variável contadora de resultados
        System.out.println("Total de resultados: " + resultados);
    }

    // Método para buscar e mostrar profissionais com o pagamento "tipoPagamento"
    public void buscaPagamentoProf (String tipoPagamento) {
        // Inicializando variável local contadora de resultados
        int resultados = 0;

        // Laço percorrendo cada profissional cadastrado presente em "profCadastros"
        for (int indiceProf: profCadastros.keySet()) {
            // Laço percorrendo cada pagamento cadastrado no profissional "indiceProf"
            for (int indicePagamento = 0; indicePagamento < profCadastros.get(indiceProf).getProfPagamentos().size(); indicePagamento++) {
                // Caso contenha o pagamento "tipoPagamento"
                if (profCadastros.get(indiceProf).getProfPagamentos().contains(tipoPagamento)) {
                    // Apresenta o cabeçalho do profissional
                    profCadastros.get(indiceProf).mostrarCabecalhoProf();
                    System.out.println();

                    // Incrementa contador de resultados
                    resultados++;

                    // Interromper o laço de repetição interno
                    break;
                }
            }
        }
        // Apresentando variável contadora de resultados
        System.out.println("Total de resultados: " + resultados);
    }

    // Método para buscar e mostrar profissionais com média de avaliação
    // maior ou igual a "valorMediaProf"
    public void buscaMediaAvalProf (int valorMediaProf) {
        // Inicializando variável local contadora de resultados
        int resultados = 0;

        // Laço percorrendo cada profissional cadastrado presente em "profCadastros"
        for (int indiceProf: profCadastros.keySet()) {
            // Caso a média do cliente "indiceProf" seja maior ou igual a "valorMediaProf"
            if (Double.parseDouble(profCadastros.get(indiceProf).getMediaAvaliacao().replace(",",".")) >= valorMediaProf) {
                // Apresenta o cabeçalho do profissional
                profCadastros.get(indiceProf).mostrarCabecalhoProf();
                System.out.println();

                // Incrementa contador de resultados
                resultados++;
            }
        }
        // Apresentando variável contadora de resultados
        System.out.println("Total de resultados: " + resultados);
    }

    // ################################################################################### //

    // ###################### Getters e Setters da Classe "BancoDados" ###################### //

    public HashMap<Integer, Cliente> getClienteCadastros() {
        return clienteCadastros;
    }

    public void setClienteCadastros(HashMap<Integer, Cliente> clienteCadastros) {
        this.clienteCadastros = clienteCadastros;
    }

    public HashMap<Integer, Profissional> getProfCadastros() {
        return profCadastros;
    }

    public void setProfCadastros(HashMap<Integer, Profissional> profCadastros) {
        this.profCadastros = profCadastros;
    }

    // ################################################################################### //
}
