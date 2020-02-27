public class LongestCommonSubSequence {

  public static void main(String[] args) {
    String firstString = "santosh";
    String secondString = "LaxmanPingle";
    char[] firstStringAr = firstString.toCharArray();
    char[] secondStringAr = secondString.toCharArray();
    int firstLength = firstStringAr.length;
    int secondLength = secondStringAr.length;

    int[][] table = new int[firstLength + 1][secondLength + 1]; // first row and col will be zero.
    for (int i = 0; i <= firstLength; i++) {
      table[i][0] = 0;
    }
    for (int j = 0; j <= firstLength; j++) {
      table[0][j] = 0;
    }

    // formation of the table
    for (int i = 1; i <= firstLength; i++) {
      for (int j = 1; j <= secondLength; j++) {
        if (firstStringAr[i - 1] == secondStringAr[j
            - 1]) {
          table[i][j] = table[i - 1][j - 1] + 1;
        } else {
          table[i][j] = Math
              .max(table[i][j - 1], table[i - 1][j]);
        }
      }
    }

    System.out.println("Longest common subsequence length: " + table[firstLength][secondLength]);

    int size = table[firstLength][secondLength];
    char[] subsequence = new char[size];
    int i = firstLength, j = secondLength;
    while (i > 0 && j > 0) {
      if (firstStringAr[i - 1] == secondStringAr[j - 1]) {
        size--;
        subsequence[size] = firstStringAr[i - 1];
        i--;
        j--;
      } else if (table[i][j - 1] > table[i - 1][j]) {
        j = j - 1;
      } else {
        i = i - 1;
      }
    }
    System.out.println("Longest common subsequence " + String.valueOf(subsequence));
  }

}
