package spring.service;

import spring.model.Keywords;

import java.util.List;

/**
 * Created by pan on 16/8/23.
 */
public interface KeywordsService {
    Keywords findById(int id);
    void saveKeywords(Keywords keywords);
    void updateKeywords(Keywords keywords);
    void deleteById(int id);
    List<Keywords> findAllKeywords();
    void deleteAllKeywords();
}
