package pl.pjatk.kamkon;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> productList = new ArrayList<>();

    public Product getProductById(Long id) {
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void deleteProductById(Long id) {
        Product productToRemove = null;
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                productToRemove = product;
                break;
            }
        }
        if (productToRemove != null) {
            productList.remove(productToRemove);
        }
    }

    public void updateProduct(Product updatedProduct) {
        for (Product product : productList) {
            if (product.getId().equals(updatedProduct.getId())) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                break;
            }
        }
    }

    public List<Product> getAllProducts() {
        return productList;
    }
}
