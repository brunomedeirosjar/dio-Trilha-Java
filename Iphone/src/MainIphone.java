import iml.Iphone;

import java.util.Scanner;

public class MainIphone {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Iphone iphone = new Iphone();
        int opcao;

        do {
            System.out.println("\n===== iPhone =====");
            System.out.println("--- Reprodutor Musical ---");
            System.out.println("1 - Tocar");
            System.out.println("2 - Pausar");
            System.out.println("3 - Selecionar música");
            System.out.println("--- Aparelho Telefônico ---");
            System.out.println("4 - Ligar");
            System.out.println("5 - Atender");
            System.out.println("6 - Iniciar correio de voz");
            System.out.println("--- Navegador de Internet ---");
            System.out.println("7 - Exibir página");
            System.out.println("8 - Adicionar nova aba");
            System.out.println("9 - Atualizar página");
            System.out.println("0 - Sair");
            System.out.print("O que você deseja fazer? ");

            while (!sc.hasNextInt()) {
                System.out.print("Opção inválida, digite um número: ");
                sc.next();
            }
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    iphone.tocar();
                    break;
                case 2:
                    iphone.pausar();
                    break;
                case 3:
                    System.out.print("Digite o nome da música: ");
                    iphone.selecionarMusica(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Digite o número para ligar: ");
                    iphone.ligar(sc.nextLine());
                    break;
                case 5:
                    iphone.atender();
                    break;
                case 6:
                    iphone.iniciarCorreioVoz();
                    break;
                case 7:
                    System.out.print("Digite a URL da página: ");
                    iphone.exibirPagina(sc.nextLine());
                    break;
                case 8:
                    iphone.adicionarNovaAba();
                    break;
                case 9:
                    iphone.atualizarPagina();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}
