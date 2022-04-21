package entity;

import java.util.HashSet;
import java.util.Set;

public class SinhVien {
    private String MSSV;
    private String HoVaTen;
    private String GioiTinh;
    private Set<MonHoc> dsMonHoc = new HashSet<MonHoc>();
//    private TaiKhoan taiKhoan;

    // Constructor
    public SinhVien() {
    }
//    public SinhVien(String MSSV, String hoVaTen, String gioiTinh, Set<MonHoc> dsMonHoc, TaiKhoan taiKhoan) {
//        this.MSSV = MSSV;
//        this.HoVaTen = hoVaTen;
//        this.GioiTinh = gioiTinh;
//        this.dsMonHoc = dsMonHoc;
//        this.taiKhoan = taiKhoan;
//    }
    public SinhVien(String MSSV, String hoVaTen, String gioiTinh) {
        this.MSSV = MSSV;
        HoVaTen = hoVaTen;
        GioiTinh = gioiTinh;
    }
    public SinhVien(String MSSV, String hoVaTen, String gioiTinh, Set<MonHoc> dsMonHoc) {
        this.MSSV = MSSV;
        HoVaTen = hoVaTen;
        GioiTinh = gioiTinh;
        this.dsMonHoc = dsMonHoc;
    }

    // Getter & Setter
    public String getMSSV() {
        return MSSV;
    }
    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
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

    public Set<MonHoc> getDsMonHoc() {
        return dsMonHoc;
    }
    public void setDsMonHoc(Set<MonHoc> dsMonHoc) {
        this.dsMonHoc = dsMonHoc;
    }

//    public TaiKhoan getTaiKhoan() {
//        return taiKhoan;
//    }
//    public void setTaiKhoan(TaiKhoan taiKhoan) {
//        this.taiKhoan = taiKhoan;
//    }
}
