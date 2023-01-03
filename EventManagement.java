import java.util.List;

         public class EventManagement implements Runnable {
  private List<Participant> TechList;
  private String searchEvent;
  private int counter=0;
  public List<Participant>getTechList()
  {
         return TechList;

         }
  public void setTechList(List<Participant>techList)
  {
  TechList=techList;
  }
 public String getSearchEvent()
 {
        return searchEvent;
 }
  public void setSearchEvent(String searchEvent)
  {
        this.searchEvent=searchEvent;
         }
  public int getCounter()
  {
        return counter;
        }
 public void setCounter(int counter)
  {
        this.counter=counter;
        }
 //FILL THE CODE HERE

         public void calculateRegistrationFee(List<Participant> list) throws InvalidEventException

         {
             setTechList(list);
        for(Participant p:list)
             {
            if(p.getEventName().equalsIgnoreCase("robocar"))
                {
                 p.setRegistrationFee(1000);
                }
            else if(p.getEventName().equalsIgnoreCase("papertalk")){
                 p.setRegistrationFee(500);

                 }

             else if(p.getEventName().equalsIgnoreCase("quiz")){
                 p.setRegistrationFee(300);
                }
             else if(p.getEventName().equalsIgnoreCase("games")){
                 p.setRegistrationFee(100);
                 }
            else{
                    throw new InvalidEventException("Event Name is Invalid");

                 }
            }
        //FILL THE CODE HERE

        }
          public void run()
  {
         String str="robocarpapertalkquizgames";
         if(str.contains(this.getSearchEvent())){
             for(Participant P:this.TechList){
                if(this.getSearchEvent().equals(P.getEventName())){
                    counter++;
                     }
                 }
            }
         setCounter(counter);

        //FILL THE CODE HERE

        }
  }
