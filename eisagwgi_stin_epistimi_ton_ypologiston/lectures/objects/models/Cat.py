from objects.models.Animal import Animal


class Cat(Animal):

    def __init__(self, name, category, legs, isFurry):
        super().__init__(name, category, legs)
        self.isFurry = isFurry

    def makeSound(self):
        print('{0} says Meow!'.format(self.name))