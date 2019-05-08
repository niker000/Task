package task3;

import utils.PrintHelper;

import java.util.Collection;

public class PrintTriangles {
    public static void printTriangles(Collection<Triangle> triangles) {
        for(Triangle triangle : triangles) {
            PrintHelper.print(triangle.toString());
        }
    }
}
