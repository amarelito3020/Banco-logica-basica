public class Main {
    public static void main(String[] args) {
        try {
            Conta conta1 = new Conta("CC", "João");
            conta1.abrirConta();
            conta1.depositar(200);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
        }

        try {
            Conta conta2 = new Conta("XYZ", "Maria"); // Tipo inválido aqui!
            conta2.abrirConta();
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar conta: " + e.getMessage());
        }

    }
}
