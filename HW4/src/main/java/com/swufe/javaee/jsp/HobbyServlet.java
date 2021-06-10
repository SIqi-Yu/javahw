package com.swufe.javaee.jsp;

import javafx.scene.shape.Path;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet(urlPatterns = "/hobbyFind")
public class HobbyServlet extends HttpServlet {
    private final Map<String, String> userHobby=new HashMap<>();
    @Override
    public void init() {

        URL url=getClass().getClassLoader().getResource("/hobby.txt");
        try(Stream<String>lines=Files.lines(Paths.get(url.toURI()))){
            lines.forEach(line->{
                String[] matchHobby=line.split(" ");
                userHobby.put(matchHobby[0],matchHobby[1]);
            });
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String hobby = request.getParameter("hobby");
       List<String> names = new ArrayList<>();
       userHobby.forEach((k, v) -> {
           if (v.equals(hobby)){
               names.add(k);
           }
       });
       request.setAttribute("names", names);
       request.setAttribute("hobby", hobby);
       // Two JSPs have different UI styles.
       //  request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
       request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
    }

}
