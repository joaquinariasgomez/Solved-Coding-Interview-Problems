public class TowerBreakers {
    public int towerBreakers(int n, int m) {
        if(m==1) {
            return 2;
        }
        if(n%2==0) {
            return 2;
        }
        else {
            return 1;
        }
    }

    public void run() {
        int n = 3, m = 6;
        System.out.println(towerBreakers(n, m));
    }

    public static void main(String[] args) {
        new TowerBreakers().run();
    }
}
