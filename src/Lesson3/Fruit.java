package Lesson3;

public abstract class Fruit {
    private  double weightFruit;

    public Fruit(double weight) {
        this.weightFruit = weight;

    }

    public double getWeight() {
        return weightFruit;
    }

    public void setWeightFruit(double weightFruit) {
        this.weightFruit = weightFruit;
    }
}
