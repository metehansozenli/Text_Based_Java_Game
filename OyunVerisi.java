import java.util.*;

public class OyunVerisi {

	private Sans sans = new Sans();
	private ArrayList<Sovalye> sovalyeler = new ArrayList<>();
	private ArrayList<Sovalye> AktifSovalyeler = new ArrayList<>();
	private	ArrayList<Dusman> dusmanlar = new ArrayList<>();
	private	ArrayList<Dusman> AktifDusmanlar = new ArrayList<>();
	private ArrayList<Sans> sanslar = new ArrayList<>();

	public OyunVerisi() {
		
		//Sovalyeler ve dusmanlar olusturluyor.
		GucluSovalye sovalye1 = new GucluSovalye("Arthur Morgan",1); sovalyeler.add(sovalye1); sans.sansAta(sovalye1);
		GucluSovalye sovalye2 = new GucluSovalye("Dutch van der Linde",1); sovalyeler.add(sovalye2); sans.sansAta(sovalye2);
		ZayifSovalye sovalye3 = new ZayifSovalye("John Marston",0); sovalyeler.add(sovalye3); sans.sansAta(sovalye3);
		ZayifSovalye sovalye4 = new ZayifSovalye("Sadie Adler",0); sovalyeler.add(sovalye4); sans.sansAta(sovalye4);
		ZayifSovalye sovalye5 = new ZayifSovalye("Bill",0); sovalyeler.add(sovalye5); sans.sansAta(sovalye5);
		ZayifSovalye sovalye6 = new ZayifSovalye("Charles Smith",0); sovalyeler.add(sovalye6); sans.sansAta(sovalye6);
		ZayifSovalye sovalye7 = new ZayifSovalye("Lenny",0); sovalyeler.add(sovalye7); sans.sansAta(sovalye7);
		
		GucluDusman dusman1 = new GucluDusman("Colm o'driscoll",1); dusmanlar.add(dusman1);
		GucluDusman dusman2 = new GucluDusman("Angelo Bronte",1); dusmanlar.add(dusman2);
		ZayifDusman dusman3 = new ZayifDusman("o'driscolls 2",0); dusmanlar.add(dusman3);
		ZayifDusman dusman4 = new ZayifDusman("o'driscolls 3",0); dusmanlar.add(dusman4);
		ZayifDusman dusman5 = new ZayifDusman("o'driscolls 4",0); dusmanlar.add(dusman5);
		ZayifDusman dusman6 = new ZayifDusman("o'driscolls 5",0); dusmanlar.add(dusman6);

	}

	public Sovalye getSovalye(String ad) {
		
		int sayac = 0;
		//sovalyeler arraylistinde gezip adi parametre olarak alinan ad ile karþýlaþtýran ve 
		//sonuc olarak bulunan sovalye nesnesinin indisini sayac degerine kaydeden dongu. 
		for(int i=0;i<sovalyeler.size();i++) {
			if (sovalyeler.get(i).getAd().equals(ad))
				sayac= i;
		}
		
		return sovalyeler.get(sayac);
				
	}
	
	public ArrayList<Sovalye> getSovalyeler() {
		return sovalyeler;
	}
	
	public ArrayList<Sovalye> getAktifSovalyeler() {
		return AktifSovalyeler;
	}
	
	public ArrayList<Dusman> getDusmanlar() {
		return dusmanlar;
	}

	public ArrayList<Dusman> getAktifDusmanlar() {
		return AktifDusmanlar;
	}
	
	public ArrayList<Sans> getSanslar() {
		return sanslar;
	}
	
}
