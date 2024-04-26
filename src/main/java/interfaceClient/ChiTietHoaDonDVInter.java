package interfaceClient;

import entity.ChiTietHoaDonDV;

import java.util.ArrayList;
import java.util.Date;

public interface ChiTietHoaDonDVInter {
    boolean createChiTietHoaDonDV(ChiTietHoaDonDV cthddv);

    ChiTietHoaDonDV getChiTietHoaDonDVTheoMaHD(String id, String maPhong);

    ArrayList<ChiTietHoaDonDV> getalltbChiTietHoaDonDV();

    ArrayList<ChiTietHoaDonDV> getalltbChiTietHoaDonDVTheoMaMH(String maMH);

    boolean updateChiTietHoaDonDV(ChiTietHoaDonDV cthddv);

    boolean deleteChiTietHoaDonDV(String maHD, String maMH);

    ChiTietHoaDonDV findChiTietHoaDonDV(String maHD, String maMH);

    ChiTietHoaDonDV findChiTietHoaDonDVforThem(String maHD, String maMH, String maPhong);

    ArrayList<ChiTietHoaDonDV> getAllTheMaHDDVforRoomArray(String maHD, String maPhong);

    ArrayList<String[]> getTOPDVNam(String nam);

    double getTongTienNam(String nam);

    ArrayList<String[]> getTOPDVThang(String thang, String nam);

    double getTongTienThangTop(String thang, String nam);

    ArrayList<String[]> getTOPDVNgay(Date ngay);

    double getTongTienNgayDV(Date ngay);

    ArrayList<String[]> getTKNam(String nam);

    ArrayList<String[]> getTKThang(String thang, String nam);

    boolean doiPhong(String maHD, String phongHT, String phongMoi);

}
