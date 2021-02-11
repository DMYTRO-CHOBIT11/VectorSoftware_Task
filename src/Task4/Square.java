package Task4;

public class Square extends Shape{
    private double side;

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double area() {
        return side*side;
    }
}
