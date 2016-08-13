package spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.Url;
import spring.service.UrlServiceImpl;

import java.util.List;

/**
 * Created by DYY on 2016/8/10.
 */
@RestController
public class UrlController {

    ApplicationContext context =
            new ClassPathXmlApplicationContext("Beans.xml");
    UrlServiceImpl urlServiceImpl = (UrlServiceImpl) context.getBean("urlServiceImpl");
    @GetMapping("/urls")
    public List<Url> getUrls() {
        return urlServiceImpl.allUrl();
    }

    @GetMapping("/urls/{id}")
    public ResponseEntity getUrl(@PathVariable("id") int id) {
        Url url = urlServiceImpl.getUrl(id);
        if (url == null) {
            return new ResponseEntity("no such url" + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(url, HttpStatus.OK);
    }
    @PostMapping("/urls")
    public ResponseEntity addUrl(@RequestBody Url url){
        urlServiceImpl.create(url);
        return new ResponseEntity(url, HttpStatus.OK);
    }
    @DeleteMapping("/urls/{id}")
    public ResponseEntity delUrl(@PathVariable int id) {
        urlServiceImpl.delete(id);
        return new ResponseEntity(id, HttpStatus.OK);
    }
}
