package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Valkyrja on 27.02.2016.
 */

public class PointTests {

    @Test
    public void testDistance() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 4);
        assert p1.distance(p2) == 5.0;
    }

    @Test
    public void testDistance1() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Assert.assertEquals(p1.distance(p2), 1.0);
    }

    @Test
    public void testDistance2() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(-3, -4);
        Assert.assertEquals(p1.distance(p2), 5.0);
    }


}
