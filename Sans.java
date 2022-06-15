import java.util.*;

public class Sans {
	
	private boolean iyiSans=false;
	private boolean kotuSans=false;
	private	int sans;
	
	Random rand = new Random();
	
	public void sansAta(Sovalye s) {
		
		sans=rand.nextInt(1,3); // Ekstra vurus hakki icin 1 veya 2 donduren random .
		
		if(rand.nextBoolean()==true) { //true yada false ureterek, random uretilen deger true ise iyiSansi aktif eder.
			iyiSans=true;
			s.setVurusHakki( (s.getVurusHakki()+sans) ); //parametre olarak alinan sovalyenin vurus hakkina ekstra vurus hakkini ekler.
		}
		else 
			kotuSans=true;
		
		
	}
	
	public String toString() {
		return iyiSans==true ? "Iyi Sans, +"+sans+" Vurus Hakki.":"Kotu Sans, Vurus Hakki Degismedi.." ;
	}
}
