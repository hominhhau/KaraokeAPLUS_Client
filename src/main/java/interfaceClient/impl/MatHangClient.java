package interfaceClient.impl;


import client.Client;
import entity.MatHang;
import entity.PhongHat;
import interfaceClient.MatHangInter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MatHangClient implements MatHangInter {

    private Client client;

    public MatHangClient() {
        this.client = new Client();
    }

    @Override
    public ArrayList<MatHang> getalltbMatHang() {
        ArrayList<PhongHat> phongHats = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getalltbMatHang");
            outObj.flush();
            return (ArrayList<MatHang>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            client.close();
        }
    }

    @Override
    public ArrayList<MatHang> getMatHangTheoMaMH(String id) {
        ArrayList<MatHang> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getMatHangTheoMaMH");
            outObj.writeObject(id);
            outObj.flush();
            return (ArrayList<MatHang>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return null;
    }

    @Override
    public boolean addMatHang(MatHang mh) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("addMatHang");
            outObj.writeObject(mh);
            outObj.flush();
            return in.readBoolean();
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean DeleteMatHang(String maMH) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("DeleteMatHang");
            outObj.writeObject(maMH);
            outObj.flush();
            return in.readBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public MatHang findMatHang(String maTim) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("findMatHang");
            outObj.writeObject(maTim);
            outObj.flush();
            return (MatHang) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean editMatHang(MatHang mh) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("editMatHang");
            outObj.writeObject(mh);
            outObj.flush();
            return in.readBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public int getTongSoMH() {
        int tongSoMH = 0;
        try {
            client.connect();

            try (ObjectOutputStream outObj = client.getOutObj();
                 ObjectInputStream in = client.getIn()) {

                outObj.writeObject("getTongSoMH");
                outObj.flush();
                tongSoMH = in.readInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return tongSoMH;
    }


    @Override
    public ArrayList<String[]> getMHNam(String nam) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getMHNam");
            outObj.writeObject(nam);
            outObj.flush();
            return (ArrayList<String[]>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public double getTongTienNam(String nam) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getTongTienNam");
            outObj.writeObject(nam);
            outObj.flush();
            return in.readDouble();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0.0;
    }

    @Override
    public ArrayList<String[]> getMHThang(String thang, String nam) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getMHThang");
            outObj.writeObject(thang);
            outObj.writeObject(nam);
            outObj.flush();
            return (ArrayList<String[]>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    @Override
    public Double getTongTienThang(String thang, String nam) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getTongTienThang");
            outObj.writeObject(thang);
            outObj.writeObject(nam);
            outObj.flush();
            return in.readDouble();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0.0;
    }

    @Override
    public ArrayList<String[]> getMHNgay(Date ngay) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getMHNgay");
            outObj.writeObject(ngay);
            outObj.flush();
            return (ArrayList<String[]>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Double getTongTienMHNgay(Date date) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getTongTienMHNgay");
            outObj.writeObject(date);
            outObj.flush();
            return in.readDouble();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return 0.0;
    }


    public static void main(String[] args) throws ParseException {
        MatHangInter mh = new MatHangClient();
// getTongSoMH
        System.out.println(mh.getTongSoMH());
    }
}


