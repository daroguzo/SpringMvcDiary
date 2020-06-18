package spring.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.diary.dao.AccountDao;
import spring.diary.dao.DiaryDao;
import spring.diary.dto.Account;

import java.util.List;

@Controller
public class DiaryController {
    @Autowired
    private DiaryDao diaryDao;

    @GetMapping(value = "/diary")
    public String diary(Model model){
        return "diary";
    }
}
