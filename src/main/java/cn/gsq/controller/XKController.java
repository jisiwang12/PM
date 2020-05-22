package cn.gsq.controller;

import cn.gsq.domain.Course;
import cn.gsq.domain.Student;
import cn.gsq.domain.XK;
import cn.gsq.service.impl.CourseServiceImpl;
import cn.gsq.service.impl.StudentServiceImpl;
import cn.gsq.service.impl.XKServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/xk")
public class XKController {

    @Autowired
    CourseServiceImpl courseService;
    @Autowired
    StudentServiceImpl studentService;
    @Autowired
    XKServiceImpl xkService;

    @RequestMapping("/findByCoid")
    public ModelAndView findByCoid(String id) {
        ModelAndView mv = new ModelAndView();
        Course course = courseService.findById(id);
        ArrayList<Student> noXK = new ArrayList<>();
        List<Student> studentListAll = studentService.findAll();
        List<XK> xkList = xkService.findByCoid(id);
        if (xkList == null || xkList.size() == 0) {
            for (Student student : studentListAll) {
                noXK.add(student);
                mv.addObject("noXK", noXK);
            }
        } else {
            for (XK xk : xkList) {
                for (int i=0;i<studentListAll.size();i++) {
                    if (xk.getXsno().equals(studentListAll.get(i).getsNo())) {

                        studentListAll.remove(i);

                    }
                }
            }
            mv.addObject("noXK", studentListAll);
        }
        mv.setViewName("xk-list");
        mv.addObject("course", course);

        return mv;
    }

    /**
     * 保存
     * @param snos
     * @param xcoid
     * @return
     */
    @RequestMapping("/save")
    public String save(String[] snos, String xcoid) {
        XK xk = new XK();
        if (snos != null && snos.length != 0) {
            for (String sno : snos) {
                xk.setXsno(sno);
                xk.setXcoid(xcoid);
                xkService.save(xk);
            }
        }
        return "redirect:/course/findAll";
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/del")
    public String del(String[] ids) {
        if (ids != null && ids.length != 0) {
            for (String id : ids) {
                xkService.del(id);
            }
        }
        return "redirect:/course/findAll";

    }


    @RequestMapping("/findXK")
    public ModelAndView findXK(String coid) {
        ModelAndView mv = new ModelAndView();
        List<XK> byCoid = xkService.findByCoid(coid);
        Course byId = courseService.findById(coid);
        mv.addObject("xkList", byCoid);
        mv.addObject("course", byId);
        mv.setViewName("xk-list-yxk");
        return mv;
    }


}
