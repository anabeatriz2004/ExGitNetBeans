/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package estga.poo.exgitnetbeans;

import java.util.Scanner;
/**
 * @author Ana Beatriz Vicente
 * @version 1.1
*/
class Peca {
    int peca = 0;
    int posisao_x;
    int posisao_y;
    Tabuleiro tabuleiro;

    public Peca (int p, Tabuleiro tab) {
        peca = p;
        tabuleiro = tab;
    }
    
    public void PosicaoPeca (int x, int y) {
        posisao_x = x;
        posisao_y = y;
    }
    
    public void MoverPeca (int x, int y) {
        tabuleiro.Posicao_Tabuleiro(this, x, y);
    }
}

class Tabuleiro {
    int tabuleiro[][] = new int[8][8];
    
    public Tabuleiro () {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // casa vazia
                tabuleiro[i][j] = 0;
            }
        }
    }
    
    public void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                // casa vazia
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println();
        }
    }
        
    public boolean Posicao_Tabuleiro(Peca peca, int x, int y) {
        
        // casa vazia
        if (tabuleiro[x][y] == 0) {
            tabuleiro[x][y] = peca.peca;
            tabuleiro[peca.posisao_x][peca.posisao_y] = 0;
            return true;
        // casa ocupada
        } else {
            System.out.println("Erro: Casa já ocupada");
            return false;
        }
    }
}

/**
 *
 * @author ASUS
 */
public class ExGitNetBeans {

    public static void main(String[] args) {
        int op;
        
        Tabuleiro tabuleiro = new Tabuleiro();
        Peca peca1 = new Peca(1, tabuleiro);
        
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("##############################");
            System.out.println("1. Ver tabuleiro");
            System.out.println("2. Escreva as coordenadas");
            System.out.println("3. Sair");
            System.out.println("##############################");
            op = scan.nextInt();
        
            switch (op) {
                case 1: 
                    tabuleiro.print();
                    break;
                case 2: 
                    peca1.PosicaoPeca(7,7);
                    peca1.MoverPeca(5, 5);
                    break;
            } 
        } while (op != 3);
        scan.close();
    }
}
