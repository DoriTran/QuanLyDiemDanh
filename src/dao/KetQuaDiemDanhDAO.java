package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;
import java.util.List;
import entity.KetQuaDiemDanh;
import entity.IDKetQuaDiemDanh;

public class KetQuaDiemDanhDAO {
    public static List<KetQuaDiemDanh> layDanhSachKetQuaDiemDanh() {
        List<KetQuaDiemDanh> dsKetQuaDiemDanh = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from KetQuaDiemDanh";
        Query query = session.createQuery(hql);
        dsKetQuaDiemDanh = query.list();
        return dsKetQuaDiemDanh;
    }

    public static KetQuaDiemDanh layThongTinKetQuaDiemDanh(IDKetQuaDiemDanh IDKetQuaDiemDanh) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        KetQuaDiemDanh kqdd = (KetQuaDiemDanh) session.get(KetQuaDiemDanh.class, IDKetQuaDiemDanh);

        session.close();

        return kqdd;
    }

    public static boolean themKetQuaDiemDanh(KetQuaDiemDanh kqdd) {
        if(KetQuaDiemDanhDAO.layThongTinKetQuaDiemDanh(kqdd.getIdKetQuaDiemDanh()) != null)
            return false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(kqdd);
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

    public static boolean capNhatThongTinKetQuaDiemDanh(KetQuaDiemDanh kqdd) {
        if(KetQuaDiemDanhDAO.layThongTinKetQuaDiemDanh(kqdd.getIdKetQuaDiemDanh()) == null)
            return false;
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.update(kqdd);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }

    public static boolean xoaKetQuaDiemDanh(IDKetQuaDiemDanh IDKetQuaDiemDanh) {
        KetQuaDiemDanh kqdd = KetQuaDiemDanhDAO.layThongTinKetQuaDiemDanh(IDKetQuaDiemDanh);
        if(kqdd == null)
            return false;
        Session session=HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.delete(kqdd);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.print(e);
            return false;
        }
    }
}