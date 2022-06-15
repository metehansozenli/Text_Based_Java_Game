
public class Dusman extends Karakterler{

	private boolean durum=true;
	private String dusmanTipi;
	
	
	public Dusman(String ad,int id) {
		super(ad,id);
		dusmanTipi= (id==1?"Guclu Dusman":"Zayif Dusman");//id 1 ise sovalyetipine Guclu Dusman, degilse Zayif Dusman atayan Ternary op.
	}
	
	public void setDurum(boolean durum) {
		this.durum=durum;
	}

	public boolean getDurum() {
		return durum;
	}
}
