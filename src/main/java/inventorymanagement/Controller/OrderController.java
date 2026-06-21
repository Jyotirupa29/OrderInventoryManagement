package inventorymanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inventorymanagement.Service.OrderService;
import inventorymanagement.entity.Orders;

@RestController
@RequestMapping("/orders")

   public class OrderController {

	@Autowired
   private OrderService orderService;

@PostMapping("/place")
 public ResponseEntity<Orders> placeorder(@RequestParam int id, @RequestParam int qty){
        return ResponseEntity.ok(orderService.placeorder(id, qty));
   }
}
