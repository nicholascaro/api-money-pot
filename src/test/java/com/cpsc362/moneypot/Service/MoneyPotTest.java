package com.cpsc362.moneypot.Service;

import com.cpsc362.moneypot.Dao.models.Pot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MoneyPotTest {

    MoneyPot moneyPot = new MoneyPot();

    @Test
    void deleteMoneyPot() {
    }

    @Test
    void addMoneyPot() {
    }

    @Test
    void findMoneyPot() {
        Map<String, Object> input = new HashMap<String, Object>();
        input.put("_id", "631c4bb4b0f0c21ab6c67081");
        Pot pot = moneyPot.findMoneyPot(input);
        assertNull(pot);

        input.put("_id", "631c0bb4b0f0c21ab6c67081");
        Pot pot1 = moneyPot.findMoneyPot(input);
        assertNotNull(pot1);

    }
}