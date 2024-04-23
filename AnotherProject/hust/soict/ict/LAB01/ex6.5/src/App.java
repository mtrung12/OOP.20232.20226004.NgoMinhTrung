import java.util.Scanner;
import java.util.Arrays;
public class App {
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter array's size: ");
        n = sc.nextInt();
        int[] a = new int[n];
        System.out.print("Enter array: ");
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        Arrays.sort(a);
        for(int i=0;i<n;i++){
           System.out.print(a[i]+" ");
        }
    }
}
