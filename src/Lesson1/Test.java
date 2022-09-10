package Lesson1;

public class Test {
        private double standartOFRun;
        private int standartOFJump;
        private int standartOFPullUp;

        public Test(double standartOFRun, int standartOFJump, int standartOFPullUp) {
            this.standartOFRun = standartOFRun;
            this.standartOFJump = standartOFJump;
            this.standartOFPullUp = standartOFPullUp;
        }

        public void  doIt(Team team) {
            for (Member member : team.getMembers()) {
                double time = member.getTime();
                int jump = member.getJump();
                int pullUp = member.getPullUp();
                if (standartOFRun >= time && standartOFJump <= jump && standartOFPullUp <= pullUp) {
                    System.out.println(member.getName() + " прошёл");
                }
            }
        }



        public double getStandartOFRun() {
            return standartOFRun;
        }

        public int getStandartOFJump() {
            return standartOFJump;
        }

        public int getStandartOFPullUp() {
            return standartOFPullUp;
        }
}


