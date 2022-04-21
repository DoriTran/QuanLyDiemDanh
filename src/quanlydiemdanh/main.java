package quanlydiemdanh;

import dao.*;
import entity.*;

import java.util.List;

public class main {
//    public static void main(String[] args) {
//        List<KetQuaDiemDanh> ds = KetQuaDiemDanhDAO.layDanhSachKetQuaDiemDanh();
//        for (int i = 0; i < ds.size(); i++) {
//            System.out.println(ds.get(i).getDiemDanh() + " "
//                    + ds.get(i).getIdKetQuaDiemDanh().getMaMon() + " "
//                    + ds.get(i).getIdKetQuaDiemDanh().getTuanDiemDanh() + " "
//                    + ds.get(i).getIdKetQuaDiemDanh().getMSSV()
//            );
//        }
//    }

//    public static void main(String[] args) {
//        IDKetQuaDiemDanh id = new IDKetQuaDiemDanh("MTH0002", "19120009", 1);
//        KetQuaDiemDanh kh = KetQuaDiemDanhDAO.layThongTinKetQuaDiemDanh(id);
//        System.out.println(kh.getDiemDanh());
//        System.out.println(kh.getIdKetQuaDiemDanh().getMaMon());
//        System.out.println(kh.getIdKetQuaDiemDanh().getMSSV());
//        System.out.println(kh.getIdKetQuaDiemDanh().getTuanDiemDanh());
//    }

//    public static void main(String[] args) {
//        IDKetQuaDiemDanh id = new IDKetQuaDiemDanh("MTH0002", "19120009", 8);
//        KetQuaDiemDanh kh = new KetQuaDiemDanh(id, true);
//        if(KetQuaDiemDanhDAO.themKetQuaDiemDanh(kh) == true)
//            System.out.println("Thêm thành công!");
//        else
//            System.out.println("Thêm không thành công!");
//    }

//    public static void main(String[] args) {
//        IDKetQuaDiemDanh id = new IDKetQuaDiemDanh("MTH0002", "19120009", 8);
//        KetQuaDiemDanh kh = new KetQuaDiemDanh(id, false);
//        if (KetQuaDiemDanhDAO.capNhatThongTinKetQuaDiemDanh(kh) == true) {
//            System.out.println("Cập nhật thành công!");
//        } else {
//            System.out.println("Cập nhật thất bại!");
//        }
//    }

    public static void main(String[] args) {
        IDKetQuaDiemDanh id = new IDKetQuaDiemDanh("MTH0002", "19120009", 8);
        if (KetQuaDiemDanhDAO.xoaKetQuaDiemDanh(id) == true) {
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Xóa thất bại!");
        }
    }
}