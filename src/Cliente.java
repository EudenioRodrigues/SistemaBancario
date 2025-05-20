import java.util.List;
import java.util.ArrayList;

public class Cliente {
    private String nome; // Nome do cliente
    private String cpf; // CPF do cliente
    private List<Conta> contas; // Lista de contas associadas ao cliente

    // Construtor: Inicializa o cliente com nome, CPF e uma lista de contas vazia
    public Cliente(String nome, String cpf) {
        setNome(nome);
        setCpf(cpf);
        this.contas = new ArrayList<>();
    }

    // Retorna o nome do cliente
    public String getNome() {
        return nome;
    }

    // Define o nome do cliente (não pode ser nulo ou vazio)
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Erro: O nome não pode ser nulo ou vazio.");
        }
        this.nome = nome;
    }

    // Retorna o CPF do cliente
    public String getCpf() {
        return cpf;
    }

    // Define o CPF do cliente (não pode ser nulo ou vazio)
    public void setCpf(String cpf) {
        if (cpf == null || cpf.trim().isEmpty()) {
            System.out.println("Erro: O CPF não pode ser nulo ou vazio.");
        }
        this.cpf = cpf;
    }

    // Retorna a lista de contas do cliente
    public List<Conta> getContas() {
        return contas;
    }

    // Define a lista de contas do cliente (não pode ser nula)
    public void setContas(List<Conta> contas) {
        if (contas == null) {
            System.out.println("Erro: A lista de contas não pode ser nula.");
        }
        this.contas = contas;
    }

    // Adiciona uma conta à lista de contas do cliente
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }
}
