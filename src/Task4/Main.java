package Task4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape>shapes=new ArrayList<>();
        shapes.add(new Circle(3));
        shapes.add(new Rectangle(4,7));
        shapes.add(new Triangle(5,6));
        shapes.add(new Square(4));

        shapes.stream().map(Shape::area).sorted().forEach(System.out::println);
    }
}
