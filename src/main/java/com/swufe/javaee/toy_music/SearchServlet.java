package com.swufe.javaee.toy_music;


import com.swufe.javaee.toy_music.Utils.SongUtils;
import com.swufe.javaee.toy_music.model.Song;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/searchSong")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String search = request.getParameter("search").trim();
            List<Song> songs = SongUtils.loadSongs();
        PrintWriter write=response.getWriter();
            if (search.length()==0){
                request.setAttribute("songs", songs);
                request.getRequestDispatcher("showAll.jsp").forward(request,response);
            }
                else {
                List<Song> results = songs.stream().filter(s -> s.getTitle().equals(search)).collect(Collectors.toList());
                if (results.size() == 0) {

                    request.getRequestDispatcher("wrong.jsp").forward(request, response);
                }
                else {

                    request.setAttribute("song", results.get(0));
                    request.getRequestDispatcher("searchResult.jsp").forward(request, response);
                }
            }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
