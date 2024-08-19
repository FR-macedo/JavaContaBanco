import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String agencia = null;
        int numero = 0;
        String nome = null;
        double saldo = 0.0;

        try {
            // Entrada do número da agência
            System.out.println("Digite o número da agência a seguir: [com o digito xxx-x]");
            agencia = sc.nextLine();
            if (!agencia.matches("\\d{3}-\\d")) {
                throw new IllegalArgumentException("Número da agência deve estar no formato xxx-x.");
            }

            // Entrada do número da conta
            System.out.println("Digite o número da conta a seguir: [com os 4 digitos xxxx]");
            numero = sc.nextInt();
            if (numero < 1000 || numero > 9999) {
                throw new IllegalArgumentException("Número da conta deve ter 4 dígitos.");
            }
            sc.nextLine(); // Limpa o buffer do scanner

            // Entrada do nome completo
            System.out.println("Digite o seu nome completo a seguir: [Nome e Sobrenome]");
            nome = sc.nextLine();
            if (nome.trim().isEmpty()) {
                throw new IllegalArgumentException("Nome completo não pode ser vazio.");
            }

            // Entrada do saldo
            System.out.println("Digite o saldo da conta a seguir: [com o digito xxx.x]");
            saldo = sc.nextDouble();
            if (saldo < 0) {
                throw new IllegalArgumentException("Saldo não pode ser negativo.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Erro: Entrada inválida. Verifique o formato dos dados inseridos.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            sc.close();
            // Exibição dos dados finais
            System.out.println("\nDados da Conta:");
            System.out.println("Número da Agência: " + agencia);
            System.out.println("Número da Conta: " + numero);
            System.out.println("Nome Completo: " + nome);
            System.out.println("Saldo: " + saldo);
        }
    }
}
