package interfaceClient;

import entity.DonDatPhong;

import java.time.LocalDate;
import java.util.ArrayList;

public interface DonDatPhongInter {
    ArrayList<DonDatPhong> getalltbDonDatPhong();
    boolean createDonDatPhong(DonDatPhong ddp);
    ArrayList<DonDatPhong> getDonDatPhongTheoMaKH(String maKH);
    ArrayList<DonDatPhong> getDonDatPhongTheoNgayNhanPhong(LocalDate ngayNhanPhong);
    ArrayList<DonDatPhong> timDonDatPhong(String maDDP, String maKH, String maPhong);
    boolean deleteDonDatPhong(String maDDP, String maPhong);
}
