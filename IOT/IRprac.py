import time
import RPi.GPIO as GPIO
from gpiozero import LED

Detect = 0
count = 0
led = LED(20)
GPIO.setmode(GPIO.BCM)
GPIO.setup(Detect, GPIO.IN, pull_up_down = GPIO.PUD_UP)

try:
    while True:
        if GPIO.input(Detect) == GPIO.LOW:
            count += 1
            print(f"person count = {count}")
            led.off()
            time.sleep(1)
            led.on()
        time.sleep(0.3)
except KeyboardInterrupt:
    print("Program closed")
finally:
    GPIO.cleanup()
