package Domains;

import java.io.Serializable;

public class Point implements Serializable {
    private final double X;
    private final double Y;

    public Point(double X,double Y)
    {
        this.X = X;
        this.Y = Y;
    }

    public double getX()
    {
        return X;
    }

    public double getY()
    {
        return Y;
    }

}
