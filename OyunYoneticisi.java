
public class OyunYoneticisi {
	
	private OyunVerisi oyunVerisi = new OyunVerisi();
	
	public OyunYoneticisi() {
		
	}
	
	public OyunYoneticisi(OyunVerisi oyunVerisi) {
		this.oyunVerisi=oyunVerisi;
	}
	
	public void sovalyeDegistir(String sovalye) {
		
		oyunVerisi.getSovalye(sovalye).setAktif(false); //Degistirilmek istenen sovalyeyi pasif yapar.
		oyunVerisi.getAktifSovalyeler().remove(oyunVerisi.getSovalye(sovalye)); //Degistirilmek istenen sovalyeyi aktiflistesinden cikarir.
		
		//Toplam sovalye sayisi kadar calisan, daha onceden aktiflesmemis iki zayif sovalyeyi ekleyip aktiflestiren dongu.
		for(int i=0;i<oyunVerisi.getSovalyeler().size();i++) {
			
				if( oyunVerisi.getSovalyeler().get(i).getAktif() == false && oyunVerisi.getSovalyeler().get(i).getId()==0) {
					oyunVerisi.getSovalyeler().get(i).setAktif(true);
					oyunVerisi.getAktifSovalyeler().add(oyunVerisi.getSovalyeler().get(i));
				}
			}
		
	}
	
}
