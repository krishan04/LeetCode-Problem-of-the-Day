class Reverse_Substrings_Between_Each_Pair_of_Parentheses {
    int i = 0; // Initialize index i to keep track of current position in the string

    public String reverseParentheses(String s) {
        char[] arr = s.toCharArray(); // Convert input string to a char array
        return helper(arr); // Call helper method with the char array
    }

    public String helper(char[] s) {
        StringBuilder sb = new StringBuilder(); // StringBuilder to build the result
        while (i < s.length) { // Loop through the characters in the char array
            if (s[i] == '(') { // If current character is '('
                i++; // Move to the next character
                String st = helper(s); // Recursively call helper to process inner parentheses
                sb.append(st); // Append the reversed inner substring to StringBuilder
            } else if (s[i] == ')') { // If current character is ')'
                i++; // Move to the next character
                return sb.reverse().toString(); // Reverse the StringBuilder and return as String
            } else { // If current character is normal character
                sb.append(s[i]); // Append the character to StringBuilder
                i++; // Move to the next character
            }
        }
        return sb.toString(); // Return the final result as String
    }
}
