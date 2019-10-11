//package com.caseStudy.ecart.Controller;
//
//import com.caseStudy.ecart.Repository.UserRepositoryClass;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.security.Principal;
//
//@CrossOrigin(origins = "http://localhost:4200")
//@RestController
//@RequestMapping("/login")
//public class LoginController {
//    @Autowired
//
//
//    UserRepositoryClass userRepositoryClass;
//    public static Principal principal;
//
//    @GetMapping(path = "/checkuser",produces = "application/json")
//    public String checkLogin(Principal principal)
//    {
//        System.out.println("Logging in user.. "+ principal.getName());
//        this.principal=principal;
//        return "\"login successful\"";
//    }
//    @GetMapping(path = "/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response)
//    {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println("logout servlet" + authentication);
//
//        if (authentication!=null)
//        {
//            new SecurityContextLogoutHandler().logout(request,response,authentication);
//            request.getSession().invalidate();
//            System.out.println("Logout Successfull");
//            return "\"logout successfull\"";
//        }
//        return "\"logout Unsuccessfull\"";
//    }
//}
