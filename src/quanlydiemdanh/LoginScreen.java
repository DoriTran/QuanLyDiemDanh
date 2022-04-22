package quanlydiemdanh;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import dao.TaiKhoanDAO;
import entity.TaiKhoan;

public class LoginScreen extends JFrame implements ActionListener {
    // Label
    private JLabel lb_AppTitle;
    private JLabel lb_LoginTitle;
    private JLabel lb_UserName;
    private JLabel lb_PassWord;

    // Text Field
    private JTextField tf_UserName;
    private JPasswordField pf_PassWord;

    // Button
    private JButton btn_Login;

    // Constructor
    public LoginScreen() {
        // Label
        this.lb_AppTitle = new JLabel("HỆ THỐNG ĐIỂM DANH");
        this.lb_LoginTitle = new JLabel("ĐĂNG NHẬP");
        this.lb_UserName = new JLabel("Username:");
        this.lb_PassWord = new JLabel("Password:");

        // Text field
        this.tf_UserName = new JTextField();
        this.pf_PassWord = new JPasswordField();

        // Button
        this.btn_Login = new JButton("Đăng nhập");

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
        this.lb_LoginTitle.setFont(new Font("Tahoma", 0, 18));
        this.lb_LoginTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.lb_LoginTitle.setHorizontalTextPosition(SwingConstants.CENTER);
        this.lb_LoginTitle.setVerifyInputWhenFocusTarget(false);
        loginPanel.add(lb_LoginTitle, status.setGrid(1,2).setWitdh(2).setInsets(5,45,15,45));

        // Set UserName Label
        this.lb_UserName.setFont(new Font("Tahoma", 0, 14));
        this.lb_UserName.setHorizontalAlignment(SwingConstants.CENTER);
        this.lb_UserName.setHorizontalTextPosition(SwingConstants.CENTER);
        this.lb_UserName.setVerifyInputWhenFocusTarget(false);
        loginPanel.add(lb_UserName, status.setGrid(1,3).setWitdh(1).setInsets(5,55,15,5));

        // Set UserName TextField
        this.tf_UserName.setText("");
        this.tf_UserName.setFont(new Font("Tahoma", 0, 14));
        loginPanel.add(tf_UserName, status.setGrid(2,3).setWitdh(2).setInsets(5,5, 15, 55));

        // Set PassWord Label
        this.lb_PassWord.setFont(new Font("Tahoma", 0, 14));
        this.lb_PassWord.setHorizontalAlignment(SwingConstants.CENTER);
        this.lb_PassWord.setHorizontalTextPosition(SwingConstants.CENTER);
        this.lb_PassWord.setVerifyInputWhenFocusTarget(false);
        loginPanel.add(lb_PassWord, status.setGrid(1,4).setWitdh(1).setInsets(5,55,10,5));

        // Set UserName TextField
        this.pf_PassWord.setText("");
        this.pf_PassWord.setFont(new Font("Tahoma", 0, 14));
        loginPanel.add(pf_PassWord, status.setGrid(2,4).setWitdh(2).setInsets(5,5, 15, 55));

        // Set Login Button
        this.btn_Login.setFont(new Font("Tahoma", 0, 16));
        this.btn_Login.setActionCommand("login");
        this.btn_Login.addActionListener(this);
        getRootPane().setDefaultButton(this.btn_Login);
        loginPanel.add(btn_Login, status.setGrid(1,5).setWitdh(2).setInsets(25,55, 30, 55).setFill(GridBagConstraints.CENTER));

        // Connect database
        TaiKhoanDAO.layThongTinTaiKhoan("");

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
            case "login":
                this.tf_UserName.setText("GV0003");
                this.pf_PassWord.setText("GiaoVu03");
                // Login Info checking
                TaiKhoan tk = TaiKhoanDAO.layThongTinTaiKhoan(this.tf_UserName.getText());
                if (tk == null) {
                    JOptionPane.showMessageDialog(this,
                            "Tài khoản không tồn tại", "Lỗi không tồn tại", JOptionPane.ERROR_MESSAGE, null);
                    this.tf_UserName.setText("");
                    this.pf_PassWord.setText("");
                    break;
                }
                else if (!tk.getAcPassWord().equals(Hashing.hash(new String(this.pf_PassWord.getPassword())))) {
                    JOptionPane.showMessageDialog(this,
                            "Sai mật khẩu", "Lỗi sai mật khẩu", JOptionPane.WARNING_MESSAGE, null);
                    this.tf_UserName.setText("");
                    this.pf_PassWord.setText("");
                    break;
                }

                // Redirect
                setVisible(false);
                dispose();
                if (!tk.isGiaoVu() && tk.getUserName().equals(new String(this.pf_PassWord.getPassword()))) {
                    System.out.println("Doi mk");
                    new ResetPassScreen(tk);
                }
                else {
                    System.out.println("Home");
                    new HomeScreen(tk);
                }

                break;
            default:
                break;
        }
    }
}