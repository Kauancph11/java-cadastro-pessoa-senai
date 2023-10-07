import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<PessoaFisica> listaPf = new ArrayList<>();
        PessoaFisica metodoPf = new PessoaFisica();


        System.out.println("Bem vindo ao sistema de cadastro de pessoas Fisicas e Juridicas");

        Scanner leitor = new Scanner(System.in);

        String opcao;
        do {

            System.out.println("Escolha uma opção 1 - Pessoa Fisica / 2 - Pessoa Juridica / 0 - Sair");
            opcao = leitor.nextLine();

            switch (opcao) {
                case "1":
                    String opcaoPf;
                    do {
                        System.out.println("Digite uma opção:");
                        System.out.println("1- Cadastrar PF");
                        System.out.println("2- Listar PF");
                        System.out.println("0- Voltar");
                        opcaoPf = leitor.nextLine();

                        switch (opcaoPf){
                            case "1":
                                PessoaFisica novaPf = new PessoaFisica();
                                Endereco novoEndPf = new Endereco();

                                System.out.println("Digite o nome:");
                                novaPf.nome = leitor.nextLine();
                                System.out.println("Digite o cpf:");
                                novaPf.cpf = leitor.nextLine();
                                System.out.println("Digite o rendimento:");
                                novaPf.rendimento = leitor.nextFloat();
                                System.out.println("Digite a data de nascimento: (dd/mm/aaaa)");
                                novaPf.dataNascimento = LocalDate.parse(leitor.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                                Period idade = Period.between(novaPf.dataNascimento, LocalDate.now());

                                if (idade.getYears() >= 18) {
                                    System.out.println("Idade valida");
                                }else {
                                    System.out.println("Idade invalida");
                                    break;
                                }

                                System.out.println("Digite o logradouro:");
                                novoEndPf.logradouro = leitor.next();
                                System.out.println("Digite o numero:");
                                novoEndPf.numero = leitor.nextInt();

                                System.out.println("Este endereco e comercial? S/N:");
                                String endCom = leitor.next();
                                if (endCom.equals("S")) {
                                    novoEndPf.endComercial = true;
                                }else {
                                    novoEndPf.endComercial = false;
                                }

                                novaPf.endereco = novoEndPf;

                                listaPf.add(novaPf);

                                System.out.println("Cadastro realizado com sucesso!");

                                break;
                            case "2":
                                if (listaPf.size() > 0){

                                    for (PessoaFisica cadapf: listaPf) {
                                        System.out.println("Nome: " + cadapf.nome);
                                        System.out.println("CPF: " + cadapf.cpf);
                                        System.out.println("Data de Nascimento: " + cadapf.dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                                        System.out.println("Imposto a ser pago: " + metodoPf.CalcularImposto(metodoPf.rendimento));
                                        System.out.println("Endereco: " + cadapf.endereco.logradouro + "-" + cadapf.endereco.numero);
                                        System.out.println();
                                        System.out.println("Aperte enter para continuar");
                                        leitor.nextLine();
                                    }

                                }else {
                                    System.out.println("A lista esta vazia");
                                }
                                break;
                            case "0":
                                System.out.println("Volta");
                                break;
                            default:
                                System.out.println("Erro");
                                break;
                        }
                    }while (!opcaoPf.equals("0"));
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