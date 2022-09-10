package Lesson1;

public class Member {
    private String name;
    private double time;
    private int jump;
    private int pullUp;

    public Member (String name, double time, int jump, int pullUp) {
        this.name = name;
        this.time = time;
        this.jump= jump;
        this.pullUp=pullUp;
    }

    public void infoMember () {
        System.out.println("[" + name + "," + time + "," + jump + "," + pullUp + "]");
    }

    public String getName() {
        return name;
    }

    public double getTime() {
        return time;
    }

    public int getJump() {
        return jump;
    }

    public int getPullUp() {
        return pullUp;
    }
}
