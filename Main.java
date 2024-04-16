import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha o nome do seu Tamagotchi");
        String nome = scanner.nextLine();

        Tamagotchi tamagotchi = new Tamagotchi(nome);

        printarOpcoes();

        int opcao = scanner.nextInt();

        while(opcao != 0) {
            switch(opcao) {
                case 1:
                    System.out.println(tamagotchi.alimentar());
                    break;
                case 2:
                    System.out.println(tamagotchi.brincar());
                    break;
                case 3:
                    System.out.println(tamagotchi.dormir());
                    break;
                case 4:
                    System.out.println(tamagotchi.tomarBanho());
                    break;
                case 5:
                    System.out.println(tamagotchi.toString());
                    break;
            }

            printarOpcoes();
            opcao = scanner.nextInt();
        }

    }

    public static void printarOpcoes() {
        System.out.println("Escolha uma das opcoes abaixo");
        System.out.println("1 - Alimentar");
        System.out.println("2 - Brincar");
        System.out.println("3 - Dormir");
        System.out.println("4 - Tomar banho");
        System.out.println("5 - Checar status");
        System.out.println("0 - Sair");
    }
}