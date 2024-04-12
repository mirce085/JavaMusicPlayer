import javax.swing.*;
import java.awt.*;


public class MainWindow extends JFrame {

    public MainWindow(){
        setTitle("MJ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLocationRelativeTo(null);


        JPanel mainTopPanel = new JPanel();
        mainTopPanel.setLayout(new BoxLayout(mainTopPanel, BoxLayout.X_AXIS));

        JPanel mainBottomPanel = new JPanel();


        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setPreferredSize(new Dimension(10, 200));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        JButton btn = new JButton("Add File");
        btn.setBackground(Color.CYAN);
        leftPanel.add(btn);

        DefaultListModel<Song> listModel = new DefaultListModel<>();
        JList<Song> list = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(list);
        leftPanel.add(scrollPane);


        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.GREEN);
        bottomPanel.setPreferredSize(new Dimension(100, 150));
        rightPanel.add(bottomPanel);


        mainTopPanel.add(leftPanel);
        mainTopPanel.add(rightPanel);


        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.add(mainTopPanel);
        contentPane.add(mainBottomPanel);

        this.setVisible(true);
    }
}
