package com.dtxw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class ImgController {
    @RequestMapping(value = "/getImg/{name}",method = RequestMethod.POST)
    public void downloadImg(HttpServletResponse response,@PathVariable String name) throws IOException
    {
        String base = "c:/imgs/";
        File file = new File(base+name);
        response.setHeader("content-type","application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename="+name);
        response.setHeader("Content-Length",String.valueOf(file.length()));
        byte[] buffer = new byte[1024];
        InputStream inputStream = null;
        OutputStream outputStream = null;

        inputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        outputStream =response.getOutputStream();
        int flag = bufferedInputStream.read(buffer);
        while (flag!=-1)
        {
            outputStream.write(buffer,0,flag);
            outputStream.flush();
            flag = bufferedInputStream.read(buffer);
        }

        inputStream.close();

    }

    @RequestMapping(value = "/GetImg/{name}",method = RequestMethod.GET)
    public void downloadImg_GET(HttpServletResponse response,@PathVariable String name) throws IOException
    {
        String base = "c:/imgs/";
        File file = new File(base+name);
        response.setHeader("content-type","application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition","attachment;filename="+name);
        response.setHeader("Content-Length",String.valueOf(file.length()));
        byte[] buffer = new byte[1024];
        InputStream inputStream = null;
        OutputStream outputStream = null;

        inputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        outputStream =response.getOutputStream();
        int flag = bufferedInputStream.read(buffer);
        while (flag!=-1)
        {
            outputStream.write(buffer,0,flag);
            outputStream.flush();
            flag = bufferedInputStream.read(buffer);
        }

        inputStream.close();

    }
    @RequestMapping(value = "/uploadImg/{name}",method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(HttpServletRequest httpServletRequest,@PathVariable String name) throws IOException {
        ServletInputStream servletInputStream = null;
        FileOutputStream fileOutputStream = null;
        try
        {
            File file = new File("c:/imgs/"+name);
            file.createNewFile();

            servletInputStream = httpServletRequest.getInputStream();
            fileOutputStream = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            int i = servletInputStream.read(buffer);
            while (i!=-1)
            {
                fileOutputStream.write(buffer,0,i);
                fileOutputStream.flush();
                i = servletInputStream.read(buffer);
            }
            fileOutputStream.close();
            return "success";
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return "error";
        }
    }

    @RequestMapping(value = "/get_AD_Img/{path}/{name}",method = RequestMethod.POST)
    @ResponseBody
    public void get_AD_Img(HttpServletResponse response,@PathVariable String path,@PathVariable String name) throws IOException {
        ServletInputStream servletInputStream = null;
        FileOutputStream fileOutputStream = null;
        File file = new File("c:/AD_imgs/"+path+"/"+name);
        byte[] buffer = new byte[1024];
        InputStream inputStream = null;
        OutputStream outputStream = null;
        inputStream = new FileInputStream(file);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        outputStream =response.getOutputStream();
        int flag = bufferedInputStream.read(buffer);
        while (flag!=-1)
        {
            outputStream.write(buffer,0,flag);
            outputStream.flush();
            flag = bufferedInputStream.read(buffer);
        }
        inputStream.close();

    }
}
