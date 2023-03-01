;import java.math.BigInteger;
import java.util.HashMap;
public class Exercise {

    public static void main(String args[]) throws Exception {
        HashMap m = new HashMap();
        Object o1 = new Object();
        Object o2 = o1;
        m.put(o1,1);
        m.put(o2,2);
        System.out.println("result is : "+m.get(o1));
        BigInteger b = new BigInteger("1");
        b.add(new BigInteger("1"));
        System.out.println("bigInteger add result is :"+b.add(new BigInteger("1")));
        System.out.println("b value is : "+b.toString());
        int [][]matrixToTest = {{4,3,2},{3,4,1},{3,2,3}};
        if(!Sandpile.matrixEntryIsOk(matrixToTest)){
            throw new Exception("sorry, the format of matrix is not correct");
        }
        Sandpile sandpile = new Sandpile(1,matrixToTest,4);
        int [][]res = sandpile.launch();
        for(int i =0;i<res.length;i++){
            for(int j =0;j<res[i].length;j++){
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
