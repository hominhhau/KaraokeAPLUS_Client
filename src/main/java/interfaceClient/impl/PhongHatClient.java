package interfaceClient.impl;

import client.Client;
import entity.PhongHat;
import interfaceClient.PhongHatInter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class PhongHatClient implements PhongHatInter {
    private Client client;

    public PhongHatClient() {
        this.client = new Client();
    }

    @Override
    public ArrayList<PhongHat> getAllPhongHat() {
        ArrayList<PhongHat> phongHats = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getAllPhongHat");
            outObj.flush();
            return (ArrayList<PhongHat>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            client.close();
        }
    }

    @Override
    public ArrayList<PhongHat> getPhongByTinhTrang(String tinhTrang) {

        ArrayList<PhongHat> phongHats = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getPhongByTinhTrang");
            outObj.writeObject(tinhTrang);
            outObj.flush();
            return (ArrayList<PhongHat>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            client.close();
        }
    }

    @Override
    public boolean updateTinhTrangPhong(String maPhong, String tinhTrangMoi) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("updateTinhTrangPhong");
            outObj.writeObject(maPhong);
            outObj.writeObject(tinhTrangMoi);
            outObj.flush();
            return in.readBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            client.close();

        }

    }

    @Override
    public PhongHat getPhongHatByMaPhong(String maPhong) {
        PhongHat phongHat = new PhongHat();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getPhongHatByMaPhong");
            outObj.writeObject(maPhong);
            outObj.flush();
            return (PhongHat) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            client.close();
        }
    }

    @Override
    public boolean editPhongHat(PhongHat ph) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("editPhongHat");
            outObj.writeObject(ph);
            outObj.flush();
            return in.readBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            client.close();
        }
    }

    @Override
    public boolean DeletePhongHat(String maPH) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("DeletePhongHat");
            outObj.writeObject(maPH);
            outObj.flush();
            return in.readBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            client.close();
        }
    }

    @Override
    public ArrayList<PhongHat> FindTheoMaLoai(String id) {
        ArrayList<PhongHat> phongHats = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("FindTheoMaLoai");
            outObj.writeObject(id);
            outObj.flush();
            return (ArrayList<PhongHat>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            client.close();
        }
    }

    @Override
    public int getSoPhongTrong() {
        try{
            client.connect();
            client.getOutObj().writeObject("getSoPhongTrong");
            client.getOutObj().flush();
            return (int) client.getIn().readLong();
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getTongSoPhong() {
        Long tongSoPhong = 0L;
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getTongSoPhong");
            outObj.flush();
            tongSoPhong = in.readLong();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return tongSoPhong.intValue();
    }

    @Override
    public boolean addPhongHat(PhongHat ph) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("addPhongHat");
            outObj.writeObject(ph);
            outObj.flush();
            return in.readBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            client.close();
        }

    }

    public static void main(String[] args) {

        PhongHatInter phongHatClient = new PhongHatClient();
        System.out.println(phongHatClient.getSoPhongTrong());
    }


}
