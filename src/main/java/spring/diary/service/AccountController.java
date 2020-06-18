package spring.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.diary.dao.AccountDao;
import spring.diary.dto.Account;

import java.util.List;

@Controller
public class AccountController {
    @Autowired
    private AccountDao accountDao;

    @GetMapping(value = "/list")
    public String list(Model model){
        List<Account> accountList = accountDao.selectAll();
        model.addAttribute("accounts", accountList);
        return "list";
    }

    @GetMapping(value = "/account")
    public String account(Model model){
        return "account";
    }
}
