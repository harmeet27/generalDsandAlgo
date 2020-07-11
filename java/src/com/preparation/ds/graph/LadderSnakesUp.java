package com.preparation.ds.graph;

import java.io.IOException;
import java.util.*;

public class LadderSnakesUp {
    // Complete the quickestWayUp function below.
    static class PositionData {
        int moves;
        int pos;
        int prevPos;

        PositionData(int moves, int pos, int prevPos) {
            this.moves = moves;
            this.pos = pos;
            this.prevPos = prevPos;
        }
    }

    static int quickestWayUp(int[][] ladders, int[][] snakes) {
        TreeMap<Integer, Integer> ladderMap = new TreeMap<>();
        TreeMap<Integer, Integer> snakesMap = new TreeMap<>();
        for (int i = 0; i < ladders.length; i++) {
            ladderMap.put(ladders[i][0], ladders[i][1]);
        }
        for(int j=0;j<snakes.length;j++){
            snakesMap.put(snakes[j][0], snakes[j][1]);
        }
        int minMoves = 100;
        Queue<PositionData> queue = new LinkedList();
        queue.add(new PositionData(0, 1, 0));
        HashMap<String, Boolean> visited = new HashMap<>();
        while (!queue.isEmpty()) {
            PositionData posData = queue.poll();
            if (!visited.containsKey(posData.prevPos + "-" + posData.pos)) {
                visited.put(posData.prevPos + "-" + posData.pos, true);
                List<PositionData> possible = findPossibleLadders(posData.moves, posData.pos, ladders, snakes);
                if (possible.size() > 0) {
                    queue.addAll(possible);
                } else {
                    //take consideration of all snakes from this pos till 100 or atleast some snakes
                    int totalMoves = findPossibleMovesTillEnd(posData.moves, posData.pos, snakesMap);
                    if(totalMoves==100000){
                        minMoves = totalMoves;
                        break;
                    }
                    if (minMoves > totalMoves) {
                        minMoves = totalMoves;
                    }
                }
            }
        }

        if (minMoves == 100000) {
            return -1;
        }
        return minMoves;

    }

    private static int findPossibleMovesTillEnd(int currentMoves, int currentpos, TreeMap<Integer, Integer> snakes) {
        int extraMoves = 100 - currentpos;

        int moves = 0;
        if (snakes.higherEntry(currentpos) == null) {
            moves = extraMoves % 6 == 0 ? extraMoves / 6 : (extraMoves / 6) + 1;
        } else {
            int pos = currentpos;
            while (pos <= 100) {
                if (snakes.containsKey(pos + 1) && snakes.containsKey(pos + 2) && snakes.containsKey(pos + 3) &&
                        snakes.containsKey(pos + 4) && snakes.containsKey(pos + 5) && snakes.containsKey(pos + 6)) {
                    moves = 100000;
                    break;
                }else{
                    if(!snakes.containsKey(pos + 6)){
                        pos=pos+6;
                        moves=moves+1;
                    }
                    else  if(!snakes.containsKey(pos + 5)){
                        pos=pos+5;
                        moves=moves+1;
                    }
                    else  if(!snakes.containsKey(pos + 4)){
                        pos=pos+4;
                        moves=moves+1;
                    }
                    else  if(!snakes.containsKey(pos + 3)){
                        pos=pos+3;
                        moves=moves+1;
                    }
                    else  if(!snakes.containsKey(pos + 2)){
                        pos=pos+2;
                        moves=moves+1;
                    }
                    else  if(!snakes.containsKey(pos + 1)){
                        pos=pos+1;
                        moves=moves+1;
                    }
                }
            }
        }

        int totalMoves = moves == 100000 ? moves : moves + currentMoves;
        return totalMoves;
    }

    private static LinkedList<PositionData> findPossibleLadders(int currentMoves, int currentPos, int[][] ladder, int[][] snakes) {
        //apply binary search here
        LinkedList<PositionData> possibleLadders = new LinkedList();
        for (int i = 0; i < ladder.length; i++) {
            PositionData possibleMove = null;
            if (ladder[i][0] >= currentPos) {
                int diff = ladder[i][0] - currentPos;
                int moves = currentMoves + (diff % 6 == 0 ? diff / 6 : (diff / 6) + 1);
                possibleMove = new PositionData(moves, ladder[i][1], currentPos);
                possibleLadders.add(possibleMove);
                for (int j = 0; j < snakes.length; j++) {
                    if (snakes[j][0] >= possibleMove.pos) {
                        int snkaesDiff = snakes[j][0] - possibleMove.pos;
                        int snkaesMove = possibleMove.moves + (snkaesDiff % 6 == 0 ? snkaesDiff / 6 : (snkaesDiff / 6) + 1);
                        possibleLadders.add(new PositionData(snkaesMove, snakes[j][1], possibleMove.pos));
                    }
                }
            }
        }


        return possibleLadders;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] ladders = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] laddersRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int laddersItem = Integer.parseInt(laddersRowItems[j]);
                    ladders[i][j] = laddersItem;
                }
            }

            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] snakes = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] snakesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int snakesItem = Integer.parseInt(snakesRowItems[j]);
                    snakes[i][j] = snakesItem;
                }
            }

            int result = quickestWayUp(ladders, snakes);

            System.out.println(String.valueOf(result));
            System.out.println();
        }
        scanner.close();
    }
}
