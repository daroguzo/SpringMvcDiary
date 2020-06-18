package spring.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring.diary.dao.DiaryDao;

@Controller
public class FindController {
    @Autowired
    private DiaryDao diaryDao;

    @GetMapping(value = "/find")
    public String find(Model model){
        return "find";
    }
}
