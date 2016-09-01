package test;

import spring.model.Pages;
import spring.util.JsoupUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by pan on 16/8/25.
 */
public class JsoupUtilTest {
    public static void main(String[] args) throws IOException {
        JsoupUtil jsoupUtil = new JsoupUtil();
        List<Pages> pages = jsoupUtil.getPages("重庆大学");
        System.out.print(pages.size());
    }
}
