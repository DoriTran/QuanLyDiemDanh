package quanlydiemdanh.TabPanel;

import dao.MonHocDAO;
import entity.MonHoc;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import quanlydiemdanh.TimeCal;
import quanlydiemdanh.GridBagStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;

public class CreateSubjectPanel extends JPanel implements ActionListener {
    // Label
    JLabel lb_Info = new JLabel("THÔNG TIN MÔN HỌC");
    JLabel lb_ID = new JLabel("Mã môn học: ");
    JLabel lb_Name = new JLabel("Tên môn học: ");
    JLabel lb_Schedule = new JLabel("THỜI KHÓA BIỂU");
    JLabel lb_StartDay = new JLabel("Ngày bắt đầu: ");
    JLabel lb_WeekDay = new JLabel("Thứ trong tuần: ");
    JLabel lb_StartTime = new JLabel("Giờ bắt đầu: ");
    JLabel lb_EndTime = new JLabel("Giờ kết thúc: ");
    JLabel lb_ClassRoom = new JLabel("Tên phòng học: ");

    // Input
    JTextField tf_ID = new JTextField();
    JTextField tf_Name = new JTextField();
    JDatePickerImpl dp_StartDay = new JDatePickerImpl(new JDatePanelImpl(new UtilDateModel()));
    String dayInWeek[]={"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    JComboBox cb_WeekDay = new JComboBox(dayInWeek);
    String timeMark[]={"07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00"};
    JComboBox cb_StartTime = new JComboBox(timeMark);
    JComboBox cb_EndTime = new JComboBox(timeMark);
    JTextField tf_ClassRoom = new JTextField();

    // Button
    JButton btn_Add = new JButton("Xác nhận");

    public String checkEmpty() {
        String result = new String("");
        if (this.tf_ID.getText().isEmpty()) result += "• Mã môn học\n";
        if (this.tf_Name.getText().isEmpty()) result += "• Tên môn học\n";
        if (this.dp_StartDay.getModel().getValue() == null) result += "• Ngày bắt đầu\n";
        if (this.tf_ClassRoom.getText().isEmpty()) result += "• Lớp học\n";
        return result;
    }

    public CreateSubjectPanel() {
        // Screen
        this.setLayout(new GridBagLayout());
        GridBagStatus status = new GridBagStatus();

        // Content
        this.lb_Info.setFont(new Font("Tahoma", 1, 24));
        this.lb_Info.setHorizontalAlignment(SwingConstants.CENTER);
        this.lb_Info.setHorizontalTextPosition(SwingConstants.CENTER);
        this.lb_Info.setVerifyInputWhenFocusTarget(false);
        this.add(lb_Info, status.setGrid(2,1).setWitdh(2).setInsets(0,0,15,100).setFill(GridBagConstraints.BOTH));

        // ID
        this.lb_ID.setFont(new Font("Tahoma", 0, 20));
        this.lb_ID.setHorizontalAlignment(SwingConstants.LEFT);
        this.lb_ID.setHorizontalTextPosition(SwingConstants.LEFT);
        this.lb_ID.setVerifyInputWhenFocusTarget(false);
        this.add(lb_ID, status.setGrid(1,2).setWitdh(1).setInsets(0,30,15,10));

        this.tf_ID.setFont(new Font("Tahoma", 0, 20));
        this.add(tf_ID, status.setGrid(2,2).setWitdh(3).setInsets(0,10, 15, 10));

        // Tên môn học
        this.lb_Name.setFont(new Font("Tahoma", 0, 20));
        this.lb_Name.setHorizontalAlignment(SwingConstants.LEFT);
        this.lb_Name.setHorizontalTextPosition(SwingConstants.LEFT);
        this.lb_Name.setVerifyInputWhenFocusTarget(false);
        this.add(lb_Name, status.setGrid(1,3).setWitdh(1).setInsets(0,30,15,10));

        this.tf_Name.setFont(new Font("Tahoma", 0, 20));
        this.add(tf_Name, status.setGrid(2,3).setWitdh(3).setInsets(0,10, 15, 10));

        // Schedule Label
        this.lb_Schedule.setFont(new Font("Tahoma", 1, 24));
        this.lb_Schedule.setHorizontalAlignment(SwingConstants.CENTER);
        this.lb_Schedule.setHorizontalTextPosition(SwingConstants.CENTER);
        this.lb_Schedule.setVerifyInputWhenFocusTarget(false);
        this.add(lb_Schedule, status.setGrid(2,4).setWitdh(2).setInsets(0,0,15,100).setFill(GridBagConstraints.BOTH));

        // Start day
        this.lb_StartDay.setFont(new Font("Tahoma", 0, 20));
        this.lb_StartDay.setHorizontalAlignment(SwingConstants.LEFT);
        this.lb_StartDay.setHorizontalTextPosition(SwingConstants.LEFT);
        this.lb_StartDay.setVerifyInputWhenFocusTarget(false);
        this.add(lb_StartDay, status.setGrid(1,5).setWitdh(1).setInsets(0,30,15,10));

        this.dp_StartDay.setFont(new Font("Tahoma", 0, 20));
        this.add(dp_StartDay, status.setGrid(2,5).setWitdh(3).setInsets(0,10, 15, 10));

        // WeekDay
        this.lb_WeekDay.setFont(new Font("Tahoma", 0, 20));
        this.lb_WeekDay.setHorizontalAlignment(SwingConstants.LEFT);
        this.lb_WeekDay.setHorizontalTextPosition(SwingConstants.LEFT);
        this.lb_WeekDay.setVerifyInputWhenFocusTarget(false);
        this.add(lb_WeekDay, status.setGrid(1,7).setWitdh(1).setInsets(0,30,15,10));

        this.cb_WeekDay.setFont(new Font("Tahoma", 0, 16));
        this.add(cb_WeekDay, status.setGrid(2,7).setWitdh(2).setInsets(0,10,15,10));

        // Start time
        this.lb_StartTime.setFont(new Font("Tahoma", 0, 20));
        this.lb_StartTime.setHorizontalAlignment(SwingConstants.LEFT);
        this.lb_StartTime.setHorizontalTextPosition(SwingConstants.LEFT);
        this.lb_StartTime.setVerifyInputWhenFocusTarget(false);
        this.add(lb_StartTime, status.setGrid(1,8).setWitdh(1).setInsets(0,30,15,10));

        this.cb_StartTime.setFont(new Font("Tahoma", 0, 16));
        this.add(cb_StartTime, status.setGrid(2,8).setWitdh(2).setInsets(0,10,15,10));

        // End time
        this.lb_EndTime.setFont(new Font("Tahoma", 0, 20));
        this.lb_EndTime.setHorizontalAlignment(SwingConstants.LEFT);
        this.lb_EndTime.setHorizontalTextPosition(SwingConstants.LEFT);
        this.lb_EndTime.setVerifyInputWhenFocusTarget(false);
        this.add(lb_EndTime, status.setGrid(1,9).setWitdh(1).setInsets(0,30,15,10));

        this.cb_EndTime.setFont(new Font("Tahoma", 0, 16));
        this.add(cb_EndTime, status.setGrid(2,9).setWitdh(2).setInsets(0,10,15,10));

        // Classroom
        this.lb_ClassRoom.setFont(new Font("Tahoma", 0, 20));
        this.lb_ClassRoom.setHorizontalAlignment(SwingConstants.LEFT);
        this.lb_ClassRoom.setHorizontalTextPosition(SwingConstants.LEFT);
        this.lb_ClassRoom.setVerifyInputWhenFocusTarget(false);
        this.add(lb_ClassRoom, status.setGrid(1,10).setWitdh(1).setInsets(0,30,15,10));

        this.tf_ClassRoom.setFont(new Font("Tahoma", 0, 20));
        this.add(tf_ClassRoom, status.setGrid(2,10).setWitdh(3).setInsets(0,10, 15, 10));

        // Button
        this.btn_Add.setFont(new Font("Tahoma", 0, 16));
        this.btn_Add.setActionCommand("add");
        this.btn_Add.addActionListener(this);
        this.add(btn_Add, status.setGrid(1,11).setWitdh(3).setInsets(25,55, 30, 55).setFill(GridBagConstraints.CENTER));
    }

    // Event handler
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "add":
                if (!checkEmpty().isEmpty()) {
                    JOptionPane.showMessageDialog(this,
                            "Các ô dữ liệu không được trống: \n" + checkEmpty(), "Lỗi trống thông tin", JOptionPane.WARNING_MESSAGE, null);
                    break;
                }
                else if (this.cb_StartTime.getSelectedIndex() >= this.cb_EndTime.getSelectedIndex()) {
                    JOptionPane.showMessageDialog(this,
                            "Giờ kết thúc phải sau giờ bắt đầu", "Lỗi sai giờ", JOptionPane.WARNING_MESSAGE, null);
                    this.cb_StartTime.setSelectedIndex(0);
                    this.cb_EndTime.setSelectedIndex(0);
                    break;
                }

                // Create new subject
                Date start_date = new java.sql.Date(((java.util.Date) this.dp_StartDay.getModel().getValue()).getTime());
                Date end_date = TimeCal.addWeek(start_date, 15);
                Time start_time = new Time(Integer.parseInt(cb_StartTime.getSelectedItem().toString().split(":")[0]), 0, 0);
                Time end_time = new Time(Integer.parseInt(cb_EndTime.getSelectedItem().toString().split(":")[0]), 0, 0);

                MonHoc mh = new MonHoc(this.tf_ID.getText(), this.tf_Name.getText(),
                    start_date, end_date, this.cb_WeekDay.getSelectedIndex() + 2,
                    start_time, end_time, this.tf_ClassRoom.getText());

                if(!MonHocDAO.themMonHoc(mh)) {
                    JOptionPane.showMessageDialog(this,
                            "Mã lớp học đã tồi tại:", "Lỗi thông tin lớp học", JOptionPane.WARNING_MESSAGE, null);
                    break;
                }
                else {
                    this.tf_ID.setText("");
                    this.tf_Name.setText("");
                    this.tf_ClassRoom.setText("");
                    this.cb_StartTime.setSelectedIndex(0);
                    this.cb_EndTime.setSelectedIndex(0);
                    this.cb_WeekDay.setSelectedIndex(0);
                }

                break;
            default:
                break;
        }
    }
}
