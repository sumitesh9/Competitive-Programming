import java.util.Scanner;
class Messi 
{
   public static void main( String[] args )
    {   
      Scanner S=new Scanner(System.in);
      
      int T = S.nextInt();
      
      for( int i=0;i<T;i++)
      {
         int a=S.nextInt();
         int b=S.nextInt();
         int c=S.nextInt();
         int x=S.nextInt();
         int y=S.nextInt();
         
         int t;
         if (x<y)
          {
            t=x;
          }
         else 
         {
            t=y;
         }
         
         if((a+b+c)!=(x+y))
          {
            System.out.println( "NO" );
         }
         else if( t<a&&t<b&&t<c)
          {
            System.out.println( "NO" );
         }
         else {
            System.out.println( "YES");
         }
      }
   }
} 