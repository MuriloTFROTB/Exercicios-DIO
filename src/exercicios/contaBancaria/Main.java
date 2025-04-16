package exercicios.contaBancaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do titular da conta: ");
        String nomeTitular = scanner.nextLine();
        System.out.println("Digite o saldo inicial da conta: ");
        double saldoInicial = scanner.nextDouble();
        Conta conta = new Conta(nomeTitular, saldoInicial);
        int opcao;
        do {
            System.out.println("\n=== MENU CONTA BANCÁRIA ===");
            System.out.println("Titular: " + conta.getNomeTitular());
            System.out.println("Saldo: R$ " + conta.getSaldo());
            System.out.println("Cheque Especial: R$ " + conta.getChequeEspecial());
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Pagar Boleto");
            System.out.println("4 - Verificar uso do Cheque Especial");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor para depósito: R$ ");
                    double deposito = scanner.nextDouble();
                    conta.adicionarSaldo(deposito);
                    break;

                case 2:
                    System.out.print("Digite o valor para saque: R$ ");
                    double saque = scanner.nextDouble();
                    conta.sacarDinheiro(saque);
                    break;

                case 3:
                    System.out.print("Digite o valor do boleto: R$ ");
                    double boleto = scanner.nextDouble();
                    conta.pagarBoleto(boleto);
                    break;

                case 4:
                    if (conta.estaUsandoChequeEspecial()) {
                        System.out.println("⚠️ Você está usando o cheque especial.");
                        System.out.println("Valor utilizado: R$ " + conta.valorUsadoDoChequeEspecial());
                    } else {
                        System.out.println("✅ Você está usando apenas o saldo da conta.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
        System.out.println("Obrigado por usar o sistema de conta bancária!");
    }
}
