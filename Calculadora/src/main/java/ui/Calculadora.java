package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora {

    private JFrame frame;
    private JTextField textField;
    private String operator = "";
    private double num1, num2, result;
    
    private JComboBox<String> comboFiguras;
    private JButton btnCalcularArea;
    private JTextField input1, input2, input3;
    private JLabel labelInput1, labelInput2, labelInput3;

    public Calculadora() {
        frame = new JFrame("Calculadora Estándar");
        textField = new JTextField();

        // Creando botones
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("8");
        JButton btn9 = new JButton("9");
        JButton btn0 = new JButton("0");
        JButton btnAdd = new JButton("+");
        JButton btnSub = new JButton("-");
        JButton btnMul = new JButton("*");
        JButton btnDiv = new JButton("/");
        JButton btnEqual = new JButton("=");
        JButton btnClear = new JButton("C");

        // Lugar de los componentes
        textField.setBounds(30, 40, 280, 30);
        btn7.setBounds(40, 100, 50, 40);
        btn8.setBounds(110, 100, 50, 40);
        btn9.setBounds(180, 100, 50, 40);
        btnDiv.setBounds(250, 100, 50, 40);
        btn4.setBounds(40, 170, 50, 40);
        btn5.setBounds(110, 170, 50, 40);
        btn6.setBounds(180, 170, 50, 40);
        btnMul.setBounds(250, 170, 50, 40);
        btn1.setBounds(40, 240, 50, 40);
        btn2.setBounds(110, 240, 50, 40);
        btn3.setBounds(180, 240, 50, 40);
        btnSub.setBounds(250, 240, 50, 40);
        btn0.setBounds(110, 310, 50, 40);
        btnAdd.setBounds(250, 310, 50, 40);
        btnEqual.setBounds(180, 310, 50, 40);
        btnClear.setBounds(40, 310, 50, 40);

        // Acciones de los botones
        btn1.addActionListener(e -> textField.setText(textField.getText() + "1"));
        btn2.addActionListener(e -> textField.setText(textField.getText() + "2"));
        btn3.addActionListener(e -> textField.setText(textField.getText() + "3"));
        btn4.addActionListener(e -> textField.setText(textField.getText() + "4"));
        btn5.addActionListener(e -> textField.setText(textField.getText() + "5"));
        btn6.addActionListener(e -> textField.setText(textField.getText() + "6"));
        btn7.addActionListener(e -> textField.setText(textField.getText() + "7"));
        btn8.addActionListener(e -> textField.setText(textField.getText() + "8"));
        btn9.addActionListener(e -> textField.setText(textField.getText() + "9"));
        btn0.addActionListener(e -> textField.setText(textField.getText() + "0"));
        btnAdd.addActionListener(e -> {
            num1 = Double.parseDouble(textField.getText());
            operator = "+";
            textField.setText("");
        });
        btnSub.addActionListener(e -> {
            num1 = Double.parseDouble(textField.getText());
            operator = "-";
            textField.setText("");
        });
        btnMul.addActionListener(e -> {
            num1 = Double.parseDouble(textField.getText());
            operator = "*";
            textField.setText("");
        });
        btnDiv.addActionListener(e -> {
            num1 = Double.parseDouble(textField.getText());
            operator = "/";
            textField.setText("");
        });
        btnEqual.addActionListener(e -> {
            num2 = Double.parseDouble(textField.getText());
            switch (operator) {
                case "+":
                    result = logic.Operaciones.sumar(num1, num2);
                    break;
                case "-":
                    result = logic.Operaciones.restar(num1, num2);
                    break;
                case "*":
                    result = logic.Operaciones.multiplicar(num1, num2);
                    break;
                case "/":
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(frame, "No se puede dividir por cero", "Error", JOptionPane.ERROR_MESSAGE);
                        textField.setText("");
                        return;
                    }
                    result = logic.Operaciones.dividir(num1, num2);
                    break;
            }
            textField.setText(String.valueOf(result));
            operator = "";
        });
        comboFiguras = new JComboBox<>(new String[]{
                "Selecciona una figura", "Cuadrado", "Círculo", "Triángulo", "Rectángulo", 
                "Pentágono", "Rombo", "Romboide", "Trapecio"
            });
            comboFiguras.setBounds(380, 40, 150, 30);
            comboFiguras.addActionListener(e -> updateInputsForFigure());

            btnCalcularArea = new JButton("Calcular Área");
            btnCalcularArea.setBounds(380, 240, 150, 40);
            btnCalcularArea.addActionListener(e -> calculateArea());

            labelInput1 = new JLabel();
            labelInput1.setBounds(380, 80, 150, 20);
            input1 = new JTextField();
            input1.setBounds(380, 100, 150, 30);

            labelInput2 = new JLabel();
            labelInput2.setBounds(380, 140, 150, 20);
            input2 = new JTextField();
            input2.setBounds(380, 160, 150, 30);

            labelInput3 = new JLabel();
            labelInput3.setBounds(380, 200, 150, 20);
            input3 = new JTextField();
            input3.setBounds(380, 220, 150, 30);
        btnClear.addActionListener(e -> textField.setText(""));

        // Añado componentes al frame
        frame.add(textField);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(btn3);
        frame.add(btn4);
        frame.add(btn5);
        frame.add(btn6);
        frame.add(btn7);
        frame.add(btn8);
        frame.add(btn9);
        frame.add(btn0);
        frame.add(btnAdd);
        frame.add(btnSub);
        frame.add(btnMul);
        frame.add(btnDiv);
        frame.add(btnEqual);
        frame.add(btnClear);

        frame.setLayout(null);
        frame.setSize(350, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        frame.add(comboFiguras);
        frame.add(btnCalcularArea);
        frame.add(labelInput1);
        frame.add(input1);
        frame.add(labelInput2);
        frame.add(input2);
        frame.add(labelInput3);
        frame.add(input3);
        frame.setLayout(null);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    
    private void updateInputsForFigure() {
        switch (comboFiguras.getSelectedIndex()) {
            case 1:
                labelInput1.setText("Lado:");
                labelInput1.setVisible(true);
                input1.setVisible(true);
                labelInput2.setVisible(false);
                input2.setVisible(false);
                labelInput3.setVisible(false);
                input3.setVisible(false);
                break;
            case 2:
                labelInput1.setText("Radio:");
                labelInput1.setVisible(true);
                input1.setVisible(true);
                labelInput2.setVisible(false);
                input2.setVisible(false);
                labelInput3.setVisible(false);
                input3.setVisible(false);
                break;
            default:
                labelInput1.setVisible(false);
                input1.setVisible(false);
                labelInput2.setVisible(false);
                input2.setVisible(false);
                labelInput3.setVisible(false);
                input3.setVisible(false);
                break;
        }
    }
    
    private void calculateArea() {
        Geometria geo = new Geometria(comboFiguras.getSelectedIndex());
        double area = 0;
        switch (comboFiguras.getSelectedIndex()) {
            case 1:
                area = geo.areacuadrado(Integer.parseInt(input1.getText()));
                break;
            case 2:
                area = geo.areaCirculo(Integer.parseInt(input1.getText()));
            case 3:
                area = geo.areatriangulo(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()));
                break;
            case 4: 
                area = geo.arearectangulo(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()));
                break;
            case 5:
                area = geo.areapentagono(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()));
                break;
            case 6:
                area = geo.arearombo(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()));
                break;
            case 7:
                area = geo.arearomboide(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()));
                break;
            case 8:
                area = geo.areatrapecio(Integer.parseInt(input1.getText()), Integer.parseInt(input2.getText()), Integer.parseInt(input3.getText()));
                break;
            default:
                JOptionPane.showMessageDialog(frame, "Por favor, selecciona una figura válida.");
                return;
        }
        textField.setText(String.format("Área de %s: %.2f", geo.getNom(), area));
    }
    
    
    public static void main(String[] args) {
    	new Calculadora();
    }
}