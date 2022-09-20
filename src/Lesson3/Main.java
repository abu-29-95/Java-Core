package Lesson3;


public class Main {
    public static void main(String[] args) {
        Fruit app = new Apple(1.5);
        Fruit ora = new Orange(2.0);

        Box <Apple> appleBox = new Box<>(new Apple(app.getWeight()),6);
        Box <Apple> appleBox1 = new Box<>(new Apple(app.getWeight()), 4);
        Box <Orange> orangeBox=  new Box<>( new Orange(ora.getWeight()), 6);
        Box <Orange> orangeBox1=  new Box<> (null,0);

        appleBox.getWeightBox();
        appleBox.infoWeight();

        orangeBox.getWeightBox();
        orangeBox.infoWeight();

        appleBox1.getWeightBox();
        appleBox1.infoWeight();



        System.out.println(appleBox.compare(orangeBox));
        System.out.println(orangeBox.compare(orangeBox1));
        orangeBox.info();


        orangeBox1.putFruitInBox(orangeBox);


        orangeBox.info();
        orangeBox1.info();





    }

}
