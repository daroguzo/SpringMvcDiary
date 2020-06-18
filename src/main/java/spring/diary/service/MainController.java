package spring.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.diary.dao.AccountDao;
import spring.diary.dto.Account;

@Controller
public class MainController {
    @Autowired
    AccountDao accountDao;

    @GetMapping("/login")
    public String login(Model model,
                        @RequestParam(value = "login", required = false) boolean login){
        if(!login)
            model.addAttribute(login);


        return "login";
    }

    @RequestMapping("/loginCheck")
    public String loginCheck(Model model,
                        @RequestParam(value = "id", required = false) String id,
                        @RequestParam(value = "password", required = false) String password){
        boolean idFlag = false;
        boolean passwordFlag = false;
        try {
            Account account = accountDao.selectByName(id);
            if(account.getPassword().equals(password))
                return "main";
        }catch (Exception e){
            System.out.println("아이디가 존재하지 않습니다.");
            return "login";
        }

        return "login";
    }
}
