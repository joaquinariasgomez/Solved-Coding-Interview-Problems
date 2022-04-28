public class AMPMHour {
    public String timeConversion(String s) {
        String format = s.substring(s.length()-2);
        boolean isPm = (format.equals("PM"));
        String[] times = s.substring(0, s.length()-2).split(":");
        String sol = "";

        if(isPm && Integer.parseInt(times[0]) < 12) {
            times[0] = Integer.toString(Integer.parseInt(times[0])+12);
        }
        if(!isPm && times[0].equals("12")) {
            times[0] = "00";
        }
        
        sol = times[0] + ":" + times[1] + ":" + times[2];
        return sol;
    }

    public void run() {
        String sample_time = "12:01:00AM";
        System.out.println(timeConversion(sample_time));
    }
    public static void main(String[] args) {
        new AMPMHour().run();
    }    
}
