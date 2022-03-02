

enum Direction{
    EAST,WEST,SOUTH,NORTH
}
public class Example{
    public static void main(String[] args) {
    
            Direction[] arr = Direction.values();

            for (Direction direction : arr){
                System.out.println(direction);
            }
    }
}