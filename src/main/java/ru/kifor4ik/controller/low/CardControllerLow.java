package ru.kifor4ik.controller.low;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kifor4ik.domain.CardEntity;
import ru.kifor4ik.service.low.CardServiceLow;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/low/card/")
public class CardControllerLow {

    @Autowired
    private CardServiceLow cardServiceLow;

    @PostMapping("/")
    public CardEntity create(@RequestBody CardEntity item) throws Exception {
        return cardServiceLow.create(item);
    }

    @GetMapping("/{id}")
    public CardEntity get(@PathVariable(value = "id") int id) throws SQLException {
        return cardServiceLow.getById(id);
    }

    @PutMapping("/")
    public CardEntity update(@RequestBody CardEntity item) throws Exception {
        return cardServiceLow.update(item);
    }

    @DeleteMapping("/")
    public CardEntity delete(@RequestParam int id) throws SQLException {
        return cardServiceLow.delete(id);
    }

}
