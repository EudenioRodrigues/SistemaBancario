import java.util.ArrayList;
import java.util.List;

public class Banco {
    private int idBanco;
    private String nomeBanco;
    private List<Cliente> clientes;
    private List<Conta> contas;

    // Construtor: Inicializa o banco com ID, nome e listas de clientes e contas
    public Banco(int idBanco, String nomeBanco) {
        setIdBanco(idBanco);
        setNomeBanco(nomeBanco);
        this.clientes = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    // Retorna o ID do banco
    public int getIdBanco() {
        return idBanco;
    }

    // Define o ID do banco (deve ser maior que zero)
    public void setIdBanco(int idBanco) {
        if (idBanco <= 0) {
            System.out.println("Erro: O ID do banco deve ser maior que zero.");
        }
        this.idBanco = idBanco;
    }

    // Retorna o nome do banco
    public String getNomeBanco() {
        return nomeBanco;
    }

    // Define o nome do banco (não pode ser nulo ou vazio)
    public void setNomeBanco(String nomeBanco) {
        if (nomeBanco == null || nomeBanco.trim().isEmpty()) {
            System.out.println("Erro: O nome do banco não pode ser nulo ou vazio.");
        }
        this.nomeBanco = nomeBanco;
    }

    // Retorna a lista de clientes do banco
    public List<Cliente> getClientes() {
        return clientes;
    }

    // Define a lista de clientes (não pode ser nula)
    public void setClientes(List<Cliente> clientes) {
        if (clientes == null) {
            System.out.println("Erro: A lista de clientes não pode ser nula.");
        }
        this.clientes = clientes;
    }

    // Retorna a lista de contas do banco
    public List<Conta> getContas() {
        return contas;
    }

    // Define a lista de contas (não pode ser nula)
    public void setContas(List<Conta> contas) {
        if (contas == null) {
            System.out.println("Erro: A lista de contas não pode ser nula.");
        }
        this.contas = contas;
    }

    // Adiciona um cliente ao banco
    public void adicionarCliente(String nome, String cpf) {
        Cliente cliente = new Cliente(nome, cpf);
        this.clientes.add(cliente);
        System.out.println("\n==============================");
        System.out.println("Cliente adicionado com sucesso!");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("==============================\n");
    }

    // Cria uma conta corrente para um cliente
    public void criarContaCorrente(int numero, Cliente cliente, double limiteEspecial) {
        ContaCorrente contaCorrente = new ContaCorrente(numero, cliente, limiteEspecial);
        this.contas.add(contaCorrente);
        cliente.getContas().add(contaCorrente);
        System.out.println("\n==============================");
        System.out.println("Conta Corrente criada com sucesso!");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Número da Conta: " + numero);
        System.out.println("Limite Especial: " + limiteEspecial);
        System.out.println("==============================\n");
    }

    // Cria uma conta poupança para um cliente
    public void criarContaPoupanca(int numero, Cliente cliente, double taxaJuros) {
        ContaPoupanca contaPoupanca = new ContaPoupanca(numero, cliente, taxaJuros);
        this.contas.add(contaPoupanca);
        cliente.getContas().add(contaPoupanca);
        System.out.println("\n==============================");
        System.out.println("Conta Poupança criada com sucesso!");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Número da Conta: " + numero);
        System.out.println("Taxa de Juros: " + taxaJuros + "%");
        System.out.println("==============================\n");
    }

    // Realiza uma transferência entre duas contas
    public void realizarTransferencia(Conta origem, Conta destino, double valor) {
        if (origem.getSaldo() >= valor) {
            origem.sacar(valor);
            destino.depositar(valor);
            System.out.println("\n==============================");
            System.out.println("Transferência realizada com sucesso!");
            System.out.println("Valor: " + valor);
            System.out.println("De: Conta " + origem.getNumero() + " (Saldo: " + origem.getSaldo() + ")");
            System.out.println("Para: Conta " + destino.getNumero() + " (Saldo: " + destino.getSaldo() + ")");
            System.out.println("==============================\n");
        } else {
            System.out.println("\n==============================");
            System.out.println("Erro: Saldo insuficiente para realizar a transferência.");
            System.out.println("==============================\n");
        }
    }

    // Exibe as informações de uma conta (corrente ou poupança)
    public void exibirInformacoesConta(Conta conta) {
        System.out.println("\n==============================");
        System.out.println("Informações da Conta");
        System.out.println("Número da Conta: " + conta.getNumero());
        System.out.println("Cliente: " + conta.getCliente().getNome());
        System.out.println("Saldo: " + conta.getSaldo());
        if (conta instanceof ContaCorrente) {
            ContaCorrente cc = (ContaCorrente) conta;
            System.out.println("Limite Especial: " + cc.getLimiteEspecial());
        } else if (conta instanceof ContaPoupanca) {
            ContaPoupanca cp = (ContaPoupanca) conta;
            System.out.println("Taxa de Juros: " + cp.getTaxaJuros() + "%");
        }
        System.out.println("==============================\n");
    }
}
