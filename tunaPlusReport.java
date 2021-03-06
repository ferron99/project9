//// Exercise with arrays of objects + report.
//// Prof bam (CST 112)

float surface;
Tuna charlie;

Tuna[] group;
int many=5;
boolean action=true;

//// SETUP:  screen size.
void setup() {
  size( 600, 400 );
  surface=  height/4;
  
  charlie=  new Tuna( );
  charlie.r=  255;
  charlie.g=  255;
  charlie.b=  200;
  charlie.fins=  1;
  charlie.name=  "Charlie";
  //
  charlie.y=  height-50;
  charlie.dy=0;
  
  
  group=  new Tuna[many];
  reset();

}
void reset() {    
  
  charlie.x=0;
  action=  ! action;
  
  float spacing=  width / (many+1);
  float tunaX= spacing;
  
  //    //INIT   //TEST  //INCR
  for( int i=0; i<many; i++) {
    group[i]=  new Tuna(  i, tunaX );
    tunaX += spacing;
  }
}

//// NEXT FRAME:  scene, show, action
void draw() {
  
  textSize(16);
  fill(0);
  
  // scene
  background( 150,200,255 );

  charlie.show();
  charlie.move();
 
   if (key >= 'A' && key <= 'Z') {
    tunaReport( surface+50, group, group.length);
  }
  else action();
 

  
  
  // msgs
  text( "Arrays of objects.  \n(Charlie collects fins.)", width/3, 20 );
  text( "('T' key for report;\n  'r' for reset; 'q' to quit)", width/2, 80 );

}  
void keyPressed() {
  if (key == 'q') exit();
  if (key == 'r') reset();
}


// Display Show and move all members of group.
void action() {  
  
  if (! action) return;
  
  // show all
  for( int i=0; i<many; i++) {
    group[i].show();
  }
  
  // move all.
  for( int i=0; i<many; i++) {
    group[i].move();
  }
  
  // collisions.
  for (int i=0; i<many; i++) {
    for (int j=i+1; j<many; j++) {
      if (group[j].hit( group[i].x, group[i].y )) {
        group[i].y=surface;
      }
    }
  }//for
  
  
  //// Charlie collects fins.  
  for (int i=0; i<many; i++) {
      if (charlie.hit( group[i].x, group[i].y )) {
        group[i].fins--;
        group[i].y=  surface;
        charlie.fins++;
      }
  }//for

  
  
}
    
  
void tunaReport( float top, Tuna[] a, int many ) {
  fill(255,255,200);
  rect( 50,top, width-100, 50 + 20*many );
  float x=70, y=top+20;
  // Labels.
  fill(150,0,0);
  text( "#", x+20, y );
  text( "fins", x+70, y );
  text( "x", x+105, y );
  text( "y", x+205, y );
  text( "dy", x+305, y );
  fill(0);
  for (int i=0; i<many; i++) {
    y += 15;    // Next line.
    text( i, x, y );
    text( a[i].num, x+20, y );
    text( a[i].fins, x+70, y );
    text( a[i].x, x+100, y );
    text( a[i].y, x+200, y );
    text( a[i].dy, x+300, y );
  }
}








//// OBJECTS
class Tuna {
  // PROPERTIES:  position, speed, etc.
  float x=100, y=100, dx=3, dy=2;
  float w=60,h=30;
  float r=255, g=255, b=200;
  int fins=1;
  int num;
  String name="";
  
  // CONSTRUCTOR
  Tuna( int n, float x ) {
    num=  n;
    this.x=  x;
    y=  random( surface,height );
    // Random colors
    r=  random( 0, 255 );
    g=  random( 0, 255 );
    b=  random( 0, 255 );
    // Random colors
    fins=  int( random( 2, 9 ) );
  }
  Tuna( ) { }    // Default constructor.
  
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
    text( name, x-w/3,y+10 );
    if (fins>1) text( fins, x-w/4,y );
  }
  void move() {
    fill(0);
    x += dx;
    y += dy;
    if (x>width) x=0;
  }
  //// True if (xx,yy) is near me.
  boolean hit( float xx, float yy ) {
    if (dist(xx,yy, this.x,this.y) < w) return true;
    else return false;
  }
}

