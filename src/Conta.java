
public class Conta {
    private int numconta;
    private String tipoconta;
    private String donoconta;
    private double saldo;
    private boolean statusconta;

    public Conta() {
        this.statusconta = false;
        this.setSaldo(0);


    }

    public int getNumconta() {
        return numconta;
    }

    public void setNumconta(int numconta) {
        this.numconta = numconta;
    }

    public String getTipoconta() {
        return tipoconta;
    }

    public String getDonoconta() {
        return donoconta;
    }

    public void setDonoconta(String donoconta) {
        this.donoconta = donoconta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return this.saldo;

    }

    public boolean isStatusconta() {
        return statusconta;
    }

    public void setTipoconta(String tipoconta) {
        this.tipoconta = tipoconta;
    }

    public void abrirConta(String tipo) {
       this.setStatusconta(true);
       this.setTipoconta(tipo);

        if ("CC".equalsIgnoreCase(tipo)){
            this.setSaldo(150);
            System.out.println("Conta aberta com sucesso!");
            System.out.println("Você ganhou uma bonificação de R$150 por abrir conta corrente.");
        } else if ("CP".equalsIgnoreCase(tipo)) {
            this.setSaldo(300);
            System.out.println("Conta aberta com sucesso!");
            System.out.println("Você ganhou uma bonificação de R$300 por abrir conta poupança.");
        } else {
        throw new IllegalArgumentException("Conta inválida! Apenas 'CC' ou 'CP' são aceitos.");
    }


    }

    public void setStatusconta(boolean statusconta) {
        this.statusconta = statusconta;
    }

    public void fecharConta() {
        if (saldo > 0) {
            System.out.println("Você ainda tem saldo. Saque antes de fechar.");
        } else if (saldo < 0) {
            System.out.println("Conta está negativada em R$" + this.getSaldo());
        } else {
            this.setStatusconta(false);
            System.out.println("Conta encerrada.");
        }
    }

    public void depositar(double valor) {
        if (statusconta) {
            setSaldo(getSaldo() + valor);
            System.out.println("Depósito de R$" + valor + " realizado");
        } else {
            System.out.println("Conta fechada. Não é possível depositar.");
        }
    }

    public void sacar(double valor) {
        if (!statusconta) {
            System.out.println("Conta fechada. Não é possível sacar.");
        } else if (getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque de R$" + valor + " realizado na conta de " + this.getDonoconta() + " Saldo atual: R$" +this.getSaldo());
        } else {
            System.out.println("Saldo insuficiente para saque de R$" + valor);
        }
    }

    public void pagarMensal() {
        if (!statusconta) {
            System.out.println("Conta fechada. Não pode cobrar mensalidade.");
            return;
        }
        if ("CC".equals(tipoconta)) {
            setSaldo(getSaldo()-10);

            System.out.println("Mensalidade de R$10 cobrada da conta corrente.");
        } else if ("CP".equals(tipoconta)) {
           setSaldo(getSaldo()-5);
            System.out.println("Mensalidade de R$5 cobrada da conta poupança.");
        }
    }
    public void transfere(Conta destino, double valor){
        if (!this.statusconta || !destino.statusconta){
            System.out.println("Uma das contas esta fechada!");
            return;
        }
        if (this.getSaldo() >= valor){
            this.setSaldo(this.getSaldo() - valor);
            destino.depositar(valor);
            System.out.println("Transferência de R$"+ String.format("%.2f", valor) + " realizada com sucesso!");
        }else {
            System.out.println("Saldo insuficiente");
        }



    }
}
