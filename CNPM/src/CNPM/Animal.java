package CNPM;

import java.util.ArrayList;
import java.util.List;

public class Animal {
	private String idVatnuoi;
	private String tenVatnuoi;
	
	private List<Animal> ani = new ArrayList<Animal>();
	
	public List<Animal> getani(){
		return this.ani;
	}
	public String getIdVatnuoi() {
		return idVatnuoi;
	}


	public void setIdVatnuoi(String idVatnuoi) {
		this.idVatnuoi = idVatnuoi;
	}

	public String getTenVatnuoi() {
		return tenVatnuoi;
	}


	public void setTenVatnuoi(String tenVatnuoi) {
		this.tenVatnuoi = tenVatnuoi;
	}


	public Animal(String idVatnuoi, String tenVatnuoi) {
		super();
		this.idVatnuoi = idVatnuoi;
		this.tenVatnuoi = tenVatnuoi;
	}
	@Override
	public String toString() {
	 return String.format("Animal[idVatnuoi = %s, tenVatnuoi = %s]", idVatnuoi, tenVatnuoi);
}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
