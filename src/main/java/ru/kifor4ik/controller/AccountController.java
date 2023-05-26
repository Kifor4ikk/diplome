package ru.kifor4ik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kifor4ik.domain.AccountEntity;
import ru.kifor4ik.service.AccountService;

import java.sql.SQLException;

@RestController
@RequestMapping("/api/account/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/")
    public AccountEntity create(@RequestBody AccountEntity item) throws Exception {
        return accountService.create(item);
    }

    @GetMapping("/{id}")
    public AccountEntity get(@PathVariable(value = "id") int id) throws SQLException {
        return accountService.getById(id);
    }

    @PutMapping("/")
    public AccountEntity update(@RequestBody AccountEntity item) throws Exception {
        return accountService.update(item);
    }

    @DeleteMapping("/")
    public AccountEntity delete(@RequestParam int id) throws SQLException {
        return accountService.delete(id);
    }

}
