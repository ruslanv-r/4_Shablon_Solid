public class ProductColor extends Product{

    private String color;
    public ProductColor(String nameProduct, String manufacturerProduct, int priceProduct, int ratingProduct, int lifeProduct,String color) {
        super(nameProduct, manufacturerProduct, priceProduct, ratingProduct, lifeProduct);
        this.color=color;
    }
}
