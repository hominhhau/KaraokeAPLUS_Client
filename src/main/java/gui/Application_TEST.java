package gui;

//import connectDB.DatabaseManager;
import gui.form.Form_Home;
import gui.form.Form_Login;
import gui.form.Form_MatHang;
import gui.form.Form_QuanLyPhongHat;
import gui.form.ProcessesLoading;
import gui.main.Main;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * @author HO MINH HAU
 */
public class Application_TEST {
    public static void main(String[] args) {
        // Khởi tạo và kết nối đến cơ sở dữ liệu
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_Login.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // Nếu kết nối được thì hiển thị MainFrame
        //if (databaseManager.isConnected()) {
//			Hiển thị giao diện MainFrame  trang chủ
        Main main = new Main();
        main.setVisible(true);

    }
}
