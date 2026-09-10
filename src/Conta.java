public class Conta {
    private int numero;
    private double saldo;
    private Cliente cliente;

    public Conta(int numero, Cliente cliente){
        this.numero = numero;
        this.saldo = 0;
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setSaldo(double valor) {
        this.saldo = valor;
    }
}
