package interfaceClient.impl;

import client.Client;
import entity.ChiTietHoaDonPhong;
import interfaceClient.ChiTietHoaDonPhongInter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ChiTietHoaDonPhongClient implements ChiTietHoaDonPhongInter {

    private Client client;

    public ChiTietHoaDonPhongClient() {
        this.client = new Client();
    }

    @Override
    public ArrayList<ChiTietHoaDonPhong> getalltbChiTietHoaDonPhong() {
        ArrayList<ChiTietHoaDonPhong> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getalltbChiTietHoaDonPhong");
            outObj.flush();
            return (ArrayList<ChiTietHoaDonPhong>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return null;
    }

    @Override
    public ChiTietHoaDonPhong getChiTietHoaDonPhongTheoMaHD(String id, String maPhong) {
        ChiTietHoaDonPhong cthdp = new ChiTietHoaDonPhong();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getChiTietHoaDonPhongTheoMaHD");
            outObj.writeObject(id);
            outObj.writeObject(maPhong);
            outObj.flush();
            cthdp = (ChiTietHoaDonPhong) in.readObject();

            System.out.println("getChiTietHoaDonPhongTheoMaHD" + id + maPhong + cthdp.getGioVao());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return cthdp;
    }

    @Override
    public boolean createChiTietHoaDonPhong(ChiTietHoaDonPhong cthdp) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("createChiTietHoaDonPhong");
            outObj.writeObject(cthdp);
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
    public ChiTietHoaDonPhong finHDByRoomID(String roomID) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("finHDByRoomID");
            outObj.writeObject(roomID);
            outObj.flush();
            return (ChiTietHoaDonPhong) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return null;
    }

    @Override
    public ChiTietHoaDonPhong finHDByRoomIDDaTT(String roomID) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("finHDByRoomIDDaTT");
            outObj.writeObject(roomID);
            outObj.flush();
            return (ChiTietHoaDonPhong) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return null;
    }

    @Override
    public boolean updateGioRaVsGia(String maHD, LocalDateTime gioRa, Float gia, String maPhong) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("updateGioRaVsGia");
            outObj.writeObject(maHD);
            outObj.writeObject(gioRa);
            outObj.writeObject(gia);
            outObj.writeObject(maPhong);
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
    public Boolean doiPhong(String maHD, String maPhongHienTai, String maPhongMoi, String ghiChu) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("doiPhongforPhong");
            outObj.writeObject(maHD);
            outObj.writeObject(maPhongHienTai);
            outObj.writeObject(maPhongMoi);
            outObj.writeObject(ghiChu);
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
    public ArrayList<ChiTietHoaDonPhong> getAllTheMaHDArray(String maHD) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getAllTheMaHDArray");
            outObj.writeObject(maHD);
            outObj.flush();
            return (ArrayList<ChiTietHoaDonPhong>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            client.close();
        }
    }

    @Override
    public void createChiTietHoaDonPhongList(List<ChiTietHoaDonPhong> cthdpList) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            outObj.writeObject("createChiTietHoaDonPhongList");
            outObj.writeObject(cthdpList);
            outObj.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }

    public static void main(String[] args) {
        //doiPhong
        ChiTietHoaDonPhongClient chiTietHoaDonPhongClient = new ChiTietHoaDonPhongClient();
//        System.out.println(chiTietHoaDonPhongClient.doiPhong("HD014", "P001", "P002", "doi phong"));
//        getAllTheMaHDArray
        ArrayList<ChiTietHoaDonPhong> list = chiTietHoaDonPhongClient.getAllTheMaHDArray("HD020");
        for (ChiTietHoaDonPhong cthdp : list) {
            if (cthdp.getPhongHat() != null)
                System.out.println(cthdp.getPhongHat().getMaPhong());
            else
                System.out.println("null");
        }
    }
}

