package spring.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.diary.dao.DiaryDao;
import spring.diary.dto.Diary;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    @Autowired
    private DiaryDao diaryDao;

    @GetMapping("/searchForm")
    public String searchForm() {
        return "searchForm";
    }

    @PostMapping("/search")
    public String search(HttpSession session, RedirectAttributes redirectAttributes,
                              @RequestParam(value = "titleSearch", required = false) String titleSearch,
                              @RequestParam(value = "contentSearch", required = false) String contentSearch,
                              @RequestParam(value = "dateSearch", required = false) String dateSearch,
                              @RequestParam(value = "action") String action){
        String id = null;
        try{
            id = (String) session.getAttribute("id");
            List<Diary> diaryList = diaryDao.selectByOwner(id);
            List<Diary> searchList = new ArrayList<>();
            if(id == null){
                return "redirect:sessionError";
            }else {
                switch (action) {
                    case "title":
                        for (Diary diary : diaryList) {
                            if (diary.getName().contains(titleSearch)) {
                                Diary element = new Diary(diary);
                                searchList.add(element);
                            }
                        }
                        if(searchList.isEmpty()){
                            redirectAttributes.addFlashAttribute("message", "검색 결과가 없습니다!");
                        }
                        redirectAttributes.addFlashAttribute("searchList", searchList);
                        return "redirect:searchResult";
                    case "content":
                        for (Diary diary : diaryList) {
                            if (diary.getContent().contains(contentSearch)) {
                                Diary element = new Diary(diary);
                                searchList.add(element);
                            }
                        }
                        if(searchList.isEmpty()){
                            redirectAttributes.addFlashAttribute("message", "검색 결과가 없습니다!");
                        }
                        redirectAttributes.addFlashAttribute("searchList", searchList);
                        return "redirect:searchResult";
                    case "date":
                        for (Diary diary : diaryList) {
                            if (diary.getDate().contains(dateSearch)) {
                                Diary element = new Diary(diary);
                                searchList.add(element);
                            }
                        }
                        if(searchList.isEmpty()){
                            redirectAttributes.addFlashAttribute("message", "검색 결과가 없습니다!");
                        }
                        redirectAttributes.addFlashAttribute("searchList", searchList);
                        return "redirect:searchResult";
                    default:
                        redirectAttributes.addFlashAttribute("오류 발생!");
                        System.out.println("디폴트 오");
                        return "redirect:seeDiary";
                }
            }
        }catch (Exception e){
            System.out.println("캐치 오류");
            return "redirect:sessionError";
        }
    }
    @GetMapping("/searchResult")
    public String searchResult(){
        return "searchResult";
    }
}

