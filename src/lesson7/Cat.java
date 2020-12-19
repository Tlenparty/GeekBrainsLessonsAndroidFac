package lesson7;


public class Cat {

    private String name;
    protected int appetite;
    protected boolean isFull; // Сытость


    public Cat(String name, int appetite, boolean isFull) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = isFull;
    }

    public void eat(Plate plate) {
        if(appetite <= plate.food) {
            plate.decreaseFood(appetite);
            System.out.println("Кот " + name + " поел " + "осталось еды в тарелке: " + plate.food);
        }else{
            System.out.println("Кот " + name + " не поел " + "осталось еды в тарелке: " + plate.food);
        }
    }

    public void checkIsCatFull() {
        System.out.println("Сытость кота " + isFull);
        System.out.println();
    }

    public void checkIsPlateFull(Plate plate) {
        if(plate.checkFood(appetite)) {
            System.out.println("Коту " + name + " достаточно еды");
            isFull = true;
        }else{
            System.out.println("Коту " + name + " недостаточно еды");
        }
    }
}
