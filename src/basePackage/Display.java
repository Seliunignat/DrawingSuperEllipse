package basePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import static java.lang.Math.*;

public class Display extends JPanel
{
    private BasicStroke ellipseStroke;
    private double n;

    public Display()
    {
        setBackground(Color.WHITE);
        ellipseStroke = new BasicStroke(8.0F, 0, 0, 10.0F, (float[])null, 0.0F);
        n = 0.5;
    }

    public void paintComponent(Graphics g)
    {
        double a = 200, b = 200;
        int r = 200;
        //n = 4;
        Point2D.Double center = new Point2D.Double(getWidth()/2, getHeight()/2);
        /*Color ellipseColor = new Color(68, 126, 193);
        GeneralPath ellipse = ellipse(a, b, r, center);
        Graphics2D canvas = (Graphics2D) g;
        canvas.setColor(ellipseColor.darker());
        canvas.setStroke(ellipseStroke);
        canvas.draw(ellipse);
        canvas.setPaint(ellipseColor);
        canvas.fill(ellipse);*/
        Color ellipseColor = new Color(68, 126, 193);
        Graphics2D canvas = (Graphics2D) g;
        canvas.setColor(ellipseColor.darker());
        canvas.setStroke(ellipseStroke);
        GeneralPath superEllipse = superEllipse(a, b, n, center);
        canvas.draw(superEllipse);
        canvas.setPaint(ellipseColor);
        canvas.fill(superEllipse);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private GeneralPath ellipse(double a, double b, int r, Point2D.Double center)
    {
        GeneralPath ellipse = new GeneralPath();
        double x, y;
        //Point2D.Double center = new Point2D.Double(getWidth()/2, getHeight()/2);
        //int r = 200;
        //double a = a, b = 0.85;
        for(double angle = 0; angle <= 2 * PI; angle += 0.01*PI)
        {
            x = a * r *Math.cos(angle) + center.getX();
            y = b * r *Math.sin(angle) + center.getY();
            if(angle == 0) ellipse.moveTo(x, y);
            ellipse.lineTo(x, y);
        }
        return ellipse;
    }

    private GeneralPath superEllipse(double a, double b, double n, Point2D.Double center)
    {
        GeneralPath superEllipse = new GeneralPath();
        double x, y;
        for(double angle = 0; angle <= 2*PI; angle += 0.01*PI)
        {
            x = a * pow(abs(cos(angle)), 2/n) *sgn(cos(angle)) + center.getX();
            y = b * pow(abs(sin(angle)), 2/n) *sgn(sin(angle)) + center.getY();
            if(angle == 0) superEllipse.moveTo(x, y);
            superEllipse.lineTo(x, y);
        }
        return superEllipse;
    }

    private int sgn(double value)
    {
        if(value < 0)
            return -1;
        else if(value == 0)
            return 0;
        else if(value > 0)
            return 1;
        return 0;
    }

    public double getN() {
        return n;
    }

    public void setN(double n) {
        this.n = n;
    }
}
