import java.util.Scanner;
public class MainClass {
    int N;
    int[][] field;
    public static void main(String args[]){
        MainClass main=new MainClass();
        Scanner scanner=new Scanner(System.in);
        main.N=scanner.nextInt();
        main.field=new int[main.N][2];
        for(int i=0;i<main.N;i++){
            main.field[i][0]=scanner.nextInt();
            main.field[i][1]=scanner.nextInt();
        }
        System.out.println(main.calc());
    }
    int calc(){
        int minDist=0x7fffffff;

        return minDist;
    }
}
