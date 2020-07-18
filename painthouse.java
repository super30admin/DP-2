//Time Complexity:O(N)
//Space Complexity:O(1)
//In this program, the initialcost of paining of each color for the first house are being stored in the prev variable. In the for loop, the current values for the next house are been computed by taking the minimum of other two colors and adding that particular color. This value is then reassigned as prev values. At the end, the minimum of the three colors is returned as the output.
//This code was successfully executed and got accepted in leetcode.
class Solution{
    public int minCost(int[][] costs){
        if(costs.length==0){
            return 0;
        }
        int prevR=costs[0][0];
        int prevG=costs[0][1];
        int prevB=costs[0][2];
        for(int i=1;i<costs.length;i++){
            int curR= Math.min(prevG,prevB)+costs[i][0];
            int curG=Math.min(prevR,prevB)+costs[i][1];
            int curB=Math.min(prevR,prevG)+costs[i][2];
            prevR=curR;
            prevG=curG;
            prevB=curB;
        }
        return Math.min(Math.min(prevR,prevG),prevB);

    }
}