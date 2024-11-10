package iotstar.controllers.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.entity.Users;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.ultis.Constant;

import java.io.IOException;
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = {"/home", "/login", "/waiting"})

public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(url.contains("/home")){
            req.getRequestDispatcher("/views/web/home.jsp").forward(req, resp);
        }
        else if(url.contains("/login")){
            req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
        }
        else if(url.contains("/waiting")){
            if (session != null && session.getAttribute("account") != null) {
                Users u = (Users) session.getAttribute("account");
                req.setAttribute("username", u.getUsername());
                if (u.getAdmin() == true) {
                    resp.sendRedirect(req.getContextPath() + "/admin/home");
                } else {
                    resp.sendRedirect(req.getContextPath() + "/home");
                }
            } else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(url.contains("/login")){
            resp.setContentType("text/html");
            resp.setCharacterEncoding("UTF-8");
            req.setCharacterEncoding("UTF-8");
            // Nhan du lieu tu request URL
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            boolean isRememberMe = false;
            String remember = req.getParameter("remember");

            if ("on".equals(remember)) {
                isRememberMe = true;
            }

            String alertMsg = "";
            // Kiểm tra điều kiện
            if (username.isEmpty() || password.isEmpty()) {
                alertMsg = "Tài khoản hoặc mật khẩu không được để trống";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
                return;
            }
            IUserService service = new UserServiceImpl();
            Users user = service.Login(username, password);

            if (user != null) {
                HttpSession session = req.getSession(true);
                session.setAttribute("account", user);

                if (isRememberMe) {
                    saveRemeberMe(resp, username);
                }
                resp.sendRedirect(req.getContextPath() + "/waiting");
            } else {
                alertMsg = "Tài khoản hoặc mật khẩu không đúng";
                req.setAttribute("alert", alertMsg);
                req.getRequestDispatcher("/views/Login.jsp").forward(req, resp);
            }
        }
    }
    private void saveRemeberMe(HttpServletResponse responese, String username) {
        Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
        cookie.setMaxAge(30 * 60);
        responese.addCookie(cookie);
    }
}
