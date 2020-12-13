import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class Window extends JFrame{


    public Window(){
        setTitle("Window");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JMenuBar menuButton = new JMenuBar();
        menuButton.add(createFile());
        menuButton.add(createSketchMenu());
        menuButton.add(create3Dmodel());
        setJMenuBar(menuButton);
        setBounds(300, 300, 400, 400);
        setVisible(true);
    }

    private JMenu createSketchMenu(){
        JMenu sketch = new JMenu("Эскиз");
        JMenuItem line = new JMenuItem("Отрезок");
        line.setIcon(new ImageIcon(" picture/line.png"));
        sketch.add(line);
        line.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println ("ActionListener.actionPerformed : line");
                JFrame frame = new JFrame("Paint");
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                JPanel panel = new PaintPanel();
                frame.add(panel);

                frame.pack();
                frame.setVisible(true);
            }
        });
        return sketch;
    }

    private JMenu create3Dmodel(){
        JMenu model = new JMenu("Модель");
        return model;
    }

    private JMenu createFile(){
        JMenu file = new JMenu("Файл");
        return file;
    }
}