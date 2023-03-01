public class Sandpile {
    public int fois;
    public int[][]matrix;
    public final int limit;

    public Sandpile(int fois, int[][] matrix, int limit) {
        this.fois = fois;
        this.matrix = matrix;
        this.limit = limit;
    }

    public static boolean matrixEntryIsOk(int [][]matrix){
        if (matrix.length!=matrix[0].length){
            return false;
        }
        if (matrix.length%2!=1){
            return false;
        }
        return true;
    }

    public int[][]launch(){
        int center = (matrix.length)/2;
        for (int i =0;i<fois;i++){
            matrix[center][center]+=1;
            while(abnormalCase(matrix)!=null){
                matrix = updateMatrix((matrix),abnormalCase(matrix));
            }
        }
        return matrix;
    }

    private int[][] updateMatrix(int[][]array, Case caseTrouvee){
        int i = caseTrouvee.x;
        int j = caseTrouvee.y;
        int n = array.length;
        array[i][j]-= limit;
        if(i-1>=0 && i-1<n)array[i-1][j] += 1;
        if(i+1<n) array[i+1][j]+=1;
        if(j-1>=0 && j-1<n)array[i][j-1] += 1;
        if(j+1<n) array[i][j+1] += 1;
        return array;
    }

    private Case abnormalCase(int[][]matrix){
        Case abnormalTrouvee = null;
        for(int i =0;i<matrix.length;i++){
            for (int j =0;j<matrix[i].length;j++){
                if (matrix[i][j]>=limit){
                    abnormalTrouvee = new Case(i,j);
                }
            }
        }
        return abnormalTrouvee;
    }

}
