package br.senai.sp.jandira.Model;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Cliente referenciaCliente  = new Cliente();
    Conta referenciaConta = new Conta();
    public void executarMenu() {

        boolean continuar = true;

        while (continuar) {

            System.out.println("---------- Bem Vindo ----------");
            System.out.println("\n==> Menu:\n");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Gerar Conta");
            System.out.println("3 - Consultar Saldo");
            System.out.println("4 - Realizar Deposito");
            System.out.println("5 - Realizar Saque");
            System.out.println("6 - Transferência");
            System.out.println("7 - Sair");
            System.out.println("-------------------------------");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    Cliente cliente = new Cliente();
                    cliente.cadastrarCliente();
                    referenciaCliente.adicionarCliente(cliente);
                    break;

                case 2:
                    System.out.println("Informe o CPF do Titular: ");
                    long cpfTitular = scanner.nextLong();
                    scanner.nextLine();

                    Cliente clienteTitular = referenciaCliente.pesquisarCliente(cpfTitular);

                    if(clienteTitular != null) {
                        Conta conta = new Conta();
                        conta.gerarConta(clienteTitular);
                        referenciaConta.adicionarContaList(conta);

                        System.out.println("Conta gerada com sucesso!");
                    } else {
                        System.out.println("Impossivel gerar a conta...");
                        System.out.println("Necessário cadastrar cliente...");
                    }
                    break;

                case 3:

                    System.out.print("Informe o CPF do Titular: ");
                    long cpfConta= scanner.nextLong();
                    scanner.nextLine();

                    Conta contaPesquisada = referenciaConta.pesquisarConta(cpfConta);

                    if(contaPesquisada != null){
                        double saldo = contaPesquisada.getSaldo();
                        System.out.println("O saldo disponivel na conta é: " + saldo);
                    } else {
                        System.out.println("O usuario não possui conta cadastrada...");
                    }

                    break;

                case 4:
                    System.out.print("Informe o CPF do Titular: ");
                    long cpfDeposito= scanner.nextLong();
                    scanner.nextLine();

                    Conta contaDeposito = referenciaConta.pesquisarConta(cpfDeposito);

                    if (contaDeposito != null){
                        System.out.println("Informe o valor para deposito: ");
                        double valorDeposito = scanner.nextDouble();
                        contaDeposito.realizarDeposito(valorDeposito);
                    }else{
                        System.out.println("O usuario não possui conta cadastrada...");
                    }

                    break;

                    case 5:
                        System.out.print("Informe o CPF do Titular: ");
                        long cpfSaque= scanner.nextLong();
                        scanner.nextLine();

                        Conta contaSaque = referenciaConta.pesquisarConta(cpfSaque);

                        if (contaSaque != null){
                            System.out.println("Informe o valor para saque: ");
                            double valorSaque = scanner.nextDouble();
                            contaSaque.realizarSaque(valorSaque);
                        }else{
                            System.out.println("O usuario não possui conta cadastrada...");
                        }

                        break;

                case 6:
                    System.out.println("Feature in Development");
                    break;


                case 7:
                    continuar = false;
                    break;

            }
        }
    }
}
