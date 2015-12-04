//// Array practice #1.

int[] a=  { 99, 44, 72, 15, -3, 177, 0, 9, 47, 9 };
int many=  a.length;
float x=10, y=20;

size( 400,300 );
background( 255);
fill(0);

for( int i=0; i<many; i++ ) {
  text( a[i], x, y );
  y += 15;
}

int total=0;
for( int i=0; i<many; i++ ) {
  total += a[i];
}
y += 30;
text( "TOTAL:  "+total, x, y );

float avg=  float(total) / many;
y += 30;
text( "MEAN AVERAGE:  "+avg, x, y );

y += 30;
text( "How to find the median?", x, y );


