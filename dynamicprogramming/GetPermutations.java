import java.util.ArrayList;

public class GetPermutations {

    public String insertChar(char element, int pos, String perm) {
        String start = perm.substring(0, pos);
        String end = perm.substring(pos);
        return start+element+end;
    }

    public ArrayList<String> getPerms(String val) {
        if(val==null) return null;
        ArrayList<String> perms = new ArrayList<String>();
        if(val.length() == 0) {
            perms.add(val);
            return perms;
        }
        char first = val.charAt(0);
        String last = val.substring(1);
        ArrayList<String> permsLast = getPerms(last);
        for(String perm : permsLast) {
            for(int j=0; j<=perm.length(); j++) {
                String newPerm = insertChar(first, j, perm);
                perms.add(newPerm);
            }
        }
        return perms;
    }

    public void run() {
        String val = "abcd";
        ArrayList<String> permutations = getPerms(val);
        for(String s : permutations) {
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        new GetPermutations().run();
    }
}
