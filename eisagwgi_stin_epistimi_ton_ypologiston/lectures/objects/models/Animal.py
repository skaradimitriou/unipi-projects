import abc


class Animal():

    def __init__(self, name, category, legs):
        self.name = name
        self.category = category
        self.legs = legs

    def makeSound(self):
        print('I am an animal')