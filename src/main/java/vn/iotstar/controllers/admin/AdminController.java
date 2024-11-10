package iotstar.controllers.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.entity.Users;
import vn.iotstar.services.IUserService;
import vn.iotstar.services.impl.UserServiceImpl;
import vn.iotstar.ultis.Constant;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = {"/admin/home","/admin/user/list", "/admin/user/add", "/admin/user/insert"
        ,"/admin/user/edit","/admin/user/update"})
public class AdminController extends HttpServlet {
public IUserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(url.contains("/admin/home")){
            req.getRequestDispatcher("/views/admin/HomeAdmin.jsp").forward(req, resp);
        }
        else if(url.contains("/admin/user/add")){
            req.getRequestDispatcher("/views/admin/user-add.jsp").forward(req, resp);
        }
        else if(url.contains("/admin/user/list")){
            List<Users> list =userService.findAll();
            req.setAttribute("listuser", list);
            req.getRequestDispatcher("/views/admin/user-list.jsp").forward(req, resp);
        }
        else if(url.contains("/admin/user/edit")){
            String username = req.getParameter("id");
            Users user = userService.findByUsername(username);

            System.out.println(user);
            req.setAttribute("msg", "hello");
            req.setAttribute("user", user);
            req.getRequestDispatcher("/views/admin/test.jsp").forward(req, resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        if(url.contains("/admin/user/insert")) {
            String username = req.getParameter("Username");
            String password = req.getParameter("Password");
            String email = req.getParameter("Email");
            String phone = req.getParameter("Phone");
            String fullname = req.getParameter("FullName");
            System.out.println(fullname);
            String Images = req.getParameter("Images");
            boolean active = Boolean.parseBoolean(req.getParameter("Active"));
            boolean admin = Boolean.parseBoolean(req.getParameter("Admin"));

            Users user = new Users();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setPhone(phone);
            user.setFullname(fullname);
            user.setAdmin(admin);
            user.setActive(active);

            // Upload Images
            String fname = "";
            String uploadPath = Constant.DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Part part = req.getPart("Images");
                if (part.getSize() > 0) {
                    String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    // rename file
                    int index = filename.lastIndexOf(".");
                    String ext = filename.substring(index+1);
                    fname = System.currentTimeMillis() + "." + ext;
                    // upload file
                    part.write(uploadPath + "/" + fname);
                    // ghi ten file vao data
                    user.setImages(fname);
                }else if(Images != null) {
                    user.setImages(Images);
                }
                else {
                    user.setImages("avatar.png");
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
            userService.insert(user);
            resp.sendRedirect(req.getContextPath() + "/admin/user/list");
        }

    }
}
