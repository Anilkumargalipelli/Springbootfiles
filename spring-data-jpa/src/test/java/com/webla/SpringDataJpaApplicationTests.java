package com.webla;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.webla.product.entity.Product;
import com.webla.product.repos.ProductRepository;

import java.util.List;

@SpringBootTest
class SpringDataJpaApplicationTests {

	@Autowired
	private ProductRepository productRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void testSaveProduct() {
		Product product = new Product();
		product.setId(100);
		product.setName("LG 400L Refrigirator");
		product.setDesc("useful for home usages");
		product.setPrice(14999.99);
		
		productRepository.save(product);
		
	}
	
	@Test
	public void testUpdateProduct() {
		Product product = new Product();
		product.setId(101);
		product.setName("LG 500L Refrigirator");
		product.setDesc("useful for home usages");
		product.setPrice(16999.99);
		
		if(productRepository.existsById(101)) {			
			productRepository.save(product);
		}else {
			System.out.println("ID NOt found ..");
		}
	}
	
	@Test
	public void testDeleteProduct() {
		if(productRepository.existsById(100)) {			
			productRepository.deleteById(100);
		}else {
			System.out.println("ID NOt found ..");
		}
	}

	@Test
	public void testPriceFilter(){
		/*List<Product> productList = productRepository.findByPriceGreaterThan(15000);
		productList.forEach( e -> {
			System.out.println("Name : "+e.getName());
			System.out.println("Description : "+e.getDesc());
		});*/

		/*List<Product> productList = productRepository.findByPriceBetween(15000, 40000);
		productList.forEach( e -> {
			System.out.println("Name : "+e.getName());
			System.out.println("Description : "+e.getDesc());
			System.out.println("price : "+e.getPrice());

		});*/


		List<Product> productList = productRepository.findByNameAndPriceAndDesc("Apple", 64000, "Iphone 14 E ");
		productList.forEach( e -> {
			System.out.println("Name : "+e.getName());
			System.out.println("Description : "+e.getDesc());
			System.out.println("price : "+e.getPrice());

		});

	}


}
