package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import View.GiaoDienChinh;

public class CoffeeListenner implements ActionListener{
	private GiaoDienChinh giaoDienChinh;
	
	
	
	public CoffeeListenner(GiaoDienChinh giaoDienChinh) {
		this.giaoDienChinh = giaoDienChinh;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
		
		if(src.equals("CoCa Cola") || src.equals("Sprite") || src.equals("Ca phe sua") || src.equals("Bac Xiu") || src.equals("Matcha Đa Xay") || src.equals("Ca Phe Đa")
			||src.equals("Bo Huc") || src.equals("Nưoc Cam") || src.equals("Nuoc Suoi") )
		{
			this.giaoDienChinh.themDoUong(src);
		}
	}

}
