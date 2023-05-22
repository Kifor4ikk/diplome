package ru.kifor4ik.controller.low;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.service.low.AbonentServiceLow;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/abonent/")
public class AbonentControllerLow {
    @Autowired
    private AbonentServiceLow abonentService;

    @PostMapping("/")
    public AbonentEntity create(AbonentEntity abonentEntity) throws SQLException {
        return abonentService.create(abonentEntity);
    }

    @GetMapping("/{id}")
    public AbonentEntity get(@PathVariable(value = "id") int id) throws SQLException {
        return abonentService.getById(id);
    }
}
