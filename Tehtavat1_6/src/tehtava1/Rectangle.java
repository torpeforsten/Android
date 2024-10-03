package tehtava1;

import java.util.Scanner;

class Rectangle {
    private double width;
    private double height;

    public void InputDimensions(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the width of the rectangle: ");
        this.width = scanner.nextDouble();
        System.out.println("Enter the height of the rectangle: ");
        this.height = scanner.nextDouble();
    }
    public double CalculateArea(){
        return width * height;
    }
    public Void PrintDimensionsAndArea(){
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
        System.out.println("Area: " + CalculateArea());
        return null;
    }
}
