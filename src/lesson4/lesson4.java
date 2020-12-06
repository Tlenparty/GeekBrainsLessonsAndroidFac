package lesson4;

import java.util.Random;
import java.util.Scanner;

public class lesson4 {
    // Вводные данные
    public static final int SIZE = 3;
    public static final int LINE_LIMIT = 10;
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static final char DOT_EMPTY = '•';
    private static final int DOT_TO_WIN = 3;
    public static final char HEADER_FIRST_SYMBOL = '♥';
    public static int testRow;     // переменные, с помощью которой комп проверяет возможный выигрыш
    public  static int testColumn;  // чтобы заблокировать ход или выиграть самому

    static int pointCheckWinRow;
    static int pointCheckWinColumn;

    public static char[][] map = new char[SIZE][SIZE];
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static void main(String[] args) {
        // Инициализация игрового поля
        initMap(); // Инициализация поля

        printMap();

        // Главный игровой цикл
        while (true) {
            // Ход человека
            humanTurn();
            // Обновляем карту
            printMap();
            // Проверка победы
            if (checkWin(DOT_X)) {
                System.out.println("Вы победили");
                break;
            }
            // Проверка остались ли ходы, проверка на ничью
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            // Ход ИИ
            aiTurn();
            // Обновляем карту
            printMap();
            // Проверка победы
            if (checkWin(DOT_O)) {
                System.out.println("Компьютер победил");
                break;
            }
            // Проверка остались ли ходы, проверка на ничью
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        // Игра закончена
        System.out.println("Закончена!");
        scanner.close();
    }

    private static boolean isMapFull() {
        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (map[y][x] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static boolean checkWin(char symbol) {
        // Создадим 2 вложенных цикла и счетчик
        // Считчик будет считать количество одинковых значений
        // Если количество одинаковых значений  = длине массива(ну или 3), то победа
        // Для прохода по строкам
        int counterOne, counterTwo;
        for (int y = 0; y < map.length; y++) {
            counterOne = 0;
            for (int x = 0; x < map.length; x++) {
                if (map[y][x] == symbol) {
                    counterOne++;
                } else if (map[y][x] != symbol) {  // Обнуление счетчика, если предыдущее значение
                    counterOne = 0;
                }
                if (counterOne == DOT_TO_WIN) {
                    return true;
                }
            }
        }
        // Для прохода по столбцам
        for (int x = 0; x < map.length; x++) {
            counterOne = 0;
            for (int y = 0; y < map.length; y++) {
                if (map[y][x] == symbol) {
                    counterOne++;
                } else if (map[y][x] != symbol) {  // Обнуление счетчика, если предыдущее значение symbol
                    counterOne = 0;
                }
                if (counterOne == DOT_TO_WIN) {
                    return true;
                }
            }
        }
        // Для прохода по диагонали
        counterOne = 0;
        counterTwo = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i][i] == symbol) {
                counterOne++;
            } else if (map[i][i] != symbol) {  // Обнуление счетчика, если предыдущее значение не symbol
                counterOne = 0;
            }
            if (map[i][map.length - i - 1] == symbol) {
                counterTwo++;
            } else if (map[i][i] != symbol) {
                counterTwo = 0;
            }
            if (counterOne == DOT_TO_WIN || counterTwo == DOT_TO_WIN) return true;
        }
        return false;
    }

    private static void aiTurn() {
        int x, y;
        System.out.println("\n Ход компьютера");

        if(blockTurn(DOT_O)) {
            y = testRow;
            x = testColumn;
        } else if (blockTurn(DOT_X)) {
            y = testRow;
            x = testColumn;
        }else {
            do {
                x = random.nextInt(SIZE);
                y = random.nextInt(SIZE);
            } while (!isCellValid(x, y));
        }
            pointCheckWinRow = y + 1;
            pointCheckWinColumn = x +1;

             map[y][x] = DOT_O;

            }

    private static void humanTurn() {
        int x = 0;
        int y = 0;
        do {
            System.out.println("Ваш ход");
            if (scanner.hasNextInt()) {
                x = scanner.nextInt() - 1;
            } else {
                scanner.next();
                System.out.println("Введите число!");
                continue;
            }
            if (scanner.hasNextInt()) {
                y = scanner.nextInt() - 1;
            } else {
                scanner.next();
                System.out.println("Введите число!");
            }
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE) return false;
        if (y < 0 || y >= SIZE) return false;
        if (map[y][x] != DOT_EMPTY) { // Проверка на занятость ячейки

            return false;
        }
        return true;
    }

    private static void printMap() {
        // Делаем отступ для удобства 
        for (int i = 0; i < LINE_LIMIT; i++) {
            System.out.println();
        }
        // Верхняя легенда
        System.out.print(HEADER_FIRST_SYMBOL + " ");
        for (int i = 1; i <= SIZE; i++) {

            System.out.print(i + " ");
        }
        System.out.println();
        // Выводим игровое поле точками
        for (int y = 0; y < map.length; y++) { // ось у
            System.out.print((y + 1) + " ");
            for (int x = 0; x < SIZE; x++) {  // ось х
                System.out.print(map[y][x] + " "); // заполняем точками
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void initMap() {
        // Создание пустого поля (поле точек)
        map = new char[SIZE][SIZE];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static boolean blockTurn(char symbol) {

        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                if (isCellValid(x, y)) {
                    map[y][x] = symbol;
                    pointCheckWinRow = y + 1;
                    pointCheckWinColumn = x + 1;
                    if (checkWin(symbol)) {
                        testRow = y;
                        testColumn = x;
                        map[y][x] = DOT_EMPTY;
                        return true;
                    }
                    map[y][x] = DOT_EMPTY;
                }
            }
        }
        return false;
    }
    }
