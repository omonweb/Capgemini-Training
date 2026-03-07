package M1prep.string_prep;

import java.util.HashSet;

public class Smallest_Window_Unique {

        public static int findShortestSubstring(String s) {

            int n = s.length();
            int minLen = n;

            for (int i = 0; i < n; i++) {

                for (int j = i; j < n; j++) {

                    String remaining = s.substring(0, i) + s.substring(j + 1);

                    if (isUnique(remaining)) {
                        minLen = Math.min(minLen, j - i + 1);
                    }
                }
            }

            return minLen;
        }

        public static boolean isUnique(String str) {

            HashSet<Character> set = new HashSet<>();

            for (char ch : str.toCharArray()) {

                if (set.contains(ch)) {
                    return false;
                }

                set.add(ch);
            }

            return true;
        }

        public static void main(String[] args) {

            String s = "abcbbck";

            System.out.println(findShortestSubstring(s));
        }
    }
