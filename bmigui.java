/*
 * You may want to look into inheriting from the JFrame class to have a GUI class.
 */


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BmiGui { // casing is weird because of the double abbrv. but still use PascalCase.

    public static String calculateBMI(double mass, double height) {
        double BMI = mass / (height * height);

        long BMIrounded = Math.round(BMI);

        String returnStr = "Your BMI is " + BMIrounded + ". You are ";

        if (BMI < 18.5) {
            returnStr += "Underweight";
        } else if (BMI < 24.9){
            returnStr += "Normal weight";
        } else if (BMI < 29.9){
            returnStr += "Overweight";
        } else {
            returnStr += "Obese";
        }
        return returnStr;
    }

    public static void main(String[] args){
        JFrame j = new JFrame(); // you might want to use a more descriptive var. name like "frame"

        JLabel startLabel = new JLabel("Calculate Your BMI");
        startLabel.setBounds(50, 50, 300, 40);
        j.add(startLabel);

        JLabel massLabel = new JLabel("Your mass (kg):");
        massLabel.setBounds(50, 100, 200, 40);
        j.add(massLabel);

        JTextField massField = new JTextField(20);
        massField.setBounds(50,150,300,40);
        j.add(massField);

        JLabel heightLabel = new JLabel("Your height (m):");
        heightLabel.setBounds(50, 200, 200, 40);
        j.add(heightLabel);

        JTextField heightField = new JTextField(20);
        heightField.setBounds(50,250,300,40);
        j.add(heightField);

        JButton calc = new JButton("calculate");
        calc.setBounds(50, 300, 300, 40);
        calc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String height_str = heightField.getText();
                String mass_str = massField.getText();

                double height = Double.parseDouble(height_str);
                double mass = Double.parseDouble(mass_str);

                String returnStr = calculateBMI(mass, height);

                startLabel.setText(returnStr);
            }
        });

        j.add(calc);

        j.setSize(400,400);

        // try to use a layout manager instead of hardcoding locations for the elements.
        // this makes it possible to resize the window and keep sensible layout and positioning
        j.setLayout(null);
        j.setVisible(true);
    }
}
