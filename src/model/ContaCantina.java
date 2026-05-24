package model;

public class ContaCantina {

    private TipoContaEnum tipoConta;
    private double saldo;
    private double limite;
    private double saldoMinimo;

    public ContaCantina(double saldo) {
        this.saldo = saldo;
        this.tipoConta = TipoContaEnum.ALUNO;
        this.saldoMinimo = 10.0;
    }

    public ContaCantina(TipoContaEnum tipoConta, double saldo) {
        this.tipoConta = tipoConta;
        this.saldo = saldo;

        if (tipoConta == TipoContaEnum.PROFESSOR) {
            this.limite = 100.0;
        }
    }

    public void emitirAlertaSaldoBaixo() {
        if (this.saldo <= this.saldoMinimo) {
            System.out.format("ALERTA DE SALDO BAIXO: R$ %.2f%n", this.saldo);
        } else {
            System.out.format("Saldo: R$ %.2f%n", this.saldo);
        }
    }

    public void debitar(double valor) {
        if (this.tipoConta == TipoContaEnum.DIRETOR) {
            this.saldo -= valor;
            emitirAlertaSaldoBaixo();
        } else if (this.tipoConta == TipoContaEnum.PROFESSOR
                && this.saldo > valor
                && valor < this.saldo + this.limite) {
            this.saldo -= valor;
            emitirAlertaSaldoBaixo();
        } else if (this.tipoConta == TipoContaEnum.ALUNO
                && this.saldo > valor) {
            this.saldo -= valor;
            emitirAlertaSaldoBaixo();
        } else {
            System.out.println("Conta sem saldo suficiente");
        }
    }

    public void creditar(double valor) {
        this.saldo += valor;

        if (this.tipoConta == TipoContaEnum.ALUNO && valor > 100.0) {
            this.saldo += 5.0;
        }

        emitirAlertaSaldoBaixo();
    }

    public void setSaldoMinimo(double saldoMinimo) {
        this.saldoMinimo = saldoMinimo;
        emitirAlertaSaldoBaixo();
    }
}