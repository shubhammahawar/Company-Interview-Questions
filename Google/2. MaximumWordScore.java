Given a String array words contains words and an integer array score contains score of each word such that score[i] represents score of word at ith position. Find the max score you can achieve using the combination of words with following rules :

you're given limit integer value, the combination of words used to get maxscore cannot exceed the size limit provided in limit value.
any word can be used multiple times . Eg: words=[sun,moon] score=[5,4] limit=7 then maxscore=10 as the score of combination "sunsun"=5+5=10 and has size 6 which is less than limit 7, hence condition is satisfied.
words are allowed to overlap and form new word. After overlap, the new word can have combined power.
Eg. words=[energy, green] score=[4,3] limit=9 then we can use new formed word greenergy with score value =(4+3)=7 here maxscore=7 as greenergy having score=7 and size=9 can be used here
Sample Input

Input: n=2 words=["pack", "acknowledge", "edged"] score=[2,12,3] limit=13
Output: 15
Explaination: Here new combination can be 
["pack", "acknowledge", "edged", "acknowledged", "packnowledge", "packnowledged"] with 
score=[2, 12, 3, 15, 14, 17]
So, packnowledged can picked from the combination to form maxscore=17
it also maintain the word limit rule that -
size(packnowledged)  <= limit
13 <= 13, hence maxscore = 17 as answer.


TC: O(n^2 * m^2) , SC: O(n * m^2)


import java.util.*;

public class mximumWordScoreCombination {

    // Instance variable to store the maximum score
    static int sol = 0;

    // Method to find the maximum score combination
    public static int findMaximumScore(List<String> words, List<Integer> score, int limit) {
        // Iterate through each word
        for (int i = 0; i < words.size(); i++) {
            // Call mergeWords method for each word
            mergeWords(words.get(i), score.get(i), limit - words.get(i).length(), words, score);
        }
        // Return the maximum score found
        return sol;
    }

    // Method to recursively merge words and calculate maximum score
    public static void mergeWords(String s, int sc, int limit, List<String> words, List<Integer> score) {
        // If the limit is negative, return (base case)
        if (limit < 0)
            return;

        // Update the maximum score
        sol = Math.max(sol, sc);

        // Iterate through each word
        for (int i = 0; i < words.size(); i++) {
            // Recursively call mergeWords for each word
            mergeWords(s + words.get(i), sc + score.get(i), limit - words.get(i).length(), words, score);
            // If the current word is different from the original word
            if (!s.equals(words.get(i))) {
                // Find the common prefix-suffix
                int st = 0;
                String commonPrefixSuffix = "";
                while (st < Math.min(s.length(), words.get(i).length())) {
                    if (words.get(i).substring(0, st + 1).equals(s.substring(s.length() - 1 - st))) {
                        commonPrefixSuffix = words.get(i).substring(0, st + 1);
                    }
                    st++;
                }

                // Get the length of the common prefix-suffix
                int len = commonPrefixSuffix.length();
                // If there is a common prefix-suffix
                if (len > 0 && len < words.get(i).length()) {
                    // Recursively call mergeWords with the remaining part of the word
                    mergeWords(s + words.get(i).substring(len), sc + score.get(i),
                            limit - words.get(i).substring(len).length(), words, score);
                }
            }
        }
    }

    public static void main(String args[]) {
        // Input words and scores
        List<String> words = Arrays.asList("green", "energy");
        List<Integer> score = Arrays.asList(3, 4);
        int limit = 9;

        // Find and print the maximum score
        System.out.println("Maximum score " + findMaximumScore(words, score, limit));
    }
}
