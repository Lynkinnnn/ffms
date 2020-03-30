package com.wowo.ffms.controller;

import com.wowo.ffms.utils.WordToPDF;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

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
@SuppressWarnings("all")
@Controller
public class WordToPDFController {

    @ResponseBody
    @RequestMapping("/wordToPDF")
    public String wordToPDF(HttpServletResponse res , @RequestParam("filePath") String filePath) throws Exception {
        InputStream in = null;
        OutputStream out = null;
        String name = "test".concat(".pdf");
        String pdfPath = "C:/Users/Administrator/Desktop/" + name;

        WordToPDF.wToPdfChange(filePath, pdfPath);
//        try{
//            if(pdfPath != null){
//                in = new FileInputStream(filePath);
//            }
//            res.setContentType("application/pdf");
//            out = res.getOutputStream();
//            byte[] b = new byte[1024];
//            int len = 0;
//            while((len = in.read(b)) != -1){
//                out.write(b);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            if(in != null){
//                in.close();
//            }
//            if(out != null){
//                out.close();
//            }
//        }
        return pdfPath;
    }
}
