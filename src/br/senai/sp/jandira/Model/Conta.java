package br.senai.sp.jandira.Model;

public class Conta {

    private String agencia = "000-20-X";
    private int numeroConta = 1234;
    private double saldo = 8640;

    public void realizarSaque(double valorSaque){

        if(valorSaque > this.saldo){
            valorSaque = 0;
            System.out.println("Não foi possível realizar o saque. Valor máximo permitido" + this.saldo);
        }

        this.saldo -= valorSaque;
        System.out.print("Seu saldo atual é: " + this.saldo);
    }

    public void realizarDeposito(double valorDeposito){
        this.saldo += valorDeposito;
        System.out.print("Seu salo atual é: " + this.saldo);

    }

    public void consultarSaldo(){
        System.out.print("Seu salo atual é:" + this.saldo);

    }
}
