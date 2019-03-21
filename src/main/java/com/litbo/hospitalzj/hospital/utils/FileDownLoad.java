package com.litbo.hospitalzj.hospital.utils;


import com.litbo.hospitalzj.supplier.controller.ex.FileDownLoadException;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileDownLoad {
    public static Integer download(String filePath, String fileName, HttpServletResponse response) {
        File file = new File(filePath);
        if (file.exists()) {
            response.setContentType("application/force-download");// 设置强制下载不打开
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
            byte[] buffer = new byte[1024 * 5];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream outputStream = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    outputStream.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return 0;
    }
    public static void downloadFile(HttpServletResponse response, String filePath)
            throws RuntimeException
    {
        File file = new File(filePath);
        if(!file.exists()){
            throw new FileDownLoadException("文件不存在");
        }
        BufferedInputStream bin = null;// 输入流缓存流
        BufferedOutputStream bout = null;// 输出流缓存流
        try
        {
            //缓存流
            bin = new BufferedInputStream(new FileInputStream(file));
            bout = new BufferedOutputStream(response.getOutputStream());
            byte[] b = new byte[1024 * 5];// 缓存数组
            int len = 0;
            while ((len = bin.read(b)) != -1)
            {
                bout.write(b, 0, len);
                bout.flush();
            }
        }
        catch (FileNotFoundException e)
        {
            //这里抛出RuntimeException,实际时抛出自定义异常,方便在上一层捕捉自定义异常,对异常信息统一管理,并返会前台
            throw new FileDownLoadException("文件读取异常");
        }
        catch (IOException e)
        {
            throw new FileDownLoadException("文件读取异常");
        }
        finally
        {
            try
            {
                // 关闭缓存流的时候会将输入输出流给关闭
                if (bin != null)
                {
                    bin.close();
                }
                if (bout != null)
                {
                    bout.close();
                }
            }
            catch (IOException e)
            {
                throw new RuntimeException("文件读取异常");
            }
        }

    }
}
        /*String newFileName = null;
        String insertPath = null;
        String fileName = "license_freeware.txt";// 设置文件名，根据业务需要替换成要下载的文件名
        if (fileName != null) {
            //设置文件路径
            String realPath = "E://onlineinfo//";
            File file = new File(realPath, fileName);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }*/

