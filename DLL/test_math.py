# Import our math operations module
from math_operations import MathOperations

def test_math_lib():
    try:
        # Test addition
        print("Testing Addition:")
        result = MathOperations.add(10, 5)
        print(f"10 + 5 = {result}")

        # Test subtraction
        print("\nTesting Subtraction:")
        result = MathOperations.subtract(10, 5)
        print(f"10 - 5 = {result}")

        # Test multiplication
        print("\nTesting Multiplication:")
        result = MathOperations.multiply(10, 5)
        print(f"10 * 5 = {result}")

        # Test division
        print("\nTesting Division:")
        result = MathOperations.divide(10, 5)
        print(f"10 / 5 = {result}")

        # Test power
        print("\nTesting Power:")
        result = MathOperations.power(2, 3)
        print(f"2^3 = {result}")

        # Test factorial
        print("\nTesting Factorial:")
        result = MathOperations.factorial(5)
        print(f"5! = {result}")

        # Test error handling
        print("\nTesting Error Handling:")
        try:
            MathOperations.divide(5, 0)
        except ValueError as e:
            print(f"Division by zero caught: {e}")

        try:
            MathOperations.factorial(-1)
        except ValueError as e:
            print(f"Negative factorial caught: {e}")

    except Exception as e:
        print(f"An error occurred: {e}")

if __name__ == "__main__":
    print("Testing Math Operations Library\n")
    test_math_lib() 