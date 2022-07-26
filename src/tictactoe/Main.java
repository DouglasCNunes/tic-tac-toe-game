package tictactoe;

import java.util.Scanner;

public class Main {

    static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    static void printBoard(Board game) {
        System.out.println("");
        for (int i = 0; i < 9; i++) {
            if(game.getPlayer1().contains(i+1)) System.out.print("O");
            else if(game.getPlayer2().contains(i+1)) System.out.print("X");
            else System.out.print(i+1);
            if(i==0 || i==1 || i==3 || i==4|| i==6 || i==7) System.out.print("|");
            else if(i<8) System.out.print("\n-|-|-\n");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Board game = new Board();
        Scanner input = new Scanner(System.in);
        int player = 0,position, playcheck=0;
        
        while(game.checkGame()==2) {
            printBoard(game);
            if(player==0) System.out.println("It is time of player \"O\"");
            else System.out.println("It is time of player \"X\".");
            position = input.nextInt();
            try {
                playcheck = game.play(player, position);
            } catch(IndexOutOfBoundsException e) {
                clearScreen();
                System.out.println("Position is out of index. Please, enter in a number between 1 and 9.");
                //The same player continuoes entering a number util enter a correct value
                continue;
            }
            if(playcheck==-1) {
                clearScreen();
                System.out.println("Position has already been played. Try again.");
                continue;
            }
            if(player==0) player++;
            else player--;
            clearScreen();
        }
        input.close();
        printBoard(game);
        if(game.checkGame()==0) System.out.println("O jogador \"O\" venceu!");
        else if(game.checkGame()==1) System.out.println("O jogador \"X\" venceu!");
        else System.out.println("Empate.");
    }
}
