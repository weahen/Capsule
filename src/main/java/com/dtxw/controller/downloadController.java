package com.dtxw.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@Controller
public class downloadController {

    @RequestMapping(value = "download")
    public void Download(HttpServletResponse httpServletResponse) throws IOException {
        String filename="Capsule.apk";
        ClassPathResource classPathResource = new ClassPathResource("capsule.apk");
        httpServletResponse.setHeader("content-type","application/octet-stream");
        httpServletResponse.setContentType("application/octet-stream");
        httpServletResponse.setHeader("Content-Disposition","attachment;filename="+filename);
        httpServletResponse.setHeader("Content-Length",String.valueOf(classPathResource.contentLength()));

        byte[] buffer = new byte[1024];
//        BufferedInputStream bufferedInputStream =null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            outputStream = httpServletResponse.getOutputStream();

//            String path = GetResource.class.getClassLoader().getResource("capsule.apk").getPath();
//            System.out.println(path);
//            bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
            inputStream = classPathResource.getInputStream();
            int i = inputStream.read(buffer);
            while (i!=-1)
            {
                outputStream.write(buffer,0,i);
                outputStream.flush();
                i = inputStream.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream!=null)
            {
                inputStream.close();
            }
        }

    }

}
