package lesson6;



public class lesson6 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Барсик");
        Cat cat2 = new Cat("Рик");
        Dog dog1  = new Dog("Бобик");
        Dog dog2  = new Dog("Морти");
        cat1.run(100);
        cat1.swim(1);
        cat2.run(1000);
        dog1.run(200);
        dog1.swim(5);
        dog2.swim(11);
        System.out.println("Всего котиков " + Cat.getCatCount());
        System.out.println("Всего песиков " + Dog.getDogCount());

    }
}
