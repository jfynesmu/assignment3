public class ProductManagement {
    public static void main(String[] args) {
        RedBlackTree<Product> tree = new RedBlackTree<>();
        ProductManager pm = new ProductManager("amazon-product-data.csv", tree);

        // Load data from CSV file
        System.out.println("Loading products...");
        pm.loadProducts();

        // Insert operations
        System.out.println("\nInsert Operations:");
        pm.addProduct(new Product("P123", "Example Product", "CategoryX", 99.99));
        pm.addProduct(new Product("P123", "Duplicate Product", "CategoryX", 199.99));

        // Search operations
        System.out.println("\nSearch Operations:");
        pm.searchProduct("B001");
        pm.searchProduct("P123");
        pm.searchProduct("P999");
    }
}

