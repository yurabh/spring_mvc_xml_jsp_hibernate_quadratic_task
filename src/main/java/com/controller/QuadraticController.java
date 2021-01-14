package com.controller;

import com.domain.Coefficient;
import com.domain.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.service.CoefficientService;
import com.service.RootService;

@Controller
public class QuadraticController {

    private CoefficientService coefficientService;

    private RootService rootService;

    @Autowired
    public QuadraticController(CoefficientService coefficientService, RootService rootService) {
        this.coefficientService = coefficientService;
        this.rootService = rootService;
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index", "command", new Coefficient());
    }

    @RequestMapping(value = "/saveCoefficientAndRoot", method = RequestMethod.GET)
    public String saveCoefficientAndRoot(@ModelAttribute("dispatcher") Coefficient coefficient,
                                         Root root, ModelMap model) {
        model.addAttribute("a", coefficient.getA());
        model.addAttribute("b", coefficient.getB());
        model.addAttribute("c", coefficient.getC());

        coefficientService.create(coefficient);

        Double d = coefficientService.discriminator(coefficient);

        Root newRoot = rootService.create(root, coefficient);

        if (d == 0) {
            model.addAttribute("x1", newRoot.getX1());
            return "resultX";
        }
        if (d > 0) {
            model.addAttribute("x1", newRoot.getX1());
            model.addAttribute("x2", newRoot.getX2());
            return "resultX1X2";
        } else {
            return "withoutResult";
        }
    }
}
