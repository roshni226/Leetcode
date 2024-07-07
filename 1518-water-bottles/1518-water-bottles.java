class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalDrank = 0;
        int emptyBottles = 0;

        // While there are still full bottles to drink
        while (numBottles > 0) {
            // Drink all current bottles
            totalDrank += numBottles;
            emptyBottles += numBottles;

            // Exchange empty bottles for new full bottles
            numBottles = emptyBottles / numExchange;
            emptyBottles = emptyBottles % numExchange;
        }

        return totalDrank;
    }
}
