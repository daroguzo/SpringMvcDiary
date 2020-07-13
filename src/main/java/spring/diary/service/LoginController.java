package spring.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring.diary.dao.AccountDao;
import spring.diary.dto.Account;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    AccountDao accountDao;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/main")
    public String main(){
        return "main";
    }

    @PostMapping("/login")
    public String login(RedirectAttributes redirectAttributes, HttpSession session,
                        @RequestParam(value = "id", required = false) String id,
                        @RequestParam(value = "password", required = false) String password){
        try {
            Account account = accountDao.selectByName(id);
            if(account.getPassword().equals(password)) {
                session.setAttribute("id", id);
                return "redirect:main";
            }else {
                redirectAttributes.addFlashAttribute("errorMessage", "암호가 틀렸습니다!");
                return "redirect:loginForm";
            }
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", "존재하지 않는 아이디입니다!");
            return "redirect:loginForm";
        }
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession, RedirectAttributes redirectAttributes){
        httpSession.removeAttribute("id");
        httpSession.invalidate();
        redirectAttributes.addFlashAttribute("message", "로그아웃!");
        return "redirect:/";
    }

    @PostMapping("/register")
    public String register(RedirectAttributes redirectAttributes,
                           @RequestParam(value = "id") String id,
                           @RequestParam(value = "password") String password,
                           @RequestParam(value = "password2") String password2) {
        try {
            Account newAccount = new Account();
            newAccount.setName(id);
            newAccount.setPassword(password);
            if(id == null || password == null){
                redirectAttributes.addFlashAttribute("errorMessage", "아이디나 패스워드는 필수 입력사항입니다.");
                return "redirect:registerForm";
            }else if(!password.equals(password2)){
                redirectAttributes.addFlashAttribute("errorMessage", "비밀번호 확인이 일치하지 않습니다!");
                return "redirect:registerForm";
            }
            accountDao.insert(newAccount);
            redirectAttributes.addFlashAttribute("message", "회원가입 완료!");
            return "redirect:/";
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", "이미 존재하는 아이디입니다!");
            return "redirect:registerForm";
        }
    }

    @GetMapping("/registerForm")
    public String registerForm(){
        return "registerForm";
    }


}
