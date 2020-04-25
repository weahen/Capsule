package com.dtxw.controller;

import com.dtxw.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class downloadController {
    @Autowired
    RoomMapper roomMapper;
    @RequestMapping(value = "downloadapp")
    public void Download(HttpServletResponse httpServletResponse) throws IOException {
        //String filename="Capsule.apk";
        //ClassPathResource classPathResource = new ClassPathResource("capsule.apk");
        File file = new File("c:/apk/capsule.apk");
        httpServletResponse.setHeader("content-type","application/octet-stream");
        httpServletResponse.setContentType("application/octet-stream");
        httpServletResponse.setHeader("Content-Disposition","attachment;filename="+file.getName());
        httpServletResponse.setHeader("Content-Length",String.valueOf(file.length()));

        byte[] buffer = new byte[1024];
//        BufferedInputStream bufferedInputStream =null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            outputStream = httpServletResponse.getOutputStream();

//            String path = GetResource.class.getClassLoader().getResource("capsule.apk").getPath();
//            System.out.println(path);
//            bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
            inputStream = new FileInputStream(file);
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

    @RequestMapping(value = "downloadtools")
    public void DownloadTools(HttpServletResponse httpServletResponse) throws IOException {
        File file = new File("c:/tools/Capsule_Manager.rar");
        httpServletResponse.setHeader("content-type","application/octet-stream");
        httpServletResponse.setContentType("application/octet-stream");
        httpServletResponse.setHeader("Content-Disposition","attachment;filename="+file.getName());
        httpServletResponse.setHeader("Content-Length",String.valueOf(file.length()));

        byte[] buffer = new byte[1024];
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            outputStream = httpServletResponse.getOutputStream();
            inputStream = new FileInputStream(file);
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
    @RequestMapping(value = "/check_version",method = RequestMethod.POST)
    @ResponseBody
    public String update(String versioncode)
    {
        String code = roomMapper.getVersion_code();
        if(code.equals(versioncode))
        {
            return null;
        }
        else
        {
            return "new version exists";
        }
    }

}
