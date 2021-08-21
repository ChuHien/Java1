package mau2.dao;

import mau2.entity.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StudentDao {
    ArrayList<Student> listStudents = new ArrayList<Student>();
    public StudentDao() {
    }
    public void addStudent(Student student){
        listStudents.add(student);
    }
    public void add(Student student) {
        int id = (listStudents.size() > 0) ? (listStudents.size() + 1) : 1;
        student.setId(id);
        listStudents.add(student);
    }
    public void edit(Student student) {
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                listStudents.get(i).setName(student.getName());
                listStudents.get(i).setAge(student.getAge());
                listStudents.get(i).setAddress(student.getAddress());
                listStudents.get(i).setGpa(student.getGpa());
                break;
            }
        }
    }
    public boolean delete(Student student) {
        boolean isFound = false;
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getId() == student.getId()) {
                student = listStudents.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listStudents.remove(student);
            return true;
        }
        return false;
    }
    public void sortStudentByName() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.getName().compareTo(student2.getName());
            }
        });
    }
    public void sortStudentByGPA() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                if (student1.getGpa() > student2.getGpa()) {
                    return 1;
                }
                return -1;
            }
        });
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = (ArrayList<Student>) listStudents;
    }
}