import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ConverterMain extends JFrame {

    ConverterEvent myConverter = new ConverterEvent(this);

    JPanel choicePanel = new JPanel();
    ButtonGroup choice = new ButtonGroup();
    JCheckBox fahrenheitToC = new JCheckBox("Fahrenheit do Celsjusz", false);
    JCheckBox celsjuszToF = new JCheckBox("Celsjusz do Fahrenheit", true);

    JPanel inputResultPanel = new JPanel();
    JSpinner input = new JSpinner(new SpinnerNumberModel(0.0, -495.0, 1000.00, 0.1));
    JLabel inputLabel = new JLabel("°C");
    JLabel equalLabel = new JLabel(" = ");
    JLabel resultNumberLabel = new JLabel("32.0");
    JLabel resultLabel = new JLabel("°F");

    JPanel convertPanel = new JPanel();
    JButton convert = new JButton("Konwertuj");
    JButton reset = new JButton("Wyczysc");

    public ConverterMain (){
        super("Konwerter temperatury");

        setSize(400, 200);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout layout = new GridLayout(4, 1);
        setLayout(layout);

        fahrenheitToC.addItemListener(myConverter);
        celsjuszToF.addItemListener(myConverter);
        input.addChangeListener(changeEvent -> myConverter.startConvert());
        convert.addActionListener(myConverter);
        reset.addActionListener(myConverter);
        reset.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                if (pressEnter(keyEvent)) {
                    myConverter.reset();
                }
            }
        });

        FlowLayout layout1 = new FlowLayout(FlowLayout.CENTER, 10, 10);
        choice.add(fahrenheitToC);
        choice.add(celsjuszToF);
        choicePanel.setLayout(layout1);
        choicePanel.add(fahrenheitToC);
        choicePanel.add(celsjuszToF);
        add(choicePanel);

        inputResultPanel.setLayout(layout1);
        inputResultPanel.add(input);
        inputResultPanel.add(inputLabel);
        inputResultPanel.add(equalLabel);
        inputResultPanel.add(resultNumberLabel);
        inputResultPanel.add(resultLabel);
        add(inputResultPanel);

        convertPanel.setLayout(layout1);
        convertPanel.add(convert);
        convertPanel.add(reset);
        add(convertPanel);

        setVisible(true);
    }

    private boolean pressEnter(KeyEvent keyEvent){
        if (keyEvent.getKeyCode() == KeyEvent.VK_ENTER) {
            return true;
        }
        return false;
    }

    private static void setLookAndFeel(){
        try{
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception e){

        }
    }

    public static void main(String[] args) {
        ConverterMain.setLookAndFeel();
        new ConverterMain();
    }
}
