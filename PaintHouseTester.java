public class PaintHouseTester {
    public static void main(String[] args) {
        PaintHouse obj = new PaintHouse();

        // int[][] costs = { { 17, 2, 17 }, { 16, 16, 5 }, { 14, 3, 19 } };

        int[][] costs = {{3,5,3},{6,17,6},{7,13,18},{9,10,18}};

        System.out.println(obj.minCost(costs));
    }
}
