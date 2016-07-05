import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import util.Native2AsciiUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;


/**
 * Created by PC on 2016/7/4.
 */
public class test {
    public static void main(String[] args){
        String keyword = "刘亦菲";
        String url = "http://s.weibo.com/weibo/"+keyword;
        try {
            Document doc = Jsoup.parse(new URL(url).openStream(), "UTF-8", url);
            String doc_ascii = Native2AsciiUtil.ascii2Native(doc.html());
            Elements links = doc.select("a[href]");
            try {
                File file = new File("D:\\Java\\workspace\\PublicOptionMonitor\\src\\doc.html");
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(doc_ascii);
                fileWriter.close(); // 关闭数据流
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void print(String s) {
        System.out.println(s);
    }
}
