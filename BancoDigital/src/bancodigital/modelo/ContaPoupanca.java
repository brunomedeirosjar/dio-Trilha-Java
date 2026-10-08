package bancodigital.modelo;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, int agencia, double saldoInicial) {
        super(cliente, agencia, saldoInicial);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupanca ===");
        imprimirInfosComuns();
    }
}
