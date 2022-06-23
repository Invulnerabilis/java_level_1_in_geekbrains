package lesson4;

import java.util.List;

public class Game {
    public enum GameStatus {
        CURRENT_PLAYER_WIN,
        DRAW,
        KEEP_PLAYING
    }

    private final GameField field;

    private final int winningRowLength;

    public Game(int fieldWidth, int fieldHeight, int winningRowLength) {
        field = new GameField(fieldWidth, fieldHeight);
        this.winningRowLength = winningRowLength;
    }

    public GameStatus putCross(int x, int y) {
        checkEmptyCell(x, y);
        field.setCell(x, y, GameField.CellStatus.CROSS);
        return getGameStatus(GameField.CellStatus.CROSS);
    }

    public GameStatus putNought(int x, int y) {
        checkEmptyCell(x, y);
        field.setCell(x, y, GameField.CellStatus.NOUGHT);
        return getGameStatus(GameField.CellStatus.NOUGHT);
    }

    public int getWidth() {
        return field.getWidth();
    }

    public int getHeight() {
        return field.getHeight();
    }

    public String toString() {
        return field.toString();
    }

    private void checkEmptyCell(int x, int y) {
        if (field.getCell(x, y) != GameField.CellStatus.EMPTY) {
            throw new IllegalArgumentException(
                    String.format("Ячейка с координатами (%d, %d) уже занята", x + 1, y + 1));
        }
    }

    public GameStatus getGameStatus(GameField.CellStatus cellStatus) {
        if (isWin(cellStatus)) {
            return GameStatus.CURRENT_PLAYER_WIN;
        } else if (isDraw()) {
            return GameStatus.DRAW;
        }

        return GameStatus.KEEP_PLAYING;
    }

    private boolean isWin(GameField.CellStatus cellStatus) {
        if (cellStatus == GameField.CellStatus.EMPTY) {
            throw new IllegalArgumentException("Проверка на победу для пустых клеток безсмысленна");
        }

        for (int rowIndex = 0; rowIndex < field.getHeight(); ++rowIndex) {
            List<GameField.CellStatus> row = field.getRow(rowIndex);
            if (hasWinningRow(row, cellStatus)) {
                return true;
            }
        }

        for (int columnIndex = 0; columnIndex < field.getWidth(); ++columnIndex) {
            List<GameField.CellStatus> column = field.getColumn(columnIndex);
            if (hasWinningRow(column, cellStatus)) {
                return true;
            }
        }

        GameField.Range mainDiagonalIndexRange = field.getMainDiagonalIndexRange();
        for (int index = mainDiagonalIndexRange.from();
             index <= mainDiagonalIndexRange.to();
             ++index) {
            List<GameField.CellStatus> diagonal = field.getMainDiagonal(index);
            if (hasWinningRow(diagonal, cellStatus)) {
                return true;
            }
        }

        GameField.Range secondaryDiagonalIndexRange = field.getSecondaryDiagonalIndexRange();
        for (int index = secondaryDiagonalIndexRange.from();
             index <= secondaryDiagonalIndexRange.to();
             ++index) {
            List<GameField.CellStatus> diagonal = field.getSecondaryDiagonal(index);
            if (hasWinningRow(diagonal, cellStatus)) {
                return true;
            }
        }

        return false;
    }

    private boolean hasWinningRow(List<GameField.CellStatus> row, GameField.CellStatus cellStatus) {
        for (int i = 0; i < row.size() - winningRowLength + 1; ++i) {
            boolean isWinningRow = true;
            for (int j = i; j < i + winningRowLength; ++j) {
                if (row.get(j) != cellStatus) {
                    isWinningRow = false;
                    break;
                }
            }

            if (isWinningRow) {
                return true;
            }
        }

        return false;
    }

    private boolean isDraw() {
        return !field.hasEmptyCell();
    }
}
