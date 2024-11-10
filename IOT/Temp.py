import time
from gpiozero import LED
from w1thermsensor import W1ThermSensor

sensor = W1ThermSensor()

led1 = LED(20)
led2 = LED(21)
led3 = LED(22)
led4 = LED(23)
led5 = LED(24)
led6 = LED(25)

for led in [led1, led2, led3, led4, led5, led6]:
    led.off()

try:
    while True:
        temp = sensor.get_temperature()
        print(f"The temperature is {temp}°C")

        if temp >= 29:
            for led in [led1, led2, led3, led4, led5, led6]:
                led.off()       
        else:
            for led in [led1, led2, led3, led4, led5, led6]:
                led.on()
        time.sleep(1)
except KeyboardInterrupt:
    print("Program closed")
finally:
    sensor.close()

