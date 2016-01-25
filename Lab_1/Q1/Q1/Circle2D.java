package Q1;

/**
 * Created by KanzakiMirai on 1/11/16.
 */

/**
 * A basic class for a 2-dimensions circle, provide simple
 * functions to calculate some value of a circle.
 *
 * The coordinate of the circle is (x, y)
 *
 * @author Diqi Zeng
 */
public class
        Circle2D {
    protected double x;
    protected double y;
    protected double radius;

    /**
     * the getter of X
     * @return the value of X
     */
    public double getX() {
        return x;
    }

    /**
     * set the coordinate X of the circle.
     * any double value is ok, no need to check anything
     *
     * @param x the expected X value
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * the getter of Y
     * @return the value of Y
     */
    public double getY() {
        return y;
    }

    /**
     * set the coordinate Y of the circle.
     * any double value is ok, no need to check anything
     *
     * @param y the expected Y value
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * the getter of radius
     * @return the value of radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * set the radius of the circle.
     * any positive value and ZERO is valid
     *
     * @param radius the expected radius value
     * @exception RuntimeException (with description)
     */
    public void setRadius(double radius) {
        if (radius < 0) {
            throw new RuntimeException("Radius cannot less than 0");
        }
        else {
            this.radius = radius;
        }
    }

    /**
     * default constructor
     */
    public Circle2D() {
        this(0, 0);
    }

    /**
     * init a circle with a expected coordinate (x, y)
     * @param x the initial coordinate X value
     * @param y the initial coordinate Y value
     */
    public Circle2D(double x, double y) {
        this.x = x;
        this.y = y;
        this.radius = 1;
    }

    /**
     * calculate the area of the circle
     * USING formula Pi * R^2
     *
     * @return the area of the circle
     */
    double getArea() {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }

    /**
     * calculate the perimater of the circle
     * USING formula 2 * Pi * R
     *
     * @return the perimeter of the circle
     */
    double getPerimeter() {
        return 2 * Math.PI * this.getRadius();
    }

    /**
     * check a point is inside a circle
     *
     * USING formula:
     *      For a circle with coordinate (a, b), given a point (x, y)
     *      if (x - a)^2 + (y - b)^2 < 0, which means that the point is INSIDE the circle
     *
     * @param x the X coordinate of the point which needs to be checked
     * @param y the Y coordinate of the point which needs to be checked
     * @return TRUE if point is inside the circle, vice versa
     */
    boolean contains(double x, double y) {
        double result = Math.pow(x - this.getX(), 2) + Math.pow(y - this.getY(), 2);
        return result < 1;
    }

    /**
     * check another circle if it is inside this circle
     *
     * USING formula:
     *      circle2 with radius r2 is inside circle1 with radius r1 if the distance between
     *      the two centers <= |r1-r2|
     *
     * @param circle another object of circle for calculating
     * @return TRUE if another circle is inside this circle, vice versa
     */
    boolean contains(Circle2D circle) {
        /**
         * the distance of two centers of circles
         */
        double distanceCenters = Math.sqrt(Math.pow(this.getX() - circle.getX(), 2) +
                Math.pow(this.getY() - circle.getY(), 2));
        /**
         * APPLYING THE FORMULA
         */
        return distanceCenters <= Math.abs(this.getRadius() - circle.getRadius());
    }

    /**
     * check another circle if it is overlapping this circle
     *
     * USING formula:
     *      circle2 overlaps
     *      circle1 if the distance between the two centers <= r1+r2
     *
     * @param circle another object of circle for calculating
     * @return TRUE if another circle is inside this circle, vice versa
     */
    boolean overlaps(Circle2D circle) {
        /**
         * the distance of two centers of circles
         */
        double distanceCenters = Math.sqrt(Math.pow(this.getX() - circle.getX(), 2) +
                Math.pow(this.getY() - circle.getY(), 2));
        /**
         * APPLYING THE FORMULA
         */
        return distanceCenters <= this.getRadius() + circle.getRadius();
    }
}