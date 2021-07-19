package cn.com.java.experiment;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass extends JFrame {
    private JPanel contentPanel;
    private JTextField genderText;
    private JTextField weightText;
    private JTextField heightText;
    private JTextField BMIText;
    private JTextField tipText;
    public MainClass() {
        setTitle("体重指数计算器");
        setFont(new Font("楷体", Font.PLAIN,16));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 400, 450, 300);
        this.setLocationRelativeTo(null);
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        JLabel genderLabel = new JLabel("性别:");
        genderLabel.setHorizontalAlignment(SwingConstants.CENTER);
        genderLabel.setFont(new Font("楷体",Font.PLAIN,16));
        genderLabel.setBounds(138,13,72,18);
        contentPanel.add(genderLabel);
        JLabel weightLabel = new JLabel("体重(kg):");
        weightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        weightLabel.setFont(new Font("楷体",Font.PLAIN,16));
        weightLabel.setBounds(126,110,72,18);
        contentPanel.add(weightLabel);
        JLabel heightLabel = new JLabel("身高(m):");
        heightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        heightLabel.setFont(new Font("楷体",Font.PLAIN,16));
        heightLabel.setBounds(114,62,96,18);
        contentPanel.add(heightLabel);
        JLabel BMILabel = new JLabel("体质指数(BMI):");
        BMILabel.setHorizontalAlignment(SwingConstants.CENTER);
        BMILabel.setFont(new Font("楷体",Font.PLAIN,16));
        BMILabel.setBounds(68,186,142,18);
        contentPanel.add(BMILabel);
        JLabel tipLabel = new JLabel("提示:");
        tipLabel.setHorizontalAlignment(SwingConstants.CENTER);
        tipLabel.setFont(new Font("楷体",Font.PLAIN,16));
        tipLabel.setBounds(149,217,53,18);
        contentPanel.add(tipLabel);

        genderText = new JTextField();
        genderText.setHorizontalAlignment(SwingConstants.CENTER);
        genderText.setFont(new Font("楷体",Font.PLAIN,16));
        genderText.setBounds(212,10,86,24);
        genderText.setColumns(10);//设置文本段列数
        contentPanel.add(genderText);
        heightText = new JTextField();
        heightText.setHorizontalAlignment(SwingConstants.CENTER);
        heightText.setFont(new Font("楷体",Font.PLAIN,16));
        heightText.setBounds(212,59,86,24);
        heightText.setColumns(10);
        contentPanel.add(heightText);
        weightText = new JTextField();
        weightText.setHorizontalAlignment(SwingConstants.CENTER);
        weightText.setFont(new Font("楷体",Font.PLAIN,16));
        weightText.setBounds(212,108,86,24);
        weightText.setColumns(10);
        contentPanel.add(weightText);
        BMIText = new JTextField();
        BMIText.setHorizontalAlignment(SwingConstants.CENTER);
        BMIText.setFont(new Font("楷体",Font.PLAIN,16));
        BMIText.setEditable(false);
        BMIText.setBounds(212,185,86,24);
        BMIText.setColumns(10);
        contentPanel.add(BMIText);
        tipText = new JTextField(SwingConstants.CENTER);
        tipText.setFont(new Font("楷体",Font.PLAIN,16));
        tipText.setHorizontalAlignment(SwingConstants.CENTER);
        tipText.setBounds(212,215,200,24);
        tipText.setColumns(10);
        tipText.setEditable(false);
        contentPanel.add(tipText);

        JButton calculateButton = new JButton("计算");
        calculateButton.setFont(new Font("楷体",Font.PLAIN,16));
        calculateButton.setBounds(153,145,113,27);
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BMI person = new BMI(genderText.getText(),Double.parseDouble(heightText.getText()),Double.parseDouble(weightText.getText()));
                BMIText.setText(String.format("%.2f",person.BMICount()));
                tipText.setText(tips(person.BMICount()));
            }
        });
        contentPanel.add(calculateButton);
    }

    public static String tips(double BMI) {
        if(BMI < 18.5)
            return "体重偏轻，应当适当增重。";
        else if(BMI < 24)
            return "体重正常，请保持！";
        else if(BMI < 28)
            return "体重偏重，应当继续适当锻炼！";
        else {
            return "肥胖，应当养成健康饮食习惯并坚持锻炼！";
        }
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    MainClass mainClass = new MainClass();
                    mainClass.setVisible(true);
                }catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        });
    }
}
