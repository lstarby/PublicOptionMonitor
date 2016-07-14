package dao;

import bean.Url;
import Mapper.UrlMapper;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;
import java.util.List;

/**
 * Created by PC on 2016/7/14.
 */
public class UrlImplement implements UrlDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void create(Url url) {
        String name = url.getName();
        String content = url.getContent();
        String sql = "insert into Url (name, content) values (?, ?)";
        jdbcTemplate.update(sql, name, content);
        System.out.println("Create record name = " + name);
    }

    public Url getUrl(Integer id) {
        String sql = "select * from Url where id = ?";
        Url url = jdbcTemplate.queryForObject(sql, new Object[]{id}, new UrlMapper());
        return url;
    }

    public void delete(Integer id) {
        String sql = "delete from Url where id = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("Delete record with id = " + id);
        return;
    }

    public void update(Url url) {
        Integer id = url.getId();
        String name = url.getName();
        String content = url.getContent();
        String sql = "update Url set name = ?, content = ? where id = ?";
        System.out.println("update record with id = " + id);
        jdbcTemplate.update(sql, name, content, id);
    }

    public List<Url> allUrl() {
        String sql = "select * from Url";
        List<Url> urls = jdbcTemplate.query(sql, new UrlMapper());
        return urls;
    }
}
