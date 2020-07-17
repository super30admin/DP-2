/* Time Complexity: O(n)
Space Complexity: O(1)

1. Using Dynamic programming to solve the problem, wherein the cost required to paint each house with a particular colour is calculated with the help of previous optimal solutions.
2. Since no two neighbouring houses can be painted with same colour, the minimum cost required to paint a particular house with a particular colour includes the specific cost plus the cost of painting previous house with a different colour(choosing to paint the previous house with a colour that costs least among the available options).
3. Repeat the same process to all the elements.
*/

class Solution{
    public int housePainting(int[][] costs){

        if(costs.length == 0 || costs == null){
            return 0;
        }

        for(int i=1; i<costs.length; i++){
            costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);

            costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);

            costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
        }

        return Math.min(costs[costs.length][0], Math.min(costs[costs.length][1],costs[costs.length][2]));
    }
}