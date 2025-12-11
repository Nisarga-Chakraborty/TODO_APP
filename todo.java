import javax.swing.*;
import java.awt.*;

public class todo extends JFrame {
    int i = 1;
    private JPanel taskPanel;

    public todo() {
        setTitle("TO DO APP");
        setSize(600, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.black);
        setLocationRelativeTo(null);
        setResizable(false);

        addToolBar();
        addHeading();
        addTaskInput();
        addScrollableTaskPanel();
    }

    public void addHeading() {
        JLabel titleLabel = new JLabel("TO DO APP ", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        titleLabel.setForeground(Color.white);
        titleLabel.setBackground(new Color(20, 35, 56));
        titleLabel.setOpaque(true);
        titleLabel.setBounds(0, 35, 600, 50);
        titleLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.yellow));
        add(titleLabel);
    }

    public void addTaskInput() {
        JLabel taskLabel = new JLabel("Tasks");
        taskLabel.setFont(new Font("Arial", Font.ITALIC, 20));
        taskLabel.setForeground(Color.white);
        taskLabel.setBackground(Color.black);
        taskLabel.setOpaque(true);
        taskLabel.setBounds(50, 100, 60, 30);

        JButton clearButton = new JButton("Clear All");
        clearButton.setFont(new Font("Arial", Font.BOLD, 16));
        clearButton.setForeground(Color.black);
        clearButton.setBackground(Color.white);
        clearButton.setBounds(440, 100, 100, 30);
        clearButton.addActionListener(e -> {
            taskPanel.removeAll();
            taskPanel.revalidate();
            taskPanel.repaint();
            i = 1;
        });

        add(taskLabel);
        add(clearButton);
    }

    public void addToolBar() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.black);

        JMenuItem addItem = new JMenuItem("Add Task");
        addItem.setFont(new Font("Arial", Font.PLAIN, 16));
        addItem.setForeground(Color.white);
        addItem.setBackground(Color.black);
        addItem.setOpaque(true);
        addItem.addActionListener(e -> {
            if (i <= 6) {
                addTask(i);
                i++;
            } else {
                JOptionPane.showMessageDialog(this, "You can only add up to 6 tasks.", "Limit Reached",
                        JOptionPane.WARNING_MESSAGE);
            }
        });

        menuBar.add(addItem);
        setJMenuBar(menuBar);
    }

    public void addScrollableTaskPanel() {
        taskPanel = new JPanel();
        taskPanel.setLayout(new BoxLayout(taskPanel, BoxLayout.Y_AXIS));
        taskPanel.setBackground(Color.black);

        JScrollPane scrollPane = new JScrollPane(taskPanel);
        scrollPane.setBounds(0, 150, 600, 500);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scrollPane);
    }

    public void addTask(int index) {
        JPanel taskContainer = new JPanel(null);
        taskContainer.setPreferredSize(new Dimension(580, 80));
        taskContainer.setBackground(Color.black);

        JLabel label = new JLabel(index + ":");
        label.setFont(new Font("Arial", Font.PLAIN, 18));
        label.setForeground(Color.white);
        label.setBounds(10, 10, 80, 30);

        JTextField text = new JTextField();
        text.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        text.setBounds(90, 10, 360, 30);

        JButton delete = new JButton("Delete");
        delete.setFont(new Font("Arial", Font.PLAIN, 16));
        delete.setBounds(460, 10, 100, 30);
        delete.setBackground(Color.white);
        delete.setForeground(Color.black);
        delete.addActionListener(e -> {
            taskPanel.remove(taskContainer);
            taskPanel.revalidate();
            taskPanel.repaint();
        });

        taskContainer.add(label);
        taskContainer.add(text);
        taskContainer.add(delete);
        taskPanel.add(taskContainer);

        taskPanel.revalidate();
        taskPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            todo app = new todo();
            app.setVisible(true);
        });
    }
}
