package inventorymanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import inventorymanagement.Service.OrderService;

@Controller
@RequestMapping("/orders")

   public class OrderController {

	@Autowired
   private OrderService orderService;

//@PostMapping("/place")
// public ResponseEntity<Orders> placeorder(@RequestParam int id, @RequestParam int qty){
//        return ResponseEntity.ok(orderService.placeorder(id, qty));
//   }
	
	@PostMapping("/place")
    public String placeorder(
            @RequestParam int id,
            @RequestParam int qty) {

        orderService.placeorder(id, qty);

        return "redirect:/";
    }
}
