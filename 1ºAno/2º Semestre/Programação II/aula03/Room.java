public class Room {

    private String roomType;
    private Point topRight, bottomLeft;

    public Room(Point topRight, Point bottomLeft, String roomType) {
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.roomType = roomType;
    }

    public String roomType() {
        return roomType;
    }

    public Point topRight() {
        return topRight;
    }

    public Point bottomLeft() {
        return bottomLeft;
    }

    public double area() {
        return (topRight.x() - bottomLeft.x()) * (topRight.y() - bottomLeft.y());
    }

    public Point geoCenter(){
        return new Point((topRight.x()+bottomLeft.x())/2,(topRight.y()+bottomLeft.y())/2);

    }
}
