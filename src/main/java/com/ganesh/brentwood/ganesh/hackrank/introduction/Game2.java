package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.Scanner;

public class Game2 {

    private static boolean canWin2(int index, int leap, int[] game) {



        if ((index + leap == game.length - 1 && game[index + leap] == 0) || index + leap >= game.length)            {
            return true;
        }
        if (index + 1 == game.length - 1 && game[index + 1] == 0) {
            return true;
        }
        if (leap!=0&&index + leap < game.length - 1 && game[index + leap] == 0) {
            if(canWin2(index + leap,leap,game)){
                return true;
            }
        }


        if (index +1 < game.length - 1 && game[index + 1] == 0) {
            if(canWin2(index + 1,leap,game)){
                return true;
            }
        }

        if (index - 1 >= 0 && game[index - 1] == 0) {
            game[index] = 5;
            if(canWin2(index - 1,leap,game)){
                return true;
            }
        }
        return false;

    }

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.


        int i = 0;
        boolean isWon = false;
        if (game.length < 2 && game.length > 100)
            return false;

        if (leap < 0 && game.length > 100)
            return false;

        if (game[0] != 0)
            return false;


        if (canWin2(i, leap, game))
        {
            return true;
        }



        return isWon;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();

        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}
