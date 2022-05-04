import java.util.HashMap;
import java.util.Map;
import java.util.Set;

final class Validation {
    final private String email1="vtu15892@veltech.edu.in";
    final private String password1="abc@1";
    final private String email2="vtu15893@veltech.edu.in";
    final private String password2="abc@12";
    final private String email3="vtu15894@veltech.edu.in";
    final private String password3="abc@123";
    final private String email4="vtu15895@veltech.edu.in";
    final private String password4="abc@1234";
    final private String email5="vtu15896@veltech.edu.in";
    final private String password5="abc@12345";
    private Map<String,String> storingCredentials=new HashMap<>();
    final private String authorization="5656";
    Validation()
    {
        storingCredentials.put(email1,password1);
        storingCredentials.put(email2,password2);
        storingCredentials.put(email3,password3);
        storingCredentials.put(email4,password4);
        storingCredentials.put(email5,password5);
    }
    Set<String> keys=storingCredentials.keySet();
    public int login(String email,String password) {
        for(String key:keys) {
            if(key.equals(email) && storingCredentials.get(key).equals(password)) {
                return 1;
            }
        }
        return 0;
    }
    public Map<String,String> getLhs(){
        return storingCredentials;
    }
    public String getAuthorization(){
        return authorization;
    }
}
class CheckDuplication
{
    Validation validation = new Validation();
    Set<String> keys=validation.getLhs().keySet();
    public boolean checkDupliaction(String email)
    {
        for(String key:keys)
        {
            if(key.equals(email))
            {
                return true;
            }
        }
        return false;
    }
}
class AddCredentials{
    Validation validation = new Validation();
    public void addCredentials(String email , String password)
    {
        validation.getLhs().put(email,password);
    }
}
class CheckAuthorization{
    Validation validation = new Validation();
    public int checkAuthorization(String updateAuthorization)
    {
        if(updateAuthorization.equals(validation.getAuthorization())){return 1;}else{return 0;}
    }
}