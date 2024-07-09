public class House {
    private String roomType;
    private Room rooms[];
    private int addDivision;

    public House(String roomType) {
        this.roomType = roomType;
        rooms = new Room[8];
        addDivision = 4;
    }

    public House(String roomType, int nDivisões, int addDivision) {
        this.roomType = roomType;
        rooms = new Room[nDivisões];
        this.addDivision = addDivision;

    }
    public void addRoom(Room divisão){
        for(int i = 0; i < rooms.length; i++){
            rooms[i] = divisão;
        }
    }
    public int size(){
        for(int i = 0; i < rooms.length; i++){
            if (rooms[i] == null){
                return i;
            }
        }
        return rooms.length;
    }
    public int maxSize(){
        return rooms.length;
    }
    public Room room(int a) {
        return rooms[a];

    }
    public double area(){
        double soma = 0;
        for(int i = 0; i < rooms.length; i++){
            soma += rooms[i].area();
        }
        return soma;
    }
    
}
