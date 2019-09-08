public class GenerateSpiralMatrix {

  public static int[][] generateMatrix(int n) {
    int [][] result = new int[n][n];
    int k =1;
    int bottom = n-1;
    int top = 0;
    int left = 0;
    int right = n-1;

    while(k<=n*n){
      for(int i=left; i<=right; i++){
        result [top][i]=k;
        k++;
      }
      top++;

      for(int i=top; i<=bottom; i++){
        result[i][right]=k;
        k++;
      }
      right --;

      for(int i=right; i>=left; i--){
        result[bottom][i]=k;
        k++;
      }
      bottom --;

      for(int i=bottom; i>=top; i--){
        result[i][left]=k;
        k++;
      }
      left++;
    }

    return result;
  }

  // main method
  public static void main(String args[]) {
    int[][] result = generateMatrix(3);
    for(int i = 0; i < result.length; i++) {
      for(int j = 0; j <result[i].length; j++) {
        System.out.print(result[i][j]);
      }
    }
  }
}