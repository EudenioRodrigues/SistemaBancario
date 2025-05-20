public final class ContaCorrente extends Conta {
    private double limiteEspecial; // Limite especial para saques

    // Construtor: Inicializa a conta corrente com número, cliente e limite especial
    public ContaCorrente(int numero, Cliente cliente, double limiteEspecial) {
        super(numero, cliente);
        setLimiteEspecial(limiteEspecial);
    }

    // Retorna o limite especial da conta
    public double getLimiteEspecial() {
        return limiteEspecial;
    }

    // Define o limite especial da conta (não pode ser negativo)
    public void setLimiteEspecial(double limiteEspecial) {
        if (limiteEspecial < 0) {
            System.out.println("Erro: O limite não pode ser negativo.");
        }
        this.limiteEspecial = limiteEspecial;
    }

    // Realiza um depósito na conta
    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do depósito deve ser maior que zero.");
        }
        setSaldo(getSaldo() + valor);
        System.out.println("Depósito realizado com sucesso. Novo saldo: " + getSaldo());
    }

    // Realiza um saque na conta (considerando o limite especial)
    @Override
    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do saque deve ser maior que zero.");
            return;
        }
        if (getSaldo() + limiteEspecial < valor) {
            System.out.println("Erro: Saldo insuficiente para realizar o saque.");
            return;
        }
        setSaldo(getSaldo() - valor);
        System.out.println("Saque realizado com sucesso. Novo saldo: " + getSaldo());
    }
}
