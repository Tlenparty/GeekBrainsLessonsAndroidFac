package lesson7;

import java.sql.SQLOutput;

public class Plate {

    protected int food;

    public Plate(int food) {
        this.food = food;
    }

    public Plate(){

    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Еды в тарелке: " + food;
    }

    public int decreaseFood(int appetite) {
            return  food -= appetite;
    }

    public boolean checkFood(int appetite) {
        return appetite <= food;
    }

    public void addFood(int food) {
        if(this.food >= 0) {
            this.food = food;
        }else
            System.err.println("Количество еды в миске должно быть положительным");
        }
}
