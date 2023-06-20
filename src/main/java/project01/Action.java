package project01;

import java.util.HashMap;
import java.util.Scanner;

public class Action {
    public static Scanner input = new Scanner(System.in);
    static int id;

    static HashMap<Integer, Urunler> actions = new HashMap<Integer, Urunler>();

    public static  void entry(){
        System.out.println("Giris menu");// kübra Hocam

        System.out.println("Lütfen yapmak istediginiz Islemi seciniz");

        String secim = input.next();

        switch (secim){
            case "1":
                //inbound();
                //entry();
                break;
            case "2":
                defineProduct();
                entry();
                break;
            case "3":
                //urunListele();
               // entry();
                break;
            case "4":
                //urunuRafaKoy();
                //entry();
                break;
            case "5":
                //urunCikisi();
                //entry();
                break;




        }


    }



    public static void defineProduct(){
        System.out.print("uruni smini giriniz : ");
        String productName = input.nextLine();

        input.nextLine();
        System.out.print("uretici bilgisi giriniz : ");
        String producter = input.nextLine();

        System.out.print("urun miktar giriniz : ");
        int amount = input.nextInt();
        input.nextLine();

        System.out.print("urun birimi giriniz : ");
        String unit = input.nextLine();

        System.out.print("urun icin raf  giriniz : ");
        String shelf = input.nextLine();

        Urunler product = new Urunler(productName,producter, amount,unit,shelf);
        actions.put(id, product);
        System.out.println(id + " : " + actions.get(id));
        id++;


    }
}
