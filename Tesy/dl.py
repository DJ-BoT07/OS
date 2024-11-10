class MathOperations:
    def add(a, b):
        return a + b
    
    def subtract(a, b):
        return a - b
    
    def multiply(a, b):
        return a * b
    
    def divide(a, b):
        if b == 0:
            raise ValueError("Cannot divide by zero")
        return a / b
    
    def power(base, exp):
        return base ** exp
    
    def square_root(n):
        if n < 0:
            raise ValueError("Cannot calculate square root of negative number")
        return n ** 0.5
