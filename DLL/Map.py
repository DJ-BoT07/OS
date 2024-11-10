
import jpype
import jpype.imports
from jpype import *

def test_java_math_lib():
    if not isJVMStarted():
        jpype.startJVM(classpath=['./'])
    else:
        print("JVM already started")
    MathLib = JClass('DLL.MathLib')
    print(MathLib.add(2, 3))
    print(MathLib.subtract(5, 2))
    print(MathLib.multiply(4, 6))
    print(MathLib.divide(10, 2))
    print(MathLib.power(2, 3))
    print(MathLib.factorial(5))
    jpype.shutdownJVM()
test_java_math_lib()  