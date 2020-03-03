public class LongestIncreasingSubsequenceLength {

  public static void main(String[] args) {
    int[] input = {2, 3, 4, 5, 0, -1, -2, -3, 0}; //Ans. 2,3,4,5 : length 4
    int[] temp = new int[input.length];

    for (int i = 0; i < input.length; i++) {
      temp[i] = 1;
    }

    // Calculate max subsequence length.
    for (int i = 1; i < input.length; i++) {
      int j = 0;
      while (j < i) {
        if (input[j] < input[i]) {
          temp[i] = Math.max(temp[j] + 1, temp[i]);
        }
        j++;
      }
    }

    // Print the max subsequence length.
    int length = temp[0];
    for (int i = 1; i < temp.length; i++) {
      if (length < temp[i]) {
        length = temp[i];
      }
    }

    System.out.print("Subsequence length : " + length);
  }
}
