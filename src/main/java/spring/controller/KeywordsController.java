package spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spring.model.Keywords;
import spring.service.KeywordsServiceImpl;

/**
 * Created by pan on 16/8/23.
 */
@Controller
@RequestMapping("/")
public class KeywordsController {
    ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
    KeywordsServiceImpl keywordsService = (KeywordsServiceImpl) context.getBean("keywordsServiceImpl");
    @GetMapping("/newkeywords")
    public String newKeywords(ModelMap map){
        Keywords keywords = new Keywords();
        map.addAttribute("keywords", keywords);
        return "newkeywords";
    }
    @PostMapping("/newkeywords")
    public String saveKeywords(Keywords keywords, ModelMap map){
        keywordsService.saveKeywords(keywords);
        map.addAttribute("success", "keywords " + keywords.getContent() + "success");
        return "keywordssuccess";
    }
}
