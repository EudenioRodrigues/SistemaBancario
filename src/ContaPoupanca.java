public final class ContaPoupanca extends Conta {
    private double taxaJuros; // Taxa de juros para cálculo de rendimento

    // Construtor: Inicializa a conta poupança com número, cliente e taxa de juros
    public ContaPoupanca(int numero, Cliente cliente, double taxaJuros) {
        super(numero, cliente);
        this.taxaJuros = taxaJuros;
    }

    // Retorna a taxa de juros da conta
    public double getTaxaJuros() {
        return taxaJuros;
    }

    // Define a taxa de juros da conta (deve estar entre 0 e 100)
    public void setTaxaJuros(double taxaJuros) {
        if (taxaJuros <= 0 || taxaJuros > 100) {
            System.out.println("Erro: A taxa de juros deve estar entre 0 e 100.");
        }
        this.taxaJuros = taxaJuros;
    }

    // Calcula o rendimento da conta com base na taxa de juros
    public void calcularRendimento() {
        if (taxaJuros <= 0) {
            System.out.println("Erro: A taxa de juros deve ser maior que zero.");
            return;
        }
        double rendimento = getSaldo() * (taxaJuros / 100);
        setSaldo(getSaldo() + rendimento);
        System.out.println("Rendimento calculado com sucesso. Novo saldo: " + getSaldo());
    }

    // Realiza um depósito na conta
    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do depósito deve ser maior que zero.");
            return;
        }
        setSaldo(getSaldo() + valor);
        System.out.println("Depósito realizado com sucesso. Novo saldo: " + getSaldo());
    }

    // Realiza um saque na conta
    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do saque deve ser maior que zero.");
            return;
        }
        if (getSaldo() < valor) {
            System.out.println("Erro: Saldo insuficiente para realizar o saque.");
            return;
        }
        setSaldo(getSaldo() - valor);
        System.out.println("Saque realizado com sucesso. Novo saldo: " + getSaldo());
    }
}

