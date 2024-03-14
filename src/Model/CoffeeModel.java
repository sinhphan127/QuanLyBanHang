package Model;

import java.util.HashMap;
import java.util.Map;

public class CoffeeModel {
	private static Map<String, String> danhSachDoUong = new HashMap<String, String>(){{
		put("CoCa Cola" ,"10000");
		put("Sprite", "8000");
		put("Ca phe sua","16000");
		put("Bac Xiu","22000");
		put("Matcha Đa Xay","35000");
		put("Ca Phe Đa","14000");
		put("Bo Huc", "20000");
		put("Nưoc Cam","30000");
		put("Nuoc Suoi", "10000");
	}};

	public static Map<String, String> getDanhSachDoUong() {
		return danhSachDoUong;
	}
	
	
}

