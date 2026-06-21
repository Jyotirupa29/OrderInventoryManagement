package inventorymanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;

import inventorymanagement.entity.Product;
import inventorymanagement.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired 
     private ProductRepository productRepository;

//  @PostMapping("/save")
//  public Product saveproduct(@RequestBody Product product) {
//
//	return productRepository.save(product);
//  }
	
	@GetMapping
	public String home(Model model) {
	    model.addAttribute("products", productRepository.findAll());
	    return "inventory";
	}
	
	@PostMapping("/save")
	public String saveproduct(Product product) {

	    productRepository.save(product);

	    return "redirect:/";
	}
}
