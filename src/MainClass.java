import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class MainClass {
    int N;
    boolean solved=false;
    int[][] field;
    double minDist=Double.MAX_VALUE;
    int[] stack;
    int[] result;
    public static void main(String args[]){
        for(int T=0;T<=6;T++){
            MainClass main = new MainClass();
            try {
                Scanner fileScanner = new Scanner(new File("TestCase/input" + T + ".txt"));
                main.N = fileScanner.nextInt();
                main.field = new int[main.N][2];
                main.stack = new int[main.N];
                for (int i = 0; i < main.N; i++) {
                    main.field[i][0] = fileScanner.nextInt();
                    main.field[i][1] = fileScanner.nextInt();
                    main.stack[i] = i;
                }
                fileScanner.close();
                long StartTime=System.currentTimeMillis();
                main.calc(0, 0);
                long EndTime=System.currentTimeMillis();
                for (int i = 0; i < main.N; i++)
                    System.out.print(main.result[i] + " ");
                System.out.println("\n" + main.minDist+ "\ntime(second) : "+(EndTime-StartTime)/1000.0+"\n");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    double getDist(int from[],int to[]){
        if(from==null)
            return 0;
        double xDiff=from[0]-to[0];
        double yDiff=from[1]-to[1];
        return Math.sqrt(xDiff*xDiff+yDiff*yDiff);
    }
    void swap(int i,int j){
        int t=stack[i];
        stack[i]=stack[j];
        stack[j]=t;
    }
    public void calc(int depth,double acc) {
        if(acc>minDist)return;
        if(depth==N-1){
            double tDist=acc+
                    getDist(field[stack[depth-1]],field[stack[depth]])+
                    getDist(field[stack[0]],field[stack[depth]]);
            if(tDist<minDist){
                result=stack.clone();
                minDist=tDist;
            }
            return;
        }
        for (int i = depth; i < N; i++) {
            swap(i, depth);
            calc(depth + 1,acc+getDist(depth>0?field[stack[depth-1]]:null,field[stack[depth]]));
            swap(i, depth);
        }
    }
}
