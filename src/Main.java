import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Bem vindo ao sistema de cadastro de pessoas Fisicas e Juridicas");

        Scanner leitor = new Scanner(System.in);

        String opcao;
        do {

            System.out.println("Escolha uma opção 1 - Pessoa Fisica / 2 - Pessoa Juridica / 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("case1");
                    break;
                case "2":
                    System.out.println("case2");
                    break;
                case "0":
                    System.out.println("case0");
                    break;
                default:
                    System.out.println("erro");
                    break;
            }

        } while (!opcao.equals("0")  );


    }
}