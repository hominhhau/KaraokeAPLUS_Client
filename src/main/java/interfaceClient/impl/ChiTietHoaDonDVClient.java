package interfaceClient.impl;

import client.Client;
import entity.ChiTietHoaDonDV;
import entity.HoaDon;
import entity.MatHang;
import entity.PhongHat;
import interfaceClient.ChiTietHoaDonDVInter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChiTietHoaDonDVClient implements ChiTietHoaDonDVInter {
    private Client client;

    public ChiTietHoaDonDVClient() {
        this.client = new Client();
    }
    @Override
//    public boolean createChiTietHoaDonDV(ChiTietHoaDonDV cthddv) {
//
//        boolean result = false;
//        try {
//            client.connect();
//            client.getOutObj().writeObject("createChiTietHoaDonDV");
//            client.getOutObj().writeObject(cthddv);
//            client.getOutObj().flush();
//            return (boolean) client.getIn().readObject().equals("true");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return result;
//        }
//
//    }
    public boolean createChiTietHoaDonDV(ChiTietHoaDonDV cthddv) {
        boolean result = false;
        try {
            client.connect();
            client.getOutObj().writeObject("createChiTietHoaDonDV");
            client.getOutObj().writeObject(cthddv);
            client.getOutObj().flush();
            result = (boolean) client.getIn().readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return result;

    }
    @Override
    public ChiTietHoaDonDV getChiTietHoaDonDVTheoMaHD(String id, String maPhong) {
        ChiTietHoaDonDV result = null;
        try {
            client.connect();
            client.getOutObj().writeObject("getChiTietHoaDonDVTheoMaHD");
            client.getOutObj().writeObject(id);
            client.getOutObj().writeObject(maPhong);
            client.getOutObj().flush();
            result = (ChiTietHoaDonDV) client.getIn().readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return result;
    }

    @Override
    public ArrayList<ChiTietHoaDonDV> getalltbChiTietHoaDonDV() {
        ArrayList<ChiTietHoaDonDV> result = new ArrayList<>();
        try {
            client.connect();
            client.getOutObj().writeObject("getalltbChiTietHoaDonDV");
            client.getOutObj().flush();
            result = (ArrayList<ChiTietHoaDonDV>) client.getIn().readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return result;
    }

    @Override
    public ArrayList<ChiTietHoaDonDV> getalltbChiTietHoaDonDVTheoMaMH(String maMH) {
        ArrayList<ChiTietHoaDonDV> result = new ArrayList<>();
        try {
            client.connect();
            client.getOutObj().writeObject("getalltbChiTietHoaDonDVTheoMaMH");
            client.getOutObj().writeObject(maMH);
            client.getOutObj().flush();
            result = (ArrayList<ChiTietHoaDonDV>) client.getIn().readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return result;
    }

    @Override
//    public boolean updateChiTietHoaDonDV(ChiTietHoaDonDV cthddv) {
//        boolean result = false;
//        try {
//            client.connect();
//            client.getOutObj().writeObject("updateChiTietHoaDonDV");
//            client.getOutObj().writeObject(cthddv);
//            client.getOutObj().flush();
//            result = client.getIn().readBoolean();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//
//    }
    public boolean updateChiTietHoaDonDV(ChiTietHoaDonDV cthddv) {
        boolean result = false;
        try {
            client.connect();
            client.getOutObj().writeObject("updateChiTietHoaDonDV");
            client.getOutObj().writeObject(cthddv);
            client.getOutObj().flush();
            result = client.getIn().readBoolean();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return result;
    }

    @Override
    public boolean deleteChiTietHoaDonDV(String maHD, String maMH) {
        boolean result = false;
        try {
            client.connect();
            client.getOutObj().writeObject("deleteChiTietHoaDonDV");
            client.getOutObj().writeObject(maHD);
            client.getOutObj().writeObject(maMH);
            client.getOutObj().flush();
            result = client.getIn().readBoolean();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return result;

    }

    @Override
    public ChiTietHoaDonDV findChiTietHoaDonDV(String maHD, String maMH) {
        ChiTietHoaDonDV result = null;
        try {
            client.connect();
            client.getOutObj().writeObject("findChiTietHoaDonDV");
            client.getOutObj().writeObject(maHD);
            client.getOutObj().writeObject(maMH);
            client.getOutObj().flush();
            result = (ChiTietHoaDonDV) client.getIn().readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return result;
    }

    @Override
    public ChiTietHoaDonDV findChiTietHoaDonDVforThem(String maHD, String maMH, String maPhong) {
        ChiTietHoaDonDV result = null;
        try {
            client.connect();
            client.getOutObj().writeObject("findChiTietHoaDonDVforThem");
            client.getOutObj().writeObject(maHD);
            client.getOutObj().writeObject(maMH);
            client.getOutObj().writeObject(maPhong);
            client.getOutObj().flush();
            result = (ChiTietHoaDonDV) client.getIn().readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
//        finally {
//            client.close();
//        }
        return result;

    }

    @Override
    public ArrayList<ChiTietHoaDonDV> getAllTheMaHDDVforRoomArray(String maHD, String maPhong) {
        ArrayList<ChiTietHoaDonDV> result = new ArrayList<>();
        try {
            client.connect();
            client.getOutObj().writeObject("getAllTheMaHDDVforRoomArray");
            client.getOutObj().writeObject(maHD);
            client.getOutObj().writeObject(maPhong);
            client.getOutObj().flush();
            result = (ArrayList<ChiTietHoaDonDV>) client.getIn().readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return result;
    }

    @Override
    public ArrayList<String[]> getTOPDVNam(String nam) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getTOPDVNam");
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
            return 0;
        }
    }

    @Override
    public ArrayList<String[]> getTOPDVThang(String thang, String nam) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getTOPDVThang");
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
    public double getTongTienThangTop(String thang, String nam) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getTongTienThangTop");
            outObj.writeObject(thang);
            outObj.writeObject(nam);
            outObj.flush();
            return in.readDouble();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public ArrayList<String[]> getTOPDVNgay(Date ngay) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getTOPDVNgay");
            outObj.writeObject(ngay);
            outObj.flush();
            return (ArrayList<String[]>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public double getTongTienNgayDV(Date ngay) {
        double result = 0;
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getTongTienNgayDV");
            outObj.writeObject(ngay);
            outObj.flush();
            result = in.readDouble();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return result;
    }

    @Override
    public ArrayList<String[]> getTKNam(String nam) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getTKNam");
            outObj.writeObject(nam);
            outObj.flush();
            return (ArrayList<String[]>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    @Override
    public ArrayList<String[]> getTKThang(String thang, String nam) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getTKThang");
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
    public boolean doiPhong(String maHD, String phongHT, String phongMoi) {
        try {
            client.connect();
            client.getOutObj().writeObject("doiPhongforDV");
            client.getOutObj().writeObject(maHD);
            client.getOutObj().writeObject(phongHT);
            client.getOutObj().writeObject(phongMoi);
            client.getOutObj().flush();
            return client.getIn().readBoolean();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            client.close();
        }
    }

    public static void main(String[] args) throws Exception {
//        Introduce local variable
//        updateChiTietHoaDonDV
        ChiTietHoaDonDVInter cthddv_dao = new ChiTietHoaDonDVClient();
        List<ChiTietHoaDonDV> list = cthddv_dao.getAllTheMaHDDVforRoomArray("HD019", "P034");
        for (ChiTietHoaDonDV cthdv : list) {
            if (cthdv.getPhongHat() != null)
                System.out.println(cthdv.getMatHang().getMaMH());
            else
                System.out.println("null");
        }
        // Điều kiện và dữ liệu mẫu
//            String maHD = "HD002"; // Mã hóa đơn
//            String maMH = "MH003"; // Mã mặt hàng
//            String maPhong = "P002"; // Mã phòng
//            int soLuong = 2; // Số lượng
//            double gia = 10.5; // Giá
//
//            // Tạo chi tiết hóa đơn dịch vụ và thêm vào cơ sở dữ liệu
//            ChiTietHoaDonDV cthddv = new ChiTietHoaDonDV(new HoaDon(maHD), new MatHang(maMH), new PhongHat(maPhong), soLuong, gia);
//            cthddv_dao.createChiTietHoaDonDV(cthddv);
//
//            // Kiểm tra xem chi tiết hóa đơn dịch vụ đã được thêm thành công hay chưa
//            ChiTietHoaDonDV chiTietHoaDonDV = cthddv_dao.findChiTietHoaDonDVforThem(maHD, maMH, maPhong);
//            if (chiTietHoaDonDV != null) {
//                System.out.println("Chi tiết hóa đơn dịch vụ đã được thêm thành công:");
//                System.out.println("Mã hóa đơn: " + chiTietHoaDonDV.getHoaDon().getMaHD());
//                System.out.println("Mã mặt hàng: " + chiTietHoaDonDV.getMatHang().getMaMH());
//                System.out.println("Mã phòng: " + chiTietHoaDonDV.getPhongHat().getMaPhong());
//                System.out.println("Số lượng: " + chiTietHoaDonDV.getSoLuong());
//                System.out.println("Giá: " + chiTietHoaDonDV.getGia());
//            } else {
//                System.out.println("Không thể thêm chi tiết hóa đơn dịch vụ.");
//            }
//        }
//

//        updateChiTietHoaDonDV
//        ChiTietHoaDonDVInter cthddv_dao = new ChiTietHoaDonDVClient();
        // Điều kiện và dữ liệu mẫu
//        String maHD = "HD003"; // Mã hóa đơn
//        String maMH = "MH004"; // Mã mặt hàng
//        String maPhong = "P003"; // Mã phòng
//        int soLuong = 2; // Số lượng
//        double gia = 10.5; // Giá
//
////        cập nhật chi tiết hóa đơn dịch vụ
//        ChiTietHoaDonDV cthddv = new ChiTietHoaDonDV(new HoaDon(maHD), new MatHang(maMH), new PhongHat(maPhong), soLuong, gia);
//        if (cthddv_dao.updateChiTietHoaDonDV(cthddv)) {
//            System.out.println("Cập nhật chi tiết hóa đơn dịch vụ thành công.");
//        } else {
//            System.out.println("Không thể cập nhật chi tiết hóa đơn dịch vụ.");
//        }
//        String maHD = "HD001"; // Mã hóa đơn
//        String maMH = "MH001"; // Mã mặt hàng
//        String maPhong = "P001"; // Mã phòng
//        int soLuong = 2; // Số lượng
//        double gia = 10.5; // Giá
//
//// Kiểm tra xem chi tiết hóa đơn dịch vụ đã tồn tại trong cơ sở dữ liệu hay chưa
//        ChiTietHoaDonDV existingCTHDDV = cthddv_dao.findChiTietHoaDonDVforThem(maHD, maMH, maPhong);
//        if (existingCTHDDV != null) {
//            // Mặt hàng đã có sẵn trong chi tiết hóa đơn dịch vụ
//
//            // Cập nhật số lượng của mặt hàng
//            existingCTHDDV.setSoLuong(existingCTHDDV.getSoLuong() + soLuong);
//
//            // Cập nhật giá của mặt hàng
//            existingCTHDDV.setGia(gia);
//
//            // Thực hiện cập nhật chi tiết hóa đơn dịch vụ
//            if (cthddv_dao.updateChiTietHoaDonDV(existingCTHDDV)) {
//                System.out.println("Cập nhật chi tiết hóa đơn dịch vụ thành công.");
//            } else {
//                System.out.println("Không thể cập nhật chi tiết hóa đơn dịch vụ.");
//            }
//        } else {
//            // Mặt hàng chưa có trong chi tiết hóa đơn dịch vụ
//
//            // Tạo một đối tượng chi tiết hóa đơn dịch vụ mới
//            ChiTietHoaDonDV newCTHDDV = new ChiTietHoaDonDV(new HoaDon(maHD), new MatHang(maMH), new PhongHat(maPhong), soLuong, gia);
//
//            // Thực hiện thêm chi tiết hóa đơn dịch vụ mới vào cơ sở dữ liệu
//            if (cthddv_dao.createChiTietHoaDonDV(newCTHDDV)) {
//                System.out.println("Thêm chi tiết hóa đơn dịch vụ thành công.");
//            } else {
//                System.out.println("Không thể thêm chi tiết hóa đơn dịch vụ.");
//            }
//        }
//
    }

}
