// Time Complexity : O(n)
// Space Complexity : O(n*m)
// Did this code successfully run on Leetcode : 
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class PaintHouses {

    public int paintHouses(int costs[][]){
        for(int i=1;i<costs.length;i++){
            costs[i][0] = Math.min(costs[i-1][1], costs[i-1][2]) + costs[i][0];
            costs[i][1] = Math.min(costs[i-1][0], costs[i-1][2]) + costs[i][1];
            costs[i][2] = Math.min(costs[i-1][0], costs[i-1][1]) + costs[i][2];
        }
        int m = costs.length-1;
        System.out.println(costs[m][0]);
        System.out.println(costs[m][1]);
        System.out.println(costs[m][2]);
        return Math.min(Math.min(costs[m][0], costs[m][1]), costs[m][2]);
    }
    public static void main(String[] args){
        System.out.println("Paint Houses");
        int[][] costs = new int[][] { 
            {7,5,10},
            {3,6,1},
            {8,7,4},
            {6,2,9},
            {1,4,7},
            {2,3,6},
        };

        PaintHouses obj = new PaintHouses();
        System.out.println(obj.paintHouses(costs));
    }
}