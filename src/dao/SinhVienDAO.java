package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.List;
import entity.SinhVien;

public class SinhVienDAO {
    public static List<SinhVien> layDanhSachSinhVien() {
        List<SinhVien> dsSinhVien = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from SinhVien";
        Query query = session.createQuery(hql);
        dsSinhVien = query.list();
        return dsSinhVien;
    }

    public static SinhVien layThongTinSinhVien(String MSSV) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        SinhVien sv = (SinhVien) session.get(SinhVien.class, MSSV);

        session.close();

        return sv;
    }

    public static boolean themSinhVien(SinhVien sv) {
        if(SinhVienDAO.layThongTinSinhVien(sv.getMSSV()) != null)
            return false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(sv);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
            return false;
        } finally {
            session.close();
        }
    }

    public static boolean capNhatThongTinSinhVien(SinhVien sv) {
        if(SinhVienDAO.layThongTinSinhVien(sv.getMSSV()) == null)
            return false;
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
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
        SinhVien sv = SinhVienDAO.layThongTinSinhVien(MSSV);
        if(sv == null)
            return false;
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
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
}