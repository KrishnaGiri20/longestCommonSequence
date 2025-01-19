class PrintLCS{
    private int[][] dp;
    private String ans = "";
    public String PrintLCS(String X, String Y, int m , int n){
      //  LongestCommonSequence lcs = new LongestCommonSequence();
        // fill the dp table with the LCS

        dp = new int[m+1][n+1];

        for(int i =0; i<=m ;i++){
            for(int j=0; j<=n ;j++){
                dp[i][j] = 0;
            }
        }

        //We'll fill the dp table with longest commmon sequence
        for(int i=1; i<=m ;i++){
            for(int j=1;j<=n;j++){
                if(X.charAt(m-1) == Y.charAt(n-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j]);
                }
            }
        }

        //to iterate reversly and push the character if the characater in both the string matche
        int a = m, b= n;
        while(a> 0 && b>0){
            if(X.charAt(a-1) == Y.charAt(b-1)){
                ans = ans + X.charAt(a-1);
                a--;
                b--;
            }else if(dp[a-1][b] > dp[a][b-1]){
                a--;
            }else{
                b--;
            }
        }
        System.out.println("the ans"+ans);
        return ans;
    }
}