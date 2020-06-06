package CNPM;
import java.util.List;
import java.util.ArrayList;
public class DangkiTiem {
	private String idHodan;
	private String idVaccine;
	private int soluong;
	private String ngaydk;
	
	private List<DangkiTiem> dktiem = new ArrayList<DangkiTiem>();
	public List<DangkiTiem> getdktiem(){
		return this.dktiem;
	}
	public DangkiTiem(String idHodan, String idVaccine, int soluong, String ngaydk) {
		super();
		this.idHodan = idHodan;
		this.idVaccine = idVaccine;
		this.soluong = soluong;
		this.ngaydk = ngaydk;
	}

	public String getIdHodan() {
		return idHodan;
	}

	public void setIdHodan(String idHodan) {
		this.idHodan = idHodan;
	}


	public String getIdVaccine() {
		return idVaccine;
	}


	public void setIdVaccine(String idVaccine) {
		this.idVaccine = idVaccine;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}


	public String getNgaydk() {
		return ngaydk;
	}


	public void setNgaydk(String ngaydk) {
		this.ngaydk = ngaydk;
	}

@Override
	public String toString() {
	 return String.format("DangkiTiem[idHodan = %s, idVaccine = %s, soluong = %d, ngaydk = %s]", idHodan, idVaccine, soluong, ngaydk);
}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*"idHoDan" INT NOT NULL,
	"idVaccine" null NOT NULL,
	"idVatNuoi" null NOT NULL,
	"soluong" INT,
	"ngaydangki" null,
 */
