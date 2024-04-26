package interfaceClient.impl;

import entity.LoaiPhong;
import interfaceClient.LoaiPhongInter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class LoaiPhongClient implements LoaiPhongInter {
    private static final String SERVER_HOST = "MSI";
    private static final int SERVER_PORT = 7900;

    @Override
    public ArrayList<LoaiPhong> getalltbLoaiPhong() {
        ArrayList<LoaiPhong> list = new ArrayList<>();
        try {
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            outObj.writeObject("getalltbLoaiPhong");
            outObj.flush();
            return (ArrayList<LoaiPhong>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<LoaiPhong> getLoaiPhongTheoMaLoai(String id) {
        ArrayList<LoaiPhong> list = new ArrayList<>();
        try {
            Socket socket = new Socket(SERVER_HOST, SERVER_PORT);
            ObjectOutputStream outObj = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            outObj.writeObject("getLoaiPhongTheoMaLoai");
            outObj.writeObject(id);
            outObj.flush();
            return (ArrayList<LoaiPhong>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        LoaiPhongClient loaiPhongClient = new LoaiPhongClient();
        System.out.println(loaiPhongClient.getalltbLoaiPhong());
    }

}
