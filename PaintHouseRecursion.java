public class PaintHouseRecursion {
    public int paint(int[][] costs) {
        return paintRec(costs, 1);
    }

    public int paintRec(int[][] costs, int row) {
        if (costs.length == 0)
            return 0;

            int red = costs[row][0] + Math.min( paintRec(costs,row - 1), paintRec(costs, row - 1));  
            int green = costs[row][1] + Math.min( paintRec(costs,row - 1), paintRec(costs, row - 1));  
            int blue = costs[row][2] + Math.min( paintRec(costs,row - 1), paintRec(costs, row - 1));  
            
             return Math.min(red, Math.min(green, blue));

    }

    public static void main(String args[]) {
        PaintHouse obj = new PaintHouse();
        int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };
        System.out.println(obj.paint(costs));

    }

}