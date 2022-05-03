
class Address{
    String doorNo;
    String street;
    String city;
    String state;
    Address(String doorNo,String street,String city,String state){
        this.doorNo=doorNo;
        this.state=state;
        this.street=street;
        this.city=city;
    }
    public String toString(){
        return  "*******ADDRESS*******"+
                "\n"+"Door number : "+doorNo+
                "\n"+"street Name : "+street+
                "\n"+"city Name   : "+city+
                "\n"+"state       : "+state+
                "\n"+"********************";
    }
}


