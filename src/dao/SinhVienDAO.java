package dao;

import entity.TaiKhoan;
import org.hibernate.Query;
import org.hibernate.Session;
import quanlydiemdanh.Hashing;
import util.HibernateUtil;
import java.util.List;
import entity.SinhVien;

public class SinhVienDAO {
    public static List<SinhVien> layDanhSachSinhVien() {
        System.out.println("layDanhSachSinhVien");
        List<SinhVien> dsSinhVien = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String hql = "from SinhVien";
        Query query = session.createQuery(hql);
        dsSinhVien = query.list();
        session.close();
        return dsSinhVien;
    }

    public static SinhVien layThongTinSinhVien(String MSSV) {
        System.out.println("layThongTinSinhVien");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SinhVien sv = (SinhVien) session.get(SinhVien.class, MSSV);

        session.close();

        return sv;
    }

    public static boolean themSinhVien(SinhVien sv) {
        System.out.println("themSinhVien");
        if(SinhVienDAO.layThongTinSinhVien(sv.getMSSV()) != null)
            return false;
        TaiKhoanDAO.themTaiKhoan(new TaiKhoan(sv.getMSSV(), Hashing.hash(sv.getMSSV()), "SV"));
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(sv);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
            session.close();
            return false;
        }
    }

    public static boolean capNhatThongTinSinhVien(SinhVien sv) {
        System.out.println("capNhatThongTinSinhVien");
        if(SinhVienDAO.layThongTinSinhVien(sv.getMSSV()) == null)
            return false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.update(sv);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }

    public static boolean xoaSinhVien(String MSSV) {
        System.out.println("xoaSinhVien");
        SinhVien sv = SinhVienDAO.layThongTinSinhVien(MSSV);
        if(sv == null)
            return false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(sv);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }

    public static boolean dangKyLop(SinhVien info) {
        System.out.println("dangKyLop");
        boolean kq = true;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.saveOrUpdate(info);
            session.getTransaction().commit();
        } catch (Exception ex) {
            kq = false;
            System.out.append(ex.getMessage());
        }

        session.close();

        return kq;
    }
}