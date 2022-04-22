package quanlydiemdanh;

import dao.GiaoVuDAO;
import dao.SinhVienDAO;
import entity.GiaoVu;
import entity.SinhVien;
import entity.TaiKhoan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class RibbonPanel extends JPanel implements ActionListener {
    // AccountInfo
    private TaiKhoan taiKhoan;
    private SinhVien sinhVien;
    private GiaoVu giaoVu;

    // Panel
    JPanel InfoPanel = new JPanel();
    JPanel ButtonPanel = new JPanel();

    // Label
    private JLabel Info;
    private JLabel AccountType;

    // Button
    private LinkedList<JButton> ribbon_buttons;

    // Constructor
    public RibbonPanel(TaiKhoan tk) {
        // AccountInfo
        this.taiKhoan = tk;
        this.sinhVien = SinhVienDAO.layThongTinSinhVien(tk.getUserName());
        this.giaoVu = GiaoVuDAO.layThongTinGiaoVu(tk.getUserName());

        // Label
        this.Info = new JLabel();
        this.AccountType = new JLabel();

        // Button
        this.ribbon_buttons = new LinkedList<JButton>();

        // Ribbon Buttons
        if (tk.isGiaoVu()) {
            this.Info.setText(giaoVu.getHoVaTen());
            this.AccountType.setText("Giáo Vụ" + " - " + giaoVu.getGioiTinh());

            this.ribbon_buttons.add(new JButton());
            this.ribbon_buttons.getLast().setText("<html><center>Tạo <br>môn học</center></html>");
            this.ribbon_buttons.getLast().setActionCommand("create");
            this.ribbon_buttons.add(new JButton());
            this.ribbon_buttons.getLast().setText("<html><center>Thêm<br>sinh viên</center></html>");
            this.ribbon_buttons.getLast().setActionCommand("add");
            this.ribbon_buttons.add(new JButton());
            this.ribbon_buttons.getLast().setText("<html><center>Kết quả<br>điểm danh</center></html>");
            this.ribbon_buttons.getLast().setActionCommand("result");
        }
        else {
            this.Info.setText(sinhVien.getHoVaTen());
            this.AccountType.setText("Sinh Viên" + " - " + sinhVien.getGioiTinh());

            this.ribbon_buttons.add(new JButton());
            this.ribbon_buttons.getLast().setText("<html><center>Điểm danh<br>môn học</center></html>");
            this.ribbon_buttons.getLast().setActionCommand("attend");
            this.ribbon_buttons.add(new JButton());
            this.ribbon_buttons.getLast().setText("<html><center>Kết quả<br>điểm danh</center></html>");
            this.ribbon_buttons.getLast().setActionCommand("check");
        }

        // Init content
        init();
    }

    // Init Content
    private void init() {
        this.setLayout(new GridBagLayout());
        InfoPanel.setLayout(new GridBagLayout());
        ButtonPanel.setLayout(new GridBagLayout());
        GridBagStatus status = new GridBagStatus();

        // Set Hovaten
        this.Info.setFont(new Font("Tahoma", 0, 20));
        this.Info.setHorizontalAlignment(SwingConstants.LEFT);
        this.Info.setHorizontalTextPosition(SwingConstants.LEFT);
        this.Info.setVerifyInputWhenFocusTarget(false);
        InfoPanel.add(Info, status.setGrid(1,1).setWitdh(2).setInsets(10,10,5,10).setFill(GridBagConstraints.BOTH));

        // Set AccountType
        this.AccountType.setFont(new Font("Tahoma", 0, 16));
        this.AccountType.setHorizontalAlignment(SwingConstants.LEFT);
        this.AccountType.setHorizontalTextPosition(SwingConstants.LEFT);
        this.AccountType.setVerifyInputWhenFocusTarget(false);
        InfoPanel.add(AccountType, status.setGrid(1,2).setWitdh(2).setInsets(0,10,10,10 ));

        // Set Ribbon Buttons
        for (int i = 0; i < ribbon_buttons.size(); i++) {
            this.ribbon_buttons.get(i).setFont(new Font("Tahoma", 0, 15));
            this.ribbon_buttons.get(i).addActionListener(this);
            ButtonPanel.add(ribbon_buttons.get(i), status.setGrid(1 + i*2,1).setHeight(2).setWitdh(2).setWeight(1,1).setFill(GridBagConstraints.BOTH).setInsets(10,10,10,10));
        }

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.InfoPanel, this.ButtonPanel);
        this.add(split, status.setGrid(1,1).setFill(GridBagConstraints.BOTH).setWeight(1,1));
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "create":
            case "attend":
                HomeScreen.homeJTabbedPanel.setSelectedIndex(0);
                break;
            case "add":
            case "check":
                HomeScreen.homeJTabbedPanel.setSelectedIndex(1);
                break;
            case "result":
                HomeScreen.homeJTabbedPanel.setSelectedIndex(2);
                break;
        }
    }
}
