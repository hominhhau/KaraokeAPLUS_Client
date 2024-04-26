package interfaceClient.impl;

import client.Client;
import interfaceClient.TaiKhoanInter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class TaiKhoanClient implements TaiKhoanInter {
    private Client client;;
    public TaiKhoanClient() {
        this.client = new Client();
    }
    @Override
    public boolean authenticate(String maNV, String plainPassword) throws Exception {
        /**
         * boolean isUser = false;
         *         try {
         *             client.connect();
         *             client.getOutObj().writeObject("authenticate");
         *             client.getOutObj().writeObject(maNV);
         *             client.getOutObj().writeObject(plainPassword);
         *             client.getOutObj().flush();
         *             isUser = client.getIn().readBoolean();
         *         }catch (Exception e){
         *             e.printStackTrace();
         *         }finally {
         *             client.close();
         *         }
         *         return isUser;
         */

//        boolean isUser = false;
//        try{
//            client.connect();
//            client.getOutObj().writeObject("authenticate");
//            client.getOutObj().writeObject(maNV);
//
//            String hashedPassword = hashPassword(plainPassword);
//            client.getOutObj().writeObject(hashedPassword);
//            //client.getOutObj().writeObject(plainPassword);
//            client.getOutObj().flush();
//            isUser = client.getIn().readBoolean();
//            return isUser;
//        }catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }finally {
//            client.close();
//        }
        client.connect();
        client.getOutObj().writeObject("authenticate");
        client.getOutObj().writeObject(maNV);

        String hashedPassword = hashPassword(plainPassword);

// Gửi mật khẩu đã mã hóa đến server
        client.getOutObj().writeObject(hashedPassword);
        client.getOutObj().flush();

// Nhận kết quả từ server
        boolean isUser = client.getIn().readBoolean();
        if (isUser) {
            System.out.println("User authenticated successfully");
        } else {
            System.out.println("Invalid password!");
        }

        return isUser;
    }

    @Override
    public boolean taoTK(String maNV) {
       try{
           client.connect();
           client.getOutObj().writeObject("taoTK");
           client.getOutObj().writeObject(maNV);
           client.getOutObj().flush();
           return client.getIn().readBoolean();
       }catch (Exception e){
           e.printStackTrace();
           return true;
       }finally {
           client.close();
       }
    }

    @Override
    public boolean nhoMK(String maNV, StringBuilder password) {
        try{
            client.connect();
            client.getOutObj().writeObject("nhoMK");
            client.getOutObj().writeObject(maNV);
            client.getOutObj().flush();
            password.append((String) client.getIn().readObject());
            return client.getIn().readBoolean();
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }finally {
            client.close();
        }
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

    public static void main(String[] args) throws Exception {
        TaiKhoanInter taiKhoanClient = new TaiKhoanClient();
        System.out.println(taiKhoanClient.authenticate("NV008", "999"));
        //System.out.println(taiKhoanClient.hashPassword("123A"));
    }


}
