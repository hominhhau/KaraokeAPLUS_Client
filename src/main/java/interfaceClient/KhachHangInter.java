package interfaceClient;

import entity.KhachHang;

import java.util.ArrayList;

public interface KhachHangInter {
    ArrayList<KhachHang> getalltbKhachHang();
    ArrayList<KhachHang> getKhachHangTheoMaKH(String id);
    ArrayList<KhachHang> getKhachHangTheoSdtKH(String sdt);
    boolean addCustomer(KhachHang kh);
    boolean DeleteCustomer(String maKH);
    KhachHang findCustomer(String maTim);
    KhachHang timKhachHangbySDT(String sdt);
    boolean editCustomer(KhachHang kh);
    ArrayList<KhachHang> getdataKH(String id);
    long getSoLuongKhachHang();

    boolean addKHforthuePhong(KhachHang kh);
}
