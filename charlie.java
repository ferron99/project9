//// Exercise with arrays of objects -- take 2.
//// Prof bam (CST 112)

float surface;
Tuna charlie;


boolean action=false;

//// SETUP:  screen size.
void setup() {
  size( 600, 400 );
  surface=  height/4;
  
  charlie=  new Tuna( );
  charlie.r=  255;
  charlie.g=  255;
  charlie.b=  200;
    
  reset();

}
void reset() {    
  charlie.fins=  1;
  //
  charlie.x=100;
  charlie.y=  height-50;
  charlie.dy=0;
  
}

//// NEXT FRAME:  scene, show, action
void draw() {
  
  textSize(16);
  fill(0);
  
  // scene
  background( 150,200,255 );
  
  
  action();
  
  // msgs
  text( "Exercise with arrays of objects.", width/3, 20 );
  text( "('a' key for action;\n  'r' for reset; 'q' to quit)", width/2, 45 );

}  
void keyPressed() {
  if (key == 'q') exit();
  if (key == 'r') reset();
  if (key == 'a') action = !action;
}


// Display Show and move all members of group.
void action() {  
  if (! action) return;
  
  charlie.show();
  charlie.move();
  
}
    
  




//// OBJECTS
class Tuna {
  // PROPERTIES:  position, speed, etc.
  float x=100, y=100, dx=3, dy=2;
  float w=60,h=30;
  float r=255, g=255, b=200;
  int fins=1;
  int num;
  
  // METHODS:  move, show, +++?
  void show() {
    fill( r, g, b );
    ellipse( x,y, w,h );
    // Fins along back.
    float xx= x-w/2;
    for (int j=0; j<fins; j++) {
      triangle( xx, y-h/2, xx+10, y-10-h/2, xx+20, y-h/2 );
      xx += 10;
    }
    fill(0);
    text( num, x+w/4,y );
    if (fins>1) text( fins, x-w/4,y );
  }
  void move() {
    fill(0);
    x += dx;
    y += dy;
    if (x>width) dx=  -dx;
    if (x<0) dx=  -dx;
  }
  //// True if (xx,yy) is near me.
  boolean hit( float xx, float yy ) {
    if (dist(xx,yy, this.x,this.y) < w) return true;
    else return false;
  }
}

