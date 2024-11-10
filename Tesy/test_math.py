from dl import MathOperations

def test_math_operations():
    # Create an instance of MathOperations
    math = MathOperations()
    
    # Test addition
    assert math.add(5, 3) == 8
    print("Addition test passed: 5 + 3 =", math.add(5, 3))
    
    # Test subtraction
    assert math.subtract(10, 4) == 6
    print("Subtraction test passed: 10 - 4 =", math.subtract(10, 4))
    
    # Test multiplication
    assert math.multiply(6, 7) == 42
    print("Multiplication test passed: 6 * 7 =", math.multiply(6, 7))
    
    # Test division
    assert math.divide(20, 5) == 4
    print("Division test passed: 20 / 5 =", math.divide(20, 5))
    
    # Test power
    assert math.power(2, 3) == 8
    print("Power test passed: 2 ^ 3 =", math.power(2, 3))
    
    # Test square root
    assert math.square_root(16) == 4
    print("Square root test passed: √16 =", math.square_root(16))
    
    # Test error handling
    try:
        math.divide(5, 0)
        print("Division by zero test failed")
    except ValueError:
        print("Division by zero test passed")
        
    try:
        math.square_root(-1)
        print("Negative square root test failed")
    except ValueError:
        print("Negative square root test passed")

if __name__ == "__main__":
    print("Running mathematical operations tests...")
    test_math_operations()
    print("All tests completed!") 