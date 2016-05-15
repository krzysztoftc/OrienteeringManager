package pl.edu.controller.admin.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import pl.edu.model.competitor.Competitor;
import pl.edu.repository.competitor.Competitors;
import pl.edu.service.competitor.ICompetitorService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bartosz on 23.04.16.
 */
@Controller("adminHomeController")
public class AdminHomeController {

    int number = 0;

    @Autowired
    private ICompetitorService competitorService;

    @RequestMapping(value = {"/admin", "/admin/"})
    public String home(ModelMap model, HttpServletRequest request, HttpServletResponse response,
                       ServletContext servletContext, TemplateEngine templateEngine){
        number++;
        model.addAttribute("n", number);
        process(request, response, servletContext, templateEngine);
        return "admin/index";
    }

    public void process(
            HttpServletRequest request, HttpServletResponse response,
            ServletContext servletContext, TemplateEngine templateEngine) {

        List<Competitor> allCompetitors = new ArrayList<Competitor>();
        for(int i = 0; i < number; ++i)
        {
            Competitor c = new Competitor();
            c.setName("Imie " + i % 4);
            c.setSurname("Ładne " + i % 7 + " nazwisko");
            c.setGender( (i % 2 == 0) ? 'M' : 'K');
            c.setBirthYear( new Long(i + 1990) );
            allCompetitors.add(c);
        }
//        List<Competitor> competitors = competitorService.list(Competitors.findAll());
//
//        allCompetitors.addAll(competitors);

        WebContext ctx = new WebContext(request, response, servletContext);
        ctx.setVariable("competitors", allCompetitors);

        try
        {
            templateEngine.process("admin/index", ctx, response.getWriter());
        }
        catch ( Exception e ) {

        }
    }
}
