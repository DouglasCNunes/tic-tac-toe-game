package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Integer> player1;
    private List<Integer> player2;
    private static Integer[][] combination = {{1,2,3},{4,5,6},{7,8,9},{1,4,7},{2,5,8},{3,6,9},{1,5,9}};

    public Board() {
        List player1 = new ArrayList<>();
        List player2 = new ArrayList<>();
    }

    private boolean checkPosition(List<Integer> player, int position) {
        for (int i = 0; i < player.size(); i++) {
            if(position == player.get(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkWin(List<Integer> player) {
        for (int i = 0; i < combination.length; i++) {
            int check = 0;
            for (int j = 0; j < 3; j++) {
                if(player.contains(combination[i][j])) {
                    check++;
                }
            }
            if(check==3) return true;
        }
        return false;
    }

    public int play(int player, int position) {
        //Player1 = zero, Player 2 = positive number
        if(checkPosition(player1, position)==false || checkPosition(player2, position)==false) return -1;
        if(player == 0) player1.add(position);
        else player2.add(position);
        return 1;
    }

    public void checkGame() {
        //Win Player1 = 0, Win PLayer2 = 1, In game = 2, Drawn = 3
        if(checkWin(player1)==true) return 0;
        if(checkWin(player2)==true) return 1;
    }

}
