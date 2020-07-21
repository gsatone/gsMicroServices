package com.gjs.rgf.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.gjs.rgf.dto.Product;
import com.gjs.rgf.service.ProductService;

@RestController
@RequestMapping("/card")
public class CardRiskController {
	
	@Autowired
	ProductService productService;

	@Value("${spring.application.name:DefaultCardService}")

	private String appName;

	@RequestMapping(value = "/")
	public String index() {
		return "Hello WellCome to Card Risk Analysis \n";
	}
	
	@RequestMapping(value = "/products")
	public ResponseEntity<Object> getProduct() {
		return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Product product) { 
		
		productService.updateProduct(id, product);
		return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		productService.createProduct(product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/rating")
	public String riskRatings(@RequestParam(value = "name", required = false, defaultValue = "Risk Ratings") String name) {
		return "<div align=\"center\">\n" + 
				"		<h1 style=\"background-color: lightgreen; color: darkgreen\"> "
				+ "Hello WellCome to Card Risk Ratings </h1>\n" 
				+ "Your request is " + name 
				+  "	</div>";

	}

	@RequestMapping(value = "/name")
	public String riskName() {
		return "<div align=\"center\">\n" + 
				"		<h1 style=\"background-color: lightgreen; color: darkgreen\"> "
				+ appName +"</h1>\n" + 
				"	</div>";
	}

}
