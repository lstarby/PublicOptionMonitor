package spring.service;

import spring.model.Url;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by PC on 2016/7/14.
 */

public interface UrlService {
    public void setDataSource(DataSource ds);
    public void create(Url url);
    public void deleteAll();
    public Url getUrl(Integer id);
    public void delete(Integer id);
    public void update(Url url);
    public List<Url> allUrl();
}
