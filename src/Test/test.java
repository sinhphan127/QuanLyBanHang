package Test;

import java.awt.EventQueue;

import javax.swing.UIManager;

import View.DangNhap;

public class test {
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UIManager.setLookAndFeel(UIManager.getLookAndFeel());
						new DangNhap();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

