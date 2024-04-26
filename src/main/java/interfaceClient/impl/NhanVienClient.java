package interfaceClient.impl;

import client.Client;
import entity.NhanVien;
import interfaceClient.NhanVienInter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class NhanVienClient implements NhanVienInter {

    private Client client;
    public NhanVienClient() {
        this.client = new Client();
    }
    @Override
    public ArrayList<NhanVien> getalltbNhanVien() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try{
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getalltbNhanVien");
            outObj.flush();
            return (ArrayList<NhanVien>) in.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return list;
        }finally {
            client.close();
        }
    }

    @Override
    public ArrayList<NhanVien> getNhanVienTheoMaNV(String id) {
        ArrayList<NhanVien> list = new ArrayList<>();
        try{
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getNhanVienTheoMaNV");
            outObj.writeObject(id);
            outObj.flush();
            return (ArrayList<NhanVien>) in.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            client.close();
        }
    }

    @Override
    public ArrayList<NhanVien> getNVTheoLoai(String lnv) {
        ArrayList<NhanVien> list = new ArrayList<>();
        try{
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getNVTheoLoai");
            outObj.writeObject(lnv);
            outObj.flush();
            return (ArrayList<NhanVien>) in.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            client.close();
        }
    }

    @Override
    public boolean addStaff(NhanVien nv) {
        try{
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("addStaff");
            outObj.writeObject(nv);
            outObj.flush();
            return (boolean) in.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }finally {
            client.close();
        }
    }

    @Override
    public boolean editStaff(NhanVien nv) {
        try{
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("editStaff");
            outObj.writeObject(nv);
            outObj.flush();
            return (boolean) in.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }finally {
            client.close();
        }
    }

    @Override
    public NhanVien findStaff(String maTim) {
        try{
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("findStaff");
            outObj.writeObject(maTim);
            outObj.flush();
            return (NhanVien) in.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            client.close();
        }
    }

    @Override
    public boolean SDT_tonTaiNV(String soDienThoai) {
        try{
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("SDT_tonTaiNV");
            outObj.writeObject(soDienThoai);
            outObj.flush();
            return (boolean) in.readObject();
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }finally {
            client.close();
        }
    }

    public static void main(String[] args) {
        NhanVienClient nhanVienClient = new NhanVienClient();
        ArrayList<NhanVien> list = nhanVienClient.getalltbNhanVien();
        for (NhanVien nv : list){
            System.out.println(nv.getMaNV());
        }
    }


}
