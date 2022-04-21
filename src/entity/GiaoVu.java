package entity;

public class GiaoVu {
    private String MaGiaoVu;
    private String HoVaTen;
    private String GioiTinh;
    private TaiKhoan taiKhoan;

    // Constructor
    public GiaoVu() {
    }
    public GiaoVu(String maGiaoVu, String hoVaTen, String gioiTinh) {
        MaGiaoVu = maGiaoVu;
        HoVaTen = hoVaTen;
        GioiTinh = gioiTinh;
    }
    public GiaoVu(String maGiaoVu, String hoVaTen, String gioiTinh, TaiKhoan taiKhoan) {
        MaGiaoVu = maGiaoVu;
        HoVaTen = hoVaTen;
        GioiTinh = gioiTinh;
        this.taiKhoan = taiKhoan;
    }

    // Getter & Setter
    public String getMaGiaoVu() {
        return MaGiaoVu;
    }
    public void setMaGiaoVu(String maGiaoVu) {
        MaGiaoVu = maGiaoVu;
    }

    public String getHoVaTen() {
        return HoVaTen;
    }
    public void setHoVaTen(String hoVaTen) {
        HoVaTen = hoVaTen;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }
    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public TaiKhoan getTaiKhoan() {
        return taiKhoan;
    }
    public void setTaiKhoan(TaiKhoan taiKhoan) {
        this.taiKhoan = taiKhoan;
    }
}
