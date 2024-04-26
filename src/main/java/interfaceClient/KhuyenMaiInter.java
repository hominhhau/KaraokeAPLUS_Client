package interfaceClient;

import entity.KhuyenMai;

import java.util.ArrayList;

public interface KhuyenMaiInter {
    public ArrayList<KhuyenMai> getAllKhuyenMai();

    public boolean createKhuyenMai(KhuyenMai km);

    public boolean editKhuyenMai(KhuyenMai km);

    public boolean DeleteKhuyenMai(String maKM);

    public String[] getKhuyenMai();

    public KhuyenMai getKhuyenMaiByMaKM(String maKM);
}
