public class PlaneSeatReservation {


    private int maxReservationsPerRow(int row, String S) {
        char[] columns = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K'};
        int nConsecutivePersons = 0;
        int reservations = 0;

        for(int i=0; i<10; ++i) {   //Iterate through columns
            String correspondingReservation = String.valueOf(row+1) + columns[i];
            if(!S.contains(correspondingReservation)) { //Seat is not reserved
                if((i == 3 && nConsecutivePersons != 2) || (i == 7 && nConsecutivePersons != 2)) { // 'D' or 'H'
                    if(nConsecutivePersons > 2) {
                        nConsecutivePersons = 3;    //Divide consecutive persons so that 2 are on left side and also count this seat (2+1)
                    }
                    else {
                        nConsecutivePersons = 1;    //Reset consecutive persons from this seat
                    }
                } else {
                    nConsecutivePersons++;
                    if(nConsecutivePersons == 4) {
                        nConsecutivePersons = 0;    //Reset counter
                        reservations++;
                    }
                }
            }
            else {
                nConsecutivePersons = 0;
            }
        }
        return reservations;
    }

    private int maxAllocations(int N, String S) {
        int maxReservations = 0;

        for(int i=0; i<N; ++i) {
            maxReservations += maxReservationsPerRow(i, S);
        }

        return maxReservations;
    }

    private void run() {
        int N = 0;
        //String S = "1A 2F 1C";
        String S = "";
        System.out.println(maxAllocations(N, S));
    }
    public static void main(String[] args) {
        new PlaneSeatReservation().run();
    }
}
