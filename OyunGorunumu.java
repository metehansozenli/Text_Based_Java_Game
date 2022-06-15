
import java.util.*;

public class OyunGorunumu {
	
	private OyunVerisi oyunVerisi = new OyunVerisi();
	private OyunYoneticisi oyunYoneticisi = new OyunYoneticisi(oyunVerisi);
	private SavasMotoru savasMotoru = new SavasMotoru();
	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	ArrayList<Integer> sayitutucu = new ArrayList<>();
	ArrayList<Integer> sayitutucuD = new ArrayList<>();
	
	public OyunGorunumu() {
		
	}
	
	public void baslangicEkrani(){
		
		randSovalye();//Oyun Baslamadan Once random sovalye ve dusmanlar olusturur.
		randDusman();
		System.out.println();
		System.out.println("******************");
		System.out.println("Oyuna Hoþgeldiniz.");
		System.out.println("******************");
		anaMenuyuGoster();
	}
	
	public void yardim() {
		//Oyun Kurallari
		System.out.println("1.Oyunun baþlangýcýnda rastgele seçilen 5 adet þövalye aktifleþtirilir. Bunlardan en az biri, en çok ikisi güçlü þövalye olmalýdýr.\n"
				+ "2.Her bir þövalyenin yalnýzca bir vuruþ hakký vardýr. Bir kez düþmana vuran þövalye yense de yenilse de aktif þövalyeler arasýndan çýkarýlýr.\n"
				+ "3.Oyun baþladýktan sonra, hangi þövalyenin hangi düþmana vuracaðýna oyuncu karar vermelidir.\n"
				+ "4.Eðer oyuncu, aktif þövalyeleri bitmeden tüm düþmanlarý yok edebilirse oyunun galibi olur.\n"
				+ "5.Düþman sayýsýndan daha az sayýda þövalye kaldýðý durumda, oyuncu oyunu kaybeder.\n");
	}
	
	public void sovalyeleriGoster() {
		
		for(int i=0;i<oyunVerisi.getSovalyeler().size();i++)
			System.out.println(oyunVerisi.getSovalyeler().get(i).toString()+"\n");
	}

	public void AktifSovalyeleriGoster() {
		
		for(int i=0;i<oyunVerisi.getAktifSovalyeler().size();i++)
			System.out.println(oyunVerisi.getAktifSovalyeler().get(i).toString()+"\n");
	}

	public void menudenSecimYap() {
		
 		System.out.println("Lutfen Seciminizi Giriniz: ");
		int secim = scan.nextInt();
		
		switch (secim) {
		case 1:
			System.out.println("SOVALYELER");
			System.out.println("**********");
			sovalyeleriGoster();
			break;
		case 2:
			System.out.println("AKTIF SOVALYELER");
			System.out.println("****************");
			AktifSovalyeleriGoster();
			break;
		case 3:
			System.out.println("Lutfen Sovalye Ismini Giriniz: ");
			System.out.println("SOVALYE BILGI");
			System.out.println("*************");
			scan.nextLine(); // Scannerin atlamamasi icin gerekli 
			SovalyeyiGoster( oyunVerisi.getSovalye(scan.nextLine()) );
			break;
		case 4:
			System.out.println("Lutfen Sovalye Ismini Giriniz: ");
			System.out.println("SOVALYE DEGISTIR");
			System.out.println("****************");
			Scanner scan2 = new Scanner(System.in);
			String Isim = scan2.nextLine();
			oyunYoneticisi.sovalyeDegistir(Isim);
			AktifSovalyeleriGoster();
			break;
		case 5:
			System.out.println("Oyun Kurallari ve Oynanis");
			System.out.println("*************************");
			yardim();
			break;
		case 6:
			savasMotoru.savas(oyunVerisi);//Savasi baslatma. 
			break;
		default:
			System.exit(0);	
		}
		anaMenuyuGoster();
		
	}
	
	public void SovalyeyiGoster(Sovalye s) {
		
		System.out.println( s.toString()+ "\n" +"Vurus Hakki: "+ s.getVurusHakki()+ "\n" + s.getSovalyeTipi() );
	}
	
	public void anaMenuyuGoster() {
		
		System.out.println();
		System.out.println("ANA MENU");
		System.out.println("1. Tum Sovalyeleri Goster.");
		System.out.println("2. Aktif Sovalyeleri Goster.");
		System.out.println("3. Adi Girilen Sovelye Bilgilerini Goster.");
		System.out.println("4. Adi Girilen Sovelyeyi Degistir.");
		System.out.println("5. Yardim.");
		System.out.println("6. Oyunu Baslat.");
		System.out.println("7. Oyundan Cik.");
		System.out.println();

		menudenSecimYap();
	}
	
	public void oyunDurumunuGoster(ArrayList<Dusman> dusmanlar,ArrayList<Sovalye> sovalyeler) {
	}
	
	public void randSovalye() {	
		
		//Olusturalan sovalyelerden random guclu 1 sovalyeyi aktifsovalye listesine ekleme.
		int randomGuclu=rand.nextInt(2);
		sayitutucu.add(randomGuclu);//random sayilarin tutuldugu arraylist.
		oyunVerisi.getSovalyeler().get(randomGuclu).setAktif(true);//Sovalye aktiflestirir
		oyunVerisi.getAktifSovalyeler().add(oyunVerisi.getSovalyeler().get(randomGuclu));
		
		//Geriye kalan sovalyelerden random aktifleþtirme islemi
		for(int i=0;i<4;i++) {
			
			int randomSayi= rand.nextInt(7);
			
				//Daha onceden random bulunan sayinin tekrar bulunmasini engelleyen yapi.
				if(sayitutucu.contains(randomSayi))
					i--;//dongunun tam olarak 4 defa calismasi icin .
				else {
					sayitutucu.add(randomSayi);
					oyunVerisi.getSovalyeler().get(randomSayi).setAktif(true);
					oyunVerisi.getAktifSovalyeler().add(oyunVerisi.getSovalyeler().get(randomSayi));
					
				}		
		}
	}
	
	public void randDusman() {	
		
		//randSovalye ile ayni islemler.
		int randomGuclu=rand.nextInt(2);
		sayitutucuD.add(randomGuclu);
		oyunVerisi.getDusmanlar().get(randomGuclu).setAktif(true);
		oyunVerisi.getAktifDusmanlar().add(oyunVerisi.getDusmanlar().get(randomGuclu));
		int randomDusmanSayisi= rand.nextInt(2,5);
		
		for(int i=0;i<randomDusmanSayisi;i++) {
			
			int randomSayi= rand.nextInt(6);
			
				//Daha onceden random bulunan sayinin tekrar bulunmasini engelleyen yapi.
				if(sayitutucuD.contains(randomSayi))
					i--;
				else {
					sayitutucuD.add(randomSayi);
					oyunVerisi.getDusmanlar().get(randomSayi).setAktif(true);
					oyunVerisi.getAktifDusmanlar().add(oyunVerisi.getDusmanlar().get(randomSayi));
					
				}
		}
		Collections.shuffle(oyunVerisi.getAktifDusmanlar()); //dusmanlari arraylist icinde karistiran metod
	}
	
}
