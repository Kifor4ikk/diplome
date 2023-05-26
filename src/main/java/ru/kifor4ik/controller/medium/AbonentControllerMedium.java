package ru.kifor4ik.controller.medium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.service.low.AbonentServiceLow;
import ru.kifor4ik.service.medium.AbonentServiceMedium;

import java.math.BigDecimal;
import java.sql.SQLException;

@RestController
@RequestMapping("/api/medium/abonent/")
public class AbonentControllerMedium {

    @Autowired
    private AbonentServiceMedium abonentService;

    @PostMapping("/")
    public AbonentEntity create(@RequestBody AbonentEntity abonentEntity) throws Exception {
        return (AbonentEntity) abonentService.create(abonentEntity);
    }

    @GetMapping("/{id}")
    public AbonentEntity get(@PathVariable(value = "id") int id) throws SQLException {
        return (AbonentEntity) abonentService.getById(id);
    }

    @PutMapping("/")
    public AbonentEntity update(@RequestBody AbonentEntity abonentEntity) throws Exception {
        return (AbonentEntity) abonentService.update(abonentEntity);
    }

    @DeleteMapping("/")
    public AbonentEntity delete(@RequestParam int id) throws SQLException {
        return (AbonentEntity) abonentService.delete(id);
    }

    @PostMapping("/transfer")
    public boolean transferMoney(@RequestParam String cardNumberSender, @RequestParam int cardPassword,
                                 @RequestParam String cardNumberReceiver, @RequestParam BigDecimal amount) throws Exception {
        return abonentService.transferMoney(cardNumberSender, cardPassword, cardNumberReceiver,amount);
    }
}
