import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        System.out.println("Type first number");
        int a = intScanner();

        System.out.println("Type second number");
        int b = intScanner();

        System.out.println("Result: "+sumTwo(a, b));
    }

    static int intScanner(){
        Scanner input = new Scanner(System.in);
        while(true){
            try{
                return input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Type NUMBER!");
                input.nextLine();
            }
        }
    }

    static int sumTwo(int a, int b){
        TypeTester typeTester = new TypeTester();
        try {
            if(typeTester.type(a) != "int" || typeTester.type(b) != "int"){
                throw new IOException("Wrong type given!");
            }
            return a + b;
        } catch (IOException e) {
            System.out.println("Wrong type given");
            return 0;
        }
    }
}
