package entity;

public class IDKetQuaDiemDanh implements java.io.Serializable {
    private String MaMon;
    private String MSSV;
    private Integer TuanDiemDanh;

    // Constructor
    public IDKetQuaDiemDanh() {
    }
    public IDKetQuaDiemDanh(String maMon, String MSSV, Integer tuanDiemDanh) {
        MaMon = maMon;
        this.MSSV = MSSV;
        TuanDiemDanh = tuanDiemDanh;
    }

    // Getter & Setter
    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String maMon) {
        MaMon = maMon;
    }

    public String getMSSV() {
        return MSSV;
    }

    public void setMSSV(String MSSV) {
        this.MSSV = MSSV;
    }

    public Integer getTuanDiemDanh() {
        return TuanDiemDanh;
    }

    public void setTuanDiemDanh(Integer tuanDiemDanh) {
        TuanDiemDanh = tuanDiemDanh;
    }
}