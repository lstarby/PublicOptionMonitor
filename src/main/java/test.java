import bean.Url;
import dao.UrlImplement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.Native2AsciiUtil;

import java.io.IOException;
import java.net.URL;


/**
 * Created by PC on 2016/7/4.
 */
public class test {
    public static void main(String[] args){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("Beans.xml");
        UrlImplement urlImplement = (UrlImplement) context.getBean("urlImplement");

        String keyword = "刘亦菲";
        Url url = new Url();
        url.setName("http://s.weibo.com/weibo/"+keyword);
        try {
            Document doc = Jsoup.parse(new URL(url.getName()).openStream(), "UTF-8", url.getName());
            String doc_ascii = Native2AsciiUtil.ascii2Native(doc.html());
            url.setContent(doc_ascii);
            urlImplement.create(url);
            urlImplement.delete(7);
            Elements links = doc.select("a[href]");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void print(String s) {
        System.out.println(s);
    }
}
