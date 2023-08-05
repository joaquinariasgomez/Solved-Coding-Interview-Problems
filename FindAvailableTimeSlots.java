import java.util.*;

public class FindAvailableTimeSlots {

    public List<String[]> getSol(List<String[]> occupied1, List<String> timeInterval1,
            List<String[]> occupied2, List<String> timeInterval2, int timeBox) {
        List<String[]> sol = new ArrayList<>();
        int pointer1 = 0;
        int pointer2 = 0;
        List<String[]> combOccupied = new ArrayList<>();
        while (pointer1 < occupied1.size() || pointer2 < occupied2.size()) {
            if (pointer1 < occupied1.size() && pointer2 < occupied2.size()) {
                if (isLess(occupied1.get(pointer1)[0], occupied2.get(pointer2)[0])) {
                    combOccupied.add(occupied1.get(pointer1));
                    pointer1++;
                } else {
                    combOccupied.add(occupied2.get(pointer2));
                    pointer2++;
                }
            } else {
                if (pointer1 < occupied1.size()) {
                    combOccupied.add(occupied1.get(pointer1));
                    pointer1++;
                } else {
                    combOccupied.add(occupied2.get(pointer2));
                    pointer2++;
                }
            }
        }

        for(String[] times : combOccupied) {
            System.out.println(times[0]+" to "+times[1]);
        }
        // Merge occupied slots
        List<String[]> combOccupiedMerged = new ArrayList<>();
        combOccupiedMerged.add(combOccupied.get(0));
        for(int i=1; i<combOccupied.size(); i++) {
            //Check if they overlap
            if(isLess(combOccupied.get(i)[0], combOccupied.get(i-1)[1])) {
                combOccupiedMerged.get(combOccupiedMerged.size()-1)[1] = combOccupied.get(i)[1];
            }
            else {
                combOccupiedMerged.add(combOccupied.get(i));
            }
        }
        System.out.println("------------");
        for(String[] times : combOccupiedMerged) {
            System.out.println(times[0]+" to "+times[1]);
        }
        System.out.println("------------");
        String[] firstInterval = new String[]{timeInterval1.get(0), combOccupiedMerged.get(0)[0]};

        return sol;
    }

    public boolean isLess(String time1, String time2) {
        // Return true is time1 is less than time2
        int hour1 = Integer.parseInt(time1.split(":")[0]);
        int mins1 = Integer.parseInt(time1.split(":")[1]);
        int hour2 = Integer.parseInt(time2.split(":")[0]);
        int mins2 = Integer.parseInt(time2.split(":")[1]);
        if (hour1 < hour2) {
            return true;
        } else {
            if (hour1 > hour2) {
                return false;
            } else {
                return mins1 < mins2;
            }
        }
    }

    /*
     *---*  *---*                *---*
        *----*    *--* *---* *---*
     */

    public void run() {
        List<String[]> occupied1 = Arrays.asList(new String[]{"9:00", "10:30"},
                                                new String[]{"12:00", "13:00"},
                                                new String[]{"16:00", "18:00"});
        List<String> timeInterval1 = Arrays.asList("9:00", "20:00");
        List<String[]> occupied2 = Arrays.asList(new String[]{"10:00", "11:30"},
                                                new String[]{"12:30", "14:30"},
                                                new String[]{"14:30", "15:00"},
                                                new String[]{"16:00", "17:00"});
        List<String> timeInterval2 = Arrays.asList("10:00", "18:30");
        int timeBox = 30;
        List<String[]> sol = getSol(occupied1, timeInterval1, occupied2, timeInterval2, timeBox);
    }

    public static void main(String[] args) {
        new FindAvailableTimeSlots().run();
    }
}