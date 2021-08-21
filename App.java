package mau2;



import mau2.controller.LoginController;
import mau2.view.LoginView;

import java.awt.EventQueue;

public class App {
    public static void main(String[] args) {
        LoginView view = new LoginView();
        LoginController controller = new LoginController(view);
        // hiển thị màn hình login
        controller.showLoginView();
    }
}