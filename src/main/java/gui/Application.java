package gui;

//import connectDB.DatabaseManager;
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
public class Application {
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
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ProcessesLoading processesLoading = new ProcessesLoading();
				Form_Login formLogin = new Form_Login();
				// Hiển thị giao diện "ProcessesLoading"
				processesLoading.setVisible(true);
				// Kết nối đến cơ sở dữ liệu
				try {

					// Đợi 3 giây trước khi ẩn "ProcessesLoading" và hiển thị "Form_Login"
					Timer timer = new Timer(3000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// Ẩn giao diện "ProcessesLoading"
							processesLoading.setVisible(false);
							// Hiển thị giao diện "Form_Login"
							formLogin.setVisible(true);
						}
					});
					timer.setRepeats(false); // Đảm bảo chạy một lần duy nhất
					timer.start();

				} catch (Exception e) {


					Timer timer = new Timer(50000, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// Ẩn giao diện "ProcessesLoading" chờ hơn 5 phút thì thoát app
							processesLoading.setVisible(false);
						}
					});
					timer.setRepeats(false);
					timer.start();
					System.out.println("Connection failed! <<check databasename, user, password>>" + e.getMessage());
				}
			}
		});

	}
}
