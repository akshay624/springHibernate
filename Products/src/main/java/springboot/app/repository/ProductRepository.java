package springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import springboot.app.pojo.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
