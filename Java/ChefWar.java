import java.util.*;
import java.io.*;
class ChefWar
{
    public static void main (String args[])throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0)
        {
            int n=Integer.parseInt(br.readLine());
            LinkedList<Integer> l=new LinkedList<Integer>();
            String str[]=br.readLine().split(" ");
            
            for(int i=0;i<n-1;i++)
            l.add(Integer.parseInt(str[i]));
            
            int f=Integer.parseInt(br.readLine());
            int temp,flag=0,index=0;
            LinkedList<Integer> ll=new LinkedList<Integer>();
            for(int i=0;i<n-1;i++)
            {
                temp=l.get(i);
                if(temp<=f)
                {
                    flag++;
                    ll.add(i);
                }
            }
            if(flag==0)
            System.out.println("impossible");
            else if(flag!=0)
            {
                long minimumd=99999999,minimump=0;
                int k,j,le,ri;
                long d;
                for(int i=0;i<flag;i++)
                {
                    LinkedList<Integer> copy=new LinkedList<Integer>(l);
                    index=ll.get(i);
                    copy.add(index,0);
                    j=index-1;
                    k=0;
                    d=0;
                    while(true)
                     {
                     index=copy.indexOf(0);
                     le=index;
                     ri=copy.size()-le-1;
                     if((le==0)&&(ri==1))
                      break;
                      if((ri%2==0)&&(le%2==0))
                      {
                          for(k=le-1;k>=1;k-=2)
                          copy.remove(k);
                          int s1=copy.indexOf(0);
                          int s2=copy.size();
                          for(k=s2-1;k>s1;k-=2)
                          copy.remove(k);
                        }
                      else if((ri%2==0)&&(le%2==1))
                      {
                          if(index!=0)
                          d=d+copy.get(index-1);
                          else
                          d=d+copy.getLast();
                          if(le!=1)
                          {
                          for(k=le-2;k>=1;k-=2)
                          copy.remove(k);
                          }
                          int s1=copy.indexOf(0);
                          int s2=copy.size();
                          for(k=s2-1;k>s1;k-=2)
                          copy.remove(k);
                        }
                      else if((ri%2==1)&&(le%2==0))
                      {   
                          for(k=le-1;k>=1;k-=2)
                          {
                              copy.remove(k);
                          }
                          int s1=copy.indexOf(0);
                          int s2=copy.size();
                          if(ri!=1)
                          {
                          for(k=s2-2;k>s1;k-=2)
                          copy.remove(k);
                          }
                          if(s1!=0)
                          copy.remove(0);
                          else
                          d=d+copy.getLast();
                        }
                      else if((ri%2==1)&&(le%2==1))
                      {
                          if(index!=0)
                          d=d+copy.get(index-1);
                          else
                          d=d+copy.getLast();
                          if(le!=1)
                          {
                          for(k=le-2;k>=1;k-=2)
                          copy.remove(k);
                          }
                          int s1=copy.indexOf(0);
                          int s2=copy.size();
                          if(ri!=1)
                          {
                          for(k=s2-2;k>s1;k-=2)
                          copy.remove(k);
                          }
                          if(s1!=0)
                          copy.remove(0);
                          else
                          d=d+copy.getLast();
                        }
                      }
                      d+=f;
                      if(d<minimumd)
                      {
                          minimumd=d;
                          minimump=ll.get(i)+1;
                      }
                    }
                    System.out.println("possible");
                    System.out.println(minimump+" "+minimumd);
            }
        }
    }
}