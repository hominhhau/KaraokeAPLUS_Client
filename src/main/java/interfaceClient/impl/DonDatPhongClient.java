package interfaceClient.impl;

import client.Client;
import entity.DonDatPhong;
import interfaceClient.DonDatPhongInter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.util.ArrayList;

public class DonDatPhongClient implements DonDatPhongInter {
    private Client client;

    public DonDatPhongClient() {
        this.client = new Client();
    }

    @Override
    public ArrayList<DonDatPhong> getalltbDonDatPhong() {
        try {
            client.connect();
            client.getOutObj().writeObject("getalltbDonDatPhong");
            client.getOutObj().flush();
            return (ArrayList<DonDatPhong>) client.getIn().readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean createDonDatPhong(DonDatPhong ddp) {
        boolean result = false;
        try {
            client.connect();
            client.getOutObj().writeObject("createDonDatPhong");
            client.getOutObj().writeObject(ddp);
            client.getOutObj().flush();
            result = client.getIn().readBoolean();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<DonDatPhong> getDonDatPhongTheoMaKH(String maKH) {
        ArrayList<DonDatPhong> donDatPhongs = new ArrayList<>();
        try {
            client.connect();
            client.getOutObj().writeObject("getDonDatPhongTheoMaKH");
            client.getOutObj().writeObject(maKH);
            client.getOutObj().flush();
            donDatPhongs = (ArrayList<DonDatPhong>) client.getIn().readObject();
            return donDatPhongs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<DonDatPhong> getDonDatPhongTheoNgayNhanPhong(LocalDate ngayNhanPhong) {
        ArrayList<DonDatPhong> donDatPhongs = new ArrayList<>();
        try {
            client.connect();
            client.getOutObj().writeObject("getDonDatPhongTheoNgayNhanPhong");
            client.getOutObj().writeObject(ngayNhanPhong);
            client.getOutObj().flush();
            donDatPhongs = (ArrayList<DonDatPhong>) client.getIn().readObject();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return donDatPhongs;

    }

    @Override
    public ArrayList<DonDatPhong> timDonDatPhong(String maDDP, String maKH, String maPhong) {
        ArrayList<DonDatPhong> donDatPhongs = new ArrayList<>();
        try {
            client.connect();
            client.getOutObj().writeObject("timDonDatPhong");
            client.getOutObj().writeObject(maDDP);
            client.getOutObj().writeObject(maKH);
            client.getOutObj().writeObject(maPhong);
            client.getOutObj().flush();
            donDatPhongs = (ArrayList<DonDatPhong>) client.getIn().readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return donDatPhongs;
    }

    @Override
    public boolean deleteDonDatPhong(String maDDP, String maPhong) {
        boolean result = false;
        try {
            client.connect();
            client.getOutObj().writeObject("deleteDonDatPhong");
            client.getOutObj().writeObject(maDDP);
            client.getOutObj().writeObject(maPhong);
            client.getOutObj().flush();
            result = client.getIn().readBoolean();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) {
        DonDatPhongClient donDatPhongClient = new DonDatPhongClient();
//        ArrayList<DonDatPhong> donDatPhongs = donDatPhongClient.getDonDatPhongTheoMaKH("KH001");
//        System.out.println(donDatPhongs);


//        // test getalltbDonDatPhong
//        ArrayList<DonDatPhong> donDatPhongs1 = donDatPhongClient.getalltbDonDatPhong();
//        for (DonDatPhong donDatPhong : donDatPhongs1) {
//            System.out.println(donDatPhong);
//        }
        ArrayList<DonDatPhong> donDatPhongs5 = donDatPhongClient.getalltbDonDatPhong();
        for (DonDatPhong donDatPhong : donDatPhongs5) {
            System.out.println(donDatPhong.getMaDonDatPhong());
        }

    }
}
