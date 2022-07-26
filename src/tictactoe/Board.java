package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private List<Integer> player1;
    private List<Integer> player2;
    private static Integer[][] combination = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9}};

    public Board() {
        player1 = new ArrayList<>();
        player2 = new ArrayList<>();
    }

    private boolean checkWin(List<Integer> player) {
        for (int i = 0; i < combination.length; i++) {
            if(player.containsAll(Arrays.asList(combination[i]))) return true;
        }
        return false;
    }

    public int play(int player, int position) {
        //Player1 = zero, Player 2 = positive number
        if(player1.contains(position) || player2.contains(position)) return -1; //Position has already been played
        if(player == 0) player1.add(position);
        else player2.add(position);
        return 1; //Play was performed;
    }

    public int checkGame() {
        //Win Player1 = 0, Win PLayer2 = 1, In game = 3, Drawn = 2
        if(checkWin(player1)==true) return 0;
        if(checkWin(player2)==true) return 1;
        if((player1.size()+player2.size()==9)) return 3;
        return 2;
    }

}
