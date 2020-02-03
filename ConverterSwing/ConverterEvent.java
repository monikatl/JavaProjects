import java.awt.event.*;

public class ConverterEvent implements Runnable, ActionListener, ItemListener{

    ConverterMain gui;
    Thread convert;
    Converter converter = new FahrenheitConverter();

    public ConverterEvent(ConverterMain in) {
        gui = in;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String command = actionEvent.getActionCommand();
        if (command.equals("Konwertuj")) {
            startConvert();
        }
        if (command.equals("Wyczysc")) {
            reset();
        }
    }

    void startConvert() {
        convert = new Thread(this);
        convert.start();
    }

    void reset() {
        gui.input.setValue(0.0);
        gui.resultNumberLabel.setText("32.0");
        gui.resultLabel.setText("°F");
        gui.inputLabel.setText("°C");
        gui.celsjuszToF.setSelected(true);
    }

    @Override
    public void itemStateChanged(ItemEvent itemEvent) {
        Object item = itemEvent.getItem();
        if (item == gui.fahrenheitToC) {
            new CelsiusConverter();
            gui.inputLabel.setText("°F");
            gui.resultLabel.setText("°C");
            celsiusz();
            startConvert();
        }
        if (item == gui.celsjuszToF) {
            new FahrenheitConverter();
            gui.inputLabel.setText("°C");
            gui.resultLabel.setText("°F");
            fahrenheit();
            startConvert();
        }
    }

    private Converter celsiusz() {
        return converter = new CelsiusConverter();
    }

    private Converter fahrenheit() {
        return converter = new FahrenheitConverter();
    }

    @Override
    public void run() {
            double in = (double) gui.input.getValue();
            double result = converter.convert(in);
            gui.resultNumberLabel.setText(String.valueOf(result));
    }
}

