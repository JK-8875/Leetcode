class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = n - 1; i >= 0; i--) {
            int[] count = freq.clone();
            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int idx = target.charAt(j) - 'a';
                count[idx]--;

                if (count[idx] < 0) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                continue;
            }

            int targetChar = target.charAt(i) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {
                if (count[c] > 0) {
                    StringBuilder ans = new StringBuilder();

                    ans.append(target.substring(0, i));
                    ans.append((char) ('a' + c));
                    count[c]--;

                    for (int k = 0; k < 26; k++) {
                        while (count[k] > 0) {
                            ans.append((char) ('a' + k));
                            count[k]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}