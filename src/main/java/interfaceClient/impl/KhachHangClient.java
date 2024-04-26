package interfaceClient.impl;

import client.Client;
import entity.KhachHang;
import interfaceClient.KhachHangInter;

import java.util.ArrayList;

public class KhachHangClient implements KhachHangInter {
    private Client client;
    public KhachHangClient(){
        this.client = new Client();
    }
    @Override
    public ArrayList<KhachHang> getalltbKhachHang() {
        ArrayList<KhachHang> list = new ArrayList<>();
        try{
            client.connect();
            client.getOutObj().writeObject("getalltbKhachHang");
            client.getOutObj().flush();
            return (ArrayList<KhachHang>) client.getIn().readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            client.close();
        }
    }

    @Override
    public ArrayList<KhachHang> getKhachHangTheoMaKH(String id) {
        ArrayList<KhachHang> list = new ArrayList<>();
        try{
            client.connect();
            client.getOutObj().writeObject("getKhachHangTheoMaKH");
            client.getOutObj().writeObject(id);
            client.getOutObj().flush();
            return (ArrayList<KhachHang>) client.getIn().readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            client.close();
        }
    }

    @Override
    public ArrayList<KhachHang> getKhachHangTheoSdtKH(String sdt) {
        ArrayList<KhachHang> list = new ArrayList<>();
        try{
            client.connect();
            client.getOutObj().writeObject("getKhachHangTheoSdtKH");
            client.getOutObj().writeObject(sdt);
            client.getOutObj().flush();
            return (ArrayList<KhachHang>) client.getIn().readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            client.close();
        }
    }

    @Override
    public boolean addCustomer(KhachHang kh) {
        try{
            client.connect();
            client.getOutObj().writeObject("addCustomer");
            client.getOutObj().writeObject(kh);
            client.getOutObj().flush();
            return (boolean) client.getIn().readObject();
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }finally {
            client.close();
        }
    }

    @Override
    public boolean DeleteCustomer(String maKH) {
        try{
            client.connect();
            client.getOutObj().writeObject("DeleteCustomer");
            client.getOutObj().writeObject(maKH);
            client.getOutObj().flush();
            return (boolean) client.getIn().readObject();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            client.close();
        }
    }

    @Override
    public KhachHang findCustomer(String maTim) {
        try{
            client.connect();
            client.getOutObj().writeObject("findCustomer");
            client.getOutObj().writeObject(maTim);
            client.getOutObj().flush();
            return (KhachHang) client.getIn().readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            client.close();
        }
    }

    @Override
    public KhachHang timKhachHangbySDT(String sdt) {
        try{
            client.connect();
            client.getOutObj().writeObject("timKhachHangbySDT");
            client.getOutObj().writeObject(sdt);
            client.getOutObj().flush();
            return (KhachHang) client.getIn().readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            client.close();
        }
    }

    @Override
    public boolean editCustomer(KhachHang kh) {
        try{
            client.connect();
            client.getOutObj().writeObject("editCustomer");
            client.getOutObj().writeObject(kh);
            client.getOutObj().flush();
            return (boolean) client.getIn().readObject();
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }finally {
            client.close();
        }
    }

    @Override
    public ArrayList<KhachHang> getdataKH(String id) {
        ArrayList<KhachHang> list = new ArrayList<>();
        try{
            client.connect();
            client.getOutObj().writeObject("getdataKH");
            client.getOutObj().writeObject(id);
            client.getOutObj().flush();
            return (ArrayList<KhachHang>) client.getIn().readObject();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public long getSoLuongKhachHang() {
        try{
            client.connect();
            client.getOutObj().writeObject("getSoLuongKhachHang");
            client.getOutObj().flush();
            return client.getIn().readLong();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    @Override
    public boolean addKHforthuePhong(KhachHang kh) {
        try{
            client.connect();
            client.getOutObj().writeObject("addCustomer");
            client.getOutObj().writeObject(kh);
            client.getOutObj().flush();
            return (boolean) client.getIn().readObject().equals("true");
        }catch (Exception e){
            e.printStackTrace();
            return true;
        }finally {
//            client.close();
        }
    }
    public static void main(String[] args) {
//        addKHforthuePhong
        KhachHangInter kh = new KhachHangClient();
//          public KhachHang(String maKH, String tenKH, String sdt, boolean gioitinh) {
        KhachHang kh1 = new KhachHang("KH1","Nguyen Van A","0123456789",true);
        System.out.println(kh.addKHforthuePhong(kh1));
    }

}
