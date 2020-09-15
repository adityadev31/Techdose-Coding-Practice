public class Main {
    
    public static int square(int[][] arr, int row, int col){
        int[][] store = new int[row+1][col+1];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<=row; i++) store[i][0] = 0;
        for(int j=0; j<=col; j++) store[0][j] = 0;
        for(int i=1; i<=row; i++){
            for(int j=1; j<=col; j++){
                if(arr[i-1][j-1]==0){
                    store[i][j]=0;
                    continue;
                }
                int a=Integer.MAX_VALUE, b=Integer.MAX_VALUE, c=Integer.MAX_VALUE;
                if(i-1>=0) a = store[i-1][j];
                if(j-1>=0) b = store[i][j-1];
                if(i-1>=0 && j-1>=0) c = store[i-1][j-1];
                int min = Integer.min(Integer.min(a,b), c);
                store[i][j] = min+1;
                max = Integer.max(max, store[i][j]);
            }
        }
        return max;
    }
    
    public static void main(String[] args) throws Exception {
        int[][] arr = {
            {1,0,1,1,1},
            {1,0,1,1,1},
            {1,1,1,1,1},
            {1,0,0,1,0}
        };
        System.out.println("Max square: \t" + square(arr, arr.length, arr[0].length));
    }
}


// O U T P U T -> Max square: 	3
