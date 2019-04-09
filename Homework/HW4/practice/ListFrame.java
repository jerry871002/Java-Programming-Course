import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

class ListFrame extends JFrame {
    private final JList<String> colorJList;
    private static final String[] colorNames = {"Black", "Blue", "Green", "Red", "Yellow"};
    private static final Color[] colors = {Color.BLACK, Color.BLUE, Color.GREEN, Color.RED, Color.YELLOW};

    public ListFrame() {
        super("List Test");
        setLayout(new FlowLayout());

        colorJList = new JList<String>(colorNames);
        colorJList.setVisibleRowCount(5);

        colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(new JScrollPane(colorJList));

        colorJList.addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent event) {
                    getContentPane().setBackground(colors[colorJList.getSelectedIndex()]);
                }
            }
        );
    }
}
