package pl.pjatk.kamkon;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/homework")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // dodaj produkt
    // POST localhost:8080/homework/products

/*
{
    "id": 1111,
    "name": "Milk",
    "price": 2.99
}
*/

    @PostMapping("/products")
    public Product postProduct(@RequestBody Product newProduct) {
        productService.addProduct(newProduct);
        return newProduct;
    }

    // wyświetl wszystkie
    // GET localhost:8080/homework/products/all

    @GetMapping("/products/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // wyświel przez id
    // GET localhost:8080/homework/product/1111

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // wyświel przez parametr id
    // GET localhost:8080/homework/product?id=3333

    @GetMapping("/product")
    public Product getProductByIdRequestParam(@RequestParam Long id) {
        return productService.getProductById(id);
    }

    // aktualizuj
    // PUT localhost:8080/homework/products/1111

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product existingProduct = productService.getProductById(id);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        productService.updateProduct(existingProduct);
        return ResponseEntity.ok(existingProduct);
    }


    // usuń
    // DELETE localhost:8080/homework/products/3333

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProductById(id);
        return ResponseEntity.ok().build();
    }
}

