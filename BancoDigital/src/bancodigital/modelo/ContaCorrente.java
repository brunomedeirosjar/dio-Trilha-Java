package bancodigital.modelo;

public class ContaCorrente extends Conta {

    public ContaCorrente(Cliente cliente, int agencia, double saldoInicial) {
        super(cliente, agencia, saldoInicial);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        imprimirInfosComuns();
    }
}
