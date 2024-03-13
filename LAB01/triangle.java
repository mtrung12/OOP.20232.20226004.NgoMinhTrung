import java.util.Scanner;
public class triangle {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        for(int i = 0; i<n;i++){
            for(int j = n-i-1; j>0; j--){
                System.out.print(" ");
            }
            for(int k=2*i+1;k>0;k--){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
