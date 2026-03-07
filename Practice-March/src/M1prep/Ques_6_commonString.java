package M1prep;

public class Ques_6_commonString {
    public static void checkCommon(String[] a, String[] b) {

        for (int i = 0; i < a.length; i++) {

            boolean[] freq = new boolean[26];

            for (char ch : a[i].toCharArray()) {
                freq[ch - 'a'] = true;
            }

            boolean found = false;

            for (char ch : b[i].toCharArray()) {
                if (freq[ch - 'a']) {
                    found = true;
                    break;
                }
            }

            if (found)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
