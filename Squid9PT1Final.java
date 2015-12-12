//BAM:  Please start with a comment that includes your name and the purpose of this code.
//BAM:  No legs on octupi; no animation (except smoke).;
//BOM:  No collisions.




class Boat {
  float posX, posY;
  float movX;
  float r = random(255);
  float g = random(255);
  float b = random(255);
  int fins=0;

  //starting Boat data
  Boat(float horizon) {
    posX = random(0, width);
    posY = horizon;
    movX = random(-4, 4);
    int(r);
    int(g);
    int(b);
  }

  //displaying Boat
  void disp(int i) {
    fill(r, g, b);
    quad(posX-20, posY-20, posX+20, posY-20, posX+10, posY, posX-10, posY);
    triangle(posX-10, posY-20, posX, posY-30, posX+10, posY-20);
    fill(0);

    //"smoke" changing directions
    if (this.movX<0) {                                             //-
      if (this.posX % 80 < 60) ellipse(posX, posY-40, 10, 10);     //-
      if (this.posX % 80 < 40) ellipse (posX+5, posY-45, 10, 10);  //-DX    
      if (this.posX % 80 < 20) ellipse (posX+15, posY-50, 10, 10); //-
    } else { 
      if (this.posX % 80 > 60) ellipse(posX-15, posY-50, 10, 10);  //+
      if (this.posX % 80 > 40) ellipse(posX-5, posY-45, 10, 10);   //+
      if (this.posX % 80 > 20) ellipse(posX, posY-40, 10, 10);     //+DY
    }

    //# of Boat
    text(i, posX-3, posY-5);
  }

  //moving Boat
  void move() {
    posX += movX;
    if (posX < 0){
      movX = random(1.5, 4);
      score(fins);
    }
    if (posX > width) movX = random(-1.5, -4);
  }
}

class Squid{
  float legs = random(1,30);
  float posX,posY;
  float movY;
  float r = random(255);
  float g = random(255);
  float b = random(255);
  int i;
  float horizon;
  
  Squid(float horizon, float spacing, int i){
    this.horizon = horizon;
    this.i = i;
    posX = (i+1) * spacing;
    posY = height;
    movY = random(-4,-2);      

//BAM:  Why use the int() methos?  (These statements do nothing!)    
    int(legs);
    int(r);
    int(g);
    int(b); 
    
  }
  
  void move(){
    posY += movY;
    if(posY < horizon+20)movY = random(2,4);
    if(posY > height)movY = random(-4,-2);
    
  }
  
  void disp(){
    fill(r,g,b);
    arc(posX, posY, 40, 40, PI, TWO_PI , OPEN);
    for(int l=1; l<legs; l++){
      line( posX,posY,posX+10,posY);
    }
    fill(0);
    text(i+1,posX,posY);
  }
}

int boatsMany = 5;
Boat boats[] = new Boat[boatsMany];

int squadMany = 3;
Squid squad[] = new Squid[squadMany];

//coord for horizon for Boats
float horizon;
int points;

void setup() {
  size(500, 500);
  rectMode(CORNERS);
  reset();
}

void reset() {
  float squadSpace = width/(squadMany+1);
  horizon = height/3;
  points = 0;
  for (int i=0; i<boatsMany; i++ ) {
    boats[i] = new Boat(horizon);
  }
  for (int i=0; i<squadMany; i++ ) {
    squad[i] = new Squid(horizon,squadSpace,i);
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
  fill(0);
  text(points,width-50,20);
  fill(0, 70, 188);
  rect(0, horizon, width, height);//sea
}

//containing all display methods
void display() {
  stroke(1);
  for (int i=0; i<boatsMany; i++ ) {
    boats[i].disp(i+1);
  }
  for (int i=0; i<squadMany; i++){
    squad[i].disp();
  }
}

//containing all movement values
void movement() {
  for (int i=0; i<boatsMany; i++ ) {
    boats[i].move();
  }
  for (int i=0; i<squadMany; i++){
    squad[i].move();
  }
}

void score(int s){
  points+=s;
}

void mousePressed() {
  reset();
}
