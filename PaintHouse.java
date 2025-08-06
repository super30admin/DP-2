// This solution uses bottom up approach where we consider three variables storing the previous costs. For each row we build up with the cost at that place plus minimum of the other two elements in previous row. For not loosing the state we will introduce additional two temp variables
class Solution {
    public int minCost(int[][] costs) {
        // Capture the initial states to paint first house
       int prevR = costs[0][0], prevB = costs[0][1], prevG = costs[0][2];
        for(int i = 1;i < costs.length; i++) {
            // Store the states as we have to update them
                int tempR = prevR;
                int tempB = prevB;

                prevR = costs[i][0] + Math.min(prevB, prevG);
                prevB = costs[i][1] + Math.min(tempR, prevG);
                prevG = costs[i][2] + Math.min(tempR, tempB);
        }
        // Minimum of all the three 
        return Math.min(prevR, Math.min(prevB, prevG));
    }
}

