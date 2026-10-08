import bancodigital.modelo.Cliente;
import bancodigital.modelo.Conta;
import bancodigital.servico.Banco;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Banco banco = new Banco("Banco Digital");

        // Valores fixos: Cliente Um (agência 1) com 1000 e Cliente Dois (agência 2) com 20000.
        banco.abrirContaCorrente(new Cliente("Cliente Um", "111.111.111-11"), 1, 1000);
        banco.abrirContaCorrente(new Cliente("Cliente Dois", "222.222.222-22"), 2, 20000);

        System.out.println("===== " + banco.getNome() + " =====");
        Conta conta = null;
        while (conta == null) {
            try {
                System.out.print("Nome do cliente: ");
                String nome = in.nextLine();
                System.out.print("Agência: ");
                int agencia = Integer.parseInt(in.nextLine().trim());
                conta = banco.identificar(nome, agencia);
            } catch (NumberFormatException e) {
                System.out.println("Erro: agência inválida.");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        System.out.println("Bem-vindo, " + conta.getCliente().getNome() + "!");

        int opcao;
        do {
            System.out.printf("%nSaldo atual: R$ %.2f%n", conta.getSaldo());
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Transferir");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            try {
                opcao = Integer.parseInt(in.nextLine().trim());
                switch (opcao) {
                    case 1 -> {
                        conta.depositar(pedirValor(in));
                        System.out.println("Depósito realizado.");
                    }
                    case 2 -> {
                        conta.sacar(pedirValor(in));
                        System.out.println("Saque realizado.");
                    }
                    case 3 -> {
                        System.out.print("Agência de destino: ");
                        int destino = Integer.parseInt(in.nextLine().trim());
                        banco.transferir(conta, destino, pedirValor(in));
                        System.out.println("Transferência realizada.");
                    }
                    case 0 -> System.out.println("Até logo!");
                    default -> System.out.println("Opção inválida.");
                }
            } catch (NumberFormatException e) {
                opcao = -1;
                System.out.println("Erro: número inválido.");
            } catch (IllegalArgumentException | IllegalStateException e) {
                opcao = -1;
                System.out.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);
    }

    private static double pedirValor(Scanner in) {
        System.out.print("Valor: ");
        return Double.parseDouble(in.nextLine().trim().replace(',', '.'));
    }
}
