public class Main {

    public static void main(String[] args) {
        Banco banco = new Banco("Banco Digital");
        Cliente venilton = new Cliente("Venilton", "123.456.789-00");

        Conta cc = new ContaCorrente(venilton);
        Conta poupanca = new ContaPoupanca(venilton);
        banco.adicionarConta(cc);
        banco.adicionarConta(poupanca);

        cc.depositar(100);
        cc.transferir(40, poupanca);
        poupanca.sacar(10);

        for (Conta conta : banco.getContas()) {
            conta.imprimirExtrato();
            System.out.println();
        }
    }
}
