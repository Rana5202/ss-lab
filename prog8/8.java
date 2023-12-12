import java.util.*;
public class Banker
{
static int safe[]=new int[20];
static boolean safety(int a[],int al[][],int need[][],int n1,int m1)
{
int n=n1;
int m=m1;
int nd[][]=new int[n][m];
int work[]=new int[m];
int all[][]=new int[n][m];
for(int i=0;i<m;i++)
work[i]=a[i];
for(int i=0;i<n;i++)
for(int j=0;j<m;j++)
all[i][j]=al[i][j];
for(int i=0;i<n;i++)
for(int j=0;j<m;j++)
nd[i][j]=need[i][j];
boolean fin[]=new boolean[n];
for(int i=0;i<n;i++)
fin[i]=false;
int check=0;
int check1=0;
do
{
for(int i=0;i<n;i++)
{
boolean flag=true;
if(fin[i]==false)
{
for(int j=0;j<m;j++)
{
if(work[j]<nd[i][j])
flag=false;
}
if(flag)
{
for(int j=0;j<m;j++)
work[j]+=all[i][j];
safe[check]=i;
check++;
fin[i]=true;
}
}
}
check1++;
}
while(check<n && check1<n);
if(check>n)
return false;
else
return true;
}
public static void main(String[] args)
{
Scanner sc=new Scanner(System.in);
int n,m;
System.out.println("enter no. of processes:");
n=sc.nextInt();
System.out.println("enter no. of resources:");
m=sc.nextInt();
int a[]=new int[m];
for(int i=0;i<m;i++)
{
System.out.println("enter no. of available instances resources:"+i);
a[i]=sc.nextInt();
}
System.out.println("enter allocation of resources:");
int al[][]=new int[n][m];
for(int i=0;i<n;i++)
for(int j=0;j<m;j++)
{
System.out.println("enter allocation instances of resources:"+j+"for process p"+i);
al[i][j]=sc.nextInt();
}
System.out.println("enter maximum of resources:");
int max[][]=new int[n][m];
for(int i=0;i<n;i++)
for(int j=0;j<m;j++)
{
System.out.println("enter max instances of resources:"+j+"for process p"+i);
max[i][j]=sc.nextInt();
}
int need[][]=new int[n][m];
for(int i=0;i<n;i++)
for(int j=0;j<m;j++){
need[i][j]=max[i][j]-al[i][j];
}
if(safety(a,al,need,n,m))
{
System.out.println("System in Safe State");
System.out.println("System's Safe sequence:");
for(int i=0;i<n;i++)
System.out.print("p"+safe[i]+"\t");
}
else
System.out.println("System in UnSafe State");
}
}
