public class Conta {
    private int numconta;
    private String tipoconta;
    private String donoconta;
    private double saldo;
    private boolean statusconta;

    public Conta(String tipo, String dono) {
        this.donoconta = dono;
        this.statusconta = false;

        if ("CC".equalsIgnoreCase(tipo)) {
            this.tipoconta = "CC";
            this.saldo = 150;
            System.out.println("Você ganhou uma bonificação de R$150 por abrir conta corrente.");
        } else if ("CP".equalsIgnoreCase(tipo)) {
            this.tipoconta = "CP";
            this.saldo = 300;
            System.out.println("Você ganhou uma bonificação de R$300 por abrir conta poupança.");
        } else {
            throw new IllegalArgumentException("Conta inválida! Apenas 'CC' ou 'CP' são aceitos.");
        }
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

    public double getSaldo() {
        return saldo;
    }

    public boolean isStatusconta() {
        return statusconta;
    }

    public void abrirConta() {
        this.statusconta = true;
        System.out.println("Conta aberta com sucesso!");
    }

    public void fecharConta() {
        if (saldo > 0) {
            System.out.println("Você ainda tem saldo. Saque antes de fechar.");
        } else if (saldo < 0) {
            System.out.println("Conta está negativada em R$" + saldo);
        } else {
            this.statusconta = false;
            System.out.println("Conta encerrada.");
        }
    }

    public void depositar(double valor) {
        if (statusconta) {
            saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado. Saldo atual: R$" + saldo);
        } else {
            System.out.println("Conta fechada. Não é possível depositar.");
        }
    }

    public void sacar(double valor) {
        if (!statusconta) {
            System.out.println("Conta fechada. Não é possível sacar.");
        } else if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado. Saldo atual: R$" + saldo);
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
            saldo -= 100;
            System.out.println("Mensalidade de R$100 cobrada da conta corrente.");
        } else if ("CP".equals(tipoconta)) {
            saldo -= 25;
            System.out.println("Mensalidade de R$25 cobrada da conta poupança.");
        }
    }
}
