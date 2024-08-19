import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String agencia = null;
        int numero = 0;
        String nome = null;
        double saldo = 0.0;
        boolean inputValido = false;

        // Entrada do número da agência
        while (!inputValido) {
            try {
                System.out.println("Digite o número da agência a seguir: [com o digito xxx-x]");
                agencia = sc.nextLine();
                if (!agencia.matches("\\d{3}-\\d")) {
                    throw new IllegalArgumentException("Número da agência deve estar no formato xxx-x.");
                }
                inputValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        inputValido = false;
        // Entrada do número da conta
        while (!inputValido) {
            try {
                System.out.println("Digite o número da conta a seguir: [com os 4 digitos xxxx]");
                if (!sc.hasNextInt()) {
                    throw new InputMismatchException("Número da conta deve ser um número inteiro.");
                }
                numero = sc.nextInt();
                if (numero < 1000 || numero > 9999) {
                    throw new IllegalArgumentException("Número da conta deve ter 4 dígitos.");
                }
                sc.nextLine(); // Limpa o buffer do scanner
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: " + e.getMessage());
                sc.nextLine(); // Limpa o buffer para evitar loop infinito
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        inputValido = false;
        // Entrada do nome completo
        while (!inputValido) {
            try {
                System.out.println("Digite o seu nome completo a seguir: [Nome e Sobrenome]");
                nome = sc.nextLine();
                if (nome.trim().isEmpty()) {
                    throw new IllegalArgumentException("Nome completo não pode ser vazio.");
                }
                inputValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        inputValido = false;
        // Entrada do saldo
        while (!inputValido) {
            try {
                System.out.println("Digite o saldo da conta a seguir: [com o digito xxx.x]");
                if (!sc.hasNextDouble()) {
                    throw new InputMismatchException("Saldo deve ser um número decimal.");
                }
                saldo = sc.nextDouble();
                if (saldo < 0) {
                    throw new IllegalArgumentException("Saldo não pode ser negativo.");
                }
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Erro: " + e.getMessage());
                sc.nextLine(); // Limpa o buffer para evitar loop infinito
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }

        sc.close();
        // Exibição dos dados finais
        System.out.println("\nDados da Conta:");
        System.out.println("Número da Agência: " + agencia);
        System.out.println("Número da Conta: " + numero);
        System.out.println("Nome Completo: " + nome);
        System.out.println("Saldo: " + saldo);
    }
}

