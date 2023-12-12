import java.util.Scanner;
public class RoundRobin
{
public static void main(String[] args)
{
int i,j,n,time,x,counter=0,time_quantum;
int wait_time=0,turnaround_time=0;
Scanner sn=new Scanner(System.in);
int[] at = new int[20];
int[] bt = new int[20];
int[] rt = new int[20];
System.out.println("Enter Total Process:\t ");
n=sn.nextInt();
x=n;
for(i=0;i<n;i++)
{
System.out.println("Enter Arrival Time for Process");
at[i]=sn.nextInt();
System.out.println("Enter burst time of process "+i);
bt[i]=sn.nextInt();
rt[i]=bt[i];
}
System.out.println("Enter Time Quantum:\t");
time_quantum=sn.nextInt();
System.out.println("\n\nProcess\t|Turnaround Time|Waiting Time");
for(time=0,i=0;x!=0;)
{
if(rt[i]<=time_quantum && rt[i]>0)
{
time+=rt[i];
rt[i]=0;
counter=1;
}
else if(rt[i]>0)
{
rt[i]-=time_quantum;
time+=time_quantum;
}
if(rt[i]==0 && counter==1)
{
x--;
System.out.print("process"+i+"\t");
System.out.print(time-at[i]+"\t");
System.out.print("\t");
System.out.print(time-at[i]-bt[i]);
System.out.println("\t");
wait_time+=time-at[i]-bt[i];
turnaround_time+=time-at[i];
counter=0;
}
if(i==n-1)
i=0;
else if(at[i+1]<=time)
i++;
else
i=0;
}
System.out.println("\n Average Waiting Time="+wait_time*1.0/n);
System.out.println("Average Turnaround Time ="+turnaround_time*1.0/n);
}
}