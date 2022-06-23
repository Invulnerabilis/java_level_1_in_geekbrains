package lesson8.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CalculatorModel {
    public enum Symbol {
        zero,
        one,
        two,
        three,
        four,
        five,
        six,
        seven,
        eight,
        nine,

        plus,
        minus,
        multiply,
        divide,

        dot,
        unary_minus,
    }

    private static boolean isDigit(Symbol symbol) {
        return symbol == Symbol.zero ||
                symbol == Symbol.one ||
                symbol == Symbol.two ||
                symbol == Symbol.three ||
                symbol == Symbol.four ||
                symbol == Symbol.five ||
                symbol == Symbol.six ||
                symbol == Symbol.seven ||
                symbol == Symbol.eight ||
                symbol == Symbol.nine;
    }

    private static boolean isOperation(Symbol symbol) {
        return symbol == Symbol.plus ||
                symbol == Symbol.minus ||
                symbol == Symbol.multiply ||
                symbol == Symbol.divide;
    }

    private static int toInt(Symbol symbol) {
        return switch (symbol) {
            case zero -> 0;
            case one -> 1;
            case two -> 2;
            case three -> 3;
            case four -> 4;
            case five -> 5;
            case six -> 6;
            case seven -> 7;
            case eight -> 8;
            case nine -> 9;
            default -> throw new IllegalArgumentException();
        };
    }

    private static Symbol fromInt(int number) {
        return switch (number) {
            case 0 -> Symbol.zero;
            case 1 -> Symbol.one;
            case 2 -> Symbol.two;
            case 3 -> Symbol.three;
            case 4 -> Symbol.four;
            case 5 -> Symbol.five;
            case 6 -> Symbol.six;
            case 7 -> Symbol.seven;
            case 8 -> Symbol.eight;
            case 9 -> Symbol.nine;
            default -> throw new IllegalArgumentException();
        };
    }

    public static char toChar(Symbol symbol) {
        return switch (symbol) {
            case zero -> '0';
            case one -> '1';
            case two -> '2';
            case three -> '3';
            case four -> '4';
            case five -> '5';
            case six -> '6';
            case seven -> '7';
            case eight -> '8';
            case nine -> '9';
            case plus -> '+';
            case minus, unary_minus -> '-';
            case multiply -> 'x';
            case divide -> '/';
            case dot -> '.';
        };
    }

    public record OperationData(
            Symbol operation,
            double leftNumber,
            double rightNumber) {
    }

    private final List<Symbol> symbolList;

    public CalculatorModel() {
        symbolList = new ArrayList<>();
    }

    public void addSymbol(Symbol symbol) {
        if (symbol == Symbol.minus) {
            if (symbolList.isEmpty() || isOperation(symbolList.get(symbolList.size() - 1))) {
                symbolList.add(Symbol.unary_minus);
            } else {
                symbolList.add(Symbol.minus);
            }
        } else {
            symbolList.add(symbol);
        }

    }

    public void clear() {
        symbolList.clear();
    }

    public void removeLast() {
        if (!symbolList.isEmpty()) {
            symbolList.remove(symbolList.size() - 1);
        }
    }

    public OperationData getOperationData() {
        if (symbolList.stream().filter(CalculatorModel::isOperation).count() != 1) {
            throw new IllegalStateException("В выражении может быть только один оператор");
        }

        int operationIndex = IntStream.range(0, symbolList.size()).filter(index -> isOperation(symbolList.get(index))).findFirst().getAsInt();
        double leftNumber = readNumber(symbolList, 0);
        Symbol operation = symbolList.get(operationIndex);
        double rightNumber = readNumber(symbolList, operationIndex + 1);

        return new OperationData(operation, leftNumber, rightNumber);
    }

    public void setNumber(double number) {
        clear();

        if (number == 0) {
            addSymbol(Symbol.zero);
            return;
        }

        if (number < 0) {
            addSymbol(Symbol.unary_minus);
            number *= -1;
        }

        long intPart = (long) number;
        double fractionalPart = number - intPart;

        List<Integer> digits = new ArrayList<>();
        while (intPart > 0) {
            digits.add((int) (intPart % 10));
            intPart /= 10;
        }

        for (int index = digits.size() - 1; index >= 0; index--) {
            addSymbol(fromInt(digits.get(index)));
        }

        if (fractionalPart != 0) {
            if (symbolList.isEmpty() || !isDigit(symbolList.get(symbolList.size() - 1))) {
                addSymbol(Symbol.zero);
            }

            addSymbol(Symbol.dot);

            final int roundDigits = 6;
            int fractionalPartInt = (int) (fractionalPart * Math.pow(10, roundDigits));
            while (fractionalPartInt % 10 == 0) {
                fractionalPartInt /= 10;
            }
            digits.clear();
            while (fractionalPartInt > 0) {
                digits.add(fractionalPartInt % 10);
                fractionalPartInt /= 10;
            }

            for (int index = digits.size() - 1; index >= 0; index--) {
                addSymbol(fromInt(digits.get(index)));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Symbol symbol : symbolList) {
            if (isOperation(symbol)) {
                sb.append(' ');
            }

            sb.append(toChar(symbol));

            if (isOperation(symbol)) {
                sb.append(' ');
            }
        }

        return sb.toString();
    }

    private double readNumber(List<Symbol> symbolList, int offset) {
        double result = 0;
        int digitsAfterDot = 0;
        boolean isDotMet = false;
        boolean isNegative = false;

        if (offset >= symbolList.size() ||
                !(symbolList.get(offset) == Symbol.unary_minus ||
                        isDigit(symbolList.get(offset)))) {
            throw new IllegalStateException("Невозможно прочитать число");
        }

        if (symbolList.get(offset) == Symbol.unary_minus) {
            isNegative = true;
            offset++;
        }

        for (int index = offset; index < symbolList.size(); ++index) {
            Symbol symbol = symbolList.get(index);
            if (isDigit(symbol)) {
                result *= 10;
                result += toInt(symbol);

                if (isDotMet) {
                    digitsAfterDot++;
                }
            } else if (symbol == Symbol.dot) {
                if (isDotMet) {
                    throw new IllegalStateException("В числе не могут встречатся две точки");
                }
                isDotMet = true;
            } else {
                break;
            }
        }

        return result / Math.pow(10, digitsAfterDot) * (isNegative ? -1 : 1);
    }
}
