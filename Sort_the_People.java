public class Sort_the_People {
    public String[] sortPeople(String[] names, int[] heights) {
        // Create a map to store heights as keys and names as values
        Map<Integer, String> map = new HashMap<>();

        // Populate the map with heights and corresponding names
        for (int i = 0; i < heights.length; i++) {
            map.put(heights[i], names[i]);
        }

        // Sort the heights array in ascending order
        Arrays.sort(heights);

        // Create an array to store the result
        String[] result = new String[heights.length];
        int index = 0;

        // Traverse the sorted heights array in reverse order
        for (int i = heights.length - 1; i >= 0; i--) {
            // Get the corresponding name from the map and add it to the result array
            result[index] = map.get(heights[i]);
            index++;
        }

        // Return the result array
        return result;
    }
}
