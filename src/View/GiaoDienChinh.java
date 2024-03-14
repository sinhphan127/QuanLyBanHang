package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Controller.CoffeeListenner;
import Model.CoffeeModel;
import Model.UserModel;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class GiaoDienChinh extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private DefaultTableModel defaultTableModel;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public GiaoDienChinh() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(GiaoDienChinh.class.getResource("/Res/cafe-icon1.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		contentPane = new JPanel();

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		panel.setBounds(0, 0, 673, 663);
		contentPane.add(panel);
		
		ActionListener ac = new CoffeeListenner(this);
		JButton btnCocaCola = new JButton("CoCa Cola");
		btnCocaCola.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/Res/Coca.png")));
		panel.add(btnCocaCola);
		btnCocaCola.addActionListener(ac);
		
		
		
		JButton btnSprite = new JButton("Sprite");
		btnSprite.addActionListener(ac);
		btnSprite.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/Res/Sprite.png")));
		panel.add(btnSprite);
		
		JButton btnCPhSa = new JButton("Ca phe sua");
		btnCPhSa.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/Res/caphesua.jpg")));
		btnCPhSa.addActionListener(ac);
		panel.add(btnCPhSa);
		
		JButton btnBcXu = new JButton("Bac Xiu");
		btnBcXu.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/Res/Bacxiu.png")));
		btnBcXu.addActionListener(ac);
		panel.add(btnBcXu);
		
		JButton btnMatchaXay = new JButton("Matcha Đa Xay");
		btnMatchaXay.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/Res/Matchaa.jpg")));
		btnMatchaXay.addActionListener(ac);
		panel.add(btnMatchaXay);
		
		JButton btnCPh = new JButton("Ca Phe Đa");
		btnCPh.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/Res/CaPheDa.jpg")));
		btnCPh.addActionListener(ac);
		panel.add(btnCPh);
		
		JButton btnBHc = new JButton("Bo Huc");
		btnBHc.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/Res/BoHuc.jpg")));
		btnBHc.addActionListener(ac);
		panel.add(btnBHc);
		
		JButton btnNcCam = new JButton("Nưoc Cam");
		btnNcCam.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/Res/NuocCam.jpg")));
		btnNcCam.addActionListener(ac);
		panel.add(btnNcCam);
		
		JButton btnNcSui = new JButton("Nuoc Suoi");
		btnNcSui.setIcon(new ImageIcon(GiaoDienChinh.class.getResource("/Res/NuocSuoi.jpg")));
		btnNcSui.addActionListener(ac);
		panel.add(btnNcSui);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(683, 0, 503, 663);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBounds(22, 10, 471, 424);
		
		defaultTableModel = new DefaultTableModel();
		table_1.setModel(defaultTableModel);
		defaultTableModel.addColumn("Ten do uong");
		defaultTableModel.addColumn("Gia Tien");
		defaultTableModel.addColumn("So Luong");
		
		panel_1.add(table_1);
		
		JButton btnThanhToan = new JButton("Thanh Toán ");
		btnThanhToan.setBackground(new Color(128, 128, 0));
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tong = 0;

				        for(int i = 0 ; i < defaultTableModel.getRowCount(); i++) {

				            tong += Integer.parseInt(defaultTableModel.getValueAt(i, 1).toString()) * 
				                    Integer.parseInt(defaultTableModel.getValueAt(i, 2).toString());
				        }


				String thongBao = "So Tien Can Phai Thanh Toan La :" + tong +"";
				String soTien_Chuoi = (String) JOptionPane.showInputDialog(
						GiaoDienChinh.this,
		                thongBao
		                + "\nNhập vào số tiền:",
		                "Thông báo",
		                JOptionPane.PLAIN_MESSAGE);

				try {
					double soTien = Double.valueOf(soTien_Chuoi);
					JOptionPane.showMessageDialog(GiaoDienChinh.this,
						    "Thối tiền lại cho khách: "+(soTien - tong),
						    "Infor",
						    JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(GiaoDienChinh.this,
						    "Nhập dữ liệu sai!",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnThanhToan.setBounds(50, 560, 123, 47);
		panel_1.add(btnThanhToan);
		
		JButton btnDatLai = new JButton("Đặt Lại");
		btnDatLai.setBackground(new Color(128, 128, 0));
		btnDatLai.setBounds(214, 560, 123, 47);
		btnDatLai.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        defaultTableModel.setRowCount(0);
		    }
		});
		btnDatLai.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_1.add(btnDatLai);
		
		JButton btnngXut = new JButton("Đăng Xuất");
		btnngXut.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnngXut.setBackground(new Color(128, 128, 0));
		btnngXut.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        GiaoDienChinh.this.setVisible(false);
		        new DangNhap();
		    }
		});
		btnngXut.setBounds(370, 560, 123, 47);
		panel_1.add(btnngXut);
		
		this.setVisible(true);
	}
//		Object[] rowData = new Object[3];
//        rowData[0] = a;
//        rowData[1] = CoffeeModel.getDanhSachDoUong().get(a);
//        rowData[2] = 1;
//        defaultTableModel.addRow(rowData);
//        defaultTableModel.fireTableDataChanged();
        public void themDoUong(String a) {
            boolean daTonTai = false;
            for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
                if (defaultTableModel.getValueAt(i, 0).equals(a)) {
                    int soLuongHienTai = (int) defaultTableModel.getValueAt(i, 2);
                    defaultTableModel.setValueAt(soLuongHienTai + 1, i, 2);
                    daTonTai = true;
                    break;
                }
            }

            if (!daTonTai) {
                Object[] rowData = new Object[3];
                rowData[0] = a;
                rowData[1] = CoffeeModel.getDanhSachDoUong().get(a);
                rowData[2] = 1;
                defaultTableModel.addRow(rowData);
            }

            defaultTableModel.fireTableDataChanged();
        }

	
}

