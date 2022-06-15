# Text_Based_Java_Game

Java ile kodlamış olduğum Şövalye-Düşman oyununda toplamda 15 adet sınıf bulunmaktadır.

”OyunVerisi” sınıfının Constructor’ünde karakterler ayrı ayrı oluşturulmuştur ve her bir karakter(şövalyeler ve düşmanlar) “dusmanlar” veya “sovalyeler” ArrayList’ine atanmıştır. Ayrıca şövalyelerin her birine “Sans” sınıfından rastgele(+1 ,+2 veya +0) ekstra vuruş hakkı tanımlanmıştır.“getSovalye” metodu ile string olarak alınan ad , tüm şövalye ArrayListi’nde gezerek şövalyenin “getAd” metodu ile karşılaştırılmakta ve şövalyenin nesnesi döndürülmektedir. Sınıfın diğer getter metodları ile aktif şövalye-düşman ve şövalyeler-düşman için ArryListlerini döndürmektedir.

“OyunGorunumu” sınıfında genel olarak konsolda gösterilecek bilgiler, seçme ekranı gibi işlemler olmaktadır.”sovalyeleriGoster”,”aktifSovalyeleriGoster”ve ”sovalyeyiGoster” metodları ekrana ArrayListlere aktarılan nesneleri bilgileri ile birlikte göstermektedir. “menudenSecimYap” metodu ise kullanıcıdan alınan seçim değerine göre menü üzerindeki işlemleri yapmaktadır. Sınıfın en önemli metodlarından olan “randDusman ve randSovalye” metodlarında ; önce güçlü karakterlerden bir tane rastgele alınır ve kalan karakterden oluşturulmak istenen kadar alınarak aktifSovalyeler-Dusmanlar Arrylistine eklenmektedir.

“SavasMotoru” sınıfı dosyalama yapılan ve asıl savaşma olayının olduğu kısımdır. Ayrıca bir tane metodu bulunmaktadır. Bu metodda önce aktif şövalyeler sonra düşmanlar bilgileri ile ekrana basılmaktadır. Oyun ise kullanıcının ekrandaki şövalye ve düşman numaralarını seçmesi ile ilerlemektedir. Seçilen numaralara göre karakterlerin oyundan çıkarılması durumunda aktifSovalyeler-Dusmanlar Arrylistiden silinmektedir ve karakter durumu “false” olarak değiştirilmektedir. Savaş sonsuz döngü içinde gerekli şartlar sağlanana kadar(düşman sayısı sıfır veya düşman sayısı şövalyeden fazla olana kadar) sürmektedir. Bu işlemler yapılırken de şövalyelere ait bilgiler bir “.txt” uzantılı dosyaya yazılmaktadır.

“Sovalyeler” sınıfı karakterler sınıfını miras almaktadır ve Sovalyeler sınıfı da GucluSovalyeler ve ZayifSovalyeler sınıfları miras almaktadır. Bu sınıfta bilgileri döndüren ve değiştirmeye yarayan getter-setter metodları bulunmaktadır. Ayrıca düşman nesnesini parametre olarak alan vur metodu da bulunmaktadır. Bu metod oyun oynanırken çağırılmaktadır ve parametre olarak aldığı düşman nesnesinin id si (zayıf veya güçlü olması ile orantılı) ile karşılaştırma yaparak düşmanın ve şövalyenin yok edilip edilmeyeceğine karar verir.

“Sans” sınıfı bir şövalye nesnesi parametresi almaktadır ve ekstra vuruş hakkı için 1 ile 2 arasında rastgele sayı üretmektedir. Farklı bir boolean random; değer olarak true döndürdüğünde iyiSans değerine true ve şövalyenin vuruş hakkına randomdan gelen sayıyı ekler. Eğer false ise kotuSans değerine true değeri atar.

Son olarak “NYP_Proje” sınıfı main metodunu içermektedir ve oyunGorunumu nesnesi ile başlangıç ekranını çağırarak oyun başlatmaktadır.
