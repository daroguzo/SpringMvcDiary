package spring.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.diary.dao.DiaryDao;
import spring.diary.dto.Diary;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class DiaryController {
    @Autowired
    private DiaryDao diaryDao;

    private static final String FILE_PATH = "src/main/resources/static/images/";
    private static final String DELETE_PATH = "src/main/resources/static/";
    private static final String READ_PATH = "images/";

    @GetMapping("/diary")
    public String diary(HttpSession session){
        String id = null;
        try{
            id = (String) session.getAttribute("id");
            if(id == null){
                return "redirect:sessionError";
            }else {
                return "diary";
            }
        }catch (Exception e){
            return "redirect:sessionError";
        }
    }

    @GetMapping("/seeDiary")
    public String seeDiary(Model model, HttpSession session){
        String id = null;
        try{
            id = (String) session.getAttribute("id");
            List<Diary> diaryList = diaryDao.selectByOwner(id);
            if(id == null){
                return "redirect:sessionError";
            }else {
                model.addAttribute("diaries", diaryList);
                return "seeDiary";
            }
        }catch (Exception e){
            return "redirect:sessionError";
        }
    }

    @PostMapping("/modifyDiary")
    public String modifyDiary(HttpSession session, RedirectAttributes redirectAttributes,
                              @RequestParam(value = "diaryId", required = false) String diaryId,
                              @RequestParam(value = "action") String action){
        String id = null;
        try{
            id = (String) session.getAttribute("id");
            Diary diary = diaryDao.selectById(diaryId);
            if(diaryId == null){
                redirectAttributes.addFlashAttribute("message", "게시물을 선택해주세요!");
                return "redirect:seeDiary";
            }

            if(id == null){
                return "redirect:sessionError";
            }else {
                if(action.equals("update")){
                    redirectAttributes.addAttribute("name", diary.getName());
                    redirectAttributes.addAttribute("content", diary.getContent());
                    redirectAttributes.addAttribute("imageFile", diary.getImageFile());
                    redirectAttributes.addAttribute("diaryId", diary.getId());
                    return "redirect:updateDiaryForm";
                }else if(action.equals("delete")){
                    File deleteFile = new File(DELETE_PATH + diary.getImageFile());
                    if(deleteFile.exists()) {
                        deleteFile.delete();
                        System.out.println("파일을 삭제하였습니다.");
                    } else {
                        System.out.println("파일이 존재하지 않습니다.");
                    }
                    diaryDao.deleteDiary(diaryId);
                    redirectAttributes.addFlashAttribute("message", "삭제 성공!");
                    return "redirect:seeDiary";
                }else {
                    redirectAttributes.addFlashAttribute("오류 발생!");
                    return "redirect:seeDiary";
                }
            }
        }catch (Exception e){
            return "redirect:sessionError";
        }
    }

    @PostMapping("/updateDiary")
    public String updateDiary(HttpSession session, RedirectAttributes redirectAttributes,
                                  @RequestParam(value = "name") String name,
                                  @RequestParam(value = "content") String content,
                                  @RequestParam(value = "diaryId") String diaryId,
                                  @RequestParam(value = "file", required = false) MultipartFile multipartFile){
        String id = null;
        String originalFileName = multipartFile.getOriginalFilename();
        long time = System.currentTimeMillis();
        String safeFile = FILE_PATH + time + originalFileName;
        String readFile = READ_PATH + time + originalFileName;
        try{
            id = (String) session.getAttribute("id");
            Diary diary = diaryDao.selectById(diaryId);
            diary.setName(name);
            diary.setContent(content);
            if(!originalFileName.equals("")) {
                diary.setImageFile(readFile);
                try {
                    multipartFile.transferTo(new File(safeFile));

                } catch (IllegalStateException | IOException e) {

                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    System.out.println("업로드 오류");
                }
            }
            if(id == null){
                return "redirect:sessionError";
            }else {
                diaryDao.update(diary);
                redirectAttributes.addFlashAttribute("message", "다이어리 수정 완료!!");
                return "redirect:seeDiary";
            }
        }catch (Exception e){
            return "redirect:sessionError";
        }
    }

    @GetMapping("updateDiaryForm")
    public String updateDiaryForm(){
        return "updateDiaryForm";
    }

    @PostMapping("/addDiary")
    public String addDiary(Model model, HttpSession session, RedirectAttributes redirectAttributes,
                           @RequestParam(value = "file", required = false) MultipartFile multipartFile,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "content", required = false) String content){
        String id = null;
        String originalFileName = multipartFile.getOriginalFilename();
        long time = System.currentTimeMillis();
        String safeFile = FILE_PATH + time + originalFileName;
        String readFile = READ_PATH + time + originalFileName;
        try{
            id = (String) session.getAttribute("id");
            Diary newDiary = new Diary();
            newDiary.setOwner(id);
            if(id == null){
                return "redirect:sessionError";
            }else {
                model.addAttribute("diary", newDiary);
                newDiary.setName(name);
                newDiary.setContent(content);
                Date date = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                System.out.println(originalFileName);
                newDiary.setDate(simpleDateFormat.format(date));
                if(!originalFileName.equals("")) {
                    newDiary.setImageFile(readFile);
                    try {
                        multipartFile.transferTo(new File(safeFile));

                    } catch (IllegalStateException | IOException e) {

                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        System.out.println("업로드 오류");
                    }
                }
                diaryDao.insert(newDiary);
                redirectAttributes.addFlashAttribute("message", "다이어리 추가 완료!!");
                return "redirect:diary";
            }
        }catch (Exception e){
            return "redirect:sessionError";
        }
    }

    @GetMapping("diaryForm")
    public String diaryForm(){
        return "diaryForm";
    }
}

