/*
1598. Crawler Log Folder
The Leetcode file system keeps a log each time some user performs a change folder operation.

The operations are described below:

"../" : Move to the parent folder of the current folder. (If you are already in the main folder, remain in the same folder).
"./" : Remain in the same folder.
"x/" : Move to the child folder named x (This folder is guaranteed to always exist).
You are given a list of strings logs where logs[i] is the operation performed by the user at the ith step.

The file system starts in the main folder, then the operations in logs are performed.

Return the minimum number of operations needed to go back to the main folder after the change folder operations.

 */
class CrawlerLogFolder {
    // Method to calculate the minimum number of operations to return to the main folder
    public int minOperations(String[] logs) {
        int count = 0; // Variable to keep track of the current folder level

        // Loop through each log entry in the array
        for (String log : logs) {
            // If the log is "../", move one folder up if not already at the main folder
            if (log.equals("../")) {
                if (count > 0) // Ensure we don't go above the main folder level
                    count--;
            }
            // If the log is not "./" (which means stay in the current folder), move one folder down
            else if (!log.equals("./")) {
                count++;
            }
        }

        // Return the current folder level
        return count;
    }
}
