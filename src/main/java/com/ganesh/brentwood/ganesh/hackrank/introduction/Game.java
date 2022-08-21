package com.ganesh.brentwood.ganesh.hackrank.introduction;

import java.util.*;

public class Game {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        if(game.length<2 && game.length>100)
            return false;
        if(leap<0 && game.length>100)
            return false;

        if(game[0]!=0)
            return false;


        int i = 0;
        boolean isWon = false;
        while (i < game.length) {

            if (leap!=0&& (i + leap == game.length - 1 && game[i + leap] == 0) || i + leap >= game.length) {
                return true;
            }
            if (i + 1 == game.length - 1 && game[i + 1] == 0) {
                return true;
            }

            boolean isAbleMove = false;
            if (leap!=0&&i + leap < game.length - 1 && game[i + leap] == 0) {
                i = i + leap;
                isAbleMove = true;
                continue;
            }
            if (i + 1 < game.length - 1 && game[i + 1] == 0) {
                i++;
                isAbleMove = true;
                continue;
            }
            if (!isAbleMove) {
                if (i - 1 >= 0 && game[i - 1] == 0) {
                    game[i]=5;
                    i--;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        int counter=1;
        while (counter <=q) {

            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println(((canWin(leap, game)) ? "YES" : "NO"));
            counter++;
        }
        scan.close();
    }
}
