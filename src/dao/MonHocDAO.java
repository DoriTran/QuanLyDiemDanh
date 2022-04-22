package dao;

import entity.SinhVien;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.*;

import entity.MonHoc;

public class MonHocDAO {
    public static List<MonHoc> layDanhSachMonHoc() {
        System.out.println("layDanhSachMonHoc");
        List<MonHoc> dsMonHoc = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String hql = "from MonHoc";
        Query query = session.createQuery(hql);
        dsMonHoc = query.list();
        return dsMonHoc;
    }

    public static MonHoc layThongTinMonHoc(String MaMonHoc) {
        System.out.println("layThongTinMonHoc");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        MonHoc mh = (MonHoc) session.get(MonHoc.class, MaMonHoc);

        session.close();

        return mh;
    }

    public static boolean themMonHoc(MonHoc mh) {
        System.out.println("themMonHoc");
        if(MonHocDAO.layThongTinMonHoc(mh.getMaMon()) != null)
            return false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(mh);
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

    public static boolean capNhatThongTinMonHoc(MonHoc mh) {
        System.out.println("capNhatThongTinMonHoc");
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
        System.out.println("xoaMonHoc");
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

    // Lấy danh sách tên môn học
    public static List<String> layDanhSachTenMonHoc() {
        System.out.println("layDanhSachTenMonHoc");

        List<String> dsMonHoc = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String hql = "select TenMon from MonHoc";
        Query query = session.createQuery(hql);
        dsMonHoc = query.list();

        session.close();

        return dsMonHoc;
    }

    public static String layMaMonHoc(String TenMonHoc) {
        System.out.println("layMaMonHoc");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        // Get MaMon
        String hql = "select MaMon from MonHoc where TenMon = '" + TenMonHoc + "'";
        Query query = session.createQuery(hql);
        List<String> rz = query.list();

        session.close();

        return rz.get(0);
    }

    // Lấy danh sách sinh viên chưa tham gia
    public static Object[][] getNotInData(String MaMon) {
        System.out.println("getNotInData");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        // Get danh sach sv
        LinkedList<SinhVien> sv = new LinkedList<SinhVien>(SinhVienDAO.layDanhSachSinhVien());

        for (int i = 0; i < sv.size(); i++) {
            Set<MonHoc> mh = sv.get(i).getDsMonHoc();

            for (MonHoc each : mh) {
                if (each.getMaMon().equals(MaMon)) {
                    sv.remove(i);
                    i--;
                    break;
                }
            }

        }

        // Get Data
        Object[][] data = new Object[sv.size()][4];
        for (int i = 0; i < sv.size(); i++) {
            data[i][0] = sv.get(i).getMSSV();
            data[i][1] = sv.get(i).getHoVaTen();
            data[i][2] = sv.get(i).getGioiTinh();
            data[i][3] = false;
        }

        session.close();

        return data;
    }

    // Kiểm tra sinh viên đã tham gia chưa
    public static boolean isInData(String MaMon, String MSSV) {
        System.out.println("isInData");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();

        // Get danh sach sv
        LinkedList<SinhVien> sv = new LinkedList<SinhVien>(MonHocDAO.layThongTinMonHoc(MaMon).getDsSinhVien());

        for (int i = 0; i < sv.size(); i++) {
            if (sv.get(i).getMSSV().equals(MSSV)) {
                session.close();
                return true;
            }
        }

        session.close();

        return false;
    }
}
