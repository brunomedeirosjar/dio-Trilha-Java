import java.util.Scanner;

public class ContaTerminal{

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int conta;
        String nome, agencia;
        float saldo = 237.48F;

        System.out.println("Por favor, digite o Nome Completo: ");
        nome = sc.nextLine();

        System.out.println("Por favor, digite o número da Agência: ");
        agencia = sc.nextLine();

        System.out.println("Por favor, digite o número da Conta: ");
        conta = sc.nextInt();


        System.out.println(String.format(
                "Olá %s, obrigado por criar uma conta em nosso banco, " +
                        "sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque",
                nome, agencia, conta, saldo
        ));
    }

}