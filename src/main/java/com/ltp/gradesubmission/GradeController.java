package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {
    List<GradeModel> studentGrades = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String name) {
        GradeModel garde;

        if (getGradeIndex(name) == -1000) {
            garde = new GradeModel();

        } else {
            garde = studentGrades.get(getGradeIndex(name));
        }
        model.addAttribute("grade", garde);
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitGrade(GradeModel grade) {
        if (getGradeIndex(grade.getName()) == -1000) {
            studentGrades.add(grade);
        } else {
            studentGrades.set(getGradeIndex(grade.getName()), grade);
        }

        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    public Integer getGradeIndex(String name) {

        for (int i = 0; i < studentGrades.size(); i++) {
            if (studentGrades.get(i).getName().equals(name))
                return i;
        }
        return -1000;

    }

}
