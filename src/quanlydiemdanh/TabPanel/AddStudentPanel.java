package quanlydiemdanh.TabPanel;

import dao.MonHocDAO;
import dao.SinhVienDAO;
import dao.TaiKhoanDAO;
import entity.MonHoc;
import entity.SinhVien;
import quanlydiemdanh.GridBagStatus;
import quanlydiemdanh.Hashing;
import quanlydiemdanh.HomeScreen;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;

public class AddStudentPanel extends JPanel implements ActionListener {
    // Panel
    JPanel SelectSubject = new JPanel();
    JPanel AddStudent = new JPanel();
    JPanel CheckStudent = new JPanel();

    // SelectSubject
    JLabel lb_Subject;
    JComboBox cb_Subject;
    JButton btn_Update;

    // AddStudent
    JLabel lb_SV;
    JLabel lb_MSSV;
    JTextField tf_MSSV;
    JLabel lb_HoVaTen;
    JTextField tf_HoVaTen;
    JLabel lb_GioiTinh;
    JComboBox cb_GioiTinh;
    JButton btn_Add;

    // CheckStudent
    JTable table;
    JScrollPane pane;
    JButton addByTable;

    // Constructor
    public AddStudentPanel() {
        init_SelectSubjectPanel();
        init_AddStudentPanel();
        init_CheckStudentPanel();

        JSplitPane first = new JSplitPane(JSplitPane.VERTICAL_SPLIT, SelectSubject, AddStudent);
        JSplitPane second = new JSplitPane(JSplitPane.VERTICAL_SPLIT, first, CheckStudent);

        this.add(second, (new GridBagStatus()).setGrid(1,1).setFill(GridBagConstraints.BOTH).setWeight(1,1));
        this.setVisible(true);
    }

    private void init_SelectSubjectPanel() {
        GridBagStatus status = new GridBagStatus();

        // Select Subject Panel
        SelectSubject.setLayout(new GridBagLayout());
        SelectSubject.setPreferredSize(new Dimension(650, 50));

        lb_Subject = new JLabel("Chọn môn học: ");
        lb_Subject.setFont(new Font("Tahoma", 0, 24));
        lb_Subject.setHorizontalAlignment(SwingConstants.LEFT);
        lb_Subject.setHorizontalTextPosition(SwingConstants.LEFT);
        lb_Subject.setVerifyInputWhenFocusTarget(false);
        SelectSubject.add(lb_Subject, status.setGrid(1,1).setWitdh(2).setInsets(10,10,10,50).setFill(GridBagConstraints.BOTH));

        cb_Subject = new JComboBox(MonHocDAO.layDanhSachTenMonHoc().toArray());
        cb_Subject.setFont(new Font("Tahoma", 0, 16));
        cb_Subject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                init_table();
                CheckStudent.removeAll();
                CheckStudent.add(pane);
                CheckStudent.setVisible(false);
                CheckStudent.setVisible(true);
            }
        });
        SelectSubject.add(cb_Subject, status.setGrid(3,1).setWitdh(4).setInsets(10,10,10,10));

        btn_Update = new JButton("Cập nhật");
        btn_Update.setFont(new Font("Tahoma", 0, 16));
        btn_Update.setActionCommand("update");
        btn_Update.addActionListener(this);

        SelectSubject.add(btn_Update, status.setGrid(7,1).setWitdh(1).setInsets(10,10, 10, 10));

    }

    private void init_AddStudentPanel() {
        GridBagStatus status = new GridBagStatus();

        // Select Subject Panel
        AddStudent.setLayout(new GridBagLayout());
        AddStudent.setPreferredSize(new Dimension(650, 120));

        lb_SV = new JLabel("Nhập sinh viên: ");
        lb_SV.setFont(new Font("Tahoma", 0, 24));
        lb_SV.setHorizontalAlignment(SwingConstants.LEFT);
        lb_SV.setHorizontalTextPosition(SwingConstants.LEFT);
        lb_SV.setVerifyInputWhenFocusTarget(false);
        AddStudent.add(lb_SV, status.setGrid(1,1).setWitdh(3).setInsets(0,25,0,0).setFill(GridBagConstraints.BOTH).setWeight(1,0));

        lb_HoVaTen = new JLabel("Họ và tên: ");
        lb_HoVaTen.setFont(new Font("Tahoma", 0, 10));
        lb_HoVaTen.setHorizontalAlignment(SwingConstants.LEFT);
        lb_HoVaTen.setHorizontalTextPosition(SwingConstants.LEFT);
        lb_HoVaTen.setVerifyInputWhenFocusTarget(false);
        AddStudent.add(lb_HoVaTen, status.setGrid(1,2).setWitdh(1).setInsets(10,25,5,10));

        tf_HoVaTen = new JTextField();
        tf_HoVaTen.setFont(new Font("Tahoma", 0, 16));
        AddStudent.add(tf_HoVaTen, status.setGrid(1,3).setWitdh(1).setInsets(0,25, 0, 0));

        lb_MSSV = new JLabel("MSSV: ");
        lb_MSSV.setFont(new Font("Tahoma", 0, 10));
        lb_MSSV.setHorizontalAlignment(SwingConstants.LEFT);
        lb_MSSV.setHorizontalTextPosition(SwingConstants.LEFT);
        lb_MSSV.setVerifyInputWhenFocusTarget(false);
        AddStudent.add(lb_MSSV, status.setGrid(2,2).setWitdh(3).setInsets(10,5,5,10));

        tf_MSSV = new JTextField();
        tf_MSSV.setFont(new Font("Tahoma", 0, 16));
        AddStudent.add(tf_MSSV, status.setGrid(2,3).setWitdh(3).setInsets(0,5, 0, 0));

        lb_GioiTinh= new JLabel("Giới tính: ");
        lb_GioiTinh.setFont(new Font("Tahoma", 0, 10));
        lb_GioiTinh.setHorizontalAlignment(SwingConstants.LEFT);
        lb_GioiTinh.setHorizontalTextPosition(SwingConstants.LEFT);
        lb_GioiTinh.setVerifyInputWhenFocusTarget(false);
        AddStudent.add(lb_GioiTinh, status.setGrid(5,2).setWitdh(1).setInsets(10,5,5,10));

        String gt[] = {"Nam", "Nữ"};
        cb_GioiTinh = new JComboBox(gt);
        cb_GioiTinh.setFont(new Font("Tahoma", 0, 16));
        AddStudent.add(cb_GioiTinh, status.setGrid(5,3).setWitdh(1).setInsets(0,5, 0, 0));

        btn_Add = new JButton("Thêm");
        btn_Add.setFont(new Font("Tahoma", 0, 16));
        btn_Add.setActionCommand("add");
        btn_Add.addActionListener(this);
        AddStudent.add(btn_Add, status.setGrid(6,3).setWitdh(1).setInsets(0,5, 0, 15));
    }

    private void init_CheckStudentPanel() {
        // Select Subject Panel
        CheckStudent.setLayout(new BorderLayout());

        init_table();

        CheckStudent.add(pane);
    }

    // Init table
    private void init_table() {
        System.out.println("Selected Item: " + this.cb_Subject.getSelectedItem().toString());
        Object[][] data = MonHocDAO.getNotInData(MonHocDAO.layMaMonHoc(this.cb_Subject.getSelectedItem().toString()));
        String[] cols = {"MSSV", "Họ và tên", "Giới tính", "Thêm"};
        DefaultTableModel model = new DefaultTableModel(data, cols);
        table = new JTable(model) {

            private static final long serialVersionUID = 1L;

            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                    case 1:
                    case 2:
                        return String.class;
                    case 3:
                        return Boolean.class;
                    default:
                        return Double.class;
                }
            }
        };
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setFont(new Font("Tahoma", 0, 16));
        table.getColumn("MSSV").setPreferredWidth(100);
        table.getColumn("Họ và tên").setPreferredWidth(350);
        table.getColumn("Giới tính").setPreferredWidth(150);
        table.getColumn("Thêm").setPreferredWidth(40);
        table.setRowHeight(40);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        table.setDefaultRenderer(String.class, centerRenderer);

        pane = new JScrollPane(table);
    }

    // Event handler
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "add":
                if (this.tf_MSSV.getText().isEmpty() || this.tf_HoVaTen.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "Các ô không được trống", "Lỗi trống ô dữ liệu", JOptionPane.WARNING_MESSAGE, null);
                    break;
                }
                else if (TaiKhoanDAO.layThongTinTaiKhoan(this.tf_MSSV.getText()) != null) {
                    JOptionPane.showMessageDialog(this,
                            "Sinh viên đã tồn tại", "Lỗi sinh viên đã tồn tại", JOptionPane.WARNING_MESSAGE, null);
                    break;
                }

                SinhVienDAO.themSinhVien(new SinhVien(this.tf_MSSV.getText(), this.tf_HoVaTen.getText(), this.cb_GioiTinh.getSelectedItem().toString()));
                SinhVien sv = SinhVienDAO.layThongTinSinhVien(this.tf_MSSV.getText());
                String mmh = MonHocDAO.layMaMonHoc(this.cb_Subject.getSelectedItem().toString());
                MonHoc ttmh = MonHocDAO.layThongTinMonHoc(mmh);
                sv.getDsMonHoc().add(ttmh);

                SinhVienDAO.dangKyLop(sv);
                break;
            case "update":
                for (int i = 0; i < this.table.getRowCount(); i++) {
                    if (Boolean.parseBoolean(this.table.getValueAt(i, 3).toString())) {
                        SinhVien eachCheckedSV = SinhVienDAO.layThongTinSinhVien(this.table.getValueAt(i,0).toString());
                        eachCheckedSV.getDsMonHoc().add(MonHocDAO.layThongTinMonHoc(MonHocDAO.layMaMonHoc(this.cb_Subject.getSelectedItem().toString())));
                        SinhVienDAO.dangKyLop(eachCheckedSV);
                        DefaultTableModel model = (DefaultTableModel) this.table.getModel();
                        model.removeRow(i);
                        i--;
                    }
                }
                break;
        }
    }
}
