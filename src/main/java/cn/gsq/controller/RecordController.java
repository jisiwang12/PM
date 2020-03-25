package cn.gsq.controller;

import cn.gsq.service.impl.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/record")
public class RecordController {
    @Autowired
    RecordService recordService;

    @RequestMapping("/save")
    public void save(HttpServletRequest request, HttpServletResponse response) {
        String ip = request.getRemoteAddr();
        recordService.save(ip);
        try {
            request.getRequestDispatcher("/content/findAll").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
