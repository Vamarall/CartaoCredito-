package br.pm.business;

import java.time.LocalDate;

public class Cartao {

    private int numero;
    private String cpf;
    private double limiteCredito;
    private LocalDate dataVencimento;
    private double fatura;
    private final static double taxaJuros = 0.02;

    public Cartao(int num, String cpf, double limiteCredito, LocalDate dataVencimento) {
        this.numero = num;
        this.cpf = cpf;
        this.limiteCredito = limiteCredito;
        this.dataVencimento = dataVencimento;
    }

    public int getNumero() {
        return this.numero;
    }

    public String getCpf() {
        return this.cpf;
    }

    public double getLimiteCredito() {
        return this.limiteCredito;
    }

    public LocalDate getDataVencimento() {
        return this.dataVencimento;
    }

    public double getFatura(){
        return this.fatura;
    }

    public boolean Compra(double valor) {

        if (valor <= this.limiteCredito) {
            limiteCredito -= valor;
            this.fatura += valor;
            return true;
        }

        return false;

    }

    public void pagarFatura(double valorPagamento) {

        if (LocalDate.now().isAfter(dataVencimento)) {

            double saldoDevedor = this.fatura * this.taxaJuros;
            this.fatura += saldoDevedor;

        }

        this.fatura -= valorPagamento;

    }

    public boolean aumetarLimite(double valor) {
        if (this.fatura == 0) {
            this.limiteCredito += valor;

            return true;
        } else {
            return false;
        }
    }

}
