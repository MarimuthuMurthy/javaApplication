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
    private Map<String,String> lhs=new HashMap<>();
    final private String authorization="5656";
    Validation()
    {
        lhs.put(email1,password1);
        lhs.put(email2,password2);
        lhs.put(email3,password3);
        lhs.put(email4,password4);
        lhs.put(email5,password5);
    }
    public void addCredentials(String email , String password)
    {
        lhs.put(email,password);
    }
    Set<String> keys=lhs.keySet();
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
    public int checkCredentials(String email,String password)
    {
        for(String key:keys)
        {
            if(key.equals(email) && lhs.get(key).equals(password))
            {
                return 1;
            }
        }
        return 0;
    }
    public int checkAuthorization(String updateAuthorization)
    {
        if(updateAuthorization.equals(authorization)){return 1;}else{return 0;}
    }
}