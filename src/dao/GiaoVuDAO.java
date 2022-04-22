package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.List;
import entity.GiaoVu;

public class GiaoVuDAO {
    public static List<GiaoVu> layDanhSachGiaoVu() {
        System.out.println("layDanhSachGiaoVu");
        List<GiaoVu> dsGiaoVu = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from GiaoVu";
        Query query = session.createQuery(hql);
        dsGiaoVu = query.list();

        return dsGiaoVu;
    }

    public static GiaoVu layThongTinGiaoVu(String MaGiaoVu) {
        System.out.println("layThongTinGiaoVu");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        GiaoVu gv = (GiaoVu) session.get(GiaoVu.class, MaGiaoVu);

        session.close();

        return gv;
    }

    public static boolean themGiaoVu(GiaoVu gv) {
        System.out.println("themGiaoVu");
        if(GiaoVuDAO.layThongTinGiaoVu(gv.getMaGiaoVu()) != null)
            return false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(gv);
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

    public static boolean capNhatThongTinGiaoVu(GiaoVu gv) {
        System.out.println("capNhatThongTinGiaoVu");
        if(GiaoVuDAO.layThongTinGiaoVu(gv.getMaGiaoVu()) == null)
            return false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.update(gv);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }

    public static boolean xoaGiaoVu(String MaGiaoVu) {
        System.out.println("xoaGiaoVu");
        GiaoVu gv = GiaoVuDAO.layThongTinGiaoVu(MaGiaoVu);
        if(gv == null)
            return false;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(gv);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }
}