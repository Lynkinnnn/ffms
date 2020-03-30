package com.wowo.ffms.controller;


import com.wowo.ffms.utils.FileUtil;
import com.wowo.ffms.utils.Office2PDF;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by lenovo12 on 2018/8/18.
 */
@ComponentScan
@Controller
@RequestMapping("/test")
public class ReadAndDownLoad {
    //base路径
    private final String BASE_PATH = Office2PDF.getLocation();

    /**
     *
     * @return choose页面
     */
    @RequestMapping("/choose")
    public String chooseFile(){
        return "ShowChoose";
    }

    /**
     *
     * @param res 响应对象
     * @param fileName 请求预览文件名
     * @throws Exception
     */
    @RequestMapping("/read/{fileName:.+}")
    public void readFile(HttpServletResponse res , @PathVariable String fileName) throws Exception{
        InputStream in = null;
        OutputStream out = null;
        String filePath =  fileHandler(fileName);
        //判断是pdf还是word还是excel
        //若是pdf直接读 否则转pdf 再读  //
       try{
           if(filePath != null){
               in = new FileInputStream(filePath);
           }
           res.setContentType("application/pdf");
           out = res.getOutputStream();
           byte[] b = new byte[1024];
           int len = 0;
           while((len = in.read(b)) != -1){
               out.write(b);
           }
       }catch (Exception e){
           e.printStackTrace();
       }finally {
           if(in != null){
               in.close();
           }
           if(out != null){
               out.close();
           }
       }
    }

    /**
     * 文件处理
     * @param fileName
     * @return
     */
    private String fileHandler(String fileName){
        String fileSuffix = FileUtil.getFileSuffix(fileName);
        if("pdf".equals(fileSuffix))
        {
            return BASE_PATH + fileName;
        }
        else
        {
            return Office2PDF.openOfficeToPDF(BASE_PATH + fileName).getAbsolutePath();
        }
    }
}
