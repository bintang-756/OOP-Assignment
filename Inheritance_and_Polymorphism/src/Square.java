public class Square extends Shape {
    private double side;

    public Square(double side, String color) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }

    @Override
    public void printInfo() {
        System.out.println("Square colored " + color + ", area = " + area());
    }

    @Override
    public void printDetails() {
        System.out.println("Shape   : Square");
        System.out.println("Color  : " + color);
        System.out.println("Side   : " + side);
        System.out.println("Area   : " + area());
    }
}
