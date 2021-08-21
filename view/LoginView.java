package mau2.view;

import mau2.entity.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JTextField userNameField;
    private JButton loginBtn;
    public LoginView(){
        initComponents();
    }
    private void initComponents(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        userNameLabel = new JLabel("UserName");
        passwordLabel = new JLabel("Password");
        userNameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginBtn = new JButton();
        loginBtn.setText("Login");
        loginBtn.addActionListener(this);
        // tao spring layout
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        // tao doi tuong panel de chua cac thanh phan cua man hinh login
        panel.setSize(400,300);
        panel.setLayout(layout);
        panel.add(userNameLabel);
        panel.add(passwordLabel);
        panel.add(userNameField);
        panel.add(passwordField);
        panel.add(loginBtn);
        // cai dat vi tri thanh phan tren man hinh login
        layout.putConstraint(SpringLayout.WEST,userNameLabel,20,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,userNameLabel,80,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST,passwordLabel,20,SpringLayout.WEST,panel);
        layout.putConstraint(SpringLayout.NORTH,passwordLabel,105,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST,userNameField,80,SpringLayout.WEST,userNameLabel);
        layout.putConstraint(SpringLayout.NORTH,userNameField,80,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST,passwordField,80,SpringLayout.WEST,passwordLabel);
        layout.putConstraint(SpringLayout.NORTH,passwordField,105,SpringLayout.NORTH,panel);
        layout.putConstraint(SpringLayout.WEST,loginBtn,80,SpringLayout.WEST,passwordLabel);
        layout.putConstraint(SpringLayout.NORTH,loginBtn,130,SpringLayout.NORTH,panel);
        // add panel toi jframe
        this.add(panel);
        this.pack();
        // cai dat thuoc tinh cho JFrame
        this.setTitle("Login");
        this.setSize(400,300);
        this.setResizable(false);

    }
    public  void showMessage(String message){
        JOptionPane.showMessageDialog(this, message);
    }
    public User getUser(){
        return new User(userNameField.getText(),String.copyValueOf(passwordField.getPassword()));
    }
    public void actionPerformed(ActionEvent e){

    }
    public void addLoginListener (ActionListener listener){
        loginBtn.addActionListener(listener);
    }
}
