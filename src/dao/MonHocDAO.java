package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.List;
import entity.MonHoc;

public class MonHocDAO {
    public static List<MonHoc> layDanhSachMonHoc() {
        List<MonHoc> dsMonHoc = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from MonHoc";
        Query query = session.createQuery(hql);
        dsMonHoc = query.list();
        return dsMonHoc;
    }

    public static MonHoc layThongTinMonHoc(String MaMonHoc) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        MonHoc mh = (MonHoc) session.get(MonHoc.class, MaMonHoc);

        session.close();

        return mh;
    }

    public static boolean themMonHoc(MonHoc mh) {
        if(MonHocDAO.layThongTinMonHoc(mh.getMaMon()) != null)
            return false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(mh);
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

    public static boolean capNhatThongTinMonHoc(MonHoc mh) {
        if(MonHocDAO.layThongTinMonHoc(mh.getMaMon()) == null)
            return false;
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.update(mh);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }

    public static boolean xoaMonHoc(String MaMonHoc) {
        MonHoc mh = MonHocDAO.layThongTinMonHoc(MaMonHoc);
        if(mh == null)
            return false;
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(mh);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }
}
