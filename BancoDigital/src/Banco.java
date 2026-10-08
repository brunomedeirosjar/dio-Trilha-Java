import java.util.ArrayList;
import java.util.List;

public class Banco {

    private final String nome;
    private final List<Conta> contas = new ArrayList<>();

    public Banco(String nome) {
        this.nome = nome;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public String getNome() {
        return nome;
    }

    public List<Conta> getContas() {
        return List.copyOf(contas);
    }
}
