from objects.models.Vehicle import Vehicle


class Car(Vehicle):

    def __init__(self, manufacturer, model, horsepower):
        super().__init__(manufacturer, model)
        self.horsepower = horsepower

    def toString(self):
        print('Manufacturer: {0}, Model: {1}, Horsepower: {2}'.format(self.manufacturer, self.model, self.horsepower))
