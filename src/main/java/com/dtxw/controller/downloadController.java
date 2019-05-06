package com.dtxw.controller;

import org.hibernate.validator.internal.util.privilegedactions.GetResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class downloadController {

    @RequestMapping(value = "download")
    public void Download(HttpServletResponse httpServletResponse) throws IOException {
        String filename="Capsule.apk";
        httpServletResponse.setHeader("content-type","application/octet-stream");
        httpServletResponse.setContentType("application/octet-stream");
        httpServletResponse.setHeader("Content-Disposition","attachment;filename="+filename);

        byte[] buffer = new byte[1024];
        BufferedInputStream bufferedInputStream =null;
        OutputStream outputStream = null;
        try {
            outputStream = httpServletResponse.getOutputStream();
            String path = GetResource.class.getClassLoader().getResource("capsule.apk").getPath();
            System.out.println(path);
            bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(path)));
            int i = bufferedInputStream.read(buffer);
            while (i!=-1)
            {
                outputStream.write(buffer,0,buffer.length);
                outputStream.flush();
                i = bufferedInputStream.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bufferedInputStream!=null)
            {
                bufferedInputStream.close();
            }
        }

    }

}
