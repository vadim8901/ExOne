import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaintPanel extends JPanel {
    private static final int DEFAULT_WIDTH = 800;
    private static final int DEFAULT_HEIGHT = 800;
    private static final Color BACK_COLOR = Color.WHITE;

    private int x1, y1, x2, y2;
    private Graphics g;

    PaintPanel() {

        setBackground(BACK_COLOR);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

        MyMouseHandler handler = new MyMouseHandler();

        this.addMouseListener(handler);
        this.addMouseMotionListener(handler);
    }

    private class MyMouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();

            System.out.println("x: " + x1 + " y: " + y1);

            g = getGraphics();

            x2 = x1;
            y2 = y1;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            x1 = e.getX();
            y1 = e.getY();

            g.drawLine(x1, y1, x2, y2);

            x2 = x1;
            y2 = y1;


        }
    }
}
