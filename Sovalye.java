
public class Sovalye extends Karakterler{
	
	private boolean durum=true;
	private int vurusHakki=1;
	private Sans sans;
	private String sovalyeTipi;
	private int basariliVurus=0,vurusSayisi=0;
	
	public Sovalye(String ad,int id) {
		super(ad,id);
		sovalyeTipi= (id==1?"Guclu Sovalye":"Zayif Sovalye"); //id 1 ise sovalyetipine Guclu Sovalye, degilse Zayif Sovalye atayan Ternary op.
	}
	
	public String getSovalyeTipi() {
		return sovalyeTipi;
	}
	
	public int getVurusHakki() {
		return vurusHakki;
	}
	
	public boolean getDurum() {
		return durum;
	}
	
	public void setDurum(boolean durum) {
		this.durum=durum;
	}
	
	public void setVurusHakki(int vh) {
		this.vurusHakki=vh;
	}
	
	public int getBasariliVurus() {
		return basariliVurus;
	}
	
	public int getVurusSayisi() {
		return vurusSayisi;
	}
	
	public void vur(Dusman d) {
		
		++vurusSayisi;
		
		if(sovalyeTipi.equals("Guclu Sovalye")) {
			if(getVurusHakki()==1) //Sovalye guclu ve vurus hakki 1 ise sovalyenin durumunu false yapar.
				setDurum(false);
			
			setVurusHakki(getVurusHakki()-1); //Sovalyenin vurus hakki 1 den fazlaysa vurus yaptiginda 1 azaltir.
			d.setDurum(false);  //dusmanin durumun false yapar. 
			System.out.println("Hedef Vuruldu.\n"+"Dusman Yok Edildi.\n");
			basariliVurus++;
				
		}
		else if(sovalyeTipi.equals("Zayif Sovalye") && d.getId()==1) { //Zayif sovalye vs guclu dusman durumu.
			setDurum(false); 
			System.out.println("Hedef Vuruldu.\n"+"Zayif Sovalye ile Guclu Dusman Yok Edemezsiniz.\n");
		}
		else if(sovalyeTipi.equals("Zayif Sovalye") && d.getId()==0) {
			if(getVurusHakki()==1) //Sovalye zayif ve vurus hakki 1 ise sovalyenin durumunu false yapar.
				setDurum(false);
				
			setVurusHakki(getVurusHakki()-1); //Sovalyenin vurus hakki 1 den fazlaysa vurus yaptiginda 1 azaltir.
			d.setDurum(false);
			System.out.println("Hedef Vuruldu.\n"+"Dusman Yok Edildi.\n");
			basariliVurus++;
		}
			
	}
	
	public void sovalyeTipiDegistir() {
		this.sovalyeTipi="Zayif Sovalye";
	}
	

}
