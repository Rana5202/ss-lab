import java.util.Scanner;
public class ShortestRemainingTime
{
public static void main(String[] args)
{
int i,n,smallest, count=0,time=0;
float avg=0,tt=0,end;
int[] a = new int[20];
int[] b = new int[20];
int[] x = new int[20];
int[] at = new int[20];
int[] pid = new int[20];
Scanner sn=new Scanner(System.in);
System.out.println("enter the number of processes:");
n=sn.nextInt();
for(i=0;i<n;i++)
{
System.out.println("Enter Arrival Time for Process :"+i);
a[i]=sn.nextInt();
}
for(i=0;i<n;i++)
{
System.out.println("Enter burst Time for Process :"+i);
b[i]=sn.nextInt();
}
for(i=0;i<n;i++)
x[i]=b[i];
b[9]=9999;
for(time=0;count!=n;time++)
{
smallest=9;
for(i=0;i<n;i++)
{
if(a[i]<=time && b[i]<b[smallest] && b[i]>0)
smallest=i;
} // end of for loop
b[smallest]--;
if(b[smallest]==0)
{
count++;
end=time+1;
avg=avg+end-a[smallest]-x[smallest];
tt=tt+end-a[smallest];
}
}
// end of outer for loop
System.out.println("\n average waiting time = "+avg/n);
System.out.format("average turn around time= %.2f",tt/n);
}
}