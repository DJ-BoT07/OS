package DLL;

import org.python.core.PyFunction;
import org.python.core.PyObject;
import org.python.util.PythonInterpreter;

public class PythonMathTest {
    private static PythonInterpreter interpreter;
    
    public static void initializePython() {
        // Initialize the Python Interpreter
        interpreter = new PythonInterpreter();
        // Load our Python math library
        interpreter.execfile("DLL/math_lib.py");
    }
    
    public static double callPythonFunction(String functionName, Object... args) {
        PyFunction pyFunction = (PyFunction) interpreter.get(functionName);
        PyObject pyResult = pyFunction.__call__(convertToPyObjects(args));
        return pyResult.asDouble();
    }
    
    private static PyObject[] convertToPyObjects(Object... args) {
        PyObject[] pyArgs = new PyObject[args.length];
        for (int i = 0; i < args.length; i++) {
            pyArgs[i] = org.python.core.Py.java2py(args[i]);
        }
        return pyArgs;
    }
    
    public static void main(String[] args) {
        System.out.println("Testing Python Math Library from Java\n");
        
        try {
            initializePython();
            
            // Test addition
            System.out.println("Testing Addition:");
            System.out.println("2 + 3 = " + callPythonFunction("add", 2, 3));
            
            // Test subtraction
            System.out.println("\nTesting Subtraction:");
            System.out.println("5 - 2 = " + callPythonFunction("subtract", 5, 2));
            
            // Test multiplication
            System.out.println("\nTesting Multiplication:");
            System.out.println("4 * 6 = " + callPythonFunction("multiply", 4, 6));
            
            // Test division
            System.out.println("\nTesting Division:");
            System.out.println("10 / 2 = " + callPythonFunction("divide", 10, 2));
            
            // Test power
            System.out.println("\nTesting Power:");
            System.out.println("2^3 = " + callPythonFunction("power", 2, 3));
            
            // Test factorial
            System.out.println("\nTesting Factorial:");
            System.out.println("5! = " + callPythonFunction("factorial", 5));
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 