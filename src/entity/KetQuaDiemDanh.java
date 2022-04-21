package entity;

public class KetQuaDiemDanh {
    private IDKetQuaDiemDanh idKetQuaDiemDanh;
    private Boolean DiemDanh;

    // Constructor
    public KetQuaDiemDanh() {
    }
    public KetQuaDiemDanh(IDKetQuaDiemDanh idKetQuaDiemDanh, Boolean diemDanh) {
        this.idKetQuaDiemDanh = idKetQuaDiemDanh;
        DiemDanh = diemDanh;
    }

    // Getter & Setter
    public IDKetQuaDiemDanh getIdKetQuaDiemDanh() {
        return idKetQuaDiemDanh;
    }

    public void setIdKetQuaDiemDanh(IDKetQuaDiemDanh idKetQuaDiemDanh) {
        this.idKetQuaDiemDanh = idKetQuaDiemDanh;
    }

    public Boolean getDiemDanh() {
        return DiemDanh;
    }

    public void setDiemDanh(Boolean diemDanh) {
        DiemDanh = diemDanh;
    }
}
