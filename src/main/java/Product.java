public class Product implements SummaAll {

    final static int minRating = 1;
    final static int maxRating = 5;

    private String nameProduct;
    private String manufacturerProduct;
    private int priceProduct;
    private int ratingProduct;
    private int lifeProduct;

    public Product(String nameProduct, String manufacturerProduct, int priceProduct, int ratingProduct, int lifeProduct) {
        this.nameProduct = nameProduct;
        this.manufacturerProduct = manufacturerProduct;
        this.priceProduct = priceProduct;
        this.ratingProduct = ratingProduct;
        this.lifeProduct = lifeProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getManufacturerProduct() {
        return manufacturerProduct;
    }

    public void setManufacturerProduct(String manufacturerProduct) {
        this.manufacturerProduct = manufacturerProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getRatingProduct() {
        return ratingProduct;
    }

    public void setRatingProduct(int ratingProduct) {
        if (ratingProduct >= minRating && ratingProduct <= maxRating){
            this.ratingProduct = ratingProduct;
        } else{
            System.out.println("Рейтинг задан вне диапазона");
        }

            this.ratingProduct = ratingProduct;
    }

    public int getLifeProduct() {
        return lifeProduct;
    }

    public void setLifeProduct(int lifeProduct) {
        this.lifeProduct = lifeProduct;
    }

    @Override
    public String toString() {
        return "Товар : " +
                "Наименование - " + nameProduct + '\'' +
                ", Производитель -'" + manufacturerProduct + '\'' +
                ", Цена - " + priceProduct +
                ", Рейтинг - " + ratingProduct + '\'' +
                ", Срок годности -" + lifeProduct + '\'';
    }

    @Override
    public int add(int sum) {
        return 0;
    }
}
