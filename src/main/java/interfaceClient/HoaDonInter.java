package interfaceClient;

import entity.HoaDon;

import java.util.ArrayList;
import java.util.Date;

public interface HoaDonInter {
    ArrayList<HoaDon> getalltbHoaDon();
    boolean createHoaDon(HoaDon hd);
    HoaDon getHoaDonTheoMaHD(String maHD);
    boolean updateTongTien(String maHD, Double tongTien, String maKM);
    int getSoLuongHoaDon();
    ArrayList<HoaDon> getHoaDonTheoMaKH(String maKH);
    int getSoLuongHoaDonNgay(Date ngay);
    double getTongTienNgay(Date ngay);
    ArrayList<HoaDon> getDoanhThuTungThangTrongNam(String nam);
    ArrayList<HoaDon> getDoanhThuNam(String nam);
    ArrayList<HoaDon> getDoanhThuNgay(Date ngay);
    ArrayList<String[]> getDoanhThuTungThangNam(String nam);
    ArrayList<HoaDon> getDoanhThuThang(String thang, String nam);
    double getTongTienThang(String thang, String nam);
    int getSoLuongHoaDonThang(String thang, String nam);
    int getSoLuongHoaDonNam(String nam);
    double getTongTienNam(String nam);
}
