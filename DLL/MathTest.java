package DLL;

public class MathTest {
    public static void testMathOperations() {
        // Test addition
        System.out.println("Testing Addition:");
        System.out.println("2 + 3 = " + MathOperations.add(2, 3));
        
        // Test subtraction
        System.out.println("\nTesting Subtraction:");
        System.out.println("5 - 2 = " + MathOperations.subtract(5, 2));
        
        // Test multiplication
        System.out.println("\nTesting Multiplication:");
        System.out.println("4 * 6 = " + MathOperations.multiply(4, 6));
        
        // Test division
        System.out.println("\nTesting Division:");
        System.out.println("10 / 2 = " + MathOperations.divide(10, 2));
        
        // Test power
        System.out.println("\nTesting Power:");
        System.out.println("2^3 = " + MathOperations.power(2, 3));
        
        // Test factorial
        System.out.println("\nTesting Factorial:");
        System.out.println("5! = " + MathOperations.factorial(5));
        
        // Test error handling
        System.out.println("\nTesting Error Handling:");
        try {
            MathOperations.divide(5, 0);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero caught: " + e.getMessage());
        }
        
        try {
            MathOperations.factorial(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Negative factorial caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Mathematical Operations Library Test\n");
        testMathOperations();
    }
} 