package lesson4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameField {
    private final List<List<CellStatus>> field;

    public GameField(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    String.format("Парметры поля должны быть положительными," +
                            " в то время как (%d, %d) были предоставлены", width, height));
        }

        field = new ArrayList<>(height);

        for (int i = 0; i < height; ++i) {
            field.add(new ArrayList<>(Collections.nCopies(width, CellStatus.EMPTY)));
        }
    }

    public void setCell(int x, int y, CellStatus status) {
        try {
            field.get(y).set(x, status);
        } catch (IndexOutOfBoundsException exception) {
            throw createBadCoordinatedException(x, y, exception);
        }
    }

    public CellStatus getCell(int x, int y) {
        try {
            return field.get(y).get(x);
        } catch (IndexOutOfBoundsException exception) {
            throw createBadCoordinatedException(x, y, exception);
        }
    }

    public int getWidth() {
        return field.get(0).size();
    }

    public int getHeight() {
        return field.size();
    }

    public List<CellStatus> getRow(int index) {
        return field.get(index);
    }

    public List<CellStatus> getColumn(int index) {
        List<CellStatus> column = new ArrayList<>(getHeight());

        for (int i = 0; i < getHeight(); ++i) {
            column.add(getCell(index, i));
        }

        return column;
    }

    // main diagonal has constant difference of coordinates y - x = index
    public List<CellStatus> getMainDiagonal(int index) {
        List<CellStatus> diagonal = new ArrayList<>();

        int x = 0;
        int y = 0;

        if (index > 0) {
            y = index;
        } else {
            x = -index;
        }

        while (x < getWidth() && y < getHeight()) {
            diagonal.add(getCell(x, y));
            x++;
            y++;
        }

        return diagonal;
    }

    public Range getMainDiagonalIndexRange() {
        return new Range(-getWidth(), getHeight());
    }

    // secondary diagonal has constant sum of coordinates x + y = index
    public List<CellStatus> getSecondaryDiagonal(int index) {
        List<CellStatus> diagonal = new ArrayList<>();

        int x = 0;
        int y = getHeight() - 1;

        if (index > getHeight() - 1) {
            x = index - getHeight() + 1;
        } else {
            y = index;
        }

        while (x < getWidth() && y >= 0) {
            diagonal.add(getCell(x, y));
            x++;
            y--;
        }

        return diagonal;
    }

    public Range getSecondaryDiagonalIndexRange() {
        return new Range(0, getWidth() + getHeight());
    }

    public boolean hasEmptyCell() {
        for (int x = 0; x < getWidth(); ++x) {
            for (int y = 0; y < getHeight(); ++y) {
                if (getCell(x, y) == CellStatus.EMPTY) {
                    return true;
                }
            }
        }

        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("♥");

        for (int i = 0; i < getWidth(); ++i) {
            sb.append(" ").append(i + 1);
        }
        sb.append("\n");

        for (int i = 0; i < getHeight(); ++i) {
            sb.append(i + 1);
            for (int j = 0; j < getWidth(); ++j) {
                sb.append(" ");
                switch (field.get(i).get(j)) {
                    case EMPTY -> sb.append("∙");
                    case NOUGHT -> sb.append("O");
                    case CROSS -> sb.append("X");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    private IllegalArgumentException createBadCoordinatedException(
            int x,
            int y,
            IndexOutOfBoundsException exception) {
        return new IllegalArgumentException(
                String.format(
                        "Запрос за пределами поля, координаты требуемой ячейки (%d, %d)," +
                                " в то время как размер поля (%d, %d)",
                        x + 1, y + 1, getWidth(), getHeight()),
                exception);
    }

    public enum CellStatus {
        EMPTY,
        NOUGHT,
        CROSS
    }

    public record Range(int from, int to) {
    }
}
