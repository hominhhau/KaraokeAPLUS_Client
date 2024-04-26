package interfaceClient;

public interface QuenMatKhauInter {
    boolean updatePasswordTaiKhoan(String soDienThoai, String matKhauMoi);
    String hashPassword(String plainPassword);
    boolean SDT_tonTaiNV(String soDienThoai);
}
