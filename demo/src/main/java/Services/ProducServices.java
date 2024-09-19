package Services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ProducServices {
    private List<Integer> nums;

    public List<Integer> generador(){
        for(int i = 0; i < 5; i++){
            nums.add((int)(Math.random() * 10) + 1);
        }
        return nums;
    }
}
