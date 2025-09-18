
import turtle
import math
import time
import random
class rocket:
    def __init__(self):
        self.t = turtle.Turtle()
        self.t.goto((0,0))
        self.t.speed(0)
        self.t.penup()
        self.t.shapesize(2)
        self.p=[0,0]
        self.v=[0,0]
        self.a=[0,0]
        self.w=0
        self.angle=0
        self.dt=1
        self.screen_size=[500,500]
        self.pixel_radius=5
    def step(self):
        self.angle=self.angle+self.w
        self.v=[self.v[0]+self.a[0]*self.dt,self.v[1]+self.a[1]*self.dt]
        self.p=[self.p[0]+self.v[0]*self.dt,self.p[1]+self.v[1]*self.dt]
        self.checkborders()
        self.t.goto(self.p)
        self.t.setheading(self.angle/(math.pi)*180)
        print(self.p,self.v,self.a)
        self.a=[0,0]
    def fd(self):
        force=1
        self.a=[math.cos(self.angle)*force,math.sin(self.angle)*force]
        self.step()
    def bw(self):
        self.a=[0,0]
        self.step()
    def lt(self):
        self.w-=0.05
        self.step()
    def rt(self):
        self.w+=0.05
        self.step()
    def checkborders(self):
        if(self.p[0]<-self.screen_size[0]):
            self.p[0]=self.screen_size[0]-1
        if(self.p[0]>self.screen_size[0]):
            self.p[0]=-self.screen_size[0]+1
        if(self.p[1]<-self.screen_size[1]):
            self.p[1]=self.screen_size[1]-1
        if(self.p[1]>self.screen_size[1]):
            self.p[1]=-self.screen_size[1]+1

class Asteroid():
    def __init__(self):
        self.t = turtle.Turtle()
        self.t.goto((0,0))
        self.t.speed(0)
        self.t.penup()
        self.t.shapesize(3)
        self.screen_size=[500,500]
        self.p=[random.randint(-self.screen_size[0],self.screen_size[0]),random.randint(-self.screen_size[1],self.screen_size[1])]
        self.v=[random.randint(-500,500)/100,random.randint(-500,500)/100]
        self.a=[0,0]
        self.dt=1
        self.t.shape("circle")
        self.pixel_radius=30
    def step(self):
        self.v=[self.v[0]+self.a[0]*self.dt,self.v[1]+self.a[1]*self.dt]
        self.p=[self.p[0]+self.v[0]*self.dt,self.p[1]+self.v[1]*self.dt]
        self.checkborders()
        self.t.goto(self.p)
        self.a=[0,0]
    def checkborders(self):
        if(self.p[0]<-self.screen_size[0]):
            self.p[0]=self.screen_size[0]-
        if(self.p[0]>self.screen_size[0]):
            self.p[0]=-self.screen_size[0]+1
        if(self.p[1]<-self.screen_size[1]):
            self.p[1]=self.screen_size[1]-1
        if(self.p[1]>self.screen_size[1]):
            self.p[1]=-self.screen_size[1]+1
    def checkcollision(self,r):
        min_distance=self.pixel_radius+r.pixel_radius
        distance=math.sqrt((r.p[0]-self.p[0])**2+(r.p[1]-self.p[1])**2)
        if(distance<min_distance):
            self.t.color("red")
        elif((distance-30)<min_distance):
            self.t.color("yellow")
        else:
            self.t.color("black")

r=rocket()
asteroids=[]
for i in range(10):
    asteroids.append(Asteroid())
screen = turtle.Screen()
screen.setup(1020,1020)
screen.onkey(r.fd,"w")
screen.onkey(r.rt,"a")
screen.onkey(r.lt,"d")
while True:
    r.step()
    for a in asteroids:
        a.step()
        a.checkcollision(r)
    screen.listen()
    #time.sleep(0.01)
