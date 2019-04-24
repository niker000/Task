package Task_3;

public class Triangle {
    final private String name;
    final private double side1;
    final private double side2;
    final private double side3;
    final private double area;

    public Triangle(String name, double side1, double side2, double side3) {
        this.name = name;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.area = CalculateTriangleArea();
    }

    public double getArea() {
        return area;
    }

    public String getName() {
        return name;
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    private double CalculateTriangleArea() {
        double p = (this.side1 + this.side2 + this.side3) / 2;

        return Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
    }

    @Override

    public String toString() {
        return "Triangle{" +
                "name='" + name + '\'' +
                ", area=" + area +
                '}';
    }
}
