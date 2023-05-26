package ru.kifor4ik.controller.hard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kifor4ik.domain.AbonentEntity;
import ru.kifor4ik.repository.prepStatRepo.AbonentRepositoryPrepState;
import ru.kifor4ik.service.low.AbonentServiceLow;

import java.sql.SQLException;
@RestController
@RequestMapping("/api/hard/abonent/")
public class AbonentControllerHard {
    @Autowired
    private AbonentRepositoryPrepState abonentService;

    @PostMapping("/")
    public AbonentEntity create(@RequestBody AbonentEntity abonentEntity) throws Exception {
        return (AbonentEntity) abonentService.create(abonentEntity);
    }

    @GetMapping("/{id}")
    public AbonentEntity get(@PathVariable(value = "id") int id) throws SQLException {
        return (AbonentEntity) abonentService.get(id);
    }

    @PutMapping("/")
    public AbonentEntity update(@RequestBody AbonentEntity abonentEntity) throws Exception {
        return (AbonentEntity) abonentService.update(abonentEntity);
    }

    @DeleteMapping("/")
    public AbonentEntity delete(@RequestParam int id) throws SQLException {
        return (AbonentEntity) abonentService.delete(id);
    }
}
