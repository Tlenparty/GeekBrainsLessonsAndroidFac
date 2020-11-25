package lesson1;
/*1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
3. Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат,где a, b, c, d – входные параметры
этого метода;
4. Написать метод, принимающий на вход два числа, и проверяющий что их сумма лежит в пределах от 10 до 20(включительно),
если да – вернуть true, в противном случае – false;
5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль положительное
ли число передали, или отрицательное; Замечание: ноль считаем положительным числом.
6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
7. Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вывести в консоль
сообщение «Привет, указанное_имя!»;
8. * Написать метод, который определяет является ли год високосным, и выводит сообщение в консоль. Каждый 4-й год является
високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.*/

public class Main {
    // Задание 2

    public static void variables() {
        byte byteVal = -128; // 8 бит
        short shortVal = 32_767; // 16 бит
        int intVal = 2_147_483_647; // 32 бит
        long longVal = 9_899_887_984_649_84L; // 64 бит
        float floatVal = 32_767.0011f; // 32 бит
        double doubleVal = 3.5458451468541684; // 64 бит
        char charVal = '\u2242'; // 16 бит
        boolean booleanVal = true;
        String stringVal = "I am string";
        System.out.println("Переменная типа byte " + byteVal);
        System.out.println(" Переменная типа short " + shortVal);
        System.out.println("Перменная тпиа int " + intVal);
        System.out.println("Перменная типа long " + longVal);
        System.out.println("Перменная типа float " + floatVal);
        System.out.println("Перменная типа double " + doubleVal);
        System.out.println("Перменная типа char " + charVal);
        System.out.println("Перменная типа boolean " + booleanVal);
        System.out.println("Перменная типа String " + stringVal);
    }

    // Задание 3

    public static double calculation(double a, double b, double c, double d) {
        if (d == 0) {
            System.out.println(" На ноль делить нельзя");
            return 0; // Просто вернем 0
        } else
            return a * (b + (c/d));
    }

    // Задание 4

    public static boolean acceptance (int a, int b ) {
        int result = a+b;
        return (result >= 10) && (result <= 20);
    }

    // Задание 5

    public static void isPositiveOrNegative( int value){
        if(value>=0) {
            System.out.println("Ваше число положителное");
        }else System.out.println("Ваше число отрицательное");
    }

    // Задание 6

    public static boolean isNegative(int value) {
        return value < 0;
    }

    // Задание 7

    public static void greeting(String name){
        System.out.println("Привет " + name);
    }

    // Задание 8

    public static void isLeapYear(int a) {
        if ((a % 400 == 0) || ((a % 4 == 0)) && (a % 100 != 0)) {  // Високосный год это каждый 400 или каждый 4й, но не каждый 100.
            System.out.println("Этот год високосный");
        } else  {
            System.out.println("Этот не год високосный");
        }
    }

    // Задание 1

    public static void main(String[] args) {
                 variables();
        System.out.println(calculation(1,2,3,0));
        System.out.println(acceptance(15,15));

    }
}
