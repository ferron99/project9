//// Array practice #2.

int many=14;
int[] a=  new int[many];
int[] b=  new int[many];

float x=10, y=20;          // Test position
int step=18;

void setup() {
  size( 800,600 );
  reset();
  textSize( 16 );
}
void reset() {
   for( int i=0; i<many; i++ ) {
    a[i]=  int( random(1,100) );
    b[i]=  int( random(1,100) );
  }
}

void draw() { 
  background( 255,255,200);
  fill(0);
  
  text( "r key to reset array values.", 
      width/2, 10 );
  y=20;

  show( a, many );
  calc( a, many );
}
void show( int[] a, int many ) {
  // Show the array.  
  fill( 250,0,250 );      // Labels color.
  text( "i", x, y );
  text( "a[i]", x+30, y );
  text( "b[i]", x+130, y );
  y += step;
  // Data
  fill(0);
  for( int i=0; i<many; i++ ) {
    text( i, x, y );
    text( a[i], x+30, y );
    text( b[i], x+130, y );
    y += step;
  }
}

void calc( int a[], int many ) {
  
  int total=0;
  for( int i=0; i<many; i++ ) {
    total += a[i];
  }
  
  y += step*2;
  text( "TOTAL for a[]:  "+total, x, y );
  float avg=  float(total) / many;
  y += 30;
  text( "MEAN AVERAGE of a[]:  "+avg, x, y );
  
  y += step*2;
  int mm;
  int median;
  text( "many:  "+many, 200,y );
  if (many % 2 >0)   {
    mm=  many/2;
    median=  a[mm];
    text( mm, 200,y+step );
  }else{
    //// Mean of many/2 and many/2 - 1 
    median=  ( a[many/2] + a[many/2 - 1] ) / 2;
    text( many/2-1, 200,y+step );
    text( many/2, 200,y+2*step );
  }

  text( "MEDIAN a[]:  "+median, x, y );
}

//// Handlers.
void keyPressed() {
  if (key == 'r') reset();
  if (key == 'a') {
    sortInt( a, many );
  }
  if (key == 'b') {
    sortInt( b, many );
  }
  if (key == 's') {
    sortInt( a, many );
    sortInt( b, many );
  }
}

// Sort an integer array.
void sortInt( int a[], int many ) {
  // Shrink the array.
  for( int m=many; m>1; m-- ) {
    //// Move biggest to end.
    // Set k such that a[k] IS biggest 
    int k=0;
    for( int j=1; j<m; j++) { 
          if (a[j] > a[k]) k=  j;
    }
    // k now points to biggest 
    swap( a, m-1, k);
  }
}

void swap( int[] a, int j, int k ) {
  int tmp;
  tmp=  a[j];
  a[j]=  a[k];
  a[k]=  tmp;
}



