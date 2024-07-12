/*
1717 Maximum Score From Removing Substrings
You are given a string s and two integers x and y. You can perform two types of operations any number of times.

Remove substring "ab" and gain x points.
For example, when removing "ab" from "cabxbae" it becomes "cxbae".
Remove substring "ba" and gain y points.
For example, when removing "ba" from "cabxbae" it becomes "cabxe".
Return the maximum points you can gain after applying the above operations on s.



Example 1:

Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
Explanation:
- Remove the "ba" underlined in "cdbcbbaaabab". Now, s = "cdbcbbaaab" and 5 points are added to the score.
- Remove the "ab" underlined in "cdbcbbaaab". Now, s = "cdbcbbaa" and 4 points are added to the score.
- Remove the "ba" underlined in "cdbcbbaa". Now, s = "cdbcba" and 5 points are added to the score.
- Remove the "ba" underlined in "cdbcba". Now, s = "cdbc" and 5 points are added to the score.
Total score = 5 + 4 + 5 + 5 = 19.
Example 2:

Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20

 */
public class Maximum_Score_From_Removing_Substrings {
    public int maximumGain(String s, int x, int y) {
        int aCount = 0; // Count of 'a' characters
        int bCount = 0; // Count of 'b' characters
        int lesser = Math.min(x, y); // The lesser of the two values x and y
        int result = 0; // The total gain

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); // Current character

            if (c > 'b') {
                // If the character is neither 'a' nor 'b'
                result += Math.min(aCount, bCount) * lesser; // Add pairs of 'ab' or 'ba' to the result
                aCount = 0; // Reset counts for 'a' and 'b'
                bCount = 0;
            } else if (c == 'a') {
                // If the character is 'a'
                if (x < y && bCount > 0) {
                    bCount--; // Use one 'b' to form 'ba'
                    result += y; // Add y to the result
                } else {
                    aCount++; // Increment count of 'a'
                }
            } else {
                // If the character is 'b'
                if (x > y && aCount > 0) {
                    aCount--; // Use one 'a' to form 'ab'
                    result += x; // Add x to the result
                } else {
                    bCount++; // Increment count of 'b'
                }
            }
        }

        // Add remaining pairs of 'ab' or 'ba' to the result
        result += Math.min(aCount, bCount) * lesser;

        return result;
    }
}
