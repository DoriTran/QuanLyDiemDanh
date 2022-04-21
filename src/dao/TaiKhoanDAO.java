package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.List;
import entity.TaiKhoan;

public class TaiKhoanDAO {
    public static List<TaiKhoan> layDanhSachTaiKhoan() {
        List<TaiKhoan> dsTaiKhoan = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from TaiKhoan";
        Query query = session.createQuery(hql);
        dsTaiKhoan = query.list();
        return dsTaiKhoan;
    }

    public static TaiKhoan layThongTinTaiKhoan(String UserName) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        TaiKhoan kh = (TaiKhoan) session.get(TaiKhoan.class, UserName);

        session.close();

        return kh;
    }

    public static boolean themTaiKhoan(TaiKhoan tk) {
        if(TaiKhoanDAO.layThongTinTaiKhoan(tk.getUserName()) != null)
            return false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(tk);
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

    public static boolean capNhatThongTinTaiKhoan(TaiKhoan tk) {
        if(TaiKhoanDAO.layThongTinTaiKhoan(tk.getUserName()) == null)
            return false;
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.update(tk);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }

    public static boolean xoaTaiKhoan(String UserName) {
        TaiKhoan kh = TaiKhoanDAO.layThongTinTaiKhoan(UserName);
        if(kh == null)
            return false;
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(kh);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }
}