import sys

height = int(sys.argv[1])  #second input from terminal casted to int
char = sys.argv[2]  #third input from terminal

for i in range(height):
    print((height - i) * " " + (2 * i + 1) * char)

print("----")
print("File Name: ",sys.argv[0])
print("Tree Height: ",sys.argv[1])
print("Tree is made of character: ",sys.argv[2])
print("-------")