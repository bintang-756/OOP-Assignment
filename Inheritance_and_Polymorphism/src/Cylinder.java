public class Cylinder extends Circle {
    private double height;

    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // volume = luas lingkaran (area) x tinggi
    public double volume() {
        return area() * height;
    }

    @Override
    public void printInfo() {
        System.out.println("Cylinder " + color + ", volume = " + volume());
    }

    @Override
    public void printDetails() {
        System.out.println("Shape   : Cylinder");
        System.out.println("Color  : " + color);
        System.out.println("Area   : " + area());
        System.out.println("Radius : " + radius);
        System.out.println("Height : " + height);
        System.out.println("Volume : " + volume());
    }
}