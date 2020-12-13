import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Window extends JFrame{

    public Window(){
        setTitle("Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JMenuBar menuButton = new JMenuBar();
        menuButton.add(createSketchMenu());
        setJMenuBar(menuButton);
        setBounds(300, 300, 400, 400);
        setVisible(true);
    }

    private JMenu createSketchMenu(){
        JMenu sketch = new JMenu("Эскиз");
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("picture/line.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        JLabel img = new JLabel(new ImageIcon(image));
        JMenuItem line = new JMenuItem("Отрезок");
        sketch.add(line);
        sketch.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("ActionListener.actionPerformed : sketch");
            }
        });
        return sketch;
    }
}
