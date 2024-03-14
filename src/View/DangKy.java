package View;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Model.UserModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class DangKy extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField textField_repassword;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public DangKy() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DangKy.class.getResource("/Res/cafe-icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Đăng Ký");
		lblNewLabel.setFont(new Font("Arial", Font.ITALIC, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 500, 80);
		contentPane.add(lblNewLabel);

		JLabel label_user = new JLabel("Tên Đăng Nhập");
		label_user.setFont(new Font("Arial", Font.ITALIC, 15));
		label_user.setIcon(new ImageIcon(DangNhap.class.getResource("/Res/user-icon.png")));
		label_user.setBounds(10, 182, 189, 48);
		contentPane.add(label_user);

		JLabel label_password = new JLabel("Mật Khẩu");
		label_password.setFont(new Font("Arial", Font.ITALIC, 15));
		label_password.setIcon(new ImageIcon(DangNhap.class.getResource("/Res/Password-icon.png")));
		label_password.setBounds(10, 278, 175, 48);
		contentPane.add(label_password);

		JTextField textField_dangNhap = new JTextField();
		textField_dangNhap.setBounds(241, 193, 179, 37);
		contentPane.add(textField_dangNhap);

		JTextField textField_matKhau = new JPasswordField();
		textField_matKhau.setBounds(241, 278, 179, 34);
		contentPane.add(textField_matKhau);

		JLabel label_repassword = new JLabel("Nhập Lại Mật Khẩu");
		label_repassword.setIcon(new ImageIcon(DangKy.class.getResource("/Res/repeat-icon.png")));
		label_repassword.setFont(new Font("Arial", Font.ITALIC, 15));
		label_repassword.setBounds(10, 374, 208, 48);
		contentPane.add(label_repassword);

		textField_repassword = new JPasswordField();
		textField_repassword.setBounds(241, 374, 179, 34);
		contentPane.add(textField_repassword);

		JButton button_xacNhan = new JButton("Xác Nhận");
		button_xacNhan.setFont(new Font("Arial", Font.ITALIC, 15));
		button_xacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String user = textField_dangNhap.getText();
				String password = textField_matKhau.getText();
				String repassword = textField_repassword.getText();
				if (user.isEmpty() || password.isEmpty() || repassword.isEmpty()) {
					JOptionPane.showMessageDialog(DangKy.this, "Tên Đăng Nhập Mật Khẩu không được thiếu !", "ERROR",
							JOptionPane.PLAIN_MESSAGE);
				} else {
					boolean kiemTra = true;
					for (String s : UserModel.getDanhSachUser()) {
						if (s.equals(user)) {
							JOptionPane.showMessageDialog(DangKy.this, "Tên Tài Khoản đã có !", "ERROR",
									JOptionPane.PLAIN_MESSAGE);
							kiemTra = false;
							break;
						}
					}
					if (kiemTra == true) {
						if (!password.equals(repassword)) {
							JOptionPane.showMessageDialog(DangKy.this, "Mật khẩu nhập lại không trùng khớp !", "ERROR",
									JOptionPane.PLAIN_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(DangKy.this, "Đăng Ký Thành Công !", "COMPLETE",
									JOptionPane.PLAIN_MESSAGE);
							UserModel.getDanhSachTaiKhoan().put(user, password);
						}
					}
				}
			}
		});
		button_xacNhan.setBounds(114, 449, 133, 37);
		contentPane.add(button_xacNhan);

		JButton button_quayLai = new JButton("Quay Lại");
		button_quayLai.setFont(new Font("Arial", Font.ITALIC, 15));
		button_quayLai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DangKy.this.setVisible(false);
				new DangNhap();
			}
		});
		button_quayLai.setBounds(319, 449, 133, 37);
		contentPane.add(button_quayLai);
		
		this.setVisible(true);
	}
}
