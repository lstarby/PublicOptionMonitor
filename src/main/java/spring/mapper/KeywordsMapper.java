package spring.mapper;

import org.springframework.jdbc.core.RowMapper;
import spring.model.Keywords;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by pan on 16/8/23.
 */
public class KeywordsMapper implements RowMapper<Keywords> {
    public Keywords mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Keywords keywords = new Keywords();
        keywords.setId(resultSet.getInt("id"));
        keywords.setContent(resultSet.getString("content"));
        keywords.setTitle(resultSet.getString("title"));
        return keywords;
    }

}
