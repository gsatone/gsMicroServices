package com.gjs.rgf.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.gjs.rgf.dto.Product;
import com.gjs.rgf.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	private static Map<String, Product> productRepo = new HashMap<>();
	static {
		Product cecl = new Product();
		cecl.setId("1");
		cecl.setName("CECL");
		productRepo.put(cecl.getId(), cecl);

		Product ccar14m = new Product();
		ccar14m.setId("2");
		ccar14m.setName("CCAR14M");
		productRepo.put(ccar14m.getId(), ccar14m);
	}

	@Override
	public void createProduct(Product product) {
		productRepo.put(product.getId(), product);

	}

	@Override
	public void updateProduct(String id, Product product) {
		productRepo.remove(id);
		product.setId(id);
		productRepo.put(id, product);

	}

	@Override
	public void deleteProduct(String id) {
		productRepo.remove(id);
	}

	@Override
	public Collection<Product> getProducts() {
		
		return productRepo.values();
	}

}
