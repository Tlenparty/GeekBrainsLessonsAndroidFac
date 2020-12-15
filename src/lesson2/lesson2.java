package lesson2;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;

public class lesson2 {
/*
1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
С помощью цикла и условия заменить 0 на 1, 1 на 0;
2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов)
заполнить его диагональные элементы единицами;
5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
если в массиве есть место, в котором сумма левой и правой части массива равны.
Примеры:  checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
граница показана символами ||, эти символы в массив не входят.
7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными
 массивами.
 */

    // Задание 1

    public static void invertArray() {
        int [] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
           /*if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }*/
            arr[i] = (arr[i] == 0 ) ? 1 : 0; // Решение черезе тернарник
            System.out.print(" " + arr[i]);
        }
    }

    // Задание 2

    public static void fillArray() {
        int [] arr = new int[8];
        for (int i = 0, k = 0; i < arr.length; i++, k += 3) {
            arr[i] = k;
            System.out.print(" " + arr[i]);
        }
    }

    // Задание 3

    public static void changeArray(){
        int [] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < 6){
                arr[i] *= 2;
            }
            System.out.print(" " + arr[i]);
        }
    }

    // Задние 4

    // 0 0 0 0   |  1 0 0 1   arr [0][0] = 1; arr [0][3]
    // 0 0 0 0   |  0 1 1 0   arr [1][1] = 1; arr [1][2]
    // 0 0 0 0   |  0 1 1 0   arr [2][2] = 1; arr [2][1]
    // 0 0 0 0   |  1 0 0 1   arr [3][3] = 1; arr [3][0]
    //           i __________j

    public static void fillDiagonal(){
        int size = 5;                                   // Размер массива
        int [][] arr = new int [size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                arr[i][i] = 1;                  // Диаганаль слева направо
                arr[i][size - i - 1] = 1;       // Диагональ права налево
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }
    }

    // Задание 5

    public static void findMinMax(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        System.out.printf("Минимальное значение: %d%n", min);
        System.out.printf("Максимальное значение: %d",max);
    }

    // Задание 6

    public static boolean checkBalance(int [] arr) {
        int leftSum = 0;
        int rightSum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++)
                leftSum += arr[j];
            for (int j = i; j < arr.length; j++)
                rightSum += arr[j];
            if (leftSum == rightSum) {
                return true;
            } else {
                leftSum = 0;
                rightSum = 0;
            }
        }
        return false;
    }

    // Задание 8

    public static void moveArray(int[] arr, int offset) {
        System.out.println("Количество смещений = " + offset + " Массив до " + Arrays.toString(arr));
        int offsetModule = Math.abs(offset); // Для отрицательных смещений берем значение по модулю
        if (offset == 0 || offsetModule == arr.length) { // Если смещений 0 или они = длине массива то ничего делать не нужно
            System.out.println("Массив после: " + Arrays.toString(arr));
            return;
        }
        if (offset > arr.length)  // Для количества смещений больше, чем длина массива
            offset -= arr.length;
        else if (offsetModule > arr.length)  // Для отрицательных смещений
            offset += arr.length;

        for (int step = 0; step < offsetModule; step++) // Проходим по массиву
            if (offset > 0)
                for (int j = 0; j < arr.length; j++) // Для положительных смещений проходим слева направо
                    swapWithLastElement(arr, j);

            else
                for (int j = arr.length - 1; j >= 0; j--) // Для отрицательных значений проходим справа налево
                    swapWithLastElement(arr, j);
        System.out.println("Массив после " + Arrays.toString(arr));
    }

        private static void swapWithLastElement ( int[] arr, int index){
            int replacementValue = arr[index]; // Создали переменную для записи новых значений массива
            arr[index] = arr[arr.length - 1];  // Для каждого последующего элемента массива присваимваем предыдущее значение
            arr[arr.length - 1] = replacementValue; // Для последнего значения в массиве присваиваем первое значение
        }


    public static void main(String[] args) {
        //  findMinMax(new int[]{1, 2, 3, 10, 26, 5, 1, -1, 0, 2, 1, 27});

        //System.out.println(checkBalance(new int [] {1, 1, 1, 2, 1}));

      //  moveArray(new int [] {0, 1, 2, 3, 4, 5}, -1);

    fillDiagonal();

    }
}
