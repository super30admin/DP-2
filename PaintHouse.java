/*
Time Complexity:O(m*n) m-> number of colors, n-> number of houses
Space Complexity:O(1)
Approach:
at each step we are checking the cost and if we are taking red for consecutive house we are taking either blue 
or green whichever is minimum
-we are modifying cost array itself 
-at the end of our calculation in the last row all values will be stored related to our decision
at ecah step so minimum out of it will be the answer
 */
class PaintHouse {
    public static int minCost(int[][] costs) {
        if(costs.length == 0 || costs == null){
            return 0;
        }
        for(int i =1; i<costs.length;i++){
            costs[i][0]+=Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1]+=Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2]+=Math.min(costs[i-1][0],costs[i-1][1]);
        }
        
        return Math.min(costs[costs.length-1][0],Math.min(costs[costs.length-1][1],costs[costs.length-1][2]));
    }
    public static void main(String args[]) {
        System.out.println(minCost(new int[][]{{17,2,17},{16,16,5},{14,3,19}}));
    }
}