import java.util.Scanner;

public class CadastroDev {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cabecalho();
        imprime_menu();
        escolha_menu();
    }

    static void cabecalho(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("----------------- CadDev - Ambiente de Cadastro -------------------");
        System.out.println("-----------------------  Seja bem-vindo(a)!  ----------------------");
        System.out.println("-------------------------------------------------------------------");
    }

    static void imprime_menu(){
        System.out.println("Menu de opções: ");
        System.out.println("\t 1 - Cadastar desenvolvedor");
        System.out.println("\t 2 - Cadastrar linguagem de programação");
        System.out.println("\t 3 - Sair");
    }

    static void escolha_menu(){
        int op = valida_escolha(entrada_numero("Digite uma opção do menu: "),3);

        switch (op){
            case 1: cadastro_dev();
                break;
            case 2: cadastro_linguagem();
                break;
            case 3: saida("Bye");
                break;
        }

    }

    static void cadastro_dev(){
        String nome = valida_string(entrada("Digite o nome do desenvolvedor: "), 3);
        String sobrenome = valida_string(entrada("Digite o sobrenome do desenvolvedor: "), 3);
        String senioridade = entrada("Informe o nível de senioridade do desenvolvedor: ");
        int idade = valida_idade(entrada_numero("Digite a idade do desenvolvedor: "));
        valida_idade(idade);
        System.out.printf("O cadastro foi realizado com sucesso!\n" +
                        "NOME COMPLETO: %s %s;\n" +
                        "SENIORIDADE: %s\n" +
                        "IDADE: %d", nome, sobrenome, senioridade, idade);
    }

    static void cadastro_linguagem(){
        String nome = valida_string(entrada("Digite o nome da linguagem: "), 3);
        String descricao = entrada("Digite a descricão da linguagem: ");
        String aplicacao = menu_aplicacao();
        System.out.printf("Cadastro realizaod com sucesso!\n" +
                "LINGUAGEM: %s\n" +
                "DESCRIÇÃO: %s\n" +
                "APLICAÇÃO: %s", nome, descricao, aplicacao);
    }

    static String menu_aplicacao(){
        String aplicacao = "";
        System.out.println("Menu de opções de aplicações da linguagem informada: ");
        System.out.println("\t 1 - Front-end");
        System.out.println("\t 2 - Back-end");
        System.out.println("\t 3 - Mobile");
        int op = valida_escolha(entrada_numero("Digite a descricão da linguagem: "),3);

        switch (op){
            case 1:
                aplicacao = "Front-end";
                break;
            case 2:
                aplicacao = "Back-end";
                break;
            case 3:
                aplicacao = "Mobile";
                break;
        }
        return aplicacao;
    }

    static String valida_string(String info, int nCaracteres){
        while(info.length()  < nCaracteres){
            System.out.printf("Informação precisa ter %d ou mais caracteres!\nDigite novamente: ", nCaracteres);
            info = sc.next();
        }
        return info;
    }

    static int valida_idade(int idade){
        while(idade <= 0){
            System.out.printf("Idade precisa ser maior que 0!\nDigite novamente: ");
            idade = sc.nextInt();
        }
        return idade;
    }

    static String entrada(String mensagem){
        System.out.print(mensagem);
        String info = sc.next();
        return info;
    }

    static int entrada_numero(String mensagem){
        System.out.print(mensagem);
        int entrada = sc.nextInt();
        return entrada;
    }

    static void saida(String mensagem){
        System.out.printf(mensagem);
    }

    static void saida_numerica(String mensagem, String info){
        System.out.printf("%s: %s", mensagem, info);
    }

    static int valida_escolha(int menu, int limite){
        while(menu <= 0 || menu > limite){
            System.out.print("Opção inválida. Digite novamente: ");
            menu = sc.nextInt();
        }
        return menu;
    }

}
