package bancodigital.servico;

import bancodigital.modelo.Cliente;
import bancodigital.modelo.Conta;
import bancodigital.modelo.ContaCorrente;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private final String nome;
    private final List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return List.copyOf(contas);
    }

    public Conta abrirContaCorrente(Cliente cliente, int agencia, double saldoInicial) {
        Conta conta = new ContaCorrente(cliente, agencia, saldoInicial);
        contas.add(conta);
        return conta;
    }

    public Conta buscarPorAgencia(int agencia) {
        return contas.stream()
                .filter(c -> c.getAgencia() == agencia)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Agência " + agencia + " não pertence a este banco."));
    }

    // Identifica o cliente pelo nome E pelo código da agência.
    public Conta identificar(String nomeCliente, int agencia) {
        Conta conta = buscarPorAgencia(agencia);
        if (!conta.getCliente().getNome().equalsIgnoreCase(nomeCliente.trim())) {
            throw new IllegalArgumentException("Nome e agência não conferem.");
        }
        return conta;
    }

    // Transferência apenas entre contas da própria instituição.
    public void transferir(Conta origem, int agenciaDestino, double valor) {
        Conta destino = buscarPorAgencia(agenciaDestino);
        if (destino == origem) {
            throw new IllegalArgumentException("Origem e destino devem ser diferentes.");
        }
        origem.transferir(valor, destino);
    }
}
