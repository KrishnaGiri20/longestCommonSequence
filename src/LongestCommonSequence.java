class LongestCommonSequence{
    //Input given as two strings as X : abcdgh , Y: abedfhe , need to return the longes common sequence as o/p : abdh , the length of longest common sequnee
    // we are initiliazing dp with the maximum constraint limit 


    private int[][] memoize;

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

}