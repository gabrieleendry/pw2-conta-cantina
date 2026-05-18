package model;


public class ContaCantina {

    private TipoContaEnum tipoConta;
    private double saldo;
    private double limite;
    private double saldoMinimo;

    public ContaCantina(double saldo){
        this.tipoConta = TipoContaEnum.Aluno;
        this.saldo = saldo;
        this.limite = 0.0;
        this.saldoMinimo = 10.0;

    }

    public ContaCantina(TipoContaEnum tipoConta, double saldo){
        th

    }


}