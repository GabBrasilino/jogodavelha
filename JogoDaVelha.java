import java.util.Scanner;

public class JogoDaVelha {
    private static char[][] tabuleiro = new char[3][3];
    private static char jogadorAtual = 'X';
    private static String jogadorX;
    private static String jogadorO;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        inicializarTabuleiro();

        System.out.print("Digite o nome do jogador X: ");
        jogadorX = scanner.nextLine();
        System.out.print("Digite o nome do jogador O: ");
        jogadorO = scanner.nextLine();

        while (true) {
            exibirTabuleiro();
            System.out.println("Jogador " + getNomeJogadorAtual() + " (" + jogadorAtual + "), faça sua jogada (linha e coluna): ");
            int linha = scanner.nextInt() - 1;
            int coluna = scanner.nextInt() - 1;

            if (fazerJogada(linha, coluna)) {
                if (verificarVencedor()) {  
                    exibirTabuleiro();
                    System.out.println("Jogador " + getNomeJogadorAtual() + " venceu!");
                    break;
                } else if (tabuleiroCheio()) {
                    exibirTabuleiro();
                    System.out.println("O jogo empatou!");
                    break;
                }
                alternarJogador();
            } else {
                System.out.println("Jogada inválida! Tente novamente.");
            }
        }

        scanner.close();
    }

    private static void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '-';
            }
        }
    }

    private static void exibirTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean fazerJogada(int linha, int coluna) {
        if (linha >= 0 && linha < 3 && coluna >= 0 && coluna < 3 && tabuleiro[linha][coluna] == '-') {
            tabuleiro[linha][coluna] = jogadorAtual;
            return true;
        }
        return false;
    }

    private static boolean verificarVencedor() {
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) ||
                (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual)) {
                return true;
            }
        }
        return (tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) ||
               (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual);
    }

    private static boolean tabuleiroCheio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static void alternarJogador() {
        jogadorAtual = (jogadorAtual == 'X') ? 'O' : 'X';
    }

    private static String getNomeJogadorAtual() {
        return (jogadorAtual == 'X') ? jogadorX : jogadorO;
    }
}

