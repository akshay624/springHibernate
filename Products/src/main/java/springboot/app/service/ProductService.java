package springboot.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import springboot.app.pojo.Product;
import springboot.app.repository.ProductRepository;

@Service
@Transactional
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product createProducts(@RequestBody Product product) {
		return productRepository.save(product);
	}

	public Product getProductById(@PathVariable long Id) {
		return productRepository.findById(Id).get();
	}

	public Product updateProductDetails(@RequestBody Product product, @PathVariable long Id) {
		return productRepository.findById(Id).map(prod -> {
			prod.setId(product.getId());
			prod.setProductName(product.getProductName());
			prod.setProductDescription(product.getProductDescription());
			prod.setPrice(product.getPrice());
			return productRepository.save(prod);
		}).orElseGet(() -> {
			product.setId(Id);
			return productRepository.save(product);
		});
	}

	void deleteProduct(@PathVariable long Id) {
		productRepository.deleteById(Id);
	}

}
