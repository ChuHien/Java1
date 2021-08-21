package mau2.controller;
import mau2.dao.StudentDao;
import mau2.entity.Student;
import mau2.view.StudentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class StudentController {
    private StudentDao studentDao;
    private StudentView studentView;

    public StudentController(StudentView view) {
        this.studentView = view;
        studentDao = new StudentDao();

        view.addAddStudentListener(new AddStudentListener());
        view.addEdiStudentListener(new EditStudentListener());
        view.addDeleteStudentListener(new DeleteStudentListener());
        view.addClearListener(new ClearStudentListener());
        view.addSortStudentGPAListener(new SortStudentGPAListener());
        view.addSortStudentNameListener(new SortStudentNameListener());
        view.addListStudentSelectionListener(new ListStudentSelectionListener());
    }

    public void showStudentView() {
        ArrayList<Student> studentList = (ArrayList<Student>) studentDao.getListStudents();
        studentView.setVisible(true);
        studentView.showListStudents(studentList);
    }
    class AddStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                studentDao.add(student);
                studentView.showStudent(student);
                studentView.showListStudents((ArrayList<Student>) studentDao.getListStudents());
                studentView.showMessage("Thêm thành công!");
            }
        }
    }

    /**
     * Lớp EditStudentListener
     * chứa cài đặt cho sự kiện click button "Edit"
     *
     * @author viettuts.vn
     */
    class EditStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                studentDao.edit(student);
                studentView.showStudent(student);
                studentView.showListStudents((ArrayList<Student>) studentDao.getListStudents());
                studentView.showMessage("Cập nhật thành công!");
            }
        }
    }
    class DeleteStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                studentDao.delete(student);
                studentView.clearStudentInfo();
                studentView.showListStudents((ArrayList<Student>) studentDao.getListStudents());
                studentView.showMessage("Xóa thành công!");
            }
        }
    }
    class ClearStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentView.clearStudentInfo();
        }
    }

    class SortStudentGPAListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentDao.sortStudentByGPA();
            studentView.showListStudents((ArrayList<Student>) studentDao.getListStudents());
        }
    }

    class SortStudentNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentDao.sortStudentByName();
            studentView.showListStudents((ArrayList<Student>) studentDao.getListStudents());
        }
    }

    class ListStudentSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            studentView.fillStudentFromSelectedRow();
        }
    }
}
