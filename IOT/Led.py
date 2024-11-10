import time
from gpiozero import LED

TRUE = 1
led_pins = [20,21,22,23,24,25,26,27]
leds = [LED(pin) for pin in led_pins]

def ledState(led, state):
    if state == 1:
        leds[led].on()
    else:
        leds[led].off()

try:
    for i in range(8):
        ledState(i, 1)
    while True:
        for i in range(8):
            ledState(i, 1)
            time.sleep(1)
            ledState(i, 0)
            time.sleep(1)
except KeyboardInterrupt:
    print("Program closed")
finally:
    for led in leds:
        led.off()