# Java-20 Android Örnekleri

Java-20 eğitim grubunun Android derslerinde yazılan küçük uygulamalar. Her klasör Android Studio ile
ayrı ayrı açılan bağımsız bir Gradle projesidir.

> **Not:** Bu depo 2017 yılında eğitim/örnek amaçlı yazıldı ve artık güncellenmiyor. Bağımlılıkları ve
> Gradle sürümü çok eskidir, bilinen güvenlik açıkları içerir; üretimde kullanmayın.

## İçerik

| Klasör | Ne yapar |
|---|---|
| `MerhabaDunya/` | İlk uygulama: kullanıcı adı/parola ile basit giriş ekranı ve ikinci aktiviteye geçiş (`Intent`) |
| `Titresim/` | Girilen süre kadar telefonu titreten örnek (`Vibrator`, `VIBRATE` izni) |
| `GPS/` | Çalışma anında konum izni ister, konum gelince Google Haritalar'da yakındaki restoranları açar |
| `Kutuphane/` | SQLite ile kitap ekleyip listeleyen küçük kütüphane uygulaması (`SQLiteOpenHelper`, menü) |
| `TwitterSearch/` | Girilen etiketi `WebView` içinde Twitter'da arar |
| `WebServis/` | `AsyncTask` ve `HttpURLConnection` ile bir REST servisinden JSON çekip ekranda gösterir |
| `Adword/` | Google Play Services Ads bağımlılığı eklenmiş, reklam denemesi için açılmış boş proje |

## Teknolojiler

- Java, Android SDK (compileSdkVersion / targetSdkVersion 24)
- Android Gradle Plugin 2.1.2, Gradle 2.10 (wrapper)
- Android Support Library `appcompat-v7` 24.1.1
- `Adword/`: `play-services-ads` 11.0.0

## Çalıştırma

1. Android Studio'da *Open* ile çalıştırmak istediğiniz klasörü (ör. `Kutuphane/`) açın.
2. Gradle eşitlemesi sırasında `local.properties` dosyası Android SDK yolunuzla oluşturulur.
3. Bir emülatör ya da cihaz seçip uygulamayı çalıştırın.

Projeler çok eski Gradle ve Android Gradle Plugin sürümleriyle yazıldığı için güncel Android Studio'da
doğrudan açılmayabilir; önce Gradle wrapper ve eklenti sürümlerinin yükseltilmesi gerekir. `WebServis/`
örneğinin kullandığı servis adresi artık yanıt vermiyor olabilir.
