package CNPM;

import java.util.ArrayList;
import java.util.List;

public class Vacxin {
	private String idVaccine;
	private String tenvaccine;
	private int soluong;
	private List<Vacxin> vaccine = new ArrayList<Vacxin>();
	public List<Vacxin> getvaccine(){
		return this.vaccine;
	}
	
	public Vacxin(String idVaccine, String tenvaccine, int soluong) {
		super();
		this.idVaccine = idVaccine;
		this.tenvaccine = tenvaccine;
		this.soluong = soluong;
	}


	public String getIdVaccine() {
		return idVaccine;
	}


	public void setIdVaccine(String idVaccine) {
		this.idVaccine = idVaccine;
	}


	public String getTenvaccine() {
		return tenvaccine;
	}


	public void setTenvaccine(String tenvaccine) {
		this.tenvaccine = tenvaccine;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	@Override
	public String toString() {
		return  String.format("Vacxin[idVaccine = %s,  tenvaccine= %s,  soluong= %d ]", idVaccine, tenvaccine, soluong);
	}


	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 * "idVaccine" null NOT NULL,
	"tenVaccine" null,
	"soluong" INT,
 */
