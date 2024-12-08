Hepsiburada Otomasyon Taskı Proje Notları

1- Web otomasyon testi, Maven+Selenium+Gauge kullanılarak oluşturulmuştur.
2- Api otomasyon testi, Maven+RestAssured+Gauge kullanılarak oluşturulmuştur.
2- Programlama dili olarak java kullanılmıştır.
3- Web ve Api otomasyon case'leri specs/Scenarios dosyasındadır. Test koşumlarını başlatmak için buradaki spec dosyasındaki senaryoların run butonlarına basınız
4- Web otomasyon testinde Page Object Pattern kullanılmıştır (src/test/java/com/hepsiburada/pages/HepsiBuradaPage.java).
5- Fail durumunda screenshot alıp .gauge/screenshots klasörüne atmaktadır. Aynı zamanda koşum sonucu üretilen html raporunda step log'larıyla birlikte screenshot da görülebilmektedir (fail durumunda).
6- Web otomasyon testi chrome, edge ve firefox'da çalışabilmektedir. Bunun için env/default/default.properties dosyasında browser tipi belirtilmelidir.
7- Api otomasyon testinde ilk senaryoda post ile booking oluşturulur, booking id kaydedilir. İkinci senaryoda kaydedilen booking id, get işleminde kullanılır.