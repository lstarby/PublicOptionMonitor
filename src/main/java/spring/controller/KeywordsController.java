package spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.Keywords;
import spring.model.Pages;
import spring.service.KeywordsServiceImpl;
import spring.service.PagesServiceImpl;
import spring.util.JsoupUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pan on 16/8/23.
 */
@Controller
@RequestMapping("/")
public class KeywordsController {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    KeywordsServiceImpl keywordsService = (KeywordsServiceImpl) context.getBean("keywordsServiceImpl");
    PagesServiceImpl pagesService = (PagesServiceImpl) context.getBean("pagesServiceImpl");

    @GetMapping("/newkeywords")
    public String newKeywords(ModelMap map) {
        Keywords keywords = new Keywords();
        map.addAttribute("keywords", keywords);
        return "newkeywords";
    }

    @PostMapping("/newkeywords")
    public String saveKeywords(Keywords keywords, ModelMap map) {
        keywordsService.saveKeywords(keywords);
        List<Pages> pages = new ArrayList<Pages>();
        JsoupUtil jsoupUtil = new JsoupUtil();
        try {
            pages = jsoupUtil.getPages(keywords.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Pages page : pages) {
            pagesService.savePages(page);
        }
        List<Keywords> keywordsList = keywordsService.findAllKeywords();
        map.addAttribute("keywordsList", keywordsList);
        return "showkeywordslist";
    }
}
