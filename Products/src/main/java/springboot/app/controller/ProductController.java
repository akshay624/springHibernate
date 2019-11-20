package springboot.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.app.pojo.Product;
import springboot.app.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/getAllProducts", method = RequestMethod.GET)
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public Product createProduct(@RequestBody Product product) {
		return productService.createProducts(product);
	}

	@RequestMapping(value = "/getProductById/{Id}", method = RequestMethod.GET)
	public Product getProductById(@PathVariable long Id) {
		return productService.getProductById(Id);
	}

	@RequestMapping(value = "/updateProductDetails/{Id}", method = RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product, @PathVariable long Id) {
		return productService.updateProductDetails(product, Id);
	}
}
