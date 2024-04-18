# Assume we have the following file, located in the same folder as Python:

f = open('C:\\Users\\Stathis Karaimitriou\\Desktop\\LearningPython\\demofile2.txt', 'w')
f.writelines('My name is Stathis\n')
f.writelines('I am 25 years old\n')
f.writelines('I am trying to save a txt file\n')
f.close()

f = open("C:\\Users\\Stathis Karaimitriou\\Desktop\\LearningPython\\demofile2.txt", "r")
print(f.read())