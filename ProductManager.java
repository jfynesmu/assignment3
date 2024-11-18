import java.io.*;

public class ProductManager {
    private String filePath;
    private RedBlackTree<Product> tree;

    public ProductManager(String filePath, RedBlackTree<Product> tree) {
        this.filePath = filePath;
        this.tree = tree;
    }

    public void loadProducts() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    Product product = new Product(data[0], data[1], data[2], Double.parseDouble(data[3]));
                    tree.insert(product);
                }
            }
            System.out.println("Products loaded successfully.");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    public void addProduct(Product product) {
        if (tree.search(product) != null) {
            System.out.println("Error: Product with ID " + product.getProductId() + " already exists.");
        } else {
            tree.insert(product);
            System.out.println("Product added: " + product);
        }
    }

    public void searchProduct(String productId) {
        Product dummy = new Product(productId, "", "", 0.0);
        Product result = tree.search(dummy);
        if (result != null) {
            System.out.println("Product found: " + result);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }
}

