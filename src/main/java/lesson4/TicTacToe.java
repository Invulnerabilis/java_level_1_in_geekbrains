package lesson4;

/*
Java. Уровень 1. Урок 4. Крестики-нолики в процедурном стиле.

1. Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в методичку.
2* (если с 1 все понятно). Переделать проверку победы для столбца и строки, подходящую для любого размера поля или кол-ва победных фишек (подсказка в конце урока).
3** (дополнительно). Доработать пункт 2, добавив проверку любой диагонали (не обязательно исходящих от углов).
*/

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final Scanner input = new Scanner(System.in);

    private static Game createGame() {
        while (true) {
            try {
                System.out.println("Задайте параметры игры:");
                System.out.println("Введите ширину поля: ");
                int width = input.nextInt();
                System.out.println("Введите высоту поля: ");
                int height = input.nextInt();
                System.out.println("Ведите длину выйгрышной комбинации: ");
                int winningRowLength = input.nextInt();
                System.out.println("Игра готова, начинайте!");

                return new Game(width, height, winningRowLength);
            } catch (InputMismatchException exception) {
                System.out.println("Ошибка в веденных данных, программа ожидала на вход число.");
                input.skip(".*");
            }
        }
    }

    private static Game.GameStatus playerMove(Game game) {
        while (true) {
            try {
                System.out.println("Ваш ход: ");
                System.out.println("Введите номер строки: ");
                int y = input.nextInt() - 1;
                System.out.println("Введите номер столбца: ");
                int x = input.nextInt() - 1;
                return game.putCross(x, y);
            } catch (IllegalArgumentException exception) {
                System.out.println("Невозможно произвести ход по данным координатам," +
                        " пожалуйста введите другие.");
                System.out.println("Причина: " + exception.getMessage() + ".");
            } catch (InputMismatchException exception) {
                System.out.println("Ошибка в веденных данных, программа ожидала на вход число.");
                input.skip(".*");
            }
        }
    }

    private static Game.GameStatus aiMove(Game game) {
        Random random = new Random();
        while (true) {
            int x = random.nextInt(game.getWidth());
            int y = random.nextInt(game.getHeight());

            try {
                return game.putNought(x, y);
            } catch (IllegalArgumentException ignored) {
            }
        }
    }

    private static void printGameStatus(Game.GameStatus status, boolean playerWin) {
        switch (status) {
            case KEEP_PLAYING -> throw new IllegalArgumentException(
                    "Вывод на печать статуса \"KEEP_PLAYING\" не имеет смысла");
            case DRAW -> System.out.println("Ничья.");
            case CURRENT_PLAYER_WIN -> System.out.println(
                    playerWin ? "Вы победили!" : "Компьютер победил.");
        }
    }

    public static void main(String[] args) {
        Game game = createGame();
        System.out.println(game);

        while (true) {
            Game.GameStatus gameStatus = playerMove(game);
            if (gameStatus != Game.GameStatus.KEEP_PLAYING) {
                System.out.println(game);
                printGameStatus(gameStatus, true);
                break;
            }

            gameStatus = aiMove(game);
            if (gameStatus != Game.GameStatus.KEEP_PLAYING) {
                System.out.println(game);
                printGameStatus(gameStatus, false);
                break;
            }

            System.out.println(game);
        }
    }
}
