
// Reference : Algorithms, Part I, Robert Sedgewick

public class Knapsack {
  public static void main(String[] args) {
    // int N = Integer.parseInt(args[0]);   // number of items
    // int W = Integer.parseInt(args[1]);   // maximum weight of knapsack
    //
    // int[] profit = new int[N+1];
    // int[] weight = new int[N+1];

    // generate random instance, items 1..N
    // for (int n = 1; n <= N; n++) {
    //   profit[n] = StdRandom.uniform(1000);
    //   weight[n] = StdRandom.uniform(W);
    // }

    int N = 5;
    int W = 15;
    int profit[] = {0,4,2,2,1,10};
    int weight[] = {0,12,1,2,1,4};

    // opt[n][w] = max profit of packing items 1..n with weight limit w
    // sol[n][w] = does opt solution to pack items 1..n with weight limit w include item n?
    int[][] opt = new int[N+1][W+1];
    boolean[][] sol = new boolean[N+1][W+1];

    for (int n = 1; n <= N; n++) { // rows
      for (int w = 1; w <= W; w++) { // columns

        // don't take item n
        int preValue = opt[n-1][w];

        // take item n
        int currentValue = Integer.MIN_VALUE;
        if (weight[n] <= w) currentValue = profit[n] + opt[n-1][w-weight[n]];

        // select better of two options
        opt[n][w] = Math.max(preValue, currentValue);
        sol[n][w] = (currentValue > preValue);
      }
    }

    // determine which items to take
    boolean[] take = new boolean[N+1];
    for (int n = N, w = W; n > 0; n--) {
      if (sol[n][w]) {
        take[n] = true;
        w = w - weight[n];
      }
      else {
        take[n] = false;
      }
    }

    // print results
    System.out.println("item" + "\t" + "profit" + "\t" + "weight" + "\t" + "take");
    for (int n = 1; n <= N; n++) {
      System.out.println(n + "\t" + profit[n] + "\t" + weight[n] + "\t" + take[n]);
    }
  }
}

