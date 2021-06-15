import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

// Classe "Main" responsável por manipular a simulação de uso das outras classes desenvolvidas
public class Main {
    public static void main(String[] args) {

        // Instanciando objeto do tipo bando de dados responsável por gerenciar
        // as entrada de clientes e profissionais
        BancoDados perfisCadastrados = new BancoDados();

        // Instanciando objeto gerador de cadastros aleatórios para
        // simular o funcionamento do app
        Populacao simulacao = new Populacao();

        // Populando o banco de dados com N cadastros aleatórios de clientes
        simulacao.randomCliente(perfisCadastrados, 10);

        // Populando o banco de dados com N cadastros aleatórios de profissionais
        simulacao.randomProf(perfisCadastrados, 10);


        // Exemplo de como buscar a ficha resumida de todos os clientes cadastrados
        System.out.println("################################### Todos Clientes Cadastrados [Resumido] ###################################");

        // Percorre todos os clientes cadastrados
        for (int id : perfisCadastrados.clienteCadastros.keySet()) {
            // Apresenta o cabeçalho do cliente usando como controle a variável ID
            perfisCadastrados.clienteCadastros.get(id).mostrarCabecalhoCliente();
        }
        System.out.println("########################################################################################################################");
        System.out.println();



        // Exemplo de como buscar a ficha completa de todos os clientes cadastrados
        System.out.println("################################### Todos Clientes Cadastrados [Completo] ###################################");

        // Percorre todos os clientes cadastrados
        for (int id : perfisCadastrados.clienteCadastros.keySet()) {
            // Apresenta a ficha completa do cliente usando como controle a variável ID
            perfisCadastrados.clienteCadastros.get(id).mostrarFichaCliente();
        }
        System.out.println("########################################################################################################################");
        System.out.println();


/*
        // Exemplo de como buscar a ficha resumida de todos os profissionais cadastrados
        System.out.println("################################### Todos Profissionais Cadastrados [Resumido] ###################################");

        // Percorre todos os profissionais cadastrados
        for (int id : perfisCadastrados.profCadastros.keySet()) {
            // Apresenta o cabeçalho do profissional usando como controle a variável ID
            perfisCadastrados.profCadastros.get(id).mostrarCabecalhoProf();
        }
        System.out.println("########################################################################################################################");
        System.out.println();
*/


        System.out.println("################################### Todos Profissionais Cadastrados [Completo] ###################################");

        // Percorre todos os profissionais cadastrados
        for (int id : perfisCadastrados.profCadastros.keySet()) {
            // Apresenta a ficha completa do profissional usando como controle a variável ID
            perfisCadastrados.profCadastros.get(id).mostrarFichaProf();
        }
        System.out.println("########################################################################################################################");
        System.out.println();


/*
        // Exemplo de busca por clientes na cidade Rolândia
        System.out.println("################################### Clientes com cidade: Rolândia ###################################");
        perfisCadastrados.buscaCidadeCliente("Rolândia");
        System.out.println("########################################################################################################################");
        System.out.println();
*/

/*
        // Exemplo de busca por profissionais na cidade Londrina
        System.out.println("################################### Profissionais com cidade: Londrina ###################################");
        perfisCadastrados.buscaCidadeProf("Londrina");
        System.out.println("########################################################################################################################");
        System.out.println();
*/

/*
        // Exemplo de busca por clientes com nome José
        System.out.println("################################### Clientes com nome: José ###################################");
        perfisCadastrados.buscaNomeCliente("José");
        System.out.println("########################################################################################################################");
        System.out.println();
*/

/*
        // Exemplo de busca por profissionais com nome fantasia de Coca-Cola
        System.out.println("################################### Profissionais com nome: Coca-Cola ###################################");
        perfisCadastrados.buscaNomeFantasiaProf("Coca-Cola");
        System.out.println("########################################################################################################################");
        System.out.println();
*/

/*
        // Exemplo de busca por profissionais com tag de Acabamentos
        System.out.println("################################### Profissionais com tag: Acabamentos ###################################");
        perfisCadastrados.buscaTagsProf("Acabamentos");
        System.out.println("########################################################################################################################");
        System.out.println();
*/

/*
        // Exemplo de busca por profissionais com pagamento do tipo Cartão de Crédito
        System.out.println("################################### Profissionais com pagamento: Cartão Crédito ###################################");
        perfisCadastrados.buscaPagamentoProf("Cartão Crédito");
        System.out.println("########################################################################################################################");
        System.out.println();
*/

/*
        // Exemplo de busca por clientes com media de avaliação acima de 3 estrelas
        System.out.println("################################### Clientes com media acima de: 3 Estrelas ###################################");
        perfisCadastrados.buscaMediaAvalCliente(3);
        System.out.println("########################################################################################################################");
        System.out.println();
*/

/*
        // Exemplo de busca por profissionais com media de avaliação acima de 4 estrelas
        System.out.println("################################### Profissionais com media acima de: 4 Estrelas ###################################");
        perfisCadastrados.buscaMediaAvalProf(4);
        System.out.println("########################################################################################################################");
        System.out.println();
*/

    }
}

// Classe "Populacao" responsável por popular de maneira aleatória os dados usados na classe "Main"
class Populacao {
        // Instanciando objeto responsável por gerar números aleatórios
        private Random rng = new Random();

        // String responsável por conter os chars que podem ser gerados pelo método getRandString
        private String charPool = "abcdefghijklmnopqrstuvwxyz";

        // String responsável por conter os numerais que podem ser gerados pelo método getRandInteger
        private String numPool = "0123456789";

        // Lista de opções para geração automática de nomes fantasia
        List<String> poolNomeFantasia = Arrays.asList(
                "Coca-Cola","Ypê","Colgate","Tang","Omo","Itambé","Antarctica","Qualy","Maggi","Soya",
                "Vitarella","Nescau","Miojo","Fanta","Sorriso","Palmolive","Italac","Knorr","Quero","Piracanjuba",
                "Bombril","Sazon","Nestlé","Maratá","Minuano","Lux","Liza","Elegê","Seda","Bauducco",
                "Hellmann’s","Ninho","Panco","Schin","Vigor","Rexona","Arisco","Personal","Camponesa","Dove",
                "Mabel","Tixan","Club Social","Veja","Piraquê","Limpol","Marilan","Tirol","Santa Clara","Santa Amália"
        );

        // Lista de opções para geração automática de nomes
        List<String> poolNome = Arrays.asList(
                "José","João","Antônio","Carlos","Francisco","Paulo","Pedro","Lucas","Luíz","Marcos",
                "Luis","Gabriel","Rafael","Daniel","Marcelo","Bruno","Eduardo","Felipe","Raimundo","Rodrigo",
                "Maria","Ana","Francisca","Antônia","Adriana","Juliana","Márcia","Fernanda","Patricia","Aline",
                "Sandra","Camila","Amanda","Bruna","Jéssica","Leticia","Júlia","Luciana","Vanessa","Mariana"
        );

        // Lista de opções para geração automática de sobrenomes
        List<String> poolSobrenome = Arrays.asList(
                "Silva","Santos","Oliveira","Souza","Rodrigues","Ferreira","Alves","Pereira","Lima","Gomes",
                "Costa","Ribeiro","Martins","Carvalho","Almeida","Lopes","Soares","Fernandes","Vieira","Barbosa",
                "Rocha","Dias","Nascimento","Andrade","Moreira","Nunes","Marques","Machado","Mendes","Freitas",
                "Cardoso","Ramos","Gonçalves","Santana","Teixeira"
        );

        // Lista de opções para geração automática de sexos
        List<String> poolSexo = Arrays.asList("Masculino","Feminino","Outro");

        // Lista de opções para geração automática de nomes de endereços
        List<String> poolNomeEndereco = Arrays.asList("Casa","Trabalho","Outro");

        // Lista de opções para geração automática de nomes de bairro
        List<String> poolBairro = Arrays.asList("Centro","Rural","Periferia");

        // Lista de opções para geração automática de nomes de cidade
        List<String> poolCidade = Arrays.asList("Rolândia","Londrina","Cambé","Ibiporã","Maringá");

        // Lista de opções para geração automática de nomes de estados
        List<String> poolEstado = Arrays.asList("Paraná", "São Paulo", "Santa Catarina");

    // Método responsável pela geração de cadastros aleatórios de clientes
    // sendo a quantidade de clientes definida pelo argumento "qtde"
    public void randomCliente (BancoDados perfisCadastrados, int qtde) {

        // Adicionando clientes pelo numero informado pelo argumento "qtde"
        for (int i = 0; i < qtde; i++) {
            // Invocando o método da classe BancoDados responsável por adicionar clientes "addCliente()"
            perfisCadastrados.addCliente();
        }

        // Populando a ficha de cada cliente de maneira aleatória
        for (int i: perfisCadastrados.clienteCadastros.keySet()){
            // Criando cadastro básico do cliente "i" através do método
            // "cadastroBasicoCliente()" da classe "Cliente"
            perfisCadastrados.clienteCadastros.get(i).cadastroBasicoCliente(
                    poolNome.get(rng.nextInt(poolNome.size())), // Nome de cliente aleatório
                    poolSobrenome.get(rng.nextInt(poolSobrenome.size())), // Sobrenome de Cliente aleatório
                    poolSexo.get(rng.nextInt(poolSexo.size())), // Sexo do cliente aleatório
                    LocalDate.of(2003- rng.nextInt(62),1,1) // Data de nascimento aleatório
                    );

            // Adicionando de 1 a 3 endereços para o cliente "i"
            for (int randEnd = 0; randEnd < rng.nextInt(2)+1; randEnd++) {
                // Invocando o método "addEndereco()" da classe "Cliente"
                perfisCadastrados.clienteCadastros.get(i).addEndereco(
                        poolNomeEndereco.get(rng.nextInt(poolNomeEndereco.size())), // Nome do endereço aleatório
                        getRandInteger(6), // Número de CEP aleatório
                        getRandString(20), // Nome de rua aleatório
                        getRandInteger(3), // Número de endereço aleatório
                        getRandString(20), // Informação de complemento aleatório
                        poolBairro.get(rng.nextInt(poolBairro.size())), // Nome de bairro aleatório
                        poolCidade.get(rng.nextInt(poolCidade.size())), // Nome de cidade aleatório
                        poolEstado.get(rng.nextInt(poolEstado.size())) // Nome de estado aleatório
                        );
            }

            // Adicionando de 0 a 50 avaliações para o cliente "i"
            for (int randAval = 0; randAval < rng.nextInt(51); randAval++) {
                // Invocando o método "addAval()" da classe "Cliente"
                perfisCadastrados.clienteCadastros.get(i).addAval(
                        (rng.nextInt(4)+1), // Valor de avaliação entre 1 e 5 estrelas
                        getRandInteger(5), // ID do avaliador aleatório
                        getRandString(140) // Comentário da avaliação aleatório
                );
            }
        }
    }

    // Método responsável pela geração de cadastros aleatórios de profissionais
    // sendo a quantidade de profissionais definida pelo argumento "qtde"
    public void randomProf (BancoDados perfisCadastrados, int qtde) {
        // Adicionando profissionais pelo número informado pela variável "qtde"
        for (int i = 0; i < qtde; i++) {
            // Invocando o método da classe BancoDados responsável por adicionar profissionais "addProf()"
            perfisCadastrados.addProf();
        }

        // Populando a ficha de cada profissional de maneira aleatória
        for (int i: perfisCadastrados.profCadastros.keySet()) {
            // Criando cadastro básico do profissional "i" através do método
            // "cadastroBasicoProf()" da classe "Profissional"
            perfisCadastrados.profCadastros.get(i).cadastroBasicoProf(
                    poolNomeFantasia.get(rng.nextInt(poolNomeFantasia.size())), // Nome fantasia aleatório
                    getRandString(50), // Descrição de serviços aleatório
                    poolNome.get(rng.nextInt(poolNome.size())), // Nome do profissional aleatório
                    poolSobrenome.get(rng.nextInt(poolSobrenome.size())), // Sobrenome do profissional aleatório
                    poolSexo.get(rng.nextInt(poolSexo.size())), // Sexo do profissional aleatório
                    LocalDate.of(2003 - rng.nextInt(62), 1, 1) // Data de nascimento aleatório
                    );

            // Adicionando de 1 a 5 tags de serviços ao profissional "i"
            for (int randTags = 0; randTags < rng.nextInt(4) + 1; randTags++) {
                // Invocando o método "addProfTags()" da classe "Profissional"
                // adicionando uma das tags disponíveis na lista "tagsDisponiveis"
                // da classe "Profissional"
                perfisCadastrados.profCadastros.get(i).addProfTags(
                        rng.nextInt(perfisCadastrados.profCadastros.get(i).getTagsDisponiveis().size())
                        );
            }

            // Adicionando de 1 a 7 formas de pagamento ao profissional "i"
            for (int randEnd = 0; randEnd < rng.nextInt(6) + 1; randEnd++) {
                // Invocando o método "addPagamento()" da classe "Profissional"
                // adicionando um dos pagamentos disponíveis na lista "pagamentosDisponiveis"
                // da classe "Profissional"
                perfisCadastrados.profCadastros.get(i).addPagamento(
                        rng.nextInt(perfisCadastrados.profCadastros.get(i).getPagamentosDisponiveis().size())
                );
            }

            // Adicionando de 1 a 3 endereços para o profissional "i"
            for (int randEnd = 0; randEnd < rng.nextInt(2) + 1; randEnd++) {
                // Invocando o método "addEndereco()" da classe "Profissional"
                perfisCadastrados.profCadastros.get(i).addEndereco(
                        poolNomeEndereco.get(rng.nextInt(poolNomeEndereco.size())), // Nome do endereço aleatório
                        getRandInteger(6), // Número de CEP aleatório
                        getRandString(20), // Nome de rua aleatório
                        getRandInteger(3), // Número de endereço aleatório
                        getRandString(20), // Informação de complemento aleatório
                        poolBairro.get(rng.nextInt(poolBairro.size())), // Nome de bairro aleatório
                        poolCidade.get(rng.nextInt(poolCidade.size())), // Nome de cidade aleatório
                        poolEstado.get(rng.nextInt(poolEstado.size())) // Nome de estado aleatório
                        );
            }

            // Adicionando de 0 a 50 avaliações para o profissional "i"
            for (int randAval = 0; randAval < rng.nextInt(50); randAval++) {
                perfisCadastrados.profCadastros.get(i).addAval(
                        (rng.nextInt(4)+1), // Valor de avaliação entre 1 e 5 estrelas
                        getRandInteger(5), // ID do avaliador aleatório
                        getRandString(140) // Comentário da avaliação aleatório
                        );
            }
        }
    }

    // Método gerador de Strings aleatórias de comprimento "comprString"
    public String getRandString(int comprString) {
        // Inicializando uma String vazia
        String randString = "";

        // Repetindo "comprString" vezes a escolha de um char aleatório de "charPool"
        for (int i = 0; i < comprString; i++) {
            // Concatenando a String anterior com o char escolhido atual
            randString += charPool.toCharArray()[rng.nextInt(charPool.length())];
        }

        // Retornando o valor da String gerado
        return randString;
    }

    // Método gerador de Inteiros aleatórios de comprimento "comprInt"
    public int getRandInteger(int comprInt) {
        // Inicializando uma String vazia
        String auxRandInt = "";

        // Repetindo "comprInt" vezes a escolha de um char aleatório de "numPool"
        for (int i = 0; i < comprInt; i++) {
            // Concatenando a String anterior com o numeral escolhido atual
            auxRandInt += numPool.toCharArray()[rng.nextInt(numPool.length())];
        }

        // Retornando o valor da String gerado (convertida para tipo Int)
        return Integer.parseInt(auxRandInt);
    }
}


