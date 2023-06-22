package project01;

import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class Action {
    public static final String R = "\u001B[31m";
    public static final String B = "\u001B[34m";

    public static Scanner input = new Scanner(System.in);
    static int id;

    static HashMap<Integer, Urunler> actions = new HashMap<Integer, Urunler>();



    public static  void entry(){

        System.out.println(R + "========================== İŞLEMLER =======================\r\n"
                + "   ____________________             ____________________          \n"
                + "   | 1-Ürün Girisi      |           |  2-Ürün Tanimla  |          \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯          \n"
                + "   ____________________             ____________________          \n"
                + "   | 3-Ürünleri  Listele |         | 4-Ürünleri Rafa Koy |        \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯         \n"
                + "   | 5-Ürün Cikisi       |                                       \n"
                + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯             ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯         \n" + B);

        System.out.print("ISLEM SECİNİZ : ");



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
                productOut();
                //entry();
                break;




        }


    }



    public static void defineProduct(){
        System.out.print("urun ismini giriniz : ");
        String productName = input.nextLine();
        System.out.print("");
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
        System.out.println("Ürün eklemeye devam etmek ister misiniz? E/H girin!");
        String cevap = input.next().toUpperCase();
        if (cevap.equals("E")){
            defineProduct();
        }



    }
    public static void assignShelf(){
        System.out.println("Lütfen rafa koymak istediginiz ürünün id girin");
         int id =input.nextInt();
        if (actions.get(id).getShelf() == null){
            System.out.println("Lutfen raf numarasini giriniz...");
            String shelf = input.nextLine();
            actions.get(id).setShelf(shelf);
            System.out.println("id : "+ id + "raf : " + shelf );
        }else if(actions.get(id).getShelf() != null)

        System.out.println("ID:"  + actions.get(id) +  "Raf:" )  ;
        //listOfProduct();
    }
    public static void productOut(){

        //System.out.println(urunListele());

        System.out.print("Sectiginiz urun id giriniz: ");
        int id = input.nextInt();

        System.out.print("Cikarmak istediğiniz miktari giriniz: ");
        int amount = input.nextInt();

        if (actions.containsKey(id)){
            Urunler product = actions.get(id);
            int availableAmount = product.getAmount();
            if (availableAmount >= amount){
                int newAmount = availableAmount - amount;
                product.setAmount(newAmount);
                if (newAmount == 0){
                    product.setShelf(null);
                }
            } else {
                System.out.println("Yeterli miktarda ürün bulunmamaktadır.");
            }
        } else {
            System.out.println("Bu ID'ye sahip bir ürün tanımlanmamış.");
        }
    }
}
