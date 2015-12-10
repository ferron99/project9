
class Boat {
  float posX, posY;
  float movX;
  float r = random(255);
  float g = random(255);
  float b = random(255);



  //starting Boat data
  Boat(float horizon) {
    posX = random(0, width);
    posY = horizon;
    movX = random(-4, 4);
    int(r);
    int(g);
    int(b);
  }

  //displaying boat
  void disp(int i) {
    fill(r, g, b);
    quad(posX-20, posY-20, posX+20, posY-20, posX+10, posY, posX-10, posY);
    triangle(posX-10, posY-20, posX, posY-30, posX+10, posY-20);
    fill(0);

    //"smoke" changing directions
    if (this.movX<0) {                                                      //+
      if (frameCount % 60 < 20) ellipse(posX, posY-40, 10, 10);             //+DX    
        else if (frameCount % 60 < 40) ellipse(posX+5, posY-45, 10, 10);    //+
          else ellipse(posX+15, posY-50, 10, 10);                           //+
    } else if (frameCount % 60 < 20) ellipse(posX, posY-40, 10, 10);        //-
        else if (frameCount % 60 < 40) ellipse(posX-5, posY-45, 10, 10);    //-DY
          else ellipse(posX-15, posY-50, 10, 10);                           //-

    //# of boat
    text(i, posX-3, posY-5);
  }

  //moving boat
  void move() {
    posX += movX;
    if (posX < 0) movX = random(1.5, 4);
    if (posX > width) movX = random(-1.5, -4);
  }
}



int armyMany = 10;
Boat army[] = new Boat[armyMany];

//coord for horizon for boats
float horizon;


void setup() {
  size(500, 500);
  rectMode(CORNERS);
  reset();
}

void reset() {
  horizon = height/3;
  for (int i=0; i<armyMany; i++ ) {
    army[i] = new Boat(horizon);
  }
  frameCount = 0;
}

void draw() {
  scene();
  display();
  movement();
}

void scene() {
  noStroke();
  background(0, 137, 240);//sky
  fill(0, 70, 188);
  rect(0, horizon, width, height);//sea
}

//containing all display methods
void display() {
  stroke(1);
  for (int i=0; i<armyMany; i++ ) {
    army[i].disp(i+1);
  }
}

//containing all movement values
void movement() {
  for (int i=0; i<armyMany; i++ ) {
    army[i].move();
  }
}

void mousePressed() {
  reset();
}
