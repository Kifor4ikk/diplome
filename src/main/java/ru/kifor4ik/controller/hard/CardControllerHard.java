package ru.kifor4ik.controller.hard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kifor4ik.domain.CardEntity;
import ru.kifor4ik.service.hard.CardHardService;
import ru.kifor4ik.service.low.CardServiceLow;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/hard/card/")
public class CardControllerHard {

    @Autowired
    private CardHardService cardService;

    @PostMapping("/")
    public CardEntity create(@RequestBody CardEntity item) throws Exception {
        return cardService.create(item);
    }

    @GetMapping("/{id}")
    public CardEntity get(@PathVariable(value = "id") int id) throws Exception {
        return cardService.getById(id);
    }

    @PutMapping("/")
    public CardEntity update(@RequestBody CardEntity item) throws Exception {
        return cardService.update(item);
    }

    @DeleteMapping("/")
    public CardEntity delete(@RequestParam int id) throws SQLException {
        return cardService.delete(id);
    }
}
