package spring.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.mapper.KeywordsMapper;
import spring.model.Keywords;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by pan on 16/8/23.
 */
@Service("keywordService")
@Transactional
public class KeywordsServiceImpl implements KeywordsService {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.dataSource = ds;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Keywords findById(int id) {
        String sql = "select * from keywords where id = ?";
        Keywords keywords = jdbcTemplate.queryForObject(sql, new Object[]{"id"}, new KeywordsMapper());
        return keywords;
    }

    public void saveKeywords(Keywords keywords) {
        String content = keywords.getContent();
        String sql = "insert into keywords (content) VALUES (?)";
        jdbcTemplate.update(sql, content);
    }

    public void updateKeywords(Keywords keywords) {
        int id = keywords.getId();
        String content = keywords.getContent();
        String sql = "update keywords set content = ? where id = ?";
        jdbcTemplate.update(sql, content, id);
    }

    public void deleteById(int id) {
        String sql = "delete from keywords where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public List<Keywords> findAllKeywords() {
        String sql = "select * from keyword";
        List<Keywords> keywordsList = jdbcTemplate.query(sql, new KeywordsMapper());
        return keywordsList;
    }
    public void deleteAllKeywords(){
        String sql = "delete * from keywords";
        jdbcTemplate.update(sql);
    }
}
