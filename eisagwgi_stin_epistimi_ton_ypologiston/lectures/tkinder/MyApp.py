# something
import tkinter
from tkinter import *


class MyApp:

    def __init__(self):
        self.root = Tk()
        self.root.title('Cicero')
        self.root.geometry('300x150')
        self.myFrame = Frame(self.root)
        self.myFrame.pack()
        self.myLabel = Label(self.myFrame)
        self.myLabel['text'] = 'O tempora, o mores'
        self.myLabel.pack()
        self.root.mainloop()
