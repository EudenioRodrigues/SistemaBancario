public abstract class Conta implements Transacao {
    private int numero; // Número da conta
    private double saldo; // Saldo da conta
    private Cliente cliente; // Cliente associado à conta

    // Construtor: Inicializa a conta com número, cliente e saldo inicial
    public Conta(int numero, Cliente cliente) {
        setCliente(cliente);
        setSaldo(0); // Saldo inicial é zero
        setNumero(numero);
    }

    // Retorna o número da conta
    public int getNumero() {
        return numero;
    }

    // Define o número da conta (deve ser maior que zero)
    public void setNumero(int numero) {
        if (numero <= 0) {
            System.out.println("Erro: O número da conta deve ser maior que zero.");
        }
        this.numero = numero;
    }

    // Retorna o saldo da conta
    public double getSaldo() {
        return saldo;
    }

    // Define o saldo da conta (não pode ser negativo)
    protected void setSaldo(double saldo) {
        if (saldo < 0) {
            System.out.println("Erro: O saldo não pode ser negativo.");
            return;
        }
        this.saldo = saldo;
    }

    // Retorna o cliente associado à conta
    public Cliente getCliente() {
        return cliente;
    }

    // Define o cliente associado à conta (não pode ser nulo)
    public void setCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Erro: O cliente não pode ser nulo.");
            return;
        }
        this.cliente = cliente;
    }

    // Métodos abstratos para depósito e saque (implementados nas subclasses)
    public abstract void depositar(double valor);
    public abstract void sacar(double valor);
}

