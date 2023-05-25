package ru.kifor4ik.controller.low;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kifor4ik.domain.AccountEntity;
import ru.kifor4ik.service.low.AccountServiceLow;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/low/account/")
public class AccountController {

    @Autowired
    private AccountServiceLow accountService;

    @PostMapping("/")
    public AccountEntity create(@RequestBody AccountEntity item) throws SQLException {
        return accountService.create(item);
    }

    @GetMapping("/{id}")
    public AccountEntity get(@PathVariable(value = "id") int id) throws SQLException {
        return accountService.getById(id);
    }

    @PutMapping("/")
    public AccountEntity update(@RequestBody AccountEntity item) throws SQLException {
        return accountService.update(item);
    }

    @DeleteMapping("/")
    public AccountEntity delete(@RequestParam int id) throws SQLException {
        return accountService.delete(id);
    }

}
