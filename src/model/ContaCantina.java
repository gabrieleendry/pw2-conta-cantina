package model;

public class ContaCantina {

    private TipoContaEnum tipoConta;
    private double saldo;
    private double limite;
    private double saldoMinimo;

    public ContaCantina(double saldo) {
        this.tipoConta = TipoContaEnum.ALUNO;
        this.saldo = saldo;
        this.limite = 0.0;
        this.saldoMinimo = 10.0;
    }

    public ContaCantina(TipoContaEnum tipoConta, double saldo) {
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        if (this.tipoConta == TipoContaEnum.PROFESSOR) {
            this.limite = 100.0;
        } else {
            this.limite = 0.0;
        }
        this.saldoMinimo = 10.0;
    }

    public void emitirAlertaSaldoBaixo() {
        if (this.saldo <= this.saldoMinimo) {
            System.out.println("ALERTA DE SALDO BAIXO: R$ " + String.format("%.2f", this.saldo));
        } else {
            System.out.println("Saldo: R$ " + String.format("%.2f", this.saldo));
        }
    }

    public void debitar(double valor) {
        boolean podeDebitar = false;

        if (this.tipoConta == TipoContaEnum.DIRETOR) {
            podeDebitar = true;
        } else if (this.tipoConta == TipoContaEnum.PROFESSOR) {
            if (this.saldo > valor && valor < (this.saldo + this.limite)) {
                podeDebitar = true;
            }
        } else if (this.tipoConta == TipoContaEnum.ALUNO) {
            if (this.saldo > valor) {
                podeDebitar = true;
            }
        }

        if (podeDebitar) {
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

    public TipoContaEnum getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(TipoContaEnum tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }
}
