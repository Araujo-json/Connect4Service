package connect4.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class connect4Controller {
    @GetMapping("/game/connect4")
    public connect4Status playGame(@RequestParam String moves){
        connect4Service service = new connect4Service();
        connect4Status status = connect4Service.getStatus(moves);
        return status;
    }
}
//TRY
//http://localhost:9416/game/connect4?moves=?????????????????X?????X?????X?????X?????O
//vertical
//http://localhost:9416/game/connect4?moves=X??????X??????X??????X????????????????????
//horizontal
//http://localhost:9416/game/connect4?moves=???????????????XXXX???????????????????????
//diagonal
//http://localhost:9416/game/connect4?moves=?????????????????X???????X???????X???????X