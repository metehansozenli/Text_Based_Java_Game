import java.io.*;
import java.io.PrintWriter;
import java.util.*;

public class SavasMotoru{
	
	Scanner scan = new Scanner(System.in);
	int turSayac=0;
	
	public SavasMotoru() {
		
	}
	
	public void savas(OyunVerisi oyunVerisi) {
		
		try (PrintWriter dosyaYaz = new PrintWriter("oyun.txt")){
		
		while(true) { //Gerekli kosullar saglanana kadar calisan sonsuz dongu.
			
			++turSayac;
			System.out.println("*****************"+"\n"+
							   "Oyun Karakterleri"+"\n"+
							   "*****************"+"\n"+
							   "--SOVALYELER--"+"\n");
			
			//Aktif Sovalye kadar calisip sovalye bilgilerini yazdiran dongu.
			for(int i=0;i<oyunVerisi.getAktifSovalyeler().size();i++) { 
				System.out.println((i+1)+")****************"+"\n"+oyunVerisi.getAktifSovalyeler().get(i).toString()+"\n"+
																  "Sovalye Tipi: "+
																  oyunVerisi.getAktifSovalyeler().get(i).getSovalyeTipi()+"\n"+
																  "Sovalye Vurus Hakki: "+
																  oyunVerisi.getAktifSovalyeler().get(i).getVurusHakki());
				System.out.println("******************");
			}
			System.out.println("--Dusmanlar--"+"\n");
			
			//Aktif dusman sayisi kadar calisip bilgilerini yazdiran dongu.
			for(int i=0;i<oyunVerisi.getAktifDusmanlar().size();i++) { 
				System.out.println((i+1)+")****************"+"\n"+"Dusman Adý: "+oyunVerisi.getAktifDusmanlar().get(i).getAd());
				System.out.println("******************");
			}
			
			System.out.println("Kullanacaðýnýz þövalyenin numarasýný giriniz:");
			int secimSovalye = scan.nextInt();
			
			System.out.println("Hedefteki düþmanýn numarasýný giriniz:");
			int secimDusman = scan.nextInt();
			
			// Alinan sovalye ve dusman numarasi ile sovalyenin vur metodu cagiriliyor.(secilenin 1 eksigi olmasi indislerin 0 dan basladigi icin)
			oyunVerisi.getAktifSovalyeler().get(secimSovalye-1).vur(oyunVerisi.getAktifDusmanlar().get(secimDusman-1));
			
			// Dosyaya bilgileri yazan kisim;
			dosyaYaz.append("\n"+turSayac+". Tur\n"+oyunVerisi.getAktifSovalyeler().get(secimSovalye-1).getAd()+
					        "--------->"+oyunVerisi.getAktifDusmanlar().get(secimDusman-1).getAd()+
					        "\nSovalye Vurus Sayisi: "+oyunVerisi.getAktifSovalyeler().get(secimSovalye-1).getVurusSayisi()+
					        "\nSovalye Basarili Vurus Sayisi: "+oyunVerisi.getAktifSovalyeler().get(secimSovalye-1).getBasariliVurus()+"\n");
			
			// Aktif sovalye sayisi kadar calisip durumu false yani oyundan cikarilmis sovalyeyi buldugunda arraylistten silen dongu.
			for(int i=0;i<oyunVerisi.getAktifSovalyeler().size();i++) {
				if(oyunVerisi.getAktifSovalyeler().get(i).getDurum()==false) {
					oyunVerisi.getAktifSovalyeler().remove(i);
				}
			}
			
			// Aktif dusman sayisi kadar calisip durumu false yani oyundan cikarilmis dusmani buldugunda arraylistten silen dongu.
			for(int i=0;i<oyunVerisi.getAktifDusmanlar().size();i++) {
				if(oyunVerisi.getAktifDusmanlar().get(i).getDurum()==false) {
					oyunVerisi.getAktifDusmanlar().remove(i);
				}
			}
			
	        //while dongusunun dusman sayisi 0 oldugunda sonlandiran kosul.
			if(oyunVerisi.getAktifDusmanlar().size()==0) {
				System.out.println("Tebrikler Kazandiniz!!!");
				dosyaYaz.append("\n\nSonuc: Kazanildi!!");//Oyun kazanildiginda dosyaya yazan kisim.
				break;
			}
			
			//while dongusunu dusman sayisi sovalye sayisindan fazla oldugu zaman sonlandiran kosul.
			else if(oyunVerisi.getAktifDusmanlar().size()>oyunVerisi.getAktifSovalyeler().size()) {
				System.out.println("Kaybettiniz...");
				dosyaYaz.append("\n\nSonuc: Kaybedildi!!");//Oyun kaybedildiginde dosyaya yazan kisim.
				break;
			}
			System.out.println("Oyun Devam Ediyor...\n");
		}
			
	}catch (FileNotFoundException e) {// Dosya olusturulken hata olmasi durumu.
			System.out.println("Dosya Olusturulurken Hata Olustu...");
			e.printStackTrace();
	}
		
	}
}
