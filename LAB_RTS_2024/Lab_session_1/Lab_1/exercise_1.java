package Lab_1;
import java.util.Scanner;

public class exercise_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ComplexNumber num1 = new ComplexNumber(2, 5); // num1=2+5i
        ComplexNumber num2 = new ComplexNumber(4, -1); // num2= 4-i

        System.out.println("Complex Number Calculator");
        System.out.println("===========================");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("===========================");
        System.out.print("Choose an option (the two numbers are predetermined): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Addition: " + num1.addition(num2));
                break;
            case 2:
                System.out.println("Subtraction: " + num1.subtraction(num2));
                break;
            case 3:
                System.out.println("Multiplication: " + num1.multiplication(num2));
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
   
}

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public String addition(ComplexNumber second) {
        double realResult = this.real + second.real;
        double imaginaryResult = this.imaginary + second.imaginary;
        return realResult + " + " + imaginaryResult + "i";
    }

    public String subtraction(ComplexNumber second) {
        double realResult = this.real - second.real;
        double imaginaryResult = this.imaginary - second.imaginary;
        return realResult + " + " + imaginaryResult + "i";
    }

    public String multiplication(ComplexNumber second) {
        double realResult = (this.real * second.real) - (this.imaginary * second.imaginary);
        double imaginaryResult = (this.real * second.imaginary) + (this.imaginary * second.real);
        return realResult + " + " + imaginaryResult + "i";
    }
}