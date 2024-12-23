
package ui;

import utils.CurrencyUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverterUI {
    public static void createAndShowUI() {
        JFrame frame = new JFrame("Currency Converter: USD to IDR");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        JLabel labelInput = new JLabel("Masukan Jumlah Dalam USD:");
        JTextField textFieldInput = new JTextField();

        JLabel labelResult = new JLabel("Hasil dalam IDR:");
        JTextField textFieldResult = new JTextField();
        textFieldResult.setEditable(false);

        JButton buttonConvert = new JButton("Convert");

        String[] columnNames = {"USD", "IDR"};
        JTable table = new JTable(new DefaultTableModel(columnNames, 0));
        JScrollPane scrollPane = new JScrollPane(table);

        buttonConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double usd = Double.parseDouble(textFieldInput.getText());
                    double idr = CurrencyUtils.convertUsdToIdr(usd);
                    textFieldResult.setText(String.format("%.2f", idr));
                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.addRow(new Object[]{usd, idr});
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Tolong masukan angka yang valid.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        inputPanel.add(labelInput);
        inputPanel.add(textFieldInput);
        inputPanel.add(labelResult);
        inputPanel.add(textFieldResult);
        inputPanel.add(new JLabel());
        inputPanel.add(buttonConvert);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
