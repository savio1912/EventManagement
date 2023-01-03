public class Participant {
  private String name;
  private String yearofstudy;
 private String department;
  private String collegeName;
  private String eventName;
  private double registrationFee;

          //5 argument Constructor
          public Participant(String name, String yearofstudy, String department, String collegeName, String
            eventName) {
         super();
         this.name = name;
        this.yearofstudy = yearofstudy;
        this.department = department;
        this.collegeName = collegeName;
         this.eventName = eventName;
         }

          public String getName() {
        return name;
        }
 public void setName(String name) {
        this.name = name;
        }
  public String getYearofstudy() {
        return yearofstudy;
        }
 public void setYearofstudy(String yearofstudy) {
        this.yearofstudy = yearofstudy;
         }
  public String getDepartment() {
        return department;
        }
  public void setDepartment(String department) {
         this.department = department;
         }
 public String getCollegeName() {
         return collegeName;
         }
 public void setCollegeName(String collegeName) {
         this.collegeName = collegeName;
         }
  public String getEventName() {
        return eventName;
         }
  public void setEventName(String eventName) {
         this.eventName = eventName;
         }
 public double getRegistrationFee() {
         return registrationFee;
         }
  public void setRegistrationFee(double registrationFee) {
         this.registrationFee = registrationFee;
         }

          @Override
 public String toString() {
         return "Participant [name=" + name + ", yearofstudy=" + yearofstudy + ", department=" +
                department
         + ", collegeName=" + collegeName + ", eventName=" +
                eventName + ", registrationFee=" + registrationFee
         + "]";
        }

          }