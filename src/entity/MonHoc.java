package entity;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

public class MonHoc {
    private String MaMon;
    private String TenMon;
    private Date NgayBatDauHoc;
    private Date NgayKetThucMon;
    private Integer ThuTrongTuan;
    private Time GioBatDau;
    private Time GioKetThuc;
    private String TenPhongHoc;
    private Set<SinhVien> dsSinhVien = new HashSet<SinhVien>();

    // Constructor
    public MonHoc() {
    }
    public MonHoc(String maMon, String tenMon, Date ngayBatDauHoc, Date ngayKetThucMon, Integer thuTrongTuan, Time gioBatDau, Time gioKetThuc, String tenPhongHoc) {
        MaMon = maMon;
        TenMon = tenMon;
        NgayBatDauHoc = ngayBatDauHoc;
        NgayKetThucMon = ngayKetThucMon;
        ThuTrongTuan = thuTrongTuan;
        GioBatDau = gioBatDau;
        GioKetThuc = gioKetThuc;
        TenPhongHoc = tenPhongHoc;
    }
    public MonHoc(String maMon, String tenMon, Date ngayBatDauHoc, Date ngayKetThucMon, Integer thuTrongTuan, Time gioBatDau, Time gioKetThuc, String tenPhongHoc, Set<SinhVien> dsSinhVien) {
        MaMon = maMon;
        TenMon = tenMon;
        NgayBatDauHoc = ngayBatDauHoc;
        NgayKetThucMon = ngayKetThucMon;
        ThuTrongTuan = thuTrongTuan;
        GioBatDau = gioBatDau;
        GioKetThuc = gioKetThuc;
        TenPhongHoc = tenPhongHoc;
        this.dsSinhVien = dsSinhVien;
    }

    // Getter & Setter

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String maMon) {
        MaMon = maMon;
    }

    public String getTenMon() {
        return TenMon;
    }

    public void setTenMon(String tenMon) {
        TenMon = tenMon;
    }

    public Date getNgayBatDauHoc() {
        return NgayBatDauHoc;
    }

    public void setNgayBatDauHoc(Date ngayBatDauHoc) {
        NgayBatDauHoc = ngayBatDauHoc;
    }

    public Date getNgayKetThucMon() {
        return NgayKetThucMon;
    }

    public void setNgayKetThucMon(Date ngayKetThucMon) {
        NgayKetThucMon = ngayKetThucMon;
    }

    public Integer getThuTrongTuan() {
        return ThuTrongTuan;
    }

    public void setThuTrongTuan(Integer thuTrongTuan) {
        ThuTrongTuan = thuTrongTuan;
    }

    public Time getGioBatDau() {
        return GioBatDau;
    }

    public void setGioBatDau(Time gioBatDau) {
        GioBatDau = gioBatDau;
    }

    public Time getGioKetThuc() {
        return GioKetThuc;
    }

    public void setGioKetThuc(Time gioKetThuc) {
        GioKetThuc = gioKetThuc;
    }

    public String getTenPhongHoc() {
        return TenPhongHoc;
    }

    public void setTenPhongHoc(String tenPhongHoc) {
        TenPhongHoc = tenPhongHoc;
    }

    public Set<SinhVien> getDsSinhVien() {
        return dsSinhVien;
    }

    public void setDsSinhVien(Set<SinhVien> dsSinhVien) {
        this.dsSinhVien = dsSinhVien;
    }
}
