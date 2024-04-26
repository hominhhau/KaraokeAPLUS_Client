package interfaceClient;

import entity.ChiTietHoaDonDV;
import entity.LoaiPhong;

import java.util.ArrayList;
import java.util.Date;

public interface LoaiPhongInter {
    public ArrayList<LoaiPhong> getalltbLoaiPhong();

    public ArrayList<LoaiPhong> getLoaiPhongTheoMaLoai(String id);

}
