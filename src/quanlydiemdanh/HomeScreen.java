package quanlydiemdanh;

import dao.TaiKhoanDAO;
import entity.TaiKhoan;
import quanlydiemdanh.TabPanel.*;

import javax.swing.*;
import java.awt.*;

public class HomeScreen extends JFrame {
    // Data
    TaiKhoan taiKhoan;

    // Panel
    public static RibbonPanel ribbonPanel;
    public static JTabbedPane homeJTabbedPanel;

    // Button
    private JButton btn_Confirm;

    // Constructor
    public HomeScreen(TaiKhoan tk) {
        // Data
        this.taiKhoan = tk;

        // Button
        this.btn_Confirm = new JButton("Xác nhận");

        // Init content
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    // Init Content
    private void init() {
        // Screen
        JPanel homePanel = new JPanel(new GridBagLayout());
        GridBagStatus status = new GridBagStatus();

        // Init Panel
        homeJTabbedPanel = new JTabbedPane();
        if (taiKhoan.isGiaoVu()) {
            homeJTabbedPanel.add("Tạo môn học mới", new CreateSubjectPanel());
            homeJTabbedPanel.add("Thêm sinh viên", new AddStudentPanel());
            homeJTabbedPanel.add("Kết quả điểm danh", new AttendanceResultGVPanel());
        }
        else {
            homeJTabbedPanel.add("Điểm danh môn học", new AttendCheckingPanel());
            homeJTabbedPanel.add("Kết quả điểm danh", new AttendanceRecordSVPanel());
        }
        ribbonPanel = new RibbonPanel(taiKhoan);
        // Split
        JSplitPane homeSplitContentPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ribbonPanel, homeJTabbedPanel);
        homePanel.add(homeSplitContentPanel, status.setGrid(1,1).setFill(GridBagConstraints.BOTH).setWeight(1,1) );

        // Main
        this.setTitle("Quản lý điểm danh");
        this.setContentPane(homePanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(680,800));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //
    }
}