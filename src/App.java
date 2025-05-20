public class App {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco(1, "Banco Exemplo");

        System.out.println("\n==============================");
        System.out.println("Bem-vindo ao Sistema Bancário!");
        System.out.println("==============================\n");

        // Adicionar clientes
        banco.adicionarCliente("João Silva", "12345678900");
        banco.adicionarCliente("Maria Oliveira", "98765432100");

        // Criar contas
        Cliente cliente1 = banco.getClientes().get(0);
        Cliente cliente2 = banco.getClientes().get(1);

        banco.criarContaCorrente(1001, cliente1, 500.0);
        banco.criarContaPoupanca(2001, cliente1, 2.5);

        banco.criarContaCorrente(1002, cliente2, 1000.0);

        // Obter as contas criadas
        Conta contaCorrente1 = banco.getContas().get(0);
        Conta contaPoupanca1 = banco.getContas().get(1);
        Conta contaCorrente2 = banco.getContas().get(2);

        // Realizar transações
        System.out.println("Realizando depósito na Conta Corrente 1...");
        contaCorrente1.depositar(1000.0);

        System.out.println("Realizando saque na Conta Corrente 1...");
        contaCorrente1.sacar(200.0);

        System.out.println("Realizando transferência da Conta Corrente 1 para a Conta Poupança 1...");
        contaCorrente1.sacar(300.0);
        contaPoupanca1.depositar(300.0);

        System.out.println("Realizando depósito na Conta Corrente 2...");
        contaCorrente2.depositar(2000.0);

        System.out.println("Realizando saque na Conta Corrente 2...");
        contaCorrente2.sacar(500.0);

        // Calcular rendimento da Conta Poupança
        System.out.println("Calculando rendimento da Conta Poupança 1...");
        ((ContaPoupanca) contaPoupanca1).calcularRendimento();

        // Exibir informações das contas
        System.out.println("Exibindo informações da Conta Corrente 1...");
        banco.exibirInformacoesConta(contaCorrente1);

        System.out.println("Exibindo informações da Conta Poupança 1...");
        banco.exibirInformacoesConta(contaPoupanca1);

        System.out.println("Exibindo informações da Conta Corrente 2...");
        banco.exibirInformacoesConta(contaCorrente2);

        System.out.println("\n==============================");
        System.out.println("Operações concluídas com sucesso!");
        System.out.println("==============================\n");
    }
}
