package interfaceClient.impl;

import client.Client;
import entity.*;
import gui.form.Form_Login;
import interfaceClient.HoaDonInter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class HoaDonClient implements HoaDonInter {
    private Client client;

    public HoaDonClient() {
        this.client = new Client();
    }

    @Override
    public ArrayList<HoaDon> getalltbHoaDon() {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getalltbHoaDon");
            outObj.flush();
            return (ArrayList<HoaDon>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            client.close();
        }
    }

    @Override
    public boolean createHoaDon(HoaDon hd) {
        boolean result = false;
        try {
            client.connect();
            client.getOutObj().writeObject("createHoaDon");
            client.getOutObj().writeObject(hd);
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
    public HoaDon getHoaDonTheoMaHD(String maHD) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getHoaDonTheoMaHD");
            outObj.writeObject(maHD);
            outObj.flush();
            return (HoaDon) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            client.close();
        }
    }

    @Override
    public boolean updateTongTien(String maHD, Double tongTien, String maKM) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("updateTongTien");
            outObj.writeObject(maHD);
            outObj.writeObject(tongTien);
            outObj.writeObject(maKM);
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
    public int getSoLuongHoaDon() {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getSoLuongHoaDon");
            outObj.flush();
            return in.readInt(); // Đọc giá trị từ ObjectInputStream
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return 0;
    }

    @Override
    public ArrayList<HoaDon> getHoaDonTheoMaKH(String maKH) {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getHoaDonTheoMaKH");
            outObj.writeObject(maKH);
            outObj.flush();
            return (ArrayList<HoaDon>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return null;
    }

    @Override
    public int getSoLuongHoaDonNgay(Date ngay) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getSoLuongHoaDonNgay");
            outObj.writeObject(ngay);
            outObj.flush();
            return in.readInt();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return 0;
    }


    @Override
    public double getTongTienNgay(Date ngay) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getTongTienNgay");
            outObj.writeObject(ngay);
            outObj.flush();
            return in.readDouble();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return 0;
    }

    @Override
    public ArrayList<HoaDon> getDoanhThuTungThangTrongNam(String nam) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getDoanhThuTungThangTrongNam");
            outObj.writeObject(nam);
            outObj.flush();
            return (ArrayList<HoaDon>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();

        }
        return null;
    }

    @Override
    public ArrayList<HoaDon> getDoanhThuNam(String nam) {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getDoanhThuNam");
            outObj.writeObject(nam);
            outObj.flush();
            return (ArrayList<HoaDon>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return null;
    }


    @Override
    public ArrayList<HoaDon> getDoanhThuNgay(Date ngay) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getDoanhThuNgay");
            outObj.writeObject(ngay);
            outObj.flush();
            return (ArrayList<HoaDon>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<String[]> getDoanhThuTungThangNam(String nam) {
        ArrayList<String[]> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getDoanhThuTungThangNam");
            outObj.writeObject(nam);
            outObj.flush();
            return (ArrayList<String[]>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return null;
    }

    @Override
    public ArrayList<HoaDon> getDoanhThuThang(String thang, String nam) {
        ArrayList<HoaDon> list = new ArrayList<>();
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getDoanhThuThang");
            outObj.writeObject(thang);
            outObj.writeObject(nam);
            outObj.flush();
            return (ArrayList<HoaDon>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();

        }
        return null;
    }

    @Override
    public double getTongTienThang(String thang, String nam) {
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
        } finally {
            client.close();
        }
        return 0;
    }

    @Override
    public int getSoLuongHoaDonThang(String thang, String nam) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getSoLuongHoaDonThang");
            outObj.writeObject(thang);
            outObj.writeObject(nam);
            outObj.flush();
            return in.readInt();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return 0;
    }

    @Override
    public int getSoLuongHoaDonNam(String nam) {
        try {
            client.connect();
            ObjectOutputStream outObj = client.getOutObj();
            ObjectInputStream in = client.getIn();
            outObj.writeObject("getSoLuongHoaDonNam");
            outObj.writeObject(nam);
            outObj.flush();

            int soLuongHDNam = (int) in.readObject(); // Đọc giá trị từ ObjectInputStream
            return soLuongHDNam;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
        return 0;
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
        } finally {
            client.close();
        }
        return 0;
    }

    public static void main(String[] args) throws ParseException {
        // Test so luong hoa don ngay
        HoaDonInter hoaDonClient = new HoaDonClient();
        NhanVien nhanVienDangNhap = Form_Login.getNhanVienDangNhap();
        String maHD = "HD098";

        LocalDate ngayLapHD = LocalDate.now();
        String maKH = "KH001";
        String maNV = "";
//        if (nhanVienDangNhap != null) {
//            maNV = nhanVienDangNhap.getMaNV();
//        } else {
        maNV = "NV001";
//        }
        // tôi nghĩ là lỗi ở đây
        double tongTien = 0;
        String maKM = null;
//        HoaDon hd = new HoaDon(maHD, ngayLapHD, new KhachHang(maKH), new NhanVien(maNV), new KhuyenMai(null), tongTien);
        HoaDon hd = new HoaDon(maHD, ngayLapHD, new KhachHang(maKH), new NhanVien(maNV), null, tongTien);
        if (hoaDonClient.createHoaDon(hd)) {
            System.out.println("Tạo hóa đơn thành công");
        } else {
            System.out.println("Tạo hóa đơn thất bại");

        }
    }

}






