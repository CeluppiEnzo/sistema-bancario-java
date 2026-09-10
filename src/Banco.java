import java.util.ArrayList;

public class Banco {

    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Conta> contas = new ArrayList<>();

    static int numero = 1001;

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void criarConta(String cpf) {
        boolean encontrou = false;
        Cliente clienteEncontrado = null;
        for (int i = 0; i < clientes.size(); i++){
            if (cpf.equals(clientes.get(i).getCpf())) {
                encontrou = true;
                clienteEncontrado = clientes.get(i);
            }
        }

        if (!encontrou){
            System.out.println("Cliente não encontrado!\n");
        } else {
            Conta conta = new Conta(numero, clienteEncontrado);
            contas.add(conta);
            numero++;
            System.out.println("\nConta criada com sucesso! \n");
            System.out.println("-------------------------");
            System.out.println("\nNúmero da conta: " + conta.getNumero() + "\n");
            System.out.println("-------------------------");
        }
    }

    public void consultarSaldo(int numero) {
        boolean encontrou = false;
        for (int i = 0; i < contas.size(); i++){
            if (numero == contas.get(i).getNumero()){
                System.out.println("\n-------------------------");
                System.out.println("Cliente: " + contas.get(i).getCliente().getNome());
                System.out.println("Saldo: R$" + contas.get(i).getSaldo());
                System.out.println("-------------------------\n");
                encontrou = true;
            }
        }
        if (!encontrou){
            System.out.println("Número da conta inválido!\n");
        }
    }

    public void depositar(int numero, double valor) {
        boolean encontrou = false;
        if (valor <= 0){
            System.out.println("Não é possível depositar esse valor!\n");
        } else {
            for (int i = 0; i < contas.size(); i++){
                if (numero == contas.get(i).getNumero()){
                    encontrou = true;
                    contas.get(i).setSaldo(contas.get(i).getSaldo() + valor);
                    System.out.println("\nSaldo depositado com sucesso!\n");
                    System.out.println("-------------------------");
                    System.out.println("Cliente: " + contas.get(i).getCliente().getNome());
                    System.out.println("Saldo: R$" + contas.get(i).getSaldo());
                    System.out.println("-------------------------\n");

                }
            }
            if (!encontrou){
                System.out.println("Número da conta inválido!\n");
            }
        }
    }

    public void sacar(int numero, double valor) {
        boolean encontrou = false;
        boolean liberado = false;
        int cliente = 0;
        if (valor > 0){
            for (int i = 0; i < contas.size(); i++){
                if (numero == contas.get(i).getNumero()){
                    encontrou = true;
                    if (contas.get(i).getSaldo() >= valor){
                        liberado = true;
                        cliente = i;
                    } else {
                        System.out.println("Saldo insuficiente!\n");
                    }
                }
            }
            if (!encontrou){
                System.out.println("Número da conta inválido!\n");
            } else {
                if (liberado){
                    contas.get(cliente).setSaldo(contas.get(cliente).getSaldo() - valor);
                    System.out.println("\nSaldo sacado com sucesso!\n");
                    System.out.println("-------------------------");
                    System.out.println("Cliente: " + contas.get(cliente).getCliente().getNome());
                    System.out.println("Saldo: R$" + contas.get(cliente).getSaldo());
                    System.out.println("-------------------------\n");
                }
            }
        } else {
            System.out.println("Não é possível sacar esse valor!\n");
        }
    }

    public void transferir(int numeroOrigem, int numeroDestino, double valor) {
        boolean encontrou = false;
        boolean saldoSuficiente = false;
        int cliente1 = 0;
        int cliente2 = 0;
        if (numeroOrigem != numeroDestino){
            if (valor > 0){
                for (int i = 0; i < contas.size(); i++){
                    if (numeroOrigem == contas.get(i).getNumero()){
                        if (valor <= contas.get(i).getSaldo()){
                            saldoSuficiente = true;
                        }
                        for (int j = 0; j < contas.size(); j++){
                            if (numeroDestino == contas.get(j).getNumero()){
                                encontrou = true;
                                cliente1 = i;
                                cliente2 = j;
                            }
                        }
                    }
                }

                if (!encontrou){
                    System.out.println("Número de origem ou destino incorretos!\n");
                } else {
                    if (saldoSuficiente){
                        contas.get(cliente1).setSaldo(contas.get(cliente1).getSaldo() - valor);
                        contas.get(cliente2).setSaldo(contas.get(cliente2).getSaldo() + valor);
                        System.out.println("Transferência de R$" + valor + " , de " + contas.get(cliente1).getCliente().getNome() + " para " + contas.get(cliente2).getCliente().getNome() + " bem sucedida!\n");
                    } else {
                        System.out.println("Saldo insuficiente!\n");
                    }
                }
            } else {
                System.out.println("Não é possível transferir esse valor!\n");
            }
        } else {
            System.out.println("Não é possível transferir para a própria conta!\n");
        }

    }

    public void listarContas() {
        if (contas.isEmpty()){
            System.out.println("Nenhuma conta cadastrada!\n");
        } else {
            System.out.println("\n==================");
            System.out.println("      CONTAS");
            System.out.println("==================\n");
            for (int i = 0; i < contas.size(); i++){
                System.out.println("-------------------------");
                System.out.println("Número da conta: " + contas.get(i).getNumero());
                System.out.println("Cliente: " + contas.get(i).getCliente().getNome());
                System.out.println("Saldo: R$" + contas.get(i).getSaldo());
                System.out.println("-------------------------\n");
            }
        }
    }
}
