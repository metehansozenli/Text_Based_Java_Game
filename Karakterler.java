
public class Karakterler {

	private boolean aktif=false;
	private String ad;
	private int id;
	
	public Karakterler(String ad,int id) {
		this.ad=ad;
		this.id=id;
	}
	
	public boolean getAktif() {
		
		return aktif;
	}
	
	public void setAktif(boolean aktif) {
		this.aktif = aktif;
	}
	
	public String getAd() {
		return ad;
	}
	
	public int getId() {
		return id;
	}
	
	public String toString() {
		return "Ad: "+ad+"\n"+"Id: "+id;
	}
}
