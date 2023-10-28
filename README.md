![01](https://github.com/turanemircan/WarehouseProject/assets/115572710/800a36b9-fbd5-42e2-a56c-32bde9157582)

# WARE HOUSE MANAGEMENT SYSTEM

+ PROJECT01 (Demo)

  + Action 
  + DepoTask
  + Runner
  + Urunler

+ PROJECT02

  + DefineProduct.java (Ürün Tanımlama)
  + Homepage.java (Anasayfa)
  + InOutbound.java (Ürün Giriş - Çıkış)
  + Listing.java (Ürün Listele)
  + Product.java (Pojo)
  + Runner.java 
  + Shelf.java (Ürün rafa yerleştir)

## Uygulama Arayüzü:

project02/Runner.java class'ını çalıştırarak uygulamayı başlatabilirsiniz.

![02](https://github.com/turanemircan/WarehouseProject/assets/115572710/d5a0866b-1c3c-4e6d-9436-85c1bfdb05db)

## AMAÇ:

  + Ürünün tanımlanması,
  + Ürünün giriş işlemlerinin yapılması,
  + Ürünün rafa yerleştirilmesi,
  + Ürünün çıkış işlemlerinin yapılması,
  + Ürünün güncellenmesi,
  + Ürünün listelenmesi gibi işlemleri gerçekleştirir.

1.1 Ürünün Tanımlanması:

  + Kullanıcı sadece ürünün adını, üreticisini ve birimini girer.
  + Tanımlanan ürüne ait id uygulamamız tarafından otomatik olarak verecektir.
  + Buradan amaç ürün numarası barkod numarası gibi tasarlanmıştır.
  + Hata yapılmasının önüne geçilmiştir.

2.1 Depoya Ürünün Giriş İşlemleri:

  + Burdaki amaç ürün için ilk kez giriş işlemi yapılacaksa ürünün miktarını belirlemek.
  + Eğer ilk kez değilse ürünün miktarını güncelemek.
  + Tanımlı ürünler id'leri ile listelenir.

  + Kullanıcı giriş yapmak istenilen ürünün id girer.
  + Girilen ürünün depoda mevcut miktarı kullanıcıya bildirilirç
  + Kullanıcı eklemek istediği miktarı girer.
  + Böylece mevcut miktar güncelenmiş olur.

Not: İlk kez girilecek ürünlerin miktarı başlangıçta sıfırdır.

3.1 Ürünün Rafa Yerleştirilmesi:

  + Tanımlı ürünler id'leri ile listelenir.
  + Kullanıcıya rafa eklemek istediği ürünün id'si girer.
  + Daha sonra eklemek istediği raf numarasını girer.
  + Raf numarası null bir değer olamaz.
  + Rafa yerleştirme işlemi gerçekleştirir.

4.1 Ürün Çıkış İşlemleri:

  + Tanımlı ürünler id'leri ile listelenir.
  + Kullanıcı çıkış yapmak istenilen ürünün id girer.
  + Kullanıcı çıkarmak istediği miktarı girer.
  + Böylece mevcut miktar güncelenmiş olur ve güncel miktar kullanıcıya bildirilir.

Not: 

  + Çıkış yapılacak miktar raftaki miktardan fazla ise program rafta yeteri kadar ürün olmadığını kullanıcıya bildirir.
  + Eğer kullanıcının verdiği ürün miktarı raftaki ürün miktarına eşit ise ürün çıkışı yapılır ve ürünün raf değeri null olarak güncelenir.

4.1 Ürünün Güncellenmesi:

Kullanıcı ürünü tanımlarken, miktar bilgisini girerken veya ürüne ait bilgi girişlerinde hata yapabilir.

Kullanıcı yaptığı hataları manuel olarak güncelleyebilsin, değiştirilebilsin

mantığı ile ürünün tüm niteliklerine müdahale olanağı tanımlandı.

5.1 Ürünün Listelenmesi:

Ürünün bir zaman damgası ile ürüne ait field(alan) ları

header(başlık) body(gövde) ve footer(alt bölüm) den oluşan bir template dizayn edildi.

kullanıcının tabloya baktığında ürün ile ilgili bilgilerin tamamını göre bileceği bir liste olarak tasarlandı.
