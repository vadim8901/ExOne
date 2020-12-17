import javax.swing.*;
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
                //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                JPanel panel = new PaintPanel();
                frame.add(panel);

                frame.pack();
                frame.setVisible(true);
            }
        });
        return sketch;
    }

    private JMenu create3Dmodel(){
        JMenu models = new JMenu("Модели");
        JMenuItem model = new JMenuItem("3DМодели");
        models.add(model);
        model.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("ActionListener.actionPerformed : model");
                ModelWindow modelWindow = new ModelWindow();
            }
        });
        return models;
    }

    private JMenu createFile(){
        JMenu files = new JMenu("Файл");
        JMenuItem file = new JMenuItem("Открыть файл");
        files.add(file);
        file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("ActionListener.actionPerformed : file");
                FileWindow fileWindow = new FileWindow();
            }
        });
        return files;
    }
}