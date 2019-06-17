package com.linux.huhx;

public class TicTacToe {

  private Character[][] board = {{'\0', '\0', '\0'}, {'\0', '\0', '\0'}, {'\0', '\0', '\0'}};
  private char lastPlayer = '\0';

  public void play(int x, int y) {
    checkAxis(x);
    checkAxis(y);
    setBox(x, y);
    lastPlayer = nextPlayer();
  }

  private void setBox(int x, int y) {
    if (board[x - 1][y - 1] != '\0') {
      throw new RuntimeException("Box is occupied");
    } else {
      board[x - 1][y - 1] = 'X';
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
