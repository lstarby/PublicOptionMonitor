package spring.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import spring.model.Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pan on 16/8/24.
 */
public class JsoupUtil {
    public List<Pages> getPages(String keywords) throws IOException {
        List<Pages> pagesList = new ArrayList<Pages>();
        int pageNum = 0;
        String htmlTitle;
        while (true) {
            String url = "http://news.baidu.com/ns?word=title%3A%28" + keywords + "%29&pn=" + pageNum * 20 + "&cl=2&ct=0&tn=newstitle&rn=20&ie=utf-8&bt=0&et=0";
            Document doc = Jsoup.connect(url)
                    .data("query", "Java")
                    .userAgent("Mozilla")
                    .cookie("auth", "token")
                    .timeout(3000)
                    .get();
            htmlTitle = doc.title();
            if (htmlTitle.contains("页面不存在")) {
                break;
            }
            // TODO: 16/8/25  解析class
            //获取标题和链接
            Elements titleElements = doc.getElementsByClass("c-title");
            Elements authorElements = doc.getElementsByClass("c-title-author");
            for (int i = 0; i < titleElements.size(); i++) {
                Pages page = new Pages();
                Element titleEle = titleElements.get(i).getElementsByTag("a").first();
                //获取标题
                String title = titleEle.getElementsByAttribute("href").text();
                page.setTitle(title);
                //获取链接
                String link = titleEle.attr("href");
                //获取content
                Document contentDoc = Jsoup.connect(link)
                        .data("query", "Java")
                        .userAgent("Mozilla")
                        .cookie("auth", "token")
                        .timeout(3000)
                        .get();
                String content = contentDoc.body().toString();
                // 获取日期和来源
                Element authorEle = authorElements.get(i);
                String[] authorAndDate = authorEle.text().replaceAll("\u00A0", " ").split("\\s+");
                String author = authorAndDate[0];
                String date = authorAndDate[1];
                page.setTitle(title);
                page.setAuthor(author);
                page.setDate(date);
                page.setContent(content);
                page.setKeywords(keywords);
                page.setLink(link);
                pagesList.add(page);
            }
            pageNum++;
            System.out.print(pageNum);
        }
        return pagesList;
    }
}
