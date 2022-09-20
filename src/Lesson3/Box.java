package Lesson3;

public class Box <F extends Fruit>{

   private F weightFruit;
    private  double amount;
    private  double weightBox;


    public Box(F weightFruit, double amount) {
        this.weightFruit = weightFruit;
        this.amount = amount;
    }

    public F getWeightFruit() {
        return weightFruit;
    }

    public double getAmount() {
        return amount;
    }

    public void setWeightFruit(F weightFruit) {
        this.weightFruit = weightFruit;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void info(){
        System.out.println(getWeightFruit()+" "+getAmount());
    }

    public double appFruit(double amountFruit){
        this.amount += amountFruit;
        return this.amount;
    }

        public void infoAmount (){
            System.out.println("["+amount+"]");
    }

    public double getWeightBox() {
        this.weightBox =0;
        F f = getWeightFruit();
        if (f!=null) {
            Double dou = f.getWeight();
            this.weightBox = amount * dou;
        }
        return weightBox;
    }
    public void infoWeight (){
        System.out.println("Weight box" +"["+weightBox+"]");
    }

public boolean compare(Box<? extends Fruit> anotherBox) {
        if (getWeightBox() == anotherBox.getWeightBox()) {
            return true;
        }
        return false;
    }


public void putFruitInBox(Box <? extends Fruit> emptyBox){
    this.weightFruit=(F) emptyBox.getWeightFruit();
    emptyBox.setWeightFruit(null);

      this.amount = 0;
      Double a = emptyBox.getAmount();
      this.amount=a;
      emptyBox.setAmount(0.0);
    }

}
