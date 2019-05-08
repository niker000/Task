package task3;

import utils.PrintHelper;
import utils.UserHelper;

import java.io.IOException;
import java.util.ArrayList;

public class TriangleMain {
    public static void main(String[] args) {
        triangleRun();
    }

    public static void triangleRun() {
        TriangleComparator triangleComparator = new TriangleComparator();
        ArrayList<Triangle> triangles = new ArrayList<>();
        try {
            do {
                PrintHelper.print("Enter the parameters of the triangle");
                triangles.add(TriangleCreator.getTriangleFromParameters(UserHelper.enterData()));
                PrintHelper.print("Do you want to continue?");
            } while (UserHelper.isContinue());
        } catch (NumberFormatException nfe) {
            PrintHelper.print("Invalid parameter");
        } catch (IOException ioe) {
            PrintHelper.print("something went wrong while entering numbers");
        } catch (IllegalArgumentException iae) {
            PrintHelper.print(iae.getMessage());
        }
        triangles.sort(triangleComparator);
        PrintTriangles.printTriangles(triangles);
    }
}
