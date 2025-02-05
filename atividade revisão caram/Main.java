import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleciona sua opção:");
        System.out.println("1 - Somar dois números");
        System.out.println("2 - O maior de 2 números");
        System.out.println("3 - Somar N números");
        System.out.println("4 - Contador de pares em sequência");
        System.out.println("0 - Sair");
        int escolha = scanner.nextInt();
        System.out.println("Voce escolheu a opção: " + escolha);


        switch (escolha) {
            case 1:
                opcao1(scanner);
                break;
            case 2:
                opcao2(scanner);
                break;
            case 3:
                opcao3(scanner);
                break;
            case 4:
                opcao4(scanner);
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                break;
        }
        scanner.close();
    }


    public static void opcao1(Scanner scanner){
        System.out.println("Digite o primeiro número: ");
        int num1 = scanner.nextInt();
        System.out.println("Digite o segundo número: ");
        int num2 = scanner.nextInt();
        System.out.println("A soma dos dois números é de: " + (num1 + num2));
    }

    public static void opcao2(Scanner scanner){
        System.out.println("Digite o primeiro número: ");
        int num1 = scanner.nextInt();
        System.out.println("Digite o segundo número: ");
        int num2 = scanner.nextInt();
        scanner.close();
        int maior = Math.max(num1, num2);
        System.out.println("O maior número é: " + maior);
    }

    public static void opcao3(Scanner scanner){
        System.out.println("Digite a quantidade de números que você quer somar: ");
        int quant = scanner.nextInt();
        int soma = 0;
        for(int i = 0; i < quant; i++){
            System.out.println("Digite um número: ");
            int numero = scanner.nextInt();
            soma += numero;
        }
        scanner.close();
        System.out.println("A soma dos números e de: "  + soma);
    }

    public static void opcao4(Scanner scanner){
        System.out.println("Digite a quantidade de números: ");
        int quant = scanner.nextInt();
        int quantPar = 0;
        for(int i = 0; i < quant; i++){
            System.out.println("Digite um número: ");
            int numero = scanner.nextInt();
            if(numero % 2 == 0){
                quantPar++;
            }
        }
        scanner.close();
        System.out.println("A quantidade de números pares e de: " + quantPar);
    }
}