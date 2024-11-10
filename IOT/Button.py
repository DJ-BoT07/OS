import time
from gpiozero import Button
from gpiozero import LED



button = Button(21)
led1 = LED(20)
led2 = LED(21)
led3 = LED(22)
led4 = LED(23)
led5 = LED(24)
led6 = LED(25)
led7 = LED(26)

led1.off()
led2.off()
led3.off()
led4.off()
led5.off()
led6.off()
led7.off()

try:
    while True:
        if button.is_pressed:
            led1.on()
            led2.on()
            led3.on()
            led4.on()
            led5.on()
            led6.on()
            led7.on()
        else:
            led1.off()
            led2.off()
            led3.off()
            led4.off()
            led5.off()
            led6.off()
            led7.off()
        time.sleep(0.1)
except KeyboardInterrupt:
    print("Program closed")
finally:
    led1.off()
    led2.off()
    led3.off()
