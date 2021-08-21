package mau2.view;


import mau2.entity.Student;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JButton addStudentBtn;
    private JButton editStudentBtn;
    private JButton deleteStudentBtn;
    private JButton clearBtn;
    private JButton sortStudentByGPA;
    private JButton sortStudentByName;
    private JScrollPane jScrollPaneStudentTable;
    private JScrollPane jScrollPaneAddress;
    private JTable studentTable;

    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel addressLabel;
    private JLabel gpaLabel;

    private JTextField idField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextArea addressTA;
    private JTextField gpaField;
    // dinh nghia cac cot cua bang student
    private String [] columnNames = new String[]{
            "ID", "Name", "Age", "Address", "GPA"
    };
    private Object data = new Object [][]{};
    public StudentView(){
        initComponents();
    }
    private void initComponents(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khoi tao cac phim chusc nawng
        addStudentBtn = new JButton("Add");
        editStudentBtn = new JButton("Edit");
        deleteStudentBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        sortStudentByGPA = new JButton("Sort By GPA");
        sortStudentByName = new JButton("Sort By Name");
        // khoi tao bang student
        jScrollPaneStudentTable = new JScrollPane();
        studentTable = new JTable();
        // khoi tao cac label
        idLabel = new JLabel("Id");
        nameLabel = new JLabel("Name");
        ageLabel = new JLabel("Age");
        addressLabel = new JLabel("Address");
        gpaLabel = new JLabel("GPA");
        // khoi tao cac truong nhap du lieu
        idField = new JTextField(6);
        nameField = new JTextField(15);
        ageField = new JTextField(6);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(5);
        jScrollPaneAddress = new JScrollPane();
        jScrollPaneAddress.setViewportView(addressTA);
        gpaField = new JTextField(6);
        // cai dat cac cot va data cho bang student
        studentTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneStudentTable.setViewportView(studentTable);
        jScrollPaneStudentTable.setPreferredSize(new Dimension(480,300));
        // tao spring layout
        SpringLayout layout = new SpringLayout();
        // tao doi tuong panel de chua cac thanh phan cua man hinh quan li Student
        JPanel panel = new JPanel();
        panel.setSize(800,420);
        panel.setLayout(layout);
        panel.add(jScrollPaneStudentTable);

        panel.add(addStudentBtn);
        panel.add(editStudentBtn);
        panel.add(deleteStudentBtn);
        panel.add(clearBtn);
        panel.add(sortStudentByGPA);
        panel.add(sortStudentByName);

        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(ageLabel);
        panel.add(addressLabel);
        panel.add(gpaLabel);

        panel.add(idField);
        panel.add(nameField);
        panel.add(ageField);
        panel.add(jScrollPaneAddress);
        panel.add(gpaField);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gpaLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gpaLabel, 200, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ageField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ageField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gpaField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gpaField, 200, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneStudentTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneStudentTable, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addStudentBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addStudentBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editStudentBtn, 60, SpringLayout.WEST, addStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, editStudentBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteStudentBtn, 60, SpringLayout.WEST, editStudentBtn);

        layout.putConstraint(SpringLayout.NORTH, clearBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteStudentBtn);

        layout.putConstraint(SpringLayout.NORTH, deleteStudentBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortStudentByGPA, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortStudentByGPA, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortStudentByName, 115, SpringLayout.WEST, sortStudentByGPA);
        layout.putConstraint(SpringLayout.NORTH, sortStudentByName, 330, SpringLayout.NORTH, panel);

        this.add(panel);
        this.pack();
        this.setTitle("Student Information");
        this.setSize(800, 420);
        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    public void showListStudents(ArrayList<Student> list) {
        int size = list.size();
        // với bảng studentTable có 5 cột,
        // khởi tạo mảng 2 chiều students, trong đó:
        // số hàng: là kích thước của list student
        // số cột: là 5
        Object [][] students = new Object[size][5];
        for (int i = 0; i < size; i++) {
            students[i][0] = list.get(i).getId();
            students[i][1] = list.get(i).getName();
            students[i][2] = list.get(i).getAge();
            students[i][3] = list.get(i).getAddress();
            students[i][4] = list.get(i).getGpa();
        }
        studentTable.setModel(new DefaultTableModel(students, columnNames));
    }

    /**
     * điền thông tin của hàng được chọn từ bảng student
     * vào các trường tương ứng của student.
     */
    public void fillStudentFromSelectedRow() {
        // lấy chỉ số của hàng được chọn
        int row = studentTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(studentTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(studentTable.getModel().getValueAt(row, 1).toString());
            ageField.setText(studentTable.getModel().getValueAt(row, 2).toString());
            addressTA.setText(studentTable.getModel().getValueAt(row, 3).toString());
            gpaField.setText(studentTable.getModel().getValueAt(row, 4).toString());
            // enable Edit and Delete buttons
            editStudentBtn.setEnabled(true);
            deleteStudentBtn.setEnabled(true);
            // disable Add button
            addStudentBtn.setEnabled(false);
        }
    }
    public void clearStudentInfo() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        addressTA.setText("");
        gpaField.setText("");
        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }
    public void showStudent(Student student) {
        idField.setText("" + student.getId());
        nameField.setText(student.getName());
        ageField.setText("" + student.getAge());
        addressTA.setText(student.getAddress());
        gpaField.setText("" + student.getGpa());
        // enable Edit and Delete buttons
        editStudentBtn.setEnabled(true);
        deleteStudentBtn.setEnabled(true);
        // disable Add button
        addStudentBtn.setEnabled(false);
    }

    public Student getStudentInfo() {
        // validate student
        if (!validateName() || !validateAge() || !validateAddress() || !validateGPA()) {
            return null;
        }
        try {
            Student student = new Student();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                student.setId(Integer.parseInt(idField.getText()));
            }
            student.setName(nameField.getText().trim());
            student.setAge(Byte.parseByte(ageField.getText().trim()));
            student.setAddress(addressTA.getText().trim());
            student.setGpa(Float.parseFloat(gpaField.getText().trim()));
            return student;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    private boolean validateName() {
        String name = nameField.getText();
        if (name == null || "".equals(name.trim())) {
            nameField.requestFocus();
            showMessage("Name không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateAddress() {
        String address = addressTA.getText();
        if (address == null || "".equals(address.trim())) {
            addressTA.requestFocus();
            showMessage("Address không được trống.");
            return false;
        }
        return true;
    }

    private boolean validateAge() {
        try {
            Byte age = Byte.parseByte(ageField.getText().trim());
            if (age < 0 || age > 100) {
                ageField.requestFocus();
                showMessage("Age không hợp lệ, age nên trong khoảng 0 đến 100.");
                return false;
            }
        } catch (Exception e) {
            ageField.requestFocus();
            showMessage("Age không hợp lệ!");
            return false;
        }
        return true;
    }

    private boolean validateGPA() {
        try {
            Float gpa = Float.parseFloat(gpaField.getText().trim());
            if (gpa < 0 || gpa > 10) {
                gpaField.requestFocus();
                showMessage("GPA không hợp lệ, gpa nên trong khoảng 0 đến 10.");
                return false;
            }
        } catch (Exception e) {
            gpaField.requestFocus();
            showMessage("GPA không hợp lệ!");
            return false;
        }
        return true;
    }

    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddStudentListener(ActionListener listener) {
        addStudentBtn.addActionListener(listener);
    }

    public void addEdiStudentListener(ActionListener listener) {
        editStudentBtn.addActionListener(listener);
    }

    public void addDeleteStudentListener(ActionListener listener) {
        deleteStudentBtn.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }

    public void addSortStudentGPAListener(ActionListener listener) {
        sortStudentByGPA.addActionListener(listener);
    }

    public void addSortStudentNameListener(ActionListener listener) {
        sortStudentByName.addActionListener(listener);
    }

    public void addListStudentSelectionListener(ListSelectionListener listener) {
        studentTable.getSelectionModel().addListSelectionListener(listener);
    }
}

