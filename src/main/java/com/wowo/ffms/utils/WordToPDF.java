package com.wowo.ffms.utils;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;

import java.io.File;

/**
 * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
 * <简述>
 * <详细描述>
 *
 * @author lingjian
 * @version $
 * @see
 * @since
 */
public class WordToPDF {

    public static void wToPdfChange(String wordFile, String pdfFile) {//wordFile word 的路径  //pdfFile pdf 的路径
        ActiveXComponent app = null;
        System.out.println("开始转换...");
        // 开始时间
        // long start = System.currentTimeMillis();
        try {
            // 打开word
            app = new ActiveXComponent("Word.Application");
            // 获得word中所有打开的文档
            Dispatch documents = app.getProperty("Documents").toDispatch();
            System.out.println("打开文件: " + wordFile);
            // 打开文档
            Dispatch document = Dispatch.call(documents, "Open", wordFile, false, true).toDispatch();
            // 如果文件存在的话，不会覆盖，会直接报错，所以我们需要判断文件是否存在
            File target = new File(pdfFile);
            if (target.exists()) {
                target.delete();
            }
            System.out.println("另存为: " + pdfFile);
            Dispatch.call(document, "SaveAs", pdfFile, 17);
            // 关闭文档
            Dispatch.call(document, "Close", false);
        } catch (Exception e) {
            System.out.println("转换失败" + e.getMessage());
        } finally {
            // 关闭office
            app.invoke("Quit", 0);
        }
    }

    public static void main(String[] args) {
        String word = "C:/Users/Administrator/Desktop/test.docx";
        String name = "testt".concat(".pdf");
        String pdf = "C:/Users/Administrator/Desktop/" + name;
        wToPdfChange(word, pdf);
    }
}
