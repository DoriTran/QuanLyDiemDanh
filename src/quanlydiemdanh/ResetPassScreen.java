package quanlydiemdanh;

import dao.TaiKhoanDAO;
import entity.TaiKhoan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetPassScreen extends JFrame implements ActionListener {
    // Data
    TaiKhoan taiKhoan;

    // Label
    private JLabel lb_AppTitle;
    private JLabel lb_ResetPassTitle;
    private JLabel lb_UserName;
    private JLabel lb_PassWord;
    private JLabel lb_PassWordRetype;

    // Text Field
    private JTextField tf_UserName;
    private JPasswordField pf_PassWord;
    private JPasswordField pf_PassWordRetype;

    // Button
    private JButton btn_Confirm;

    // Constructor
    public ResetPassScreen(TaiKhoan tk) {
        // Data
        this.taiKhoan = tk;

        // Label
        this.lb_AppTitle = new JLabel("HỆ THỐNG ĐIỂM DANH");
        this.lb_ResetPassTitle = new JLabel("ĐỔI MẬT KHẨU");
        this.lb_UserName = new JLabel("Username:");
        this.lb_PassWord = new JLabel("Password:");
        this.lb_PassWordRetype = new JLabel("Retype:");

        // Text field
        this.tf_UserName = new JTextField();
        this.pf_PassWord = new JPasswordField();
        this.pf_PassWordRetype = new JPasswordField();

        // Button
        this.btn_Confirm = new JButton("Xác nhận");

        // Init content
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    // Init Content
    private void init() {
        // Screen
        JPanel loginPanel = new JPanel(new GridBagLayout());
        GridBagStatus status = new GridBagStatus();

        // Set App Title
        this.lb_AppTitle.setFont(new Font("Tahoma", 1, 22));
        this.lb_AppTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.lb_AppTitle.setHorizontalTextPosition(SwingConstants.CENTER);
        this.lb_AppTitle.setVerifyInputWhenFocusTarget(false);
        loginPanel.add(lb_AppTitle, status.setGrid(1,1).setWitdh(2).setInsets(30,45,5,45).setFill(GridBagConstraints.BOTH));

        // Set Login Title
        this.lb_ResetPassTitle.setFont(new Font("Tahoma", 0, 18));
        this.lb_ResetPassTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.lb_ResetPassTitle.setHorizontalTextPosition(SwingConstants.CENTER);
        this.lb_ResetPassTitle.setVerifyInputWhenFocusTarget(false);
        loginPanel.add(lb_ResetPassTitle, status.setGrid(1,2).setWitdh(2).setInsets(5,45,15,45));

        // Set UserName Label
        this.lb_UserName.setFont(new Font("Tahoma", 0, 14));
        this.lb_UserName.setHorizontalAlignment(SwingConstants.CENTER);
        this.lb_UserName.setHorizontalTextPosition(SwingConstants.CENTER);
        this.lb_UserName.setVerifyInputWhenFocusTarget(false);
        loginPanel.add(lb_UserName, status.setGrid(1,3).setWitdh(1).setInsets(5,55,15,5));

        // Set UserName TextField
        this.tf_UserName.setText(taiKhoan.getUserName());
        this.tf_UserName.setFont(new Font("Tahoma", 0, 14));
        this.tf_UserName.setEditable(false);
        loginPanel.add(tf_UserName, status.setGrid(2,3).setWitdh(2).setInsets(5,5, 15, 55));

        // Set PassWord Label
        this.lb_PassWord.setFont(new Font("Tahoma", 0, 14));
        this.lb_PassWord.setHorizontalAlignment(SwingConstants.CENTER);
        this.lb_PassWord.setHorizontalTextPosition(SwingConstants.CENTER);
        this.lb_PassWord.setVerifyInputWhenFocusTarget(false);
        loginPanel.add(lb_PassWord, status.setGrid(1,4).setWitdh(1).setInsets(5,55,15,5));

        // Set PassWord TextField
        this.pf_PassWord.setText("");
        this.pf_PassWord.setFont(new Font("Tahoma", 0, 14));
        loginPanel.add(pf_PassWord, status.setGrid(2,4).setWitdh(2).setInsets(5,5, 15, 55));

        // Set PassWord Label
        this.lb_PassWordRetype.setFont(new Font("Tahoma", 0, 14));
        this.lb_PassWordRetype.setHorizontalAlignment(SwingConstants.CENTER);
        this.lb_PassWordRetype.setHorizontalTextPosition(SwingConstants.CENTER);
        this.lb_PassWordRetype.setVerifyInputWhenFocusTarget(false);
        loginPanel.add(lb_PassWordRetype, status.setGrid(1,5).setWitdh(1).setInsets(5,55,10,5));

        // Set UserName TextField
        this.pf_PassWordRetype.setText("");
        this.pf_PassWordRetype.setFont(new Font("Tahoma", 0, 14));
        loginPanel.add(pf_PassWordRetype, status.setGrid(2,5).setWitdh(2).setInsets(5,5, 15, 55));

        // Set Login Button
        this.btn_Confirm.setFont(new Font("Tahoma", 0, 16));
        this.btn_Confirm.setActionCommand("confirm");
        this.btn_Confirm.addActionListener(this);
        getRootPane().setDefaultButton(this.btn_Confirm);
        loginPanel.add(btn_Confirm, status.setGrid(1,6).setWitdh(2).setInsets(25,55, 30, 55).setFill(GridBagConstraints.CENTER));

        // Main
        this.setTitle("Quản lý điểm danh");
        this.setContentPane(loginPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    // Event handler
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "confirm":
                // Check
                if (!(new String(this.pf_PassWord.getPassword()).equals(new String(this.pf_PassWordRetype.getPassword())))) {
                    JOptionPane.showMessageDialog(this,
                            "Mật khẩu và Mật khẩu nhập lại không trùng khớp", "Lỗi sai không trùng khớp", JOptionPane.WARNING_MESSAGE, null);
                    this.pf_PassWord.setText("");
                    this.pf_PassWordRetype.setText("");
                    break;
                }
                else if (Hashing.hash(new String(this.pf_PassWord.getPassword())).equals(taiKhoan.getAcPassWord())) {
                    JOptionPane.showMessageDialog(this,
                            "Mật khẩu giống với mật khẩu cũ", "Lỗi sai giống mật khẩu cũ", JOptionPane.WARNING_MESSAGE, null);
                    this.pf_PassWord.setText("");
                    this.pf_PassWordRetype.setText("");
                    break;
                }
                else if (new String(this.pf_PassWord.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "Mật khẩu mới không được rỗng", "Lỗi mật khẩu không hợp lệ", JOptionPane.WARNING_MESSAGE, null);
                    this.pf_PassWord.setText("");
                    this.pf_PassWordRetype.setText("");
                    break;
                }

                // Đổi mật khẩu
                taiKhoan.setAcPassWord(Hashing.hash(new String(this.pf_PassWord.getPassword())));
                System.out.println(Hashing.hash(new String(this.pf_PassWord.getPassword())));
                TaiKhoanDAO.capNhatThongTinTaiKhoan(taiKhoan);

                // Redirect
                setVisible(false);
                dispose();
                new HomeScreen(taiKhoan);

                break;
            default:
                break;
        }
    }
}