from objects.models.Animal import Animal
from objects.models.Car import Car
from objects.models.Cat import Cat
from objects.models.User import User
from objects.models.Vehicle import Vehicle

person = User('Stathis', 25)

print('{0} is {1} years old'.format(person.name, person.age))

cat = Cat('Tom', 'Cat', 4, True)

print('{0} is a {1} and has {2} legs'.format(cat.name, cat.category, cat.legs))
cat.makeSound()

vehicle = Vehicle('Man', 'Model')
vehicle.makeEngineSound()

car1 = Car('Nissan', 'Skyline', '250hp')

car1.toString()