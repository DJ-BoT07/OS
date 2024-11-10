import time
from gpiozero import Buzzer

buzzer = Buzzer(18)

try:
    while True:
        buzzer.on()
        time.sleep(1)
        buzzer.off()
        time.sleep(1)
except KeyboardInterrupt:
    print("Program closed")
