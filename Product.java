public class Product implements Comparable<Product> {
    private String productId;
    private String name;
    private String category;
    private double price;

    public Product(String productId, String name, String category, double price) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    @Override
    public int compareTo(Product other) {
        return this.productId.compareTo(other.productId);
    }

    @Override
    public String toString() {
        return "Product ID: " + productId + ", Name: " + name + ", Category: " + category + ", Price: $" + price;
    }
}

