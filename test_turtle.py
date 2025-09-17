
import turtle
import math
import time
"""
turtle.speed(0)
angle=-200
step=-1
zoom=5
while True:
    turtle.forward(angle*zoom)
    turtle.left(angle)
    angle+=step
    if angle > 200 or angle < -200:
        step=-step
    turtle.color((abs(angle/250),0.1,0.1))
"""
class rocket:
    def __init__(self):
        self.p=[0,0]
        self.v=[0,0]
        self.a=[0,0]
        self.w=0
        self.angle=0
        self.dt=1
    def step(self):
        self.angle=self.angle+self.w
        self.v=[self.v[0]+self.a[0]*self.dt,self.v[1]+self.a[1]*self.dt]
        self.p=[self.p[0]+self.v[0]*self.dt,self.p[1]+self.v[1]*self.dt]
        turtle.goto(self.p)
        turtle.setheading(self.angle/(math.pi)*180)
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

    

"""
def fd():
    turtle.forward(10)
def lt():
    turtle.left(5)
def rt():
    turtle.right(5)
turtle.onkeypress(fd,"w")
turtle.onkeypress(lt,"a")
turtle.onkeypress(rt,"d")
"""
r=rocket()
turtle.onkey(r.fd,"w")
turtle.onkey(r.lt,"a")
turtle.onkey(r.rt,"d")
turtle.goto((0,0))
while True:
    r.step()
    turtle.listen()
    time.sleep(0.03)
