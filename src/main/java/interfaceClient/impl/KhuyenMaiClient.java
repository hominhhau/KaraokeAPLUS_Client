package interfaceClient.impl;

import client.Client;
import entity.KhuyenMai;
import interfaceClient.KhuyenMaiInter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class KhuyenMaiClient implements KhuyenMaiInter {
    private Client client;

    public KhuyenMaiClient() {
        this.client = new Client();
    }

    @Override
    public ArrayList<KhuyenMai> getAllKhuyenMai() {
        ArrayList<KhuyenMai> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getAllKhuyenMai");
            outObj.flush();
            return (ArrayList<KhuyenMai>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            client.close();
        }
    }

    @Override
    public boolean createKhuyenMai(KhuyenMai km) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            outObj.writeObject("createKhuyenMai");
            outObj.writeObject(km);
            outObj.flush();
            return (boolean) new ObjectInputStream(client.getIn()).readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            client.close();
        }
    }


    @Override
    public boolean editKhuyenMai(KhuyenMai km) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            outObj.writeObject("editKhuyenMai");
            outObj.writeObject(km);
            outObj.flush();
            return (boolean) new ObjectInputStream(client.getIn()).readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            client.close();
        }
    }

    @Override
    public boolean DeleteKhuyenMai(String maKM) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            outObj.writeObject("DeleteKhuyenMai");
            outObj.writeObject(maKM);
            outObj.flush();
            return (boolean) new ObjectInputStream(client.getIn()).readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            client.close();
        }
    }

    @Override
    public String[] getKhuyenMai() {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getKhuyenMai");
            outObj.flush();
            return (String[]) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            client.close();
        }
    }

    @Override
    public KhuyenMai getKhuyenMaiByMaKM(String maKM) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getKhuyenMaiByMaKM");
            outObj.writeObject(maKM);
            outObj.flush();
            return (KhuyenMai) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            client.close();
        }
    }
}
