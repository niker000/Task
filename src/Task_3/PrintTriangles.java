package Task_3;

import Utils.PrintHelper;

import java.util.Collection;

public class PrintTriangles {
    public static void printTriangles(Collection<Triangle> triangles) {
        for(Triangle triangle : triangles) {
            PrintHelper.print(triangle.toString());
        }
    }
}
