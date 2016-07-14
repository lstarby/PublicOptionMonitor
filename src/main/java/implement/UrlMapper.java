package implement;

import bean.Url;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by PC on 2016/7/14.
 */
public class UrlMapper implements RowMapper<Url> {
    public Url mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Url url = new Url();
        url.setId(resultSet.getInt("id"));
        url.setContent(resultSet.getString("content"));
        url.setName(resultSet.getString("name"));
        return url;
    }

}
