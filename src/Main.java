public class Main {
    public static void main(String[] args) {

        Conta conta1 = new Conta();
        conta1.abrirConta("CP");
        conta1.setDonoconta("Alisson");
        System.out.printf("Seu saldo é R$ %.2f\n", conta1.getSaldo());


        Conta conta2 = new Conta();
        conta2.abrirConta("CC");
        conta2.setDonoconta("Mauricio");
        conta2.transfere(conta1, 5);

        System.out.println("Saldo: " + conta1.getSaldo());
        System.out.println("Saldo: " + conta2.getSaldo());






    }
}
