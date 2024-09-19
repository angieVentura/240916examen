package Controllers;

import Services.ProducServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    public ProducServices product;

    @GetMapping("/{iden}")
    public ResponseEntity num(@PathVariable Integer numerito){

        List<Integer> nums = product.generador();
        String str = "no encontrao";

        for (int i = 0; i < nums.size();i++){
            if(nums.get(i) == numerito){
                str = "encontrao";
                break;
            }
        }

        String numberString = nums.stream().map(String::valueOf)
                .collect(Collectors.joining(","));

        return ResponseEntity.ok(numberString + " " + str);
    }
}
