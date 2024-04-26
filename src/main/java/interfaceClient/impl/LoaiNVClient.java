package interfaceClient.impl;

import client.Client;
import entity.LoaiNhanVien;
import interfaceClient.LoaiNVInter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LoaiNVClient implements LoaiNVInter {
    private Client client;
    public LoaiNVClient() {
        this.client = new Client();
    }
    @Override
    public ArrayList<LoaiNhanVien> getAllLoaiNhanVien() {
        ArrayList<LoaiNhanVien> list = new ArrayList<>();
        try{
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getAllLoaiNhanVien");
            outObj.flush();
            return (ArrayList<LoaiNhanVien>) in.readObject();
        }catch (Exception e) {
            e.printStackTrace();
            return list;
        }finally {
            client.close();
        }
    }

    public static void main(String[] args) {
        LoaiNVClient loaiNVClient = new LoaiNVClient();
        ArrayList<LoaiNhanVien> list = loaiNVClient.getAllLoaiNhanVien();
        for (LoaiNhanVien loaiNhanVien : list) {
            System.out.println(loaiNhanVien.getMaLoai());
        }
    }
}
