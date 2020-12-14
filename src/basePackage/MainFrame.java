package basePackage;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame
{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private Display display = new Display();

    public MainFrame()
    {
        super("Рисуем");
        setSize(WIDTH, HEIGHT);
        Toolkit kit = Toolkit.getDefaultToolkit();
        // Отцентрировать окно приложения на экране
        setLocation((kit.getScreenSize().width - WIDTH)/2,
                (kit.getScreenSize().height - HEIGHT)/2);
        // Развѐртывание окна на весь экран
        //setExtendedState(MAXIMIZED_BOTH);

        getContentPane().add(display, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // write your code here
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
