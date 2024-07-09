/*There is a restaurant with a single chef. You are given an array customers, where customers[i] = [arrivali, timei]:

arrivali is the arrival time of the ith customer. The arrival times are sorted in non-decreasing order.
timei is the time needed to prepare the order of the ith customer.
When a customer arrives, he gives the chef his order, and the chef starts preparing it once he is idle. The customer waits till the chef finishes preparing his order. The chef does not prepare food for more than one customer at a time. The chef prepares food for customers in the order they were given in the input.

Return the average waiting time of all customers. Solutions within 10-5 from the actual answer are considered accepted.

*/
class Average_Waiting_Time {
    // Method to calculate the average waiting time for all customers
    public double averageWaitingTime(int[][] customers) {
        int current_time = 0; // Variable to keep track of the current time
        double total_time = 0; // Variable to accumulate the total waiting time

        // Loop through each customer in the array
        for(int[] customer : customers) {
            int arrival_time = customer[0]; // Arrival time of the current customer
            int prep_time = customer[1]; // Preparation time for the current customer's order

            // If the current time is less than the arrival time, update current time to the arrival time
            if(current_time < arrival_time)
                current_time = arrival_time;

            // Update the current time by adding the preparation time
            current_time += prep_time;

            // Calculate the waiting time for the current customer and add it to the total time
            total_time += (current_time - arrival_time);
        }

        // Calculate the average waiting time by dividing the total time by the number of customers
        return total_time / customers.length;
    }
}
