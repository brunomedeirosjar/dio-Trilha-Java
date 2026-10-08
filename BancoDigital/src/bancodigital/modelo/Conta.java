package bancodigital.modelo;

// Abstração: Conta representa o que é comum a qualquer tipo de conta do banco.
// Herança: ContaCorrente e ContaPoupanca reutilizam esta classe base.
public abstract class Conta implements IConta {

    private static int sequencial = 1;

    // Encapsulamento: estado privado, acesso controlado por métodos.
    private final int agencia;
    private final int numero;
    private double saldo;
    private final Cliente cliente;

    protected Conta(Cliente cliente, int agencia, double saldoInicial) {
        this.agencia = agencia;
        this.numero = sequencial++;
        this.cliente = cliente;
        this.saldo = saldoInicial;
    }

    @Override
    public void sacar(double valor) {
        validarValor(valor);
        if (valor > saldo) {
            throw new IllegalStateException("Saldo insuficiente.");
        }
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        validarValor(valor);
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    private void validarValor(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", cliente.getNome()));
        System.out.println(String.format("Agencia: %d", agencia));
        System.out.println(String.format("Numero: %d", numero));
        System.out.println(String.format("Saldo: R$ %.2f", saldo));
    }
}
