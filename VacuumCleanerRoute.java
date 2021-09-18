public class VacuumCleanerRoute {

    public boolean returnToOrigin(String route) {
        char[] routeArray = route.toCharArray();

        int right = 0;
        int up = 0;
        for(int i=0; i<routeArray.length; i++) {
            if(routeArray[i] == 'R') right++;
            if(routeArray[i] == 'L') right--;
            if(routeArray[i] == 'U') up++;
            if(routeArray[i] == 'D') up--;
        }
        return up == 0 && right == 0;
    }

    public void run() {
        String route = "RUULLDRD";
        System.out.println(returnToOrigin(route));
    }
    public static void main(String[] args) {
        new VacuumCleanerRoute().run();
    }
}
