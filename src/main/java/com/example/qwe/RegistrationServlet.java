package com.example.qwe;

import com.example.qwe.domain.User;
import com.example.qwe.services.UserService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegistrationServlet extends HttpServlet {
    private static final String LOGIN = "login";
    private static final String PASSWORD = "pwd";
    private static final String PARAM_ADVERT = "advert";
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService)config.getServletContext().getAttribute("userService");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegistrationBean formBean = fillFormBean(request);
        Map<String, String> errors = validate(formBean);

        if (errors.size() > 0) {
            formBean.setPassword("");
            request.setAttribute("bean", formBean);
            request.setAttribute("errors", errors);
            request.getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
            return;
        }

        userService.add(transformToDomain(formBean));
        CartUtils.redirect(request, response, "/login?reg_success=1");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegistrationBean formBean = new RegistrationBean();
        request.setAttribute("regBean", formBean);
        request.setAttribute("errors", new HashMap<String, String>());
        request.getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
    }

    private Map<String, String> validate(RegistrationBean bean) {
        Map<String, String> errors = new HashMap<>();
        validateString(bean.getLogin(), "\\w{3,16}", LOGIN, errors);
        validateString(bean.getPassword(), "\\w{8,16}", PASSWORD, errors);
        return errors;
    }

    private boolean validateString(String data, String pattern, String key, Map<String, String> map) {
        if (data == null || data.equals("")) {
            if (key.equals(LOGIN)) {
                map.put(key, "Login is empty");
            } else if (key.equals(PASSWORD)) {
                map.put(key, "Password is empty");
            }
            return false;
        }

        if (! data.matches(pattern)) {
            if (key.equals(LOGIN)) {
                map.put(key, "Login has invalid value");
            } else if (key.equals(PASSWORD)) {
                map.put(key, "Password has invalid value");
            }
            return false;
        }
        return true;
    }

    private RegistrationBean fillFormBean(HttpServletRequest request) {
        RegistrationBean bean = new RegistrationBean();
        bean.setLogin(request.getParameter(LOGIN));
        bean.setPassword(request.getParameter(PASSWORD));
        bean.setAdvertising(request.getParameter(PARAM_ADVERT) != null && !request.getParameter(PARAM_ADVERT).trim().equals(""));
        return bean;
    }

    private User transformToDomain(RegistrationBean bean) {
        User user = new User();
        user.setLogin(bean.getLogin());
        user.setPass(bean.getPassword());
        user.setAdvertising(bean.isAdvertising());
        return user;
    }
}
