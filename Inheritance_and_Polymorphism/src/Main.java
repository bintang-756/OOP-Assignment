import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Polymorphism: onecl list of type Shape holds different subclass objects
        ArrayList<Shape> shapes = new ArrayList<>();
        int choice;

        do {
            showMenu();
            choice = readInt("Choose menu: ");
            System.out.println();

            switch (choice) {
                case 1:
                    double side = readDouble("Enter side   : ");
                    String squareColor = readString("Enter color  : ");
                    Shape square = new Square(side, squareColor);
                    shapes.add(square);
                    System.out.println("\nSquare created successfully.");
                    square.printInfo();
                    break;

                case 2:
                    double radius = readDouble("Enter radius : ");
                    String circleColor = readString("Enter color  : ");
                    Shape circle = new Circle(radius, circleColor);
                    shapes.add(circle);
                    System.out.println("\nCircle created successfully.");
                    circle.printInfo();
                    break;

                case 3:
                    double height = readDouble("Enter height : ");
                    double cylRadius = readDouble("Enter radius : ");
                    String cylColor = readString("Enter color  : ");
                    Shape cylinder = new Cylinder(height, cylRadius, cylColor);
                    shapes.add(cylinder);
                    System.out.println("\nCylinder created successfully.");
                    cylinder.printInfo();
                    break;

                case 4:
                    if (shapes.isEmpty()) {
                        System.out.println("No shapes have been created yet.");
                    } else {
                        System.out.println("=== All Shapes ===");
                        int no = 1;
                        for (Shape s : shapes) {
                            System.out.println("--- Shape #" + no++ + " ---");
                            s.printDetails(); // polymorphism: otomatis sesuai jenis objeknya
                            System.out.println();
                        }
                    }
                    break;

                case 0:
                    System.out.println("Thank you, program finished.");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
            System.out.println();
        } while (choice != 0);
    }

    private static void showMenu() {
        System.out.println("===== SHAPE MENU =====");
        System.out.println("1. Square");
        System.out.println("2. Circle");
        System.out.println("3. Cylinder");
        System.out.println("4. Show all shapes");
        System.out.println("0. Exit");
        System.out.println("======================");
    }

    private static String readString(String message) {
        System.out.print(message);
        return input.nextLine().trim();
    }

    private static int readInt(String message) {
        while (true) {
            try {
                return Integer.parseInt(readString(message));
            } catch (NumberFormatException e) {
                System.out.println("Input must be a whole number.");
            }
        }
    }

    private static double readDouble(String message) {
        while (true) {
            try {
                double value = Double.parseDouble(readString(message).replace(',', '.'));
                if (value > 0) return value;
                System.out.println("Value must be greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number.");
            }
        }
    }
}