class LongestCommonSubstring{
    String ans = "";
    private int[][] dp;
    private int maxLength  = 0 ;
    public int lcsTopDown(String X, String Y, int m , int n){
        //initialization of dp array
        dp = new int[m+1][n+1];
        for(int i = 0;i<=m ;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = 0;
            }
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }   
}