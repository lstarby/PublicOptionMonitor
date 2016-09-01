package spring.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mapper.PagesMapper;
import spring.model.Pages;
import sun.jvm.hotspot.debugger.Page;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by pan on 16/8/26.
 */
@Service("PagesService")
@Transactional
public class PagesServiceImpl implements PagesService {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds){
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public Pages findPagesById(int id) {
        String sql = "select * from pages where id = ?";
        Pages pages = jdbcTemplate.queryForObject(sql, new Object[]{"id"}, new PagesMapper());
        return pages;
    }

    public void savePages(Pages pages) {
        String link = pages.getLink();
        String content = pages.getContent();
        String author = pages.getAuthor();
        String date = pages.getDate();
        String keywords = pages.getKeywords();
        String title = pages.getTitle();
        String sql = "insert into pages (link, content, author, date, keywords, title) values(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, link, content, author, date, keywords, title);
    }

    public List<Pages> findPagesByKeywords(String keywords) {
        String sql = "select * from pages where keywords = ?";
        List<Pages> pagesList = jdbcTemplate.query(sql, new PagesMapper());
        return pagesList;
    }

    public void updatePages(Pages pages) {

    }

    public void deletePagesById(int id) {

    }

    public void deleteAllPages() {

    }

    public List<Pages> findAllPages() {
        String sql = "select * from pages";
        List<Pages> pagesList = jdbcTemplate.query(sql, new PagesMapper());
        return pagesList;
    }
}
