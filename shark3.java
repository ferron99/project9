//// Exercise with arrays of objects -- take 2.
//// Prof bam (CST 112)


Shark[] group;
int many=5;
float surface;

//// SETUP:  screen size.
void setup() {
  size( 600, 400 );
  surface=  height/4;
  
  group=  new Shark[many];

  float spacing=  width / (many+1);
  float sharkX= spacing;
  
  //    //INIT   //TEST  //INCR
  for( int i=0; i<many; i++) {
    group[i]=  new Shark(  i, sharkX );
    sharkX += spacing;
  }
}

//// NEXT FRAME:  scene, show, action
void draw() {
  
  textSize(16);
  fill(0);
  
  // scene
  background( 150,200,255 );
  
  // show all
  for( int i=0; i<many; i++) {
    group[i].show();
  }
  
  // action
  for( int i=0; i<many; i++) {
    group[i].move();
  }
  
  // msgs
  text( "Exercise with arrays of objects.", width/3, 20 );
  
}
    
  




//// OBJECTS
class Shark {
  // PROPERTIES:  position, speed, etc.
  float x=100, y=100, dx=3, dy=2;
  float w=60,h=30;
  float r,g,b;
  //++++ color?
  int fins=1;
  int num;
  
  // CONSTRUCTOR
  Shark( int n, float x ) {
    num=  n;
    this.x=  x;
    y=  random( surface,height );
    // Random colors
    r=  random( 0, 255 );
    g=  random( 0, 255 );
    b=  random( 0, 255 );
    // Random colors
    fins=  int( random( 1, 7.5 ) );
  }
  
  // METHODS:  move, show, +++?
  void show() {
    text( "# show() was called.", 10,50 );
    fill( r, g, b );
    ellipse( x,y, w,h );
    // Fins along back.
    float xx= x-w/2;
    float space=  w / (fins+1);
    for (int j=0; j<fins; j++) {
      triangle( xx, y-h/2, xx+10, y-10-h/2, xx+20, y-h/2 );
      xx += space;
    }
  }
  void move() {
    fill(0);
    text( "# "+ num, x,y-30 );
    text( "  "+ fins, x+40,y-10 );
    x += dx;
    if (x>width) dx=  -dx;
    y += dy;
    if (y>height) dy=  -dy;
  }
}
