package spring.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.diary.dao.AccountDao;
import spring.diary.dto.Account;

import javax.servlet.http.HttpSession;

@Controller
public class AccountController {
    @Autowired
    private AccountDao accountDao;

    @GetMapping("/account")
    public String account(HttpSession session){
        String id = null;
        try{
            id = (String) session.getAttribute("id");
            if(id == null){
                return "redirect:sessionError";
            }else {
             return "account";
            }
        }catch (Exception e){
            return "redirect:sessionError";
        }
    }

    @GetMapping("/seeAccount")
    public String seeAccount(Model model, HttpSession session){
        String id = null;
        try{
            id = (String) session.getAttribute("id");
            Account account;
            account = accountDao.selectByName(id);
            if(id == null){
                return "redirect:sessionError";
            }else {
                model.addAttribute("account", account);
                return "seeAccount";
            }
        }catch (Exception e){
            return "redirect:sessionError";
        }
    }

    @PostMapping("/changePwd")
    public String changePwd(Model model, HttpSession session, RedirectAttributes redirectAttributes,
                            @RequestParam(value = "oldPwd") String oldPwd,
                            @RequestParam(value = "newPwd") String newPwd,
                            @RequestParam(value = "newPwd2") String newPwd2){
        String id = null;
        try{
            id = (String) session.getAttribute("id");
            Account account;
            account = accountDao.selectByName(id);
            if(id == null){
                return "redirect:sessionError";
            }else if(!newPwd.equals(newPwd2)) {
                model.addAttribute("account", account);
                redirectAttributes.addFlashAttribute("errorMessage", "새로운 비밀번호가 일치하지 않습니다!");
                return "redirect:pwdForm";
            }else{
                if(!account.getPassword().equals(oldPwd)){
                    redirectAttributes.addFlashAttribute("errorMessage", "이전 비밀번호가 일치하지 않습니다!");
                    return "redirect:pwdForm";
                }
                account.setPassword(newPwd);
                accountDao.updatePassword(account);
                redirectAttributes.addFlashAttribute("message", "비밀번호 변경 완료!");
                return "redirect:account";
            }
        }catch (Exception e){
            return "redirect:sessionError";
        }
    }

    @GetMapping("/pwdForm")
    public String pwdForm(){
        return "pwdForm";
    }

    @GetMapping("/updateAccount")
    public String updateAccount(){
        return "updateAccount";
    }

    @PostMapping("/changeName")
    public String changeName(Model model, HttpSession session, RedirectAttributes redirectAttributes,
                             @RequestParam(value = "newName", required = false) String newName){
        String id = null;
        try{
            id = (String) session.getAttribute("id");
            Account account;
            account = accountDao.selectByName(id);
            if(id == null){
                return "redirect:sessionError";
            }else {
                model.addAttribute("account", account);
                account.setUserName(newName);
                accountDao.updateUserName(account);
                redirectAttributes.addFlashAttribute("message", "이름 변경 완료!");
                return "redirect:updateAccount";
            }
        }catch (Exception e){
            return "redirect:sessionError";
        }
    }

    @GetMapping("/nameForm")
    public String nameForm() {
        return "nameForm";
    }

    @GetMapping("/phoneForm")
    public String phoneForm(){
        return "phoneForm";
    }

    @PostMapping("/changePhone")
    public String changePhone(Model model, HttpSession session, RedirectAttributes redirectAttributes,
                             @RequestParam(value = "newPhone", required = false) String newPhone){
        String id = null;
        try{
            id = (String) session.getAttribute("id");
            Account account;
            account = accountDao.selectByName(id);
            if(id == null){
                return "redirect:sessionError";
            }else {
                model.addAttribute("account", account);
                account.setPhoneNumber(newPhone);
                accountDao.updatePhoneNumber(account);
                redirectAttributes.addFlashAttribute("message", "전화번호 변경 완료!");
                return "redirect:updateAccount";
            }
        }catch (Exception e){
            return "redirect:sessionError";
        }
    }

    @GetMapping("/addressForm")
    public String addressForm(){
        return "addressForm";
    }

    @PostMapping("/changeAddress")
    public String changeAddress(Model model, HttpSession session, RedirectAttributes redirectAttributes,
                             @RequestParam(value = "newAddress", required = false) String newAddress){
        String id = null;
        try{
            id = (String) session.getAttribute("id");
            Account account;
            account = accountDao.selectByName(id);
            if(id == null){
                return "redirect:sessionError";
            }else {
                model.addAttribute("account", account);
                account.setAddress(newAddress);
                accountDao.updateAddress(account);
                redirectAttributes.addFlashAttribute("message", "주소 변경 완료!");
                return "redirect:updateAccount";
            }
        }catch (Exception e){
            return "redirect:sessionError";
        }
    }

    @GetMapping("sessionError")
    public String sessionError(){
        return "sessionError";
    }
}
