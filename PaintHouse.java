class PaintHouse {
    public int minCost(int[][] costs) {
        int length = costs.length;
        for(int i=1;i<length;i++){
            costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
            costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
            costs[i][2] += Math.min(costs[i-1][0],costs[i-1][1]);
        }


        return Math.min(costs[length-1][0],Math.min(costs[length-1][1],costs[length-    1][2]));
    }
    public static void main(String[] args){
        PaintHouse p = new PaintHouse();
        int [][] arr = {{17,8,7},{45,2,90},{4,23,1}};
        System.out.println(p.minCost(arr));
    }
}