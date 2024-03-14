package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.UserModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class DangNhap extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField_dangNhap;
	private JPasswordField textField_matKhau;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DangNhap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DangNhap.class.getResource("/Res/cafe-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 128));
		panel.setBounds(0, 0, 500, 600);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel label_dangNhap = new JLabel("Hệ Thống Quản Lý Coffee");
		label_dangNhap.setBackground(new Color(0,0,0));
		label_dangNhap.setForeground(new Color(0, 0, 0));
		label_dangNhap.setFont(new Font("Arial", Font.ITALIC, 15));
		label_dangNhap.setHorizontalAlignment(SwingConstants.CENTER);
		label_dangNhap.setBounds(0, 0, 488, 79);
		panel.add(label_dangNhap);
		
		JLabel label_user = new JLabel("Tên Đăng Nhập");
		label_user.setFont(new Font("Arial", Font.ITALIC, 15));
		label_user.setIcon(new ImageIcon(DangNhap.class.getResource("/Res/user-icon.png")));
		label_user.setBounds(12, 187, 199, 48);
		panel.add(label_user);
		
		JLabel label_password = new JLabel("Mật Khẩu");
		label_password.setFont(new Font("Arial", Font.ITALIC, 15));
		label_password.setIcon(new ImageIcon(DangNhap.class.getResource("/Res/Password-icon.png")));
		label_password.setBounds(12, 271, 185, 48);
		panel.add(label_password);
		
		textField_dangNhap = new JTextField();
		textField_dangNhap.setBounds(241, 193, 179, 37);
		panel.add(textField_dangNhap);
		
		textField_matKhau = new JPasswordField();
		textField_matKhau.setBounds(241, 278, 179, 34);
		panel.add(textField_matKhau);
		
		JButton button_dangNhap = new JButton("Đăng Nhập");
		button_dangNhap.setFont(new Font("Arial", Font.ITALIC, 15));
		button_dangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_dangNhap.getText().isEmpty() || textField_matKhau.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(DangNhap.this,
						    "Tên Đăng Nhập Hoặc Mật Khẩu không được thiếu !",
						    "ERROR",
						    JOptionPane.PLAIN_MESSAGE);
				}
				else 
				{
					String user = textField_dangNhap.getText();
					String password = textField_matKhau.getText();
					boolean kiemTra = false;
					for(String s : UserModel.getDanhSachUser())
					{
						if(s.equals(user))
						{
							kiemTra = true;
							break;
						}
					}
						if(kiemTra)
						{
							if(password.equals(UserModel.getDanhSachTaiKhoan().get(user)))
							{
								DangNhap.this.setVisible(false);
								new GiaoDienChinh();
							}
							else 
							{
								JOptionPane.showMessageDialog(DangNhap.this,
									    "Mật Khẩu không đúng !",
									    "ERROR",
									    JOptionPane.PLAIN_MESSAGE);
							}
						}
						else 
						{
							JOptionPane.showMessageDialog(DangNhap.this,
								    "Tên đăng nhập không tìm thấy !",
								    "ERROR",
								    JOptionPane.PLAIN_MESSAGE);
						}
					}
						
				}
			
		});
		button_dangNhap.setBounds(287, 369, 133, 37);
		panel.add(button_dangNhap);
		
		/*
		 * JLabel label_note1 = new
		 * JLabel("Tên Đăng Nhập và Mật Khẩu được xây dựng trước, do không có chỗ lưu. "
		 * ); label_note1.setFont(new Font("Arial", Font.ITALIC, 12));
		 * label_note1.setBounds(0, 436, 488, 65); panel.add(label_note1);
		 * 
		 * JLabel label_note2 = new
		 * JLabel("Tên Đăng Nhập : user123, Mật Khẩu : 123456"); label_note2.setFont(new
		 * Font("Arial", Font.ITALIC, 12)); label_note2.setBounds(0, 498, 488, 65);
		 * panel.add(label_note2);
		 */
		
		JButton button_dangKy = new JButton("Đăng Ký");
		button_dangKy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangNhap.this.setVisible(false);
				new DangKy();
			}
		});
		button_dangKy.setFont(new Font("Arial", Font.ITALIC, 15));
		button_dangKy.setBounds(94, 369, 133, 37);
		panel.add(button_dangKy);
	
		this.setVisible(true);
	}
	
}
