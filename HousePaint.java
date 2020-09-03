// Time Complexity : O(n), n is the number of houses
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class HousePaint {
    public int minCost(int[][] costs) {
        if(costs.length ==0){
            return 0;
        }

        for(int i=1;i<costs.length;i++){
            //current cost plus minimum cost for previous house selection
            costs[i][0] = costs[i][0] + Math.min(costs[i-1][1], costs[i-1][2]);//select the colors which are not adjacent from the previous selection
            costs[i][1] = costs[i][1] + Math.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] = costs[i][2] + Math.min(costs[i-1][0], costs[i-1][1]);

        }

        return Math.min(costs[costs.length-1][0], Math.min(costs[costs.length-1][1], costs[costs.length-1][2]));
        
    }
}

class Main{
    public static void main(String[] args){
        HousePaint hp = new HousePaint();
        int[][] costs = {{17,2,17}, {16,16,5}, {14,3,19}};
        System.out.println(hp.minCost(costs));
    }
}