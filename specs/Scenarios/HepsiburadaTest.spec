# Hepsiburada QA Study Case

* Browser açılır

## Senaryo 1

●	hepsiburada.com sitesini ziyaret edilir.
●	Arama işlemi gerçekleştirilir (Örnek: “iphone” gibi popüler ve yorumu olan bir ürün)
●	Arama sonucunda gelen ürün listesinden ürün seçer ve ürün detay sayfasına gider.(Aranan ürünler bir array dizisine atılarak içinden bir tanesini random seçer ve ona gider)
●	Sayfanın yüklenmesinin tamamlanıldığından emin olunur.
●	Değerlendirmeler tab’ine geçiş yapılır ve buradan Sırala : En Yeni Değerlendirme seçilir.
●	Gelen değerlendirmeler içinden  thumbsUp ya da thumbsDown seçeneklerinden bir tanesi seçilir.
●	Teşekkür Ederiz yazısının geldiği kontrol edilir.
●	Eğer Değerlendirmeler tab’inda hiç yorum gelmiyorsa herhangi bir işlem yapmaz.

* "https://www.hepsiburada.com" web sayfasını aç.
* Hepsiburada sayfasının açıldığını doğrula.
* Çerez ayarlarını kabul et
* Search alanında "iphone" ürününü ara.
* Listelenen ürünlerden random bir tanesi seçilir.
* Yeni açılan pencereye geçiş yapılır
* Sayfa aşağıya kaydırılır.
* Değerlendirmeler sekmesine geçiş yapılır.
* Değerlendirme yoksa bitir, varsa sırala, thumbsUp yap ve "Teşekkür Ederiz." yazısının geldiğini kontrol et.



## Senaryo 2

●	hepsiburada.com sitesini ziyaret edilir.
●	Arama işlemi gerçekleştirilir (Örnek: “iphone” gibi popüler ve yorumu olan bir ürün)
●	Arama sonucunda gelen ürün listesinden ürün seçer ve ürün detay sayfasına gider.(Aranan ürünler bir array dizisine atılarak içinden bir tanesini random seçer ve ona gider)
●	Seçilen ürün sayfasında diğer satıcılar görünürlüğü kontrol edilir.
●	Seçilen ürün fiyat bilgisi ile Diğer Satıcılar tab’inde görünür olan fiyatlar karşılaştırılır.
●	Fiyatı en düşük olan ürün sepete eklenir. Diğer Satıcılar tab’i boş ise varolan ürün üzerinden devam edilir.

* "https://www.hepsiburada.com" web sayfasını aç.
* Hepsiburada sayfasının açıldığını doğrula.
* Çerez ayarlarını kabul et
* Search alanında "iphone" ürününü ara.
* Listelenen ürünlerden random bir tanesi seçilir.
* Yeni açılan pencereye geçiş yapılır
* Diğer satıcılar yoksa devam et, varsa fiyat karşılaştır, düşük olanı seç.
* Ürünü sepete ekle.
* "10" saniye bekle



## Senaryo 3

●	hepsiburada.com sitesini ziyaret edilir.
●	Arama işlemi gerçekleştirilir (Örnek: “iphone” gibi popüler ve yorumu olan bir ürün)
●	Arama sonucunda gelen ürün listesinden ürün seçer ve ürün detay sayfasına gider.(Aranan ürünler bir array dizisine atılarak içinden bir tanesini random seçer ve ona gider)
●	Seçilen ürün sayfasında ürün fiyat bilgisi kontrol edilir.
●	Ürün sepete eklenir.
●	Ürün sayfası ile sepet fiyatının eşit olduğu kontrol edilir.

* "https://www.hepsiburada.com" web sayfasını aç.
* Hepsiburada sayfasının açıldığını doğrula.
* Çerez ayarlarını kabul et
* Search alanında "iphone" ürününü ara.
* Listelenen ürünlerden random bir tanesi seçilir.
* Yeni açılan pencereye geçiş yapılır
* Ürün fiyatı kaydedilir.
* Ürünü sepete ekle.
* Kaydedilen ürün fiyatı ile sepetteki fiyat karşılaştırılır.
* "10" saniye bekle



