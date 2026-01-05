public class TestDP {
    public static void main(String[] args) {
        // Coin Change II tests
        CoinChangeII cc2 = new CoinChangeII();

        int[] coins1 = {1, 2, 5};
        int amount1 = 5;     // ways = 4
        int exp1 = 4;

        int[] coins2 = {2};
        int amount2 = 3;     // ways = 0
        int exp2 = 0;

        int[] coins3 = {10};
        int amount3 = 0;     // ways = 1 (choose nothing)
        int exp3 = 1;

        System.out.println(cc2.changeRecursive(amount1, coins1) == exp1);
        System.out.println(cc2.changeTopDown(amount1, coins1) == exp1);
        System.out.println(cc2.change2D(amount1, coins1) == exp1);
        System.out.println(cc2.change1D(amount1, coins1) == exp1);

        System.out.println(cc2.change1D(amount2, coins2) == exp2);
        System.out.println(cc2.change1D(amount3, coins3) == exp3);

        //Paint House tests
        PaintHouse ph = new PaintHouse();

        int[][] costs1 = {
                {17, 2, 17},
                {16, 16, 5},
                {14, 3, 19}
        }; // expected = 10
        int expPH1 = 10;

        int[][] costs2 = {
                {7, 6, 2}
        }; // expected = 2
        int expPH2 = 2;

        int[][] costs3 = {}; // expected = 0
        int expPH3 = 0;

        System.out.println(ph.minCostRecursive(costs1) == expPH1);
        System.out.println(ph.minCostTopDown(costs1) == expPH1);
        System.out.println(ph.minCost2D(costs1) == expPH1);
        System.out.println(ph.minCostOptimized(costs1) == expPH1);

        System.out.println(ph.minCostOptimized(costs2) == expPH2);
        System.out.println(ph.minCostOptimized(costs3) == expPH3);
    }
}
