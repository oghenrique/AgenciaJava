package br.senai.sp.jandira.Model;

import java.util.ArrayList;
import java.util.List;

public class Conta {

    private String agencia = "1234-XX";
    private int numeroConta;
    private double saldo = 0;
    private Cliente cliente;

    public void gerarConta(Cliente cliente){
        numeroConta = (int) (Math.random()*10000);
        this.cliente = cliente;
    }

        List<Conta> listContas = new ArrayList<>();

    public void adicionarContaList(Conta conta){
        listContas.add(conta);
    }

    public Conta pesquisarConta(long cpf) {
        for (Conta conta : listContas) {

            long validaCpfConta = conta.cliente.getCpf();;
            if (validaCpfConta == cpf) {
                return conta;
            }
        }
        return null;
    }

    public void listarContas(){
        for (Conta conta : listContas ) {
            System.out.println(conta.numeroConta);
        }
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }


    public void realizarSaque(double valorSaque){

        if(this.saldo >= valorSaque){
            this.saldo -= valorSaque;
            System.out.println("Seu saldo atual é: " + this.saldo);
        } else{
            System.out.println("Informe um valor valido");
        }
    }

    public void realizarDeposito(double valorDeposito){
        this.saldo += valorDeposito;
        System.out.print("Seu salo atual é: " + this.saldo);

    }

}
