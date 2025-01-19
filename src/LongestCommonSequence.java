class LongestCommonSequence{
    //Input given as two strings as X : abcdgh , Y: abedfhe , need to return the longes common sequence as o/p : abdh , the length of longest common sequnee
    // we are initiliazing dp with the maximum constraint limit 


    private int[][] memoize;
    private int[][] dp;
    //constructor
    // public LongestCommonSequence(int rows, int cols){
    //     memoize = new int[rows, cols];
    //     for(int i=0; i<rows;i++){
    //         for(int j=0; j<cols; j++){
    //             memoize[i][j] = -1;
    //         }
    //     }

    // }


    public int recursiveLCS(String X, String Y, int m , int n){
        if(n==0 || m==0){
            return 0;
        }
        if(X.charAt(m-1) == Y.charAt(n-1)){
            return 1 + recursiveLCS(X, Y, m-1, n-1);
        }else{
            return Math.max(recursiveLCS(X,Y,m-1, n), recursiveLCS(X,Y,m,n-1));
        }
    }


    public int memoizeLCS(String X, String Y, int m, int n){
        // In memoization we basically calculate with recursive call + table to store ther calculated value

        memoize = new int[m+1][n+1];

        //initialiation

        for(int i = 0 ;i<=m; i++){
            for(int j=0; j<=n ;j++){
                memoize[i][j] = -1;
            }
        }


        return memoizeHelper(X, Y , m , n);
    }



    public int memoizeHelper(String X, String Y, int m ,int n){
        if(m==0 || n==0){
            return 0;
        }

        if(memoize[m][n] != -1){
            return memoize[m][n];
        }
        if(X.charAt(m-1) == Y.charAt(n-1)){
            return 1 + memoizeHelper(X, Y, m-1, n-1);
        }else{
            return Math.max(memoizeHelper(X,Y, m-1 , n) , memoizeHelper(X,Y,m, n-1));
        }
    }


    // we initialize with -1 in bottom up because we are checking if the value is present or not in the table
    //but we are initialiaing with the actual possible vlaue of the solution in the top down approach

    public int topDownLCS(String X, String Y, int m, int n){
        //initialization of the array
        dp = new int[m+1][n+1];
        for(int i =0;i<=m; i++){
            for(int j=0; j<=n ;j++){
                dp[i][j] = 0;
            }
        }
        //In DP we convert the recursice approach from Memeoization to the iterative approach


        for(int i=1; i<=m;i++){
            for(int j=1;j<=n; j++){
                if(X.charAt(i-1) ==  Y.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

}