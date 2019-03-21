package com.litbo.hospitalzj.hospital.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileDownLoad1 {
    /*  *//**
     * 获取文件下载数据
     * @return
     * @author geYang
     * @date 2018-06-13 10:20
     * *//*
    private static byte[] getDownloadByte(String fileUrl) {
        try {
            String uploadPath = getUploadPathAll(fileUrl);
            InputStream inputStream = new FileInputStream(new File(uploadPath));
            byte[] data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            throw new SysException("文件下载异常");
        }
    }
*/

    /**
     * @param request
     * @param response
     * @param downloadFile 下载文件完整路径
     * @param fileName 下载文件名（带文件后缀）
     */
    public static void downloadFile(HttpServletRequest request, HttpServletResponse response, String downloadFile, String fileName) {

        BufferedInputStream bis = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedOutputStream bos = null;
        try {
            File file=new File(downloadFile); //:文件的声明
            is = new FileInputStream(file);  //:文件流的声明
            os = response.getOutputStream(); // 重点突出
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(os);

            if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
                fileName = new String(fileName.getBytes("GB2312"),"ISO-8859-1");
            } else {
                // 对文件名进行编码处理中文问题
                fileName = java.net.URLEncoder.encode(fileName, "UTF-8");// 处理中文文件名的问题
                fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
            }

            response.reset(); // 重点突出
            response.setCharacterEncoding("UTF-8"); // 重点突出
            response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型 // 重点突出
            // inline在浏览器中直接显示，不提示用户下载
            // attachment弹出对话框，提示用户进行下载保存本地
            // 默认为inline方式
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            //  response.setHeader("Content-Disposition", "attachment; filename="+fileName); // 重点突出
            int bytesRead = 0;
            byte[] buffer = new byte[4096];// 4k或者8k
            while ((bytesRead = bis.read(buffer)) != -1){ //重点
                bos.write(buffer, 0, bytesRead);// 将文件发送到客户端
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            // 特别重要
            // 1. 进行关闭是为了释放资源
            // 2. 进行关闭会自动执行flush方法清空缓冲区内容
            try {
                if (null != bis) {
                    bis.close();
                    bis = null;
                }
                if (null != bos) {
                    bos.close();
                    bos = null;
                }
                if (null != is) {
                    is.close();
                    is = null;
                }
                if (null != os) {
                    os.close();
                    os = null;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

