class PaintHouse {
    public int minCost(int[][] costs) {
        // Time Complexity: O(n)
        // Space Complexity: O(1)
        
        if(costs.length == 0 || costs[0].length < 3)
            return 0;
        
        //int[] for previous row costs
        int[] temp = new int[3];
        temp[0] = costs[0][0];
        temp[1] = costs[0][1];
        temp[2] = costs[0][2];
        
        // Variables to store temp[] values to read when evaluating
        int a, b, c;
        
        for(int i = 1; i < costs.length; i++){
            a = temp[0];
            b = temp[1];
            c = temp[2];
            
            temp[0] =  costs[i][0] + Math.min(b, c);
            temp[1] =  costs[i][1] + Math.min(a, c);
            temp[2] =  costs[i][2] + Math.min(a, b);
        }
        return Math.min(temp[0], Math.min(temp[1], temp[2]));
        
//          Method 2 : manipulating the input
//         //O(n * 3) --> O(n)    ( 3 colors )
//         //Space - O(1)       
//         // Updating every row with value that is minimum of two choices we have (if R --> then G or B)
//         // and adding it to the respective cell value;
//         for(int i = 1; i < costs.length; i++){
//             costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
//             costs[i][1] += Math.min(costs[i-1][2], costs[i-1][0]);
//             costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
//         }
        
//         // Returning the minimum value of total costs present in the last row
//         return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length -1][1], costs[costs.length -1 ][2]));
        
    }
}
