class PaintHouse {
    public int painthouse(int[][] costs){

       //R G B
        //0 1 2
        int red = helper(costs,0,0);
        int green = helper(costs,0,1);
        int blue = helper(costs,0,2);
        
        return Math.min(red, Math.min(green,blue));
    }
    
    private int helper(int[][] costs, int index, int lastRowsColor){
        //base condition
        if (index==costs.length){
            return 0;
        }
        if (lastRowsColor==0){
            int blue = costs[index][0] + helper(costs, index+1, 2);
            int green = costs[index][0] + helper( costs, index+1, 1);
            
            return Math.min(blue,green);
        }
        if (lastRowsColor ==1) {
            int red = costs[index][1] + helper(costs, index+1,0);
            int blue = costs[index][1] + helper(costs, index+1, 2);
            
             return Math.min(red,blue);
        }
        if (lastRowsColor ==2) {
            int red = costs[index][2] + helper(costs, index+1,0);
            int green = costs[index][2] + helper(costs, index+1, 1);
            
             return Math.min(red,green);
        }
        return -1;
    }
}