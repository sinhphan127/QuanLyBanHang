package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class UserModel {
	private static Map<String, String> danhSachTaiKhoan = new HashMap<String, String>(){{put("user123", "123456");}};
	private static Set<String> danhSachUser = UserModel.danhSachTaiKhoan.keySet();

	public static Map<String, String> getDanhSachTaiKhoan() {
		return danhSachTaiKhoan;
	}

	public static void setDanhSachTaiKhoan(Map<String, String> danhSachTaiKhoan) {
		UserModel.danhSachTaiKhoan = danhSachTaiKhoan;
	}
	
	public static Set<String> getDanhSachUser() {
		return danhSachUser;
	}

	public static void setDanhSachUser(Set<String> danhSachUser) {
		UserModel.danhSachUser = danhSachUser;
	}

//	public String themTaiKhoan(String user, String password)
//	{
//		return this.danhSachTaiKhoan.put(user, password);
//	}
//	
//	public String traTaiKhoan(String user)
//	{
//		String password = this.danhSachTaiKhoan.get(user);
//		return password;
//	}
}
