package interfaceClient.impl;

import client.Client;
import interfaceClient.DoiMatKhauInter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class DoiMatKhauClient implements DoiMatKhauInter {
    private Client client;
    public DoiMatKhauClient() {
        this.client = new Client();
    }
    @Override
    public boolean doiMatKhau(String maNV, String matKhauMoi) {
        try {
            client.connect();
            client.getOutObj().writeObject("doiMatKhau");
            client.getOutObj().writeObject(maNV);
            client.getOutObj().writeObject(hashPassword(matKhauMoi));
            client.getOutObj().flush();
            //return (boolean) client.getIn().readObject();
            return client.getIn().readBoolean();
            //return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
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

    public static void main(String[] args) {
        DoiMatKhauClient doiMatKhauClient = new DoiMatKhauClient();
        System.out.println(doiMatKhauClient.doiMatKhau("NV008", "5"));
    }
}
