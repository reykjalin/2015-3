import circle as c # Import circle.py file, also includes math
import sys # For arguments

rad = float(input("Radius of a circle: "))

print("Area: ", c.area(rad))

print("Circumference: ", c.circumference(rad))
