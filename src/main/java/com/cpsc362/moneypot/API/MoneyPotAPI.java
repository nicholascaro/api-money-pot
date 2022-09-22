package com.cpsc362.moneypot.API;


import com.cpsc362.moneypot.Dao.models.Pot;
import com.cpsc362.moneypot.Service.MoneyPot;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MoneyPotAPI {
    MoneyPot moneyPot = new MoneyPot();

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, path = "/delete")
    public String deletePot (@RequestBody Map<String, Object> requestBodyParam) {
        return moneyPot.deleteMoneyPot(requestBodyParam);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public String createPot (@RequestBody Pot potModel) {
        return moneyPot.addMoneyPot(potModel);
    }

    //TODO write find end-point
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, path = "/find")
    public Pot findPot (@RequestBody Map<String, Object> requestBodyParam) {
        return moneyPot.findMoneyPot(requestBodyParam);
    }


}
