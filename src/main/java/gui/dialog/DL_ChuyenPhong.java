/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package gui.dialog;


import entity.ChiTietHoaDonPhong;
import entity.PhongHat;
import gui.form.Form_QuanLyDatPhong;
import gui.swing.notification.Notification;
import gui.swing.scrollbar.ScrollBarCustom;
import interfaceClient.ChiTietHoaDonDVInter;
import interfaceClient.ChiTietHoaDonPhongInter;
import interfaceClient.PhongHatInter;
import interfaceClient.impl.ChiTietHoaDonDVClient;
import interfaceClient.impl.ChiTietHoaDonPhongClient;
import interfaceClient.impl.PhongHatClient;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author HO MINH HAU
 */
public class DL_ChuyenPhong extends JDialog {

    private PhongHatInter ph_dao = new PhongHatClient();
    private String loaiPhong;
    private Float gia;
    private String maPhong;

    private ChiTietHoaDonPhongInter cthdp_dao = new ChiTietHoaDonPhongClient();
    private ChiTietHoaDonDVInter cthddv_dao = new ChiTietHoaDonDVClient();

    public DL_ChuyenPhong(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jScrollPane1.getViewport().setOpaque(false);
        jScrollPane1.setVerticalScrollBar(new ScrollBarCustom());
        loadData();
        tblDSP.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = tblDSP.getSelectedRow();
                    if (selectedRow != -1) {
                        maPhong = (String) tblDSP.getValueAt(selectedRow, 0);
                        loaiPhong = (String) tblDSP.getValueAt(selectedRow, 2);
//                        System.out.println(maPhong);
//                        System.out.println(loaiPhong);
                    }
                }
            }
        });

    }

    public void loadData() {
//        ConnectDB db = ConnectDB.getInstance();
//        try {
//            db.connect();
        PhongHat ph = new PhongHat();
        ph_dao = new PhongHatClient();
        ArrayList<PhongHat> phongTrongList = ph_dao.getPhongByTinhTrang("Trong");
        for (PhongHat phongHat : phongTrongList) {
            if (phongHat.getLoaiPhong().getMaLoaiPhong().equals("LP001")) {
                loaiPhong = "VIP";
                gia = 100000f;
            } else {
                loaiPhong = "Thường";
                gia = 60000f;
            }
            String[] rowData = {phongHat.getMaPhong(), phongHat.getTenPhong(), loaiPhong, gia.toString()};
            DefaultTableModel model = (DefaultTableModel) tblDSP.getModel();
            model.addRow(rowData);


        }
//        } catch (SQLException ex) {
//
//        }


    }

    // check txtLyDo không được rỗng và thông báo
    public boolean checkLyDo() {
        if (txtLyDo.getText().equals("")) {
            return false;
        }
        return true;
    }
    private boolean doiPhong(String maHD, String roomSelected, String maPhong, String lyDo) {
        try {
            cthdp_dao.doiPhong(maHD, roomSelected, maPhong, lyDo);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean doiPhongDV(String maHD, String roomSelected, String maPhong) {
        try {
            cthddv_dao = new ChiTietHoaDonDVClient();
            cthddv_dao.doiPhong(maHD, roomSelected, maPhong);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean updateTinhTrangPhongTrong(String roomSelected) {
        try {
            Form_QuanLyDatPhong updatePhong = new Form_QuanLyDatPhong();
            ph_dao.updateTinhTrangPhong(updatePhong.getRoomSelected(), "Trong");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    private boolean updateTinhTrangPhongDangSuDung(String maPhong) {
        try {
            ph_dao.updateTinhTrangPhong(maPhong, "Dang su dung");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        btnExit = new gui.swing.Button();
        jScrollPane1 = new JScrollPane();
        tblDSP = new JTable();
        btnXacNhan = new gui.swing.RadiusButton();
        jLabel2 = new JLabel();
        txtLyDo = new JTextField();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 153, 0));
        jLabel1.setText("Đổi Phòng ");

        btnExit.setBackground(new java.awt.Color(255, 0, 51));
        btnExit.setBorder(null);
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("  X  ");
        btnExit.setEffectColor(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnExit.setHorizontalTextPosition(SwingConstants.CENTER);
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        tblDSP.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "Mã", "Tên ", "Loại Phòng", "Giá "
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblDSP);

        btnXacNhan.setBackground(new java.awt.Color(0, 204, 0));
        btnXacNhan.setText("Xác Nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Lý do chuyển phòng:");

        txtLyDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLyDoActionPerformed(evt);
            }
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
                                                .addGap(144, 144, 144)
                                                .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(jLabel2)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtLyDo, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(55, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btnXacNhan, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 446, GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 17, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(btnExit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1)))
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel2))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtLyDo)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXacNhan, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 18, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {
        if (checkLyDo()) {
            // Disable the button to prevent multiple clicks
            btnXacNhan.setEnabled(false);

            // Execute heavy operations in background threads
            SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    // Access heavy operations here
                    Form_QuanLyDatPhong frmPH = new Form_QuanLyDatPhong();
                    cthdp_dao = new ChiTietHoaDonPhongClient();
                    ChiTietHoaDonPhong hd = cthdp_dao.finHDByRoomID(frmPH.getRoomSelected());
                    ph_dao = new PhongHatClient();
                    PhongHat dataPH = ph_dao.getPhongHatByMaPhong(frmPH.getRoomSelected());
                    String loaiPhong = dataPH.getLoaiPhong().getMaLoaiPhong();
                    if (loaiPhong.equals("LP001") && tblDSP.getValueAt(tblDSP.getSelectedRow(), 2).equals("Thường")) {
                        SwingUtilities.invokeLater(() -> {
                            Notification noti = new Notification((java.awt.Frame) SwingUtilities.getWindowAncestor(DL_ChuyenPhong.this),
                                    Notification.Type.WARNING, Notification.Location.TOP_RIGHT,
                                    "Không thể chuyển từ phòng VIP sang phòng thường");
                            noti.showNotification();
                            btnXacNhan.setEnabled(true);
                        });
                    } else {
                        String maHD = hd.getHoaDon().getMaHD();

                        if (doiPhong(maHD, frmPH.getRoomSelected(), maPhong, txtLyDo.getText())) {
                            if (doiPhongDV(maHD, frmPH.getRoomSelected(), maPhong)) {
                                if (updateTinhTrangPhongTrong(frmPH.getRoomSelected())) {
                                    if (updateTinhTrangPhongDangSuDung(maPhong)) {
                                        SwingUtilities.invokeLater(() -> {
                                            btnXacNhan.setEnabled(true);
                                            dispose();
                                            Notification noti = new Notification((java.awt.Frame) SwingUtilities.getWindowAncestor(DL_ChuyenPhong.this),
                                                    Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Chuyển phòng thành công");
                                            noti.showNotification();
                                        });
                                    }
                                }
                            }
                        }
                        SwingUtilities.invokeLater(() -> {
                            btnXacNhan.setEnabled(true);
                            dispose();
                            Notification noti = new Notification((java.awt.Frame) SwingUtilities.getWindowAncestor(DL_ChuyenPhong.this),
                                    Notification.Type.SUCCESS, Notification.Location.TOP_RIGHT, "Chuyển phòng thành công");
                            noti.showNotification();
                        });
                    }
                    return null;
                }
            };
            worker.execute();


        } else {
            txtLyDo.requestFocus();
            Notification noti = new Notification((java.awt.Frame) SwingUtilities.getWindowAncestor(this),
                    Notification.Type.WARNING, Notification.Location.TOP_RIGHT, "Vui lòng nhập lý do chuyển phòng");
            noti.showNotification();
        }
    }

    private void txtLyDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLyDoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLyDoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DL_ChuyenPhong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DL_ChuyenPhong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DL_ChuyenPhong.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(DL_ChuyenPhong.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DL_ChuyenPhong dialog = new DL_ChuyenPhong(new JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.swing.Button btnExit;
    private gui.swing.RadiusButton btnXacNhan;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTable tblDSP;
    private JTextField txtLyDo;
    // End of variables declaration//GEN-END:variables
}
