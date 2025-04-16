package exercicios.contaBancaria;

public class Conta {
    private String nomeTitular;
    private double saldo;
    private double chequeEspecial;

    Conta(String titular, double saldo) {
        this.nomeTitular = titular;
        this.saldo = saldo;
        if (saldo <= 500 && saldo > 0) {
            this.chequeEspecial = 50.00;
        } else {
            this.chequeEspecial = (saldo / 2);
        }
    }

    public boolean estaUsandoChequeEspecial() {
        return this.saldo < 0;
    }

    public double valorUsadoDoChequeEspecial() {
        if (this.saldo < 0) {
            return Math.abs(this.saldo);
        }
        return 0.0;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void adicionarSaldo(double value) {
        if (value > 0) {
            this.saldo += value;
        } else {
            System.out.println("Erro");
        }
    }

    public boolean retirarSaldo(double value) {
        if (value > 0 && value <= (this.saldo + this.chequeEspecial)) {
            this.saldo -= value;
            

            if(this.saldo<0){
                double taxa= valorUsadoDoChequeEspecial()* 0.20;
                System.out.println("Taxa de 20% sobre o cheque especial: " + taxa);
                this.saldo -= taxa;
            }

            return true;
        } else {
            System.out.println("Erro");
            return false;
        }
    }

    public void pagarBoleto(double value) {
        if (retirarSaldo(value)) {
            System.out.println("Boleto pago com sucesso!");
        } else {
            System.out.println("Erro ao pagar o boleto.");
        }
    }

    public void sacarDinheiro(double value) {
        if (retirarSaldo(value)) {
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Erro ao sacar.");
        }
    }

    @Override
    public String toString() {

        return "Nome do titular: " + nomeTitular + "\n" +
                "Saldo: " + saldo + "\n" +
                "Cheque Especial: " + chequeEspecial + "\n" +
                "Usando Cheque Especial: " + estaUsandoChequeEspecial() + "\n" +
                "Valor Usado do Cheque Especial: " + valorUsadoDoChequeEspecial() + "\n";
    }
}
