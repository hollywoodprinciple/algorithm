public class MinimumEditDistance {

  public static void main(String[] args) {
    // String first = "santosh";
    // String second = "pingle";  // 6 operations

    String first = "cetbucket";
    String second = "cricket";   // 3 operations.

    char[] firstA = first.toCharArray();
    char[] secondA = second.toCharArray();
    int[][] temp = new int[secondA.length + 1][firstA.length + 1];

    for (int j = 0; j <= firstA.length; j++) {  // 0th row
      temp[0][j] = j;
    }

    for (int j = 0; j <= secondA.length; j++) { // 0th col.
      temp[j][0] = j;
    }

    for (int i = 1; i <= secondA.length; i++) {
      System.out.println();
      for (int j = 1; j <= firstA.length; j++) {
        if (secondA[i - 1] == firstA[j - 1]) {
          temp[i][j] = temp[i - 1][j - 1];
          System.out.print(" " + temp[i][j]);
        } else { // take minimum of top, diagonal, left
          temp[i][j] = Math.min(temp[i][j - 1], temp[i - 1][j - 1]);
          temp[i][j] = Math.min(temp[i][j], temp[i - 1][j]) + 1;
          System.out.print(" " + temp[i][j]);
        }
      }
    }
    System.out.println();
    System.out.println("Minimum edit distance operations : " + temp[secondA.length][firstA.length]);
    // convert first string to second string

    // print the operations
    // String first = "cetbucket";
    // String second = "cricket";   // 3 operations.

    int j = firstA.length; // ub
    int i = secondA.length; // cri
    while (i > 0 && j > 0) {
      if (firstA[j - 1] == secondA[i - 1]) {
        i = i - 1;
        j = j - 1;
      } else if (temp[i][j] == temp[i - 1][j - 1] + 1) {
        System.out.println( firstA[j - 1] + " -> " + secondA[i - 1]);
        i = i - 1;
        j = j - 1;
      } else if (temp[i][j] == temp[i][j - 1] + 1){
        System.out.println(firstA[j - 1] + " -");
        j = j - 1;
      }else {
        System.out.println(firstA[j - 1] + " +");
        j = j - 1;
      }
    }
  }

}
