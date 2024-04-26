package interfaceClient;

public interface TaiKhoanInter {
    boolean authenticate(String maNV, String plainPassword) throws Exception;
    boolean taoTK(String maNV);
    boolean nhoMK(String maNV, StringBuilder password);
    String hashPassword(String plainPassword);
}
