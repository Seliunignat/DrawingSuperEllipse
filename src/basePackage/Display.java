package basePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import static java.lang.Math.*;

public class Display extends JPanel
{
    private BasicStroke ellipseStroke;

    public Display()
    {
        setBackground(Color.WHITE);
        ellipseStroke = new BasicStroke(10.0F, 0, 0, 10.0F, (float[])null, 0.0F);
    }

    public void paintComponent(Graphics g)
    {
        Color ellipseColor = new Color(68, 126, 193);
        GeneralPath ellipse = new GeneralPath();
        Graphics2D canvas = (Graphics2D) g;
        canvas.setColor(ellipseColor.darker());
        canvas.setStroke(ellipseStroke);

        double x, y;
        Point2D.Double center = new Point2D.Double(getWidth()/2, getHeight()/2);
        int r = 200;
        double a = 1, b = 0.85;
        for(double angle = 0; angle <= 2 * PI; angle += 0.01*PI)
        {
            x = a * r*Math.cos(angle) + center.getX();
            y = b * r*Math.sin(angle) + center.getY();
            if(angle == 0) ellipse.moveTo(x, y);
            ellipse.lineTo(x, y);
        }

        canvas.draw(ellipse);
        canvas.setPaint(ellipseColor);
        canvas.fill(ellipse);
    }
}
