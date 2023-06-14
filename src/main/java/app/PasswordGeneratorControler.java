package app;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

@WebServlet("/PasswordGeneratorControler")
public class PasswordGeneratorControler extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //creating attribute to display in index.jsp
        String password = createPassword(request);
        PasswordGeneratorResult passwordGeneratorResult = new PasswordGeneratorResult(password);
        request.setAttribute ("password",passwordGeneratorResult);
        request.getRequestDispatcher("index.jsp").forward(request ,response);
    }
    //creating password to index.jps
    private static String createPassword(HttpServletRequest request) {
        String[] checkboxs = getCheckboxs(request);
        int passwordLenght = getPasswordLenght(request);
        ArrayList<String> collect = (ArrayList<String>) Arrays.stream(checkboxs).collect(Collectors.toList());
        return PasswordGenerator.createPassword(passwordLenght, collect);
    }
    //validate input chexboxes
    private static String[] getCheckboxs(HttpServletRequest request) {
        if (request.getParameterValues("checkboxs") == null){
            String[] tab = new String[1];
            tab[0] = "lowercase";
            return tab;
        }
        return request.getParameterValues("checkboxs");
    }
    //validate input Number
    private static int getPasswordLenght(HttpServletRequest request) {
        if (request.getParameter("passwordLenght").isEmpty()){
            return 4;
        }
        return Integer.parseInt(request.getParameter("passwordLenght"));
    }

}
