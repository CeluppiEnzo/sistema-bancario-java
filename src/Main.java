import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Banco banco = new Banco();

        int opcao = 0;

        while (opcao != 8) {
            System.out.println("====================");
            System.out.println("SISTEMA BANCÁRIO");
            System.out.println("====================");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Criar conta");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Depositar");
            System.out.println("5 - Sacar");
            System.out.println("6 - Transferir");
            System.out.println("7 - Listar contas");
            System.out.println("8 - Sair");
            System.out.println("====================");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.println("Qual o nome do cliente que deseja cadastrar? ");
                String nome = scanner.nextLine();
                System.out.println("Qual o cpf do cliente que deseja cadastrar? ");
                String cpf = scanner.nextLine();
                System.out.println("Qual o telefone do cliente que deseja cadastrar? ");
                String telefone = scanner.nextLine();
                Cliente cliente = new Cliente(nome, cpf, telefone);
                banco.cadastrarCliente(cliente);
                System.out.println("Cliente cadastrado com sucesso!");
            } else if (opcao == 2) {
                System.out.print("Digite o CPF do cliente: ");
                String cpf = scanner.nextLine();

                banco.criarConta(cpf);
            } else if (opcao == 3) {
                System.out.println("Digite o número da conta: ");
                int numero = scanner.nextInt();
                scanner.nextLine();

                banco.consultarSaldo(numero);
            } else if (opcao == 4) {
                System.out.println("Digite o número da conta: ");
                int numero = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite o valor do depósito: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                banco.depositar(numero, valor);
            } else if (opcao == 5) {
                System.out.println("Digite o número da conta: ");
                int numero = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite o valor do saque: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                banco.sacar(numero, valor);
            } else if (opcao == 6) {
                System.out.println("Digite o número da conta de origem (de onde o dinheiro sai): ");
                int numeroOrigem = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite o número da conta de destino (para onde o dinheiro vai): ");
                int numeroDestino = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Digite o valor da transferência: ");
                double valor = scanner.nextDouble();
                scanner.nextLine();

                banco.transferir(numeroOrigem, numeroDestino, valor);
            } else if (opcao == 7) {
                banco.listarContas();
            } else if (opcao == 8) {
                System.out.println("Encerrando...");
            } else {
                System.out.println("Opção inválida!");
            }
        }

        scanner.close();
    }
}