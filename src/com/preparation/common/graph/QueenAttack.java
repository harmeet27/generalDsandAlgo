package com.preparation.common.graph;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class QueenAttack {
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        HashMap<String, Boolean> moves = new HashMap();
        totalMoves(n, r_q - 1, c_q - 1, moves);
        int r1 = r_q - 1;
        int c1 = c_q - 1;
        moves.remove(r1 + "," + c1);
        for (int i = 0; i < obstacles.length; i++) {
            String type = obstacleType(r_q - 1, c_q - 1, obstacles[i][0] - 1, obstacles[i][1] - 1);
            if (type == null) {
                continue;
            }
            removeObstacles(obstacles[i][0] - 1, obstacles[i][1] - 1, n, moves, type);
        }
        printMap(moves);
        return moves.size();
    }

    private static void printMap(HashMap<String, Boolean> moves) {
        Set<Map.Entry<String, Boolean>> val = moves.entrySet();
        for (Map.Entry<String, Boolean> entry : val) {
            System.out.println(entry.getKey());
        }
    }

    private static void removeObstacles(int oi, int oj, int n, HashMap<String, Boolean> moves, String type) {

        if (type.equals("topv")) {
            for (int i = oi; i >= 0; i--) {
                moves.remove(i + "," + oj);
            }
        } else if (type.equals("bottomv")) {
            for (int i = oi; i < n; i++) {
                moves.remove(i + "," + oj);
            }
        } else if (type.equals("righth")) {
            for (int j = oj; j < n; j++) {
                moves.remove(oi + "," + j);
            }
        } else if (type.equals("lefth")) {
            for (int j = oj; j >= 0; j--) {
                moves.remove(oi + "," + j);
            }
        } else if (type.equals("2")) {
            for (int j = oj, i = oi; j >= 0 && i >= 0; j--, i--) {
                moves.remove(i + "," + j);
            }
        } else if (type.equals("1")) {
            for (int j = oj, i = oi; j < n && i >= 0; j++, i--) {
                moves.remove(i + "," + j);
            }
        } else if (type.equals("3")) {
            for (int j = oj, i = oi; j >= 0 && i < n; j--, i++) {
                moves.remove(i + "," + j);
            }
        } else if (type.equals("4")) {
            for (int j = oj, i = oi; j < n && i < n; j++, i++) {
                moves.remove(i + "," + j);
            }
        }
    }

    private static String obstacleType(int qi, int qj, int i, int j) {
        if (j == qj) {
            if (i < qi) {
                return "topv";
            } else {
                return "bottomv";
            }
        } else if (i == qi) {
            if (j < qj) {
                return "lefth";
            } else {
                return "righth";
            }
        } else if (Math.abs(i - qi) == Math.abs(j - qj)) {
            if (i > qi && j > qj) {
                return "4";
            } else if (i < qi && j > qj) {
                return "1";
            } else if (i < qi && j < qj) {
                return "2";
            } else {
                return "3";
            }
        }

        return null;
    }


    private static void totalMoves(int n, int pi, int pj, HashMap<String, Boolean> moves) {
        //vertical
        for (int i = 0; i < n; i++) {
            moves.put(i + "," + pj, true);
        }

        //horizontal
        for (int j = 0; j < n; j++) {
            moves.put(pi + "," + j, true);
        }

        //1st diagonal to and fro
        for (int k = pi, l = pj; k < n && l < n; k++, l++) {
            moves.put(k + "," + l, true);
        }
        for (int k = pi, l = pj; k >= 0 && l >= 0; k--, l--) {
            moves.put(k + "," + l, true);
        }

        //2nd diagonal to and fro
        for (int i = pi, j = pj; i >= 0 && j < n; i--, j++) {
            moves.put(i + "," + j, true);
        }
        for (int i = pi, j = pj; i < n && j >= 0; i++, j--) {
            moves.put(i + "," + j, true);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        System.out.println(String.valueOf(result));
        System.out.println();

        scanner.close();
    }
}
