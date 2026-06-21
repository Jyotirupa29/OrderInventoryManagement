package inventorymanagement.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventorymanagement.entity.Orderitem;
import inventorymanagement.entity.Orders;
import inventorymanagement.entity.Product;
import inventorymanagement.exception.InsufficientStockException;
import inventorymanagement.repository.OrdersRepository;
import inventorymanagement.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
public class OrderService {

     @Autowired
     private ProductRepository productRepository;

	 @Autowired
     private OrdersRepository ordersRepository;

	 @Transactional
     public Orders placeorder (int id, int qty) {

	Product product=productRepository.findById(id)
			.orElseThrow(()-> new RuntimeException("Product Unavailable"));


	if (product.getStock()<qty) {
      throw new InsufficientStockException("insufficient stock");
}
	
	     System.out.println("productavailable");
         product.setStock(product.getStock() - qty);
         System.out.println("then updated stock");

			Orders orders=new Orders();
            System.out.println("create orders");
	        orders.setDateTime(LocalDateTime.now());
	 
	        Orderitem item = new Orderitem();
            item.setProduct(product);
            item.setQty(qty);
            item.setOrders(orders);

	        orders.setItems(List.of(item));

	        System.out.println("create order itmes and assign items");

	        System.out.println("save orders intrun saves order items and updates pro");

	        return ordersRepository.save(orders);
}
}