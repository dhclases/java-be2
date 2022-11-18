package m5methods;

public class ReturnEarly {

    private boolean systemIsUp;

    // Before
    public String getPersonalInfo(Person person, int pin){
        if (systemIsUp){
            if (person != null && person.getName().equals("")){
                if(person.getPin() != pin){
                    return  "Invalid pin";
                }
                return "Invalid Name";
            }
            return "System is down at the moment";
        }
        return person.getPersonalInfo();
    }


    // After
    public String getPersonalInfo2(Person person, int pin){

        if(!systemIsUp) return "System is down at the moment";

        if(person != null && person.getName().equals("")) return "Invalid Name";

        if(person.getPin() != pin) return "Invalid pin";

        return person.getPersonalInfo();
    }
}
