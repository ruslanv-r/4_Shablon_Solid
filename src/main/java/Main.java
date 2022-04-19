import java.util.*;

public class Main {

    public static void main(String[] args) {
//        Product product;
        List<Product> listProduct = new ArrayList<>();
        List<Product> payListProduct = new ArrayList<>();
        Set<String> criterionManufacture = new HashSet<>();
        Set<Integer> criterionRating= new HashSet<>();

        addListProduct(listProduct);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие из данного списка:");
            System.out.println("1 - Выбор продукта из списка для покупки");
            System.out.println("2 - Поиск продукта по критериям");
            System.out.println("3 - Рекомендация продуктов");
            System.out.println("end - Выход");


            String temp = scanner.nextLine();


            if (temp.equals("end")) {
                break;
            }
            int choiceNumberMenu = Integer.parseInt(temp);


            switch (choiceNumberMenu) {
                case 1:
                    toPayFromList(listProduct, payListProduct, scanner);
                    break;
                case 2:
                    while (true) {
                        System.out.println("Выберите критерий для поиска, end - Выход");
                        System.out.println("1 - Производитель");
                        System.out.println("2 - Рэйтинг");

                        temp = scanner.nextLine();
                        if (temp.equals("end")) {
                            break;
                        }

                        int choiceNumberMenu3 = Integer.parseInt(temp);
                        String typeKriteria = null;
                        int count = 0;

                        switch (choiceNumberMenu3) {
                            case 1:

                                }


                        for (int i = 0; i < listProduct.size(); i++) {

                            if (choiceNumberMenu3 == 1) {
                                criterionManufacture.add(listProduct.get(i).getManufacturerProduct());
                            } else {
                                criterionRating.add(listProduct.get(i).getRatingProduct());
                            }

                            System.out.println(criterion.toString());


                        }

                        //  System.out.println(products.getNameProduct() + ", " + products.getPriceProduct());


                    }

            }


//        for(Product products :  listProduct) {
//            System.out.println(products.getNameProduct() + ", " + products.getPriceProduct());
//        }
        }
    }

        public static void addListProduct (List < Product > listProduct) {
            listProduct.add(new Product("Хлеб", "Хлебзавод", 50, 5, 10));
            listProduct.add(new Product("Булка", "Хлебзавод", 90, 5, 10));
            listProduct.add(new Product("Гречка", "Севзапас", 150, 4, 500));
            listProduct.add(new Product("Молоко", "Севзапас", 90, 4, 150));
            listProduct.add(new Product("Яблоко", "Житница", 200, 3, 120));
            listProduct.add(new Product("Лапша", "Житница", 100, 2, 600));
            listProduct.add(new Product("Чай", "Севзапас", 250, 5, 1000));


        }

        public static void toPayFromList (List < Product > listProduct, List < Product > payListProduct, Scanner scanner)
        {
            while (true) {
                System.out.println("Выберите продукт из списка, end - Выход");
                for (int i = 0; i < listProduct.size(); i++) {
                    System.out.println(i + 1 + " - " + listProduct.get(i).getNameProduct() + ", " + listProduct.get(i).getPriceProduct());
                }

                String temp = scanner.nextLine();
                if (temp.equals("end")) {
                    break;
                }
                int choiceNumberMenu2 = Integer.parseInt(temp);

                payListProduct.add(listProduct.get(choiceNumberMenu2 - 1));
                System.out.println(payListProduct);
            }

        }


    }
