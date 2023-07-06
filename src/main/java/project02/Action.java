package project02;

import java.util.*;

public class Action implements DefineProduct, Shelf, Listing,Homepage,InOutbound{

    public static Scanner input = new Scanner(System.in);
    static int id=100;

    static HashMap<Integer, Product> actions = new HashMap<Integer, Product>();

    @Override
    public void mainMenu() {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_YELLOW = "\u001B[33m";

        System.out.println(ANSI_CYAN + "Select the desired operation in the application." + ANSI_RESET);
        System.out.println("Options:");
        System.out.println(ANSI_YELLOW + "1. Define Product" + ANSI_RESET + "\t\t" + ANSI_YELLOW + "2. List Product" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "3. Inbound Product" + ANSI_RESET + "\t\t" + ANSI_YELLOW + "4. Assign Shelf Number" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "5. Outbound Product" + ANSI_RESET + "\t\t" + ANSI_YELLOW + "6. Exit" + ANSI_RESET);

    }
    public void homepage() {

        String choice;

        do {
            mainMenu();
            choice = input.next();

                switch (choice) {
                    case "1":
                        defineProduct();

                        break;
                    case "2":
                        listing();
                        break;
                    case "3":
                            inboundProdct();
                        break;
                    case "4":
                        assignShelf();
                        break;
                    case "5":
                            productOut();
                        break;
                    case "6":
                        System.exit(6);
                  default:
                        System.out.println("The choice is incorrect.\n Please try again.");

                }

        } while (true);
    }

    @Override
    public void defineProduct() {
        input.nextLine();
        System.out.print("urun ismini giriniz : ");
        String productName = input.nextLine();

        System.out.print("uretici bilgisi giriniz : ");
        String producter = input.nextLine();

        int amount = 0;

        System.out.print("urun birimi giriniz : ");
        String unit = input.nextLine();

        String shelf = null;

        Product product = new Product(productName,producter, amount,unit,shelf);
        actions.put(id, product);
        System.out.println(id + " : " + actions.get(id));
        id++;
        System.out.println("Ürün eklemeye devam etmek ister misiniz? E/H girin!");
        String cevap = input.next().toUpperCase();
        if (cevap.equals("E")){
            defineProduct();
        }
    }

    @Override
    public void assignShelf() {
        listing();
        System.out.println("Please enter the ID of the product that you want to assign to the shelf!");
        try {
            int id = input.nextInt();
            input.nextLine();

            if (!actions.containsKey(id)) {
                throw new NoSuchElementException("No product found for the specified ID!");
            }

            Product product = actions.get(id);
            if (product.getShelf() == null) {
                System.out.println("Please enter the shelf number!");
                String shelf = input.nextLine();

                if (shelf.isEmpty()) {
                    throw new IllegalArgumentException("Shelf number cannot be empty!");
                }

                product.setShelf(shelf);
                System.out.println("ID : "+ id + "\nShelf : " + shelf );
            } else {
                throw new IllegalArgumentException(product.getShelf() + " is already assigned for this product.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid ID format! Please enter a valid ID.");
            input.nextLine(); // Clear the input buffer
        } catch (IllegalArgumentException | NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void listing() {
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-5s %-15s %-15s %-10s %-10s %-5s\n", "ID", "PRODUCT NAME", "PRODUCTER", "AMOUNT", "UNIT", "SHELF");
        Set<Map.Entry<Integer, Product>> actionList = actions.entrySet();
        System.out.println("-----------------------------------------------------------------");

        for (Map.Entry<Integer, Product> entry : actionList) {
            Product product = entry.getValue();
            System.out.printf("%-5d %-15s %-15s %-10d %-10s %-5s\n", entry.getKey(), product.getProductName(),
                    product.getProducter(), product.getAmount(), product.getUnit(), product.getShelf());
        }

        System.out.println("-----------------------------------------------------------------");
    }


    @Override
    public void inboundProdct() {
        listing();
        System.out.print("Sectiginiz urun id giriniz: ");
        try {

        if (input.hasNextInt()){
            int id = input.nextInt();
            if (actions.containsKey(id)) {
                System.out.println(actions.get(id).getAmount() + " " +
                        actions.get(id).getUnit() + " depoda var." +
                        "\nNe kadar miktar ekleyeceksiniz?");

                if (input.hasNextInt()){
                    int amount = input.nextInt();
                    if(amount>0){
                        int newAmount=amount + actions.get(id).getAmount();
                        actions.get(id).setAmount(amount);
                        System.out.println(actions.get(id).getAmount() + " " + actions.get(id).getUnit() + " depoda var.");
                    }else {
                        throw new IllegalArgumentException("Amount cannot to be negative");
                    }

                }else{
                    throw new IllegalArgumentException("Amount must to be digit");
                }


            } else {
                throw new NoSuchElementException("No product found with this Id");
            }

        }else {
            throw new InputMismatchException("Id must to be digit");
        }
        } catch(InputMismatchException e){
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException | NoSuchElementException e){
            System.out.println(e.getMessage());

        }


    }
    @Override
    public void productOut() throws NoSuchElementException {
        listing();

        System.out.print("Sectiginiz urun id giriniz: ");
        int id = input.nextInt();

        if (!actions.containsKey(id)) {
            throw new NoSuchElementException("Belirtilen ID'ye sahip bir ürün bulunamadı.");
        } else {
            Product product = actions.get(id);
            int availableAmount = product.getAmount();
            System.out.print("Cikarmak istediğiniz miktari giriniz: ");
            int amount = input.nextInt();
            amount = Math.abs(amount);
            if (availableAmount < amount) {
                throw new IllegalArgumentException("Yeterli ürün bulunmamaktadır. Mevcut miktar: " + availableAmount);

            } else {
                int newAmount = 0;
                newAmount = availableAmount - amount;
                product.setAmount(newAmount);
                System.out.println("Güncel miktar: " + newAmount);

                if (newAmount == 0) {
                    product.setShelf(null);
                }
            }
        }

    }
}
