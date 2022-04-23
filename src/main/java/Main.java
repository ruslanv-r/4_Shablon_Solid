import java.util.*;

public class Main {
    /*Single-Responsibility principle
     * наименования методов приближены по сути к их функционалу
     * созданы отдельные листы под различные выборки
     * код отформатирован
     * */

    /*
    Dependency inversion principle
    был создан интерфейс Logger и класс LoggerFles
    через интерфейс был создан объект, с помощью которого заполняется лист с покупками
    и возратами продуктов

     */

    /*
     *Interface segregation principle
     *для наглядного примера ввел два интерфейса PaySend и ReturnSend
     * в классе Send имплементировал их
     */
    public static void main(String[] args) {
        PaySend paySend = new Send();
        ReturnSend returnSend = new Send();

//SummaAll summaAll = new Product("Хлеб", "Хлебзавод", 50, 5, 10);
        Check check = new Check();
        Logger logger = new LoggerFiles();
        List<Product> listProduct = new ArrayList<>(); //осн лист продуктов
        List<String> listLogg = new ArrayList<>(); // Логи
        List<Product> listManufacturerProduct = new ArrayList<>(); //выборка по производителю
        List<Product> listRatingProduct = new ArrayList<>();//выборка по рейтингу
        List<Product> payListProduct = new ArrayList<>(); //лист купленных товаров
        Set<String> criterionManufacture = new HashSet<>(); //Сет производителей
        Set<Integer> criterionRating = new HashSet<>();//значение рейтинга
        Map<Product, Integer> total = new HashMap<>();

        addListProduct(listProduct);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие из данного списка:");
            System.out.println("1 - Выбор продукта из списка для покупки");
            System.out.println("2 - Поиск продукта по критериям");
            System.out.println("3 - Рекомендация продуктов");
            System.out.println("4 - Удаление продуктов из списка");
            System.out.println("5 - Вывод лог-файла");
            System.out.println("end - Выход");

            String temp = scanner.nextLine();
            int choiceNumberMenu = 0;
            if (temp.equals("end")) {
                break;
            }

            if (check.checkForInt(temp)) {
                choiceNumberMenu = Integer.parseInt(temp);
            } else {
                continue;
            }

            switch (choiceNumberMenu) {
                case 1:
                    toPayFromList(listProduct, payListProduct, scanner, logger, listLogg, paySend, check);
                    break;
                case 2:
                    toPayFromcСiterion(listProduct, listRatingProduct, payListProduct, criterionManufacture,
                            criterionRating, listManufacturerProduct, scanner, logger, listLogg, paySend, check);
                    break;
                case 3:
                    toPayRecomendation(listProduct, payListProduct, scanner, check);
                    break;
                case 4:
                    System.out.println(payListProduct);
                    returnPayFromList(payListProduct, scanner, logger, listLogg, returnSend, check);
                    break;
                case 5:
                    showLogg(listLogg);
                    break;
            }
            //        for(Product products :  listProduct) {
//            System.out.println(products.getNameProduct() + ", " + products.getPriceProduct());
//        }
        }
    }

    public static void addListProduct(List<Product> listProduct) {
        listProduct.add(new Product("Хлеб", "Хлебзавод", 50, 5, 10));
        listProduct.add(new Product("Булка", "Хлебзавод", 90, 5, 10));
        listProduct.add(new Product("Гречка", "Севзапас", 150, 4, 500));
        listProduct.add(new Product("Молоко", "Севзапас", 90, 4, 150));
        listProduct.add(new Product("Яблоко", "Житница", 200, 3, 120));
        listProduct.add(new Product("Лапша", "Житница", 100, 2, 600));
        listProduct.add(new Product("Чай", "Севзапас", 250, 5, 1000));
    }

    public static void toPayFromList(List<Product> listProduct, List<Product> payListProduct,
                                     Scanner scanner, Logger logger, List<String> listLogg, PaySend paySend, Check check) {

        //Don’t Repeat Yourself в данный метод идет отсылка из всех пунктов меню, для включения в списк покупок (убирание повторов)

        while (true) {
            System.out.println("Выберите продукт из списка, end - Выход");
            for (int i = 0; i < listProduct.size(); i++) {      //Магические числа
                System.out.println(i + 1 + " - " + listProduct.get(i).getNameProduct() + ", " + listProduct.get(i).getPriceProduct());
            }

            String temp = scanner.nextLine();

            if (temp.equals("end")) {
                break;
            }
            int choiceNumberMenu2 = 0;
            if (check.checkForInt(temp)) {
                choiceNumberMenu2 = Integer.parseInt(temp);
            } else {
                continue;
            }

            payListProduct.add(listProduct.get(choiceNumberMenu2 - 1));
            logger.logg("Произведена покупка продукта: " + listProduct.get(choiceNumberMenu2 - 1).getNameProduct(), listLogg);
            paySend.sendPay(listProduct.get(choiceNumberMenu2 - 1).getNameProduct());
            System.out.println(payListProduct);
        }
    }

    public static void toPayFromcСiterion(List<Product> listProduct, List<Product> listRatingProduct, List<Product> payListProduct,
                                          Set<String> criterionManufacture, Set<Integer> criterionRating,
                                          List<Product> listManufacturerProduct, Scanner scanner, Logger logger,
                                          List<String> listLogg, PaySend paySend, Check check) {

        while (true) {
            System.out.println("Выберите критерий для поиска, end - Выход");
            System.out.println("1 - Производитель");
            System.out.println("2 - Рэйтинг");

            String temp = scanner.nextLine();
            if (temp.equals("end")) {
                break;
            }

            int choiceNumberMenu3 = 0;
            if (check.checkForInt(temp)) {
                choiceNumberMenu3 = Integer.parseInt(temp);
            } else {
                continue;
            }
            String typeKriteria = null;
            int count = 0;

            switch (choiceNumberMenu3) {
                case 1:
                    choiceCriterionManufacturer(listProduct, listRatingProduct, payListProduct, criterionManufacture,
                            criterionRating, listManufacturerProduct, scanner, logger, listLogg, paySend, check);
                    break;

                case 2:
                    choiceCriterionRation(listProduct, listRatingProduct, payListProduct, criterionManufacture,
                            criterionRating, listManufacturerProduct, scanner, logger, listLogg, paySend, check);
                    break;
            }
            //  System.out.println(products.getNameProduct() + ", " + products.getPriceProduct());
        }
    }

    public static void toPayRecomendation(List<Product> listProduct, List<Product> payListProduct, Scanner scanner, Check check) {
        while (true) {
            System.out.println("Рекомендуем выбрать следующие продукты из списка, end - Выход");

            System.out.println(1 + " - " + listProduct.get(0).getNameProduct() + ", " + listProduct.get(0).getPriceProduct());

            String temp = scanner.nextLine();
            if (temp.equals("end")) {
                break;
            }
            int choiceNumberMenu2 = 0;

            if (check.checkForInt(temp)) {
                choiceNumberMenu2 = Integer.parseInt(temp);
            } else {
                continue;
            }

            payListProduct.add(listProduct.get(choiceNumberMenu2 - 1));
            System.out.println(payListProduct);
        }
    }

    public static void returnPayFromList(List<Product> payListProduct, Scanner scanner, Logger logger, List<String> listLogg, ReturnSend returnSend, Check check) {
        while (true) {
            System.out.println("Выберите продукт для удаления из списка, end - Выход");

            if (payListProduct.size() == 0) {
                System.out.println("Список покупок пуст");
                break;
            }
            for (int i = 0; i < payListProduct.size(); i++) {   //Магические числа
                System.out.println(i + 1 + " - " + payListProduct.get(i).getNameProduct() + ", " + payListProduct.get(i).getPriceProduct());
            }

            String temp = scanner.nextLine();
            if (temp.equals("end")) {
                break;
            }
            int choiceNumberMenu2 = 0;

            if (check.checkForInt(temp)) {
                choiceNumberMenu2 = Integer.parseInt(temp);
            } else {
                continue;
            }

            logger.logg("Произведен возрат продукта: " + payListProduct.get(choiceNumberMenu2 - 1).getNameProduct(), listLogg);
            returnSend.sendReturn(payListProduct.get(choiceNumberMenu2 - 1).getNameProduct());

            payListProduct.remove(choiceNumberMenu2 - 1);




            System.out.println(payListProduct);
        }
    }

    public static void showLogg(List<String> listLogg) {
        while (true) {
            System.out.println("Лог действий при покупке, end - Выход");

            if (listLogg.size() == 0) {
                System.out.println("Список действий пуст");
                break;
            }
            for (int i = 0; i < listLogg.size(); i++) {   //Магические числа
                System.out.println(i + 1 + " - " + listLogg.get(i));
            }
            break;
        }
    }

    public static void choiceCriterionManufacturer(List<Product> listProduct, List<Product> listRatingProduct, List<Product> payListProduct,
                                                   Set<String> criterionManufacture, Set<Integer> criterionRating,
                                                   List<Product> listManufacturerProduct, Scanner scanner, Logger logger,
                                                   List<String> listLogg, PaySend paySend, Check check) {
        for (int i = 0; i < listProduct.size(); i++) {      //Магические числа

            criterionManufacture.add(listProduct.get(i).getManufacturerProduct());

            //  criterionRating.add(listProduct.get(i).getRatingProduct());
        }
        while (true) {
            System.out.println("Выберите производителя, end - Выход");
            System.out.println(criterionManufacture.toString());
            String temp = scanner.nextLine();
            if (temp.equals("end")) {
                break;
            }

            for (int i = 0; i < listProduct.size(); i++) {      //Магические числа

                if (listProduct.get(i).getManufacturerProduct().equals(temp)) {
                    listManufacturerProduct.add(listProduct.get(i));
                    // System.out.println(i + 1 + " - " + listProduct.get(i).getNameProduct() + ", " + listProduct.get(i).getPriceProduct());
                }
            }
            toPayFromList(listManufacturerProduct, payListProduct, scanner, logger, listLogg, paySend, check);
        }
    }

    public static void choiceCriterionRation(List<Product> listProduct, List<Product> listRatingProduct, List<Product> payListProduct,
                                             Set<String> criterionManufacture, Set<Integer> criterionRating,
                                             List<Product> listManufacturerProduct, Scanner scanner, Logger logger,
                                             List<String> listLogg, PaySend paySend, Check check) {

        while (true) {
            System.out.println("Укажите рейтинг товара, ниже которого не отображать товар (1-5), Выход - end");
            String temp = scanner.nextLine();
            if (temp.equals("end")) {
                break;
            }
            int choiceNumber1 = 0;

            if (check.checkForInt(temp)) {
                choiceNumber1 = Integer.parseInt(temp);
            } else {
                continue;
            }

            for (int i = 0; i < listProduct.size(); i++) {      //Магические числа

                if (listProduct.get(i).getRatingProduct() >= choiceNumber1) {
                    listRatingProduct.add(listProduct.get(i));
                    System.out.println(i + 1 + " - " + listProduct.get(i).getNameProduct() + ", " + listProduct.get(i).getPriceProduct());
                }
            }
            toPayFromList(listRatingProduct, payListProduct, scanner, logger, listLogg, paySend, check);
        }

    }
}
