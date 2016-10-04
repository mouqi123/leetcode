public class Stack{
   public int maxProfit(int k,int[] prices){
      int n=prices.length;
      int[][] t=new int[k][n];
      for(int i=1;i<k;i++){
        for(int j=1;j<n;j++){
           t[i][j]=Math.max(t[i][j-1],prices[j]-prices[j-1]+t[i-1][j-1]);
        }
      }
      return t[k-1][n-1];
   }
}
   
   public static void main(String[] args){
       int[] p={
