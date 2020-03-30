//package com.wowo.ffms.utils;
//
//import com.jacob.activeX.ActiveXComponent;
//import com.jacob.com.Dispatch;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.sql.Blob;
//
///**
// * 版权：(C) 版权所有 2000-2019 上海天好电子商务股份有限公司苏州分公司
// * <简述>
// * <详细描述>
// *
// * @author lingjian
// * @version $
// * @see
// * @since
// */
//public class Word2PDF {
//    /**
//     * doc转pdf在线浏览
//     *
//     */
//    public final DataMap queryApplicantDOC2PDF(final DataMap para) throws Exception {
//
//        String sbrid = para.getString("sbrid");
//
//        StringBuffer sqlBF = new StringBuffer();
//
//        sqlBF.setLength(0);
//        sqlBF.append(" select sbrdoc, upper(zjhm) zjhm ");
//        sqlBF.append("   from vt.applicant ");
//        sqlBF.append("  where sbrid = ? ");
//
//        this.sql.setSql(sqlBF.toString());
//        sql.setString(1, sbrid);
//        DataSet dsApplicant = sql.executeQuery();
//
//        if (dsApplicant.size() <= 0) {
//            return null;
//        }
//        String zjhm = dsApplicant.getString(0, "zjhm");
//        String filePath = "temp" + File.separator + GlobalVars.APP_ID;
//        String path = filePath + File.separator + zjhm;
//        File docFile = new File(path + File.separator + zjhm + ".doc");
//        File docPdfFile = new File(path + File.separator + zjhm + "doc.pdf");
//
//        //减少数据库负担，直接存在服务器上缓存了
//        if (!docPdfFile.exists()) {
//            Blob sbrpdf = dsApplicant.getBlob(0, "sbrdoc");
//            int len = (new BigDecimal(sbrpdf.length())).intValue();
//            byte[] byteDoc = sbrpdf.getBytes(1, len);
//            path = path + File.separator;
//            File dir = new File(path);
//            if (!dir.exists()) {
//                if (!dir.mkdirs()) {
//                    throw new Exception("创建目录失败!");
//                }
//            }
//            FileIOUtil.writeBytesToFile(byteDoc, docFile);
//        }
//        try {
//            app = new ActiveXComponent("Word.Application");
//            Dispatch documents = app.getProperty("Documents").toDispatch();
//            Dispatch document = Dispatch.call(documents, "Open", wordFile, false,
//                    true).toDispatch();
//            // 判断文件存在
//            File target = new File(docPdfFile);
//            if (!docPdfFile.exists()) {
//                Dispatch.call(document, "SaveAs", pdfFile, 17);
//                Dispatch.call(document, "Close", false);
//            }
//        }catch(Exception e) {
//            System.out.println("转换失败"+e.getMessage());
//        }finally {
//            // 关闭office
//            app.invoke("Quit", 0);
//        }
//
//        String filePath = Path + File.separator + zjhm + "doc.pdf"
//        String fileName = zjhm + "doc.pdf"
//        FileInputStream inputstream = null;
//        HttpServletResponse response = null;
//        try {
//            inputstream = new FileInputStream(filePath);
//            FileIOUtil.writeStreamToResponse(inputstream, fileName, response);
//        } catch (IOException e) {
//            throw new Exception("文件读取异常：" + e.getMessage());
//        } finally {
//            try {
//                if (inputstream != null) {
//                    inputstream.close();
//                }
//            } catch (Exception e) {
//                throw new Exception("文件损坏或不存在："
//                        + e.getMessage());
//            }
//        }
//        return null;
//    }
//
//}
