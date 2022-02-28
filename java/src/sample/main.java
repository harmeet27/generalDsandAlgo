package sample;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

public class main {


}

class SnakeGame {

    private String GAME_OVER = "Game over";
    private int height;
    private int width;
    private Deque<Position> snakePositions;
    private Set<Position> existingPosSet;
    private int moves = 0;

    public SnakeGame(int height, int width, int initialLength) {
        this.height = height;
        this.width = width;
        this.snakePositions = new LinkedList<>();
        this.existingPosSet = new HashSet<>();
        for (int i = 0; i < initialLength; i++) {
            intializeSnake(0, i);
        }
    }

    public void move(Direction direction) {

        Position possiblePosition = getPossiblePosition(direction);
        if (possiblePosition.x == -1 || possiblePosition.x >= height || possiblePosition.y == -1 || possiblePosition.y >= width) {
            throw new RuntimeException(GAME_OVER);
        }

        if (existingPosSet.contains(possiblePosition)) {
            throw new RuntimeException(GAME_OVER);
        }
        move(possiblePosition);
    }


    private void intializeSnake(int x, int y) {
        Position position = new Position(x, y);
        this.snakePositions.add(position);
        this.existingPosSet.add(position);
    }

    private void move(Position position) {
        if (moves + 1 == 5) {
            //growing
            moves = 0;
        } else {
            Position tail = snakePositions.getFirst();
            existingPosSet.remove(tail);
            snakePositions.remove();
            moves++;
        }
        snakePositions.add(position);
        existingPosSet.add(position);

    }

    private Position getPossiblePosition(Direction direction) {
        Position possiblePosition = snakePositions.getLast();

        if (direction == Direction.U) {
            possiblePosition.x = possiblePosition.x - 1;
        } else if (direction == Direction.D) {
            possiblePosition.x = possiblePosition.x + 1;
        } else if (direction == Direction.L) {
            possiblePosition.y = possiblePosition.y - 1;
        } else if (direction == Direction.R) {
            possiblePosition.y = possiblePosition.y - 1;
        }
        return possiblePosition;
    }

}

enum Direction {
    U, D, L, R;
}

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object other) {
        Position otherPosition = (Position) other;
        if (otherPosition.x == this.x && otherPosition.y == this.y) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }
}

/***
 *
 * Design a code of snake,
 *
 * Game of snake
 * 1. hits the wall, bite itself die.
 * 2. Board 20*20 matrix.
 * 3. Snake of length =5 initially, and it is there in first row , looking towards right.
 * 4. you don't need to eat point.
 *      just avoid biting itself and hitting the wall.
 *
 * 5. After each 5 move(cell in any direction), snake length increase by 1 cell.
 *
 * Handle the user to play this game.
 * move(direction);
 *
 * Assumptions:
 * 1. No suggestions are needed, just need to capture whatver move is selected by the user.
 * 2. Fixed board of 20*20;
 * 3.   tail will remain same, and head will increase when(inc of 1 cell)
 *      else normally tail will move by 1 along with head.
 *
 * snakePositions : [] : search heavy sort of data structure.
 *                     : growing dynamically(insertions/deleteions from the start and end)
 *
 * isGameOver() --> 1. position on the basis of direction, hieght and width
 *                  2. biting itself
 *
 * sample.Position : int x;
 *            int y;
 *
 *
 */



/**

 ***/