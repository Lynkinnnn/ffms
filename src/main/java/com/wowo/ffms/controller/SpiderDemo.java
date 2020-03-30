package com.wowo.ffms.controller;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/spiderDemo")
public class SpiderDemo {

    public static String getHtmlInfoFromUrl(String url, String encoding) {
        StringBuffer sb = new StringBuffer();
        InputStreamReader isr = null;
        try{
            URL urlObj = new  URL(url);
            URLConnection uc = urlObj.openConnection();
            //设置User-Agent来欺骗服务器
            uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
//            uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0;WindowsNT 5.0)");
//            uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true
            isr = new InputStreamReader(uc.getInputStream(), encoding);
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                isr.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        String str = sb.toString();
        //System.out.println(str);
        return str;

    }

    /**
     * @param url  网址
     * @param encoding 解码方式
     */
    @RequestMapping("/getHospitalInfo")
    public String getHospitalInfo(String url, String encoding, Model model) {
        String html = getHtmlInfoFromUrl(url, encoding);
        org.jsoup.nodes.Document document = Jsoup.parse(html);
        Elements elementList = document.getElementsByTag("img");
        List<HashMap<String, String>> maps =  new ArrayList<HashMap<String, String>>();
        for(org.jsoup.nodes.Element element: elementList){
            String img = element.attr("src");
            //String img = element.getElementsByAttributeValue("rel", "nofollow").attr("src");
            String title = element.attr("alt");
            //String title = element.getElementsByAttributeValue("rel", "nofollow").attr("alt");
            if(img != "" || title != "") {//筛选li标签
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("img", img);
                map.put("title", title);
                maps.add(map);
            }
        }
        model.addAttribute("maps", maps);
        return "spider/spiderResult";
    }


    /**
     * @param url  网址
     * @param encoding 解码方式
     */
    @RequestMapping("/getIdCardInfo")
    @ResponseBody
    public List<String> getIdCardInfo(String url, String encoding, Model model) {
        String html = getHtmlInfoFromUrl(url, encoding);
        org.jsoup.nodes.Document document = Jsoup.parse(html);
        Elements elementList = document.getElementsByTag("td");
        List<String> idCardInfos =  new ArrayList<>();
        for(org.jsoup.nodes.Element element: elementList){
            String value = element.getElementsByAttributeValue("style", "vertical-align: middle;").text();
            //String title = element.getElementsByAttributeValue("rel", "nofollow").attr("alt");
            if(StringUtils.isNotBlank(value)) {//筛选td标签
                idCardInfos.add(value);
            }
        }
        return idCardInfos;
    }



    @RequestMapping("/spiderDemo")
    public String spiderDemo() {
        return "spider/spiderDemo";
    }

}
