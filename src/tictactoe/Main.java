package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board game = new Board();
        Scanner input = new Scanner(System.in);
        int player = 0,position;
        
        while(game.checkGame()==2) {
            if(player==0) System.out.println("It is time of player 1.");
            else System.out.println("It is time of player 2.");
            position = input.nextInt();
            game.play(player, position);
            if(player==0) player++;
            else player--;
            if(game.checkGame()==1) System.out.println("Sucesso");
        }
    }
}
