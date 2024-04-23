import java.util.Scanner;
public class addMatrix {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = 0, m = 0;
        int i, j;
        while(true){
            System.out.print("Enter number of row: ");
            n = sc.nextInt();
            if(n<=0){
                System.out.println("Invalid Input!");
                continue;
            }
            System.out.print("Enter number of column: ");
            m = sc.nextInt();
            if(m<=0){
                System.out.println("Invalid Input!");
                continue;
            }
            break;
        }
        int[][] a = new int[n][m];
        System.out.print("Enter matrix 1: ");
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                a[i][j]=sc.nextInt();
            }
        }
        int[][] b = new int[n][m];
        System.out.print("Enter matrix 2: ");
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                b[i][j]=sc.nextInt();
            }
        }
        int[][] c = new int[n][m];
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                c[i][j]=a[i][j]+b[i][j];
            }
        }
        for(i=0;i<n;i++){
            for(j=0;j<m;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }
}
