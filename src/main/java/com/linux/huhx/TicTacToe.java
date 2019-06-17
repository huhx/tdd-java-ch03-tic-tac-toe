package com.linux.huhx;

public class TicTacToe {

  private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
  private char lastPlayer = '\0';

  public String play(int x, int y) {
    checkAxis(x);
    checkAxis(y);
    lastPlayer = nextPlayer();
    setBox(x, y, lastPlayer);
    for (int index = 0; index < 3; index++) {
      if (board[0][index] == lastPlayer &&
          board[1][index] == lastPlayer &&
          board[2][index] == lastPlayer) {
        return lastPlayer + " is the winner";
      }
    }
    return "No winner";
  }

  private void setBox(int x, int y, char lastPlayer) {
    if (board[x - 1][y - 1] != '\0') {
      throw new RuntimeException("Box is occupied");
    } else {
      board[x - 1][y - 1] = lastPlayer;
    }
  }

  private void checkAxis(int x) {
    if (x < 1 || x > 3) {
      throw new RuntimeException("X is outside board");
    }
  }

  public char nextPlayer() {
    if (lastPlayer == 'X') {
      return 'O';
    }
    return 'X';
  }
}
