package lesson5;

public class lesson5 {

    public static void main(String[] args) {

        Employed employed1 = new Employed("Богдан","Артемович", "Крайслер", 25, "программист",
                "bogdangang@mail.ru","+7-921-854-78-97",5000);

       // employed1.printInfo();
        // Задание 5

        Employed [] empArray = new Employed[5];
        empArray[0] = new Employed("Олег","Николаевич", "Вазик", 22, "летчик","vazikgazik@mail.ru",  "+7-921-784-54-78",4000);
        empArray[1] = new Employed("Иван","Петрович", "Нитуп", 88, "секретарь","mutiputi@mail.ru",  "+7-911-345-11-78",5000);
        empArray[2] = new Employed("Петр","Сафронович", "Ров", 14, "блогер","bugjetstill@mail.ru",  "+7-904-321-55-78",1000);
        empArray[3] = new Employed("Инга","Львовна", "Карась", 78, "безработный","kekpek@mail.ru",  "+7-999-417-87-97",2000);
        empArray[4] = new Employed("Ольга","Ахмедова", "Путана", 32, "директор","duklike@mail.ru",  "+7-906-12-32-22",102);

        // Задание 6

        for (Employed employed : empArray) {
            if(employed.age > 40){
                employed.printInfo();
            }
        }
    }
}
