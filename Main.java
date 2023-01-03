import java.util.Scanner;
  import java.util.*;
 public class Main {
  public static void main(String [] args)
 {
         // CODE SKELETON - VALIDATION STARTS
         // DO NOT CHANGE THIS CODE

         new SkeletonValidator();

         // CODE SKELETON - VALIDATION ENDS

         Scanner sc=new Scanner(System.in);
         System.out.println("Enter the number of entries");
         int n=sc.nextInt();
         System.out.println("Enter the Participant Name/Yearofstudy/Department/CollegeName/EventName");
                List<Participant> list=new ArrayList<Participant>();
         String strlist[]=new String[n];
         for(int i=0;i<n;i++)
             {
             strlist[i]=sc.next();
             String a[]=strlist[i].split("/");
             Participant pt=new Participant(a[0],a[1],a[2],a[3],a[4]);
             list.add(pt);
            }
         EventManagement em=new EventManagement();
         try {
             em.calculateRegistrationFee(list);
            }
         catch(InvalidEventException e)
         {
             System.out.println("Caught");

             // Print the message from MyException object
             System.out.println(e.getMessage());
         }

         System.out.println("Print participant details");
         for(Participant p:list)
             {
             System.out.println(p);
             }
         System.out.println("Enter the event to search");
        String summa=sc.nextLine();
         String srch=sc.nextLine();
         em.setSearchEvent(srch);
         em.run();
         int count=em.getCounter();
         if(count<=0){
             System.out.println("No participant found");

             }
         else{
             System.out.println("Number of participants for "+srch+" event is "+count); }
         }
 }
