// TC = 0(n)
// sc = 0(n)

public class PaintHouse {

    public static final int red = 0;
    public static final int blue = 1;
    public static final int green = 2;

    public static void main(String[] args) {

        int[][] arr = {
                { 17, 2, 17 },
                { 16, 16, 5 },
                { 14, 3, 9 },
        };

        PaintHouse obj = new PaintHouse();
        int obj1 = obj.housePaint(arr);
        System.out.println("min cost  is  = " + obj1);

    }

    public int housePaint(int[][] cost) {

        if (cost == null || cost.length == 0)
            return 0;

        int n = cost.length;
        int[][] dp = new int[n][3];

        dp[n - 1][red] = cost[n - 1][red];
        dp[n - 1][blue] = cost[n - 1][blue];
        dp[n - 1][green] = cost[n - 1][green];

        for (int i = n - 2; i >= 0; i--) {
            dp[i][red] = Math.min(cost[i + 1][blue], cost[i + 1][green]) + cost[i][red];
            dp[i][blue] = Math.min(cost[i + 1][green], cost[i + 1][red]) + cost[i][blue];
            dp[i][green] = Math.min(cost[i + 1][blue], cost[i + 1][red]) + cost[i][green];

        }
        return Math.min(dp[0][red], Math.min(dp[0][blue], dp[0][green]));

    }

}