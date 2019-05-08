package task3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriangleTest {
    @Test
    public void getArea() {
        Triangle triangle = new Triangle("triangle", 2, 3, 4 );
        assertEquals(2.9047375096555625, triangle.getArea(),0);
    }

    @Test
    public void getName() {
        Triangle triangle = new Triangle("triangle", 2, 3, 4 );
        assertEquals("triangle", triangle.getName());
    }

    @Test
    public void getSide1() {
        Triangle triangle = new Triangle("triangle", 2, 3, 4 );
        assertEquals(2, triangle.getSide1(),0);
    }

    @Test
    public void getSide2() {
        Triangle triangle = new Triangle("triangle", 2, 3, 4 );
        assertEquals(3, triangle.getSide2(),0);
    }

    @Test
    public void getSide3() {
        Triangle triangle = new Triangle("triangle", 2, 3, 4 );
        assertEquals(4, triangle.getSide3(),0);
    }
}