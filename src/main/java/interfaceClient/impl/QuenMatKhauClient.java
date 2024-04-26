package interfaceClient.impl;

import client.Client;
import interfaceClient.NhanVienInter;
import interfaceClient.QuenMatKhauInter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class QuenMatKhauClient implements QuenMatKhauInter {
    private Client client;
    public QuenMatKhauClient() {
        this.client = new Client();
    }
    @Override
    public boolean updatePasswordTaiKhoan(String soDienThoai, String matKhauMoi) {
        try {
            // Kiểm tra số điện thoại tồn tại trước khi đổi mật khẩu
            if (SDT_tonTaiNV(soDienThoai)) {
                // Nếu số điện thoại tồn tại, tiến hành đổi mật khẩu
                client.connect();
                ObjectOutputStream outObj = client.getOutObj();
                ObjectInputStream in = client.getIn();
                outObj.writeObject("updatePasswordTaiKhoan");
                outObj.writeObject(soDienThoai);
                outObj.writeObject(hashPassword(matKhauMoi));
                outObj.flush();
                return in.readBoolean(); // Trả về kết quả đổi mật khẩu
            } else {
                return false; // Số điện thoại không tồn tại
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close(); // Đóng kết nối
        }
        return false;
    }

    @Override
    public String hashPassword(String plainPassword) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = messageDigest.digest(plainPassword.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        }catch(NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean SDT_tonTaiNV(String soDienThoai) {
        try{
            NhanVienInter nhanVienInter = new NhanVienClient();
            return nhanVienInter.SDT_tonTaiNV(soDienThoai);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        QuenMatKhauInter quenMatKhauInter = new QuenMatKhauClient();
        //System.out.println(quenMatKhauInter.SDT_tonTaiNV("0934119430"));
        System.out.println(quenMatKhauInter.updatePasswordTaiKhoan("0909444666", "999"));;
    }
}
