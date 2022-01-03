public class PaintHouse {
    public static void main(String[] args) {
        int[][] costs = {
            {17,2,17},{16,16,5},{14,3,19}
        };
        System.out.println(minCost(costs));
    }

    public static int minCost(int[][] costs) {
        if(costs == null){
            return 0;
        }
        
        int blue = 0, green = 0, red = 0;
        
        for(int i=0; i<costs.length; i++){
            int tempBlue = blue;
            int tempGreen = green;
            int tempRed = red;
            
            blue = Math.min(tempGreen, tempRed) + costs[i][0];
            green = Math.min(tempBlue, tempRed) + costs[i][1];
            red = Math.min(tempGreen, tempBlue) + costs[i][2];
         }
        
        return Math.min(blue, Math.min(green, red));
    }
}
