package mau2.controller;

import mau2.dao.UserDao;
import mau2.entity.User;
import mau2.view.LoginView;
import mau2.view.StudentView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    private UserDao userDao;
    private LoginView loginView;
    private StudentView studentView;
    public LoginController(LoginView loginView){
        this.loginView = loginView;
        this.userDao = new UserDao();
        loginView.addLoginListener(new LoginListener());
    }
    public void showLoginView(){
        loginView.setVisible(true);
    }
    // lop LoginListener chua cai dat cho su kien click button
    class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            User user = loginView.getUser();
            if(userDao.checkUser(user)){
                // neu dang nhap thanh cong mo man hinh quan li sinh vien
                studentView = new StudentView();
                StudentController studentController = new StudentController(studentView);
                studentController.showStudentView();
                loginView.setVisible(false);
            } else {
                loginView.showMessage("username hoac password sai");
            }
        }

    }
}
