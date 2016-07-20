import bean.Url;
import dao.UrlImplement;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import util.Native2AsciiUtil;

import java.io.*;
import java.net.URL;


/**
 * Created by PC on 2016/7/4.
 */
public class test {
    public static void main(String[] args){
//        ApplicationContext context =
//                new ClassPathXmlApplicationContext("Beans.xml");
//        UrlImplement urlImplement = (UrlImplement) context.getBean("urlImplement");

        String keyword = "刘亦菲";
        Url url = new Url();
        url.setName("http://s.weibo.com/weibo/"+keyword);
        try {
//            Document doc = Jsoup.parse(new URL(url.getName()).openStream(), "UTF-8", url.getName());
            Document doc = Jsoup.connect("http://s.weibo.com/weibo/刘亦菲").get();
            File file = new File("D:\\Java\\workspace\\PublicOptionMonitor\\src\\doc.html");
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
            bufferedWriter.write(Native2AsciiUtil.ascii2Native(doc.toString()));
            bufferedWriter.close();
//            String doc_ascii = Native2AsciiUtil.ascii2Native(doc.html());
            // 得到search_feed

            Element search_feed = doc.select("div#pl_weibo_direct").first();
            Elements x = doc.select("body > *");
            System.out.print(search_feed);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void print(String s) {
        System.out.println(s);
    }
}
