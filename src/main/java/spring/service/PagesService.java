package spring.service;

import spring.model.Pages;

import java.util.List;

/**
 * Created by pan on 16/8/26.
 */
public interface PagesService {
    Pages findPagesById(int id);
    void savePages(Pages pages);
    List<Pages> findPagesByKeywords(String keywords);
    void updatePages(Pages pages);
    void deletePagesById(int id);
    void deleteAllPages();
    List<Pages> findAllPages();
}
