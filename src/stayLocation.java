public interface stayLocation {
    void stayDetails(String place , int roomNo);
    void changePlace(String place);
    void changeRoom(int room);
}

class StayInHostel implements stayLocation{

    String hostelName;
    int roomNo;
    @Override
    public void stayDetails(String hostelName , int roomNo) {
        this.hostelName= hostelName;
        this.roomNo = roomNo;
    }

    @Override
    public void changePlace(String place) {
        this.hostelName = place;
    }

    @Override
    public void changeRoom(int room) {
        this.roomNo = room;
    }
    public String toString(){
        return "hostel name : "+hostelName +"\n"+"hostel room no :"+roomNo;
    }
}
class StayInHouse implements stayLocation{

    String city ;
    int doorno;
    @Override
    public void stayDetails(String city , int doorno) {
        this.city = city;
        this.doorno = doorno;
    }

    @Override
    public void changePlace(String place) {
     this.city = place;
    }

    @Override
    public void changeRoom(int room) {
    this.doorno = room;
    }
    public String toString(){
        return "city name : "+city +"\n"+"door no :"+doorno;
    }
}