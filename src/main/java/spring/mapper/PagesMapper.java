package spring.mapper;

import org.springframework.jdbc.core.RowMapper;
import spring.model.Pages;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pan on 16/8/26.
 */
public class PagesMapper implements RowMapper<Pages> {
    public Pages mapRow(ResultSet resultSet, int i) throws SQLException {
        Pages pages = new Pages();
        pages.setId(resultSet.getInt("id"));
        pages.setTitle(resultSet.getString("title"));
        pages.setLink(resultSet.getString("link"));
        pages.setKeywords(resultSet.getString("keywords"));
        pages.setAuthor(resultSet.getString("author"));
        pages.setDate(resultSet.getString("date"));
        pages.setContent(resultSet.getString("content"));
        return pages;
    }
}
