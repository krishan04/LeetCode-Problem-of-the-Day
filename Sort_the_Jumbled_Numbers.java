public class Sort_the_Jumbled_Numbers {
    List<int[]> mapped = new ArrayList<>();

    // Loop through each number in the nums array
        for(int i = 0; i < nums.length; i++){
        // Convert the current number to a string
        String s = Integer.toString(nums[i]);
        StringBuilder n = new StringBuilder();

        // Build the mapped value using the mapping array
        for(char ch : s.toCharArray()){
            n.append(mapping[ch - '0']);
        }

        // Add the original number, its mapped value, and original index to the list
        mapped.add(new int[]{nums[i], Integer.parseInt(n.toString()), i});
    }

    // Sort the list based on the mapped values
        mapped.sort((a, b) -> {
        // Compare by mapped value first
        if(a[1] != b[1]) return Integer.compare(a[1], b[1]);
            // If mapped values are equal, compare by original index to maintain stability
        else return Integer.compare(a[2], b[2]);
    });

    // Rebuild the sorted nums array using the original numbers from the sorted list
        for(int i = 0; i < nums.length; i++){
        nums[i] = mapped.get(i)[0];
    }

    // Return the sorted nums array
        return nums;
}
}
