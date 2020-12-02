package lesson3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class lesson3 {
/**1. Написать программу, которая загадывает случайное число от 0 до 9, и пользователю дается 3 попытки угадать это число.
При каждой попытке компьютер должен сообщить больше ли указанное пользователем число чем загаданное, или меньше.
После победы или проигрыша выводится запрос – «Повторить игру еще раз? 1 – да / 0 – нет»(1 – повторить, 0 – нет).
    2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
      "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
       "pear", "pepper", "pineapple", "pumpkin", "potato"};
  При запуске программы компьютер загадывает слово, запрашивает ответ у пользователя,
   сравнивает его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
   компьютер показывает буквы которые стоят на своих местах
    apple – загаданное
    apricot - ответ игрока
    ap############# (15 символов, чтобы пользователь не мог узнать длину слова)
    Для сравнения двух слов посимвольно, можно пользоваться:
    String str = "apple";
    str.charAt(0); - метод, вернет char, который стоит в слове str на первой позиции
    Играем до тех пор, пока игрок не отгадает слово
    Используем только маленькие буквы
 ПОДСКАЗКА РАБОТЫ CHARAT
 public class Test {

 public static void main(String args[]) {
 String s = "Я буду хорошим программистом!";
 char result1 = s.charAt(8);
 char result2 = s.charAt(11);
 System.out.println("Восьмой символ строки - " + result1);
 System.out.println("Одиннадцатый символ строки - " + result2);
 }
 }
 Получим следующий результат:

 Восьмой символ строки - о
 Одиннадцатый символ строки - ш
 */

    // Задание 1

    public static void guessTheNumber() throws IOException  {
        Random random = new Random();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            int counter = 0;
            int guess = -1;
            int randomNumber = random.nextInt(10);
            while (counter < 3 && guess != randomNumber) {
                System.out.println("Введите число от 0 до 9");
                try {
                    guess = Integer.parseInt(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (guess != randomNumber) {
                    System.out.println("Ваше число " + (guess < randomNumber ? "меньше" : "больше"));
                    counter++;
                }
            }
            System.out.println("Вы " + ((guess == randomNumber) ? "Победили!" : "Проиграли овтет был " + randomNumber));
            System.out.println("Хотите сыграть еще? 1 - да / 2 - нет");
        } while ((Integer.parseInt(reader.readLine())) == 1);
        reader.close();
    }

    // Задание 2

    public static void  guessTheWord (){

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int indWord = random.nextInt(words.length - 1);
        String word = words[indWord];
        int lenWord = word.length();
        System.out.println("Я загадал слово, попробуй отгадать его");
        System.out.println(word);

        Scanner scanner = new Scanner(System.in);
        do {
            //спрашиваем ответ
            System.out.println("Введи свой ответ: (для выхода из игры, просто нажмите Enter)");
            String answer = scanner.nextLine();
            //если нам надоест играть то мы выйдем
            if (answer.equals(""))
                break;
            else if (word.equals(answer)) {
                System.out.println("Вы угадали слово, игра закончена!!!");
                break;
            }
            //так как наш игрок не угадал то будем готовить для него подсказку
            char[] charsAnswer = answer.toCharArray();
            for (int i = 0; i < lenWord; i++) {
                if (i >= charsAnswer.length)
                    break;
                if (word.charAt(i) != charsAnswer[i]) charsAnswer[i] = '#';  // Сравниваем и присваиваем #
            }
            StringBuilder comment = new StringBuilder(String.valueOf(charsAnswer));
            for (int i = comment.length(); i < 15; i++) comment.append("#");
            System.out.println(comment);
        }
        while (true);
    }

    /*
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        int indWord = random.nextInt(words.length - 1);
        String word = words[indWord]; // Загадалли рандомное слово в массиве  (1)
        int lenWord = word.length(); // Длина слова=. Пусть будет
        System.out.println("Я загадал слово, попробуй отгадать его");
        System.out.println(word); // Подсказка ! Не забудь убрать ее))


        do{
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine(); // Вводим ответ (2)
            if (answer.equals(""))
                break;
            else if (word.equals(answer)) {   // Если загаданное слово = ответу победа (3)
                System.out.println("Вы угадали слово, игра закончена!!!");
                break;
            }
                char [] charAnswer = answer.toCharArray(); // Массив символов нашего слова (4)
                for (int i = 0; i < lenWord; i++) {
                    if (i >= charAnswer.length)
                        break;
                    if(charAnswer[i] != word.charAt(i))
                        charAnswer[i] = '#';
                        System.out.println(charAnswer);
                    }
        }while(true);

*/


    public static void main(String[] args)  throws IOException {
        guessTheNumber();
        guessTheWord();

    }
}

