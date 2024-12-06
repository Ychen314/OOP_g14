import java.util.Scanner;
public class calculator{
    public static int add(int number1,int number2){
        return number1 + number2;
    }

    public static int sub(int number1,int number2){
        return number1 - number2;
    }


public static void main(String[]args){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter number 1 :");
    int number1 = in.nextInt();
    System.out.println("Enter number 2 :");
    int number2 = in.nextInt();
    add(number1,number2);
    sub(number1,number2);

}
}