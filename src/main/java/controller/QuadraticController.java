package controller;

import dao.CoefficientDao;
import dao.RootDao;
import model.Coefficient;
import model.Root;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuadraticController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index() {
        return new ModelAndView("index", "command", new Coefficient());
    }

    @RequestMapping(value = "/addCof", method = RequestMethod.POST)
    public String viewData(@ModelAttribute("dispatcher") Coefficient coefficient, Root root, ModelMap model) {
        model.addAttribute("a", coefficient.getA());
        model.addAttribute("b", coefficient.getB());
        model.addAttribute("c", coefficient.getC());
        saveCoefficientToDb(coefficient);

        Double d = (coefficient.getB() * coefficient.getB()) - (4 * coefficient.getA() * coefficient.getC());

        if (d == 0) {
            Double x = coefficient.getB() * (-1) / (2 * coefficient.getA());
            root.setX1(x);
            root.setX2(x);
            saveRootToDb(root);
            model.addAttribute("x1", x);
            return "resultX";
        }

        if (d > 0) {
            Double x1 = (coefficient.getB() * (-1) + Math.sqrt(d)) / (2 * coefficient.getA());
            Double x2 = (coefficient.getB() * (-1) - Math.sqrt(d)) / (2 * coefficient.getA());
            root.setX1(x1);
            root.setX2(x2);
            saveRootToDb(root);
            model.addAttribute("x1", x1);
            model.addAttribute("x2", x2);
            return "resultX1X2";
        } else {
            return "withoutResult";
        }
    }

    private void saveCoefficientToDb(Coefficient coefficient) {
        CoefficientDao coefficientDao = new CoefficientDao();
        coefficientDao.createCoefficient(coefficient);
    }

    private void saveRootToDb(Root root) {
        RootDao rootDao = new RootDao();
        rootDao.createRoot(root);
    }
}
