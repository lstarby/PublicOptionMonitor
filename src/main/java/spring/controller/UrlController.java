package spring.controller;

import spring.service.UrlService;
import spring.model.Url;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by DYY on 2016/8/10.
 */
@RestController
public class UrlController {

    @Autowired
    public UrlService urlService;

    @GetMapping("/urls")
    public List<Url> getUrls() {
        return urlService.allUrl();
    }

    @GetMapping("/urls/{id}")
    public ResponseEntity getUrl(@PathVariable("id") int id) {
        Url url = urlService.getUrl(id);
        if (url == null) {
            return new ResponseEntity("no such url" + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(url, HttpStatus.OK);
    }

    @DeleteMapping("/urls/{id}")
    public ResponseEntity delUrl(@PathVariable int id) {
        return new ResponseEntity(id, HttpStatus.OK);
    }
}
