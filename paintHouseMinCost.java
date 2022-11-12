// Time Complexity : //O(n) n= number of rows, cause the cols are fixed that is 3
// Space Complexity : O(1) // no extra space used cause modifying the same array


public class paintHouseMinCost {
    public int minCost(int[][] costs) {
        if(costs.length==0) return 0;
        
        
        for(int i=costs.length-2;i>=0;i--){
            
            //start from bottom, for each element of current row , 
            //take min from each col of the next row except the adjascent
                costs[i][0]+=Math.min(costs[i+1][1] , costs[i+1][2]);
                costs[i][1]+=Math.min(costs[i+1][0] , costs[i+1][2]);
                costs[i][2]+=Math.min(costs[i+1][0] , costs[i+1][1]);    
            
        }
        
        
        return Math.min(costs[0][0], Math.min(costs[0][1],costs[0][2]));
    }
} 
