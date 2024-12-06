package com.jiehfut.resresp.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RestController
public class FileUpAndDownController {
    /**
     * 实现文件的上传和下载，使用向客户端响应 ResponseEntity 对象，作为整个响应报文
     * 由 springMVC 借用 jackson 依赖将其转换为 json 格式
     */


    // 实现 luffy.jpg 的下载
    @RequestMapping(value = "/testDown", method = RequestMethod.GET)
    public ResponseEntity<byte[]> testDown(HttpSession session) throws Exception {

        // 获取 ServletContext 对象
        ServletContext servletContext = session.getServletContext();
        // 获取服务器中文件的真实路径   getRealPath（获取当前工程在服务器中的部署路径）
        String realPath = servletContext.getRealPath("/static/img/luffy.jpg");
        System.out.println("realPath = " + realPath);
        // realPath = E:\code\spring_code\springMVC\g-springMVC-HttpMessageConverter\target\g-springMVC-HttpMessageConverter-1.0-SNAPSHOT\static\img\luffy.jpg
        // 创建输入流，读取文件
        InputStream is = new FileInputStream(realPath);
        // 创建字节数组     is.available() 就是文件的所有的字节数，数组长度正好能存下整个文件
        byte[] bytes = new byte[is.available()];
        // 将流读到字节数组中
        is.read(bytes);
        // 接下来就是将数组中的数据全部响应到浏览器，数组中的内容就是文件，将数组转换成为 ResponseEntity 对象响应给前端


        // 创建HttpHeaders对象设置响应头信息  MultiValueMap 就是一个 map 集合，头信息 headers 就是键值对
        MultiValueMap<String, String> headers = new HttpHeaders();
        // 设置要下载方式（现在设置的是以附件下载）以及下载文件的默认名字
        headers.add("Content-Disposition", "attachment;filename=luffy.jpg");
        // 设置响应状态码 200
        HttpStatus statusCode = HttpStatus.OK;
        // 创建ResponseEntity对象，bytes 就是响应体，headers 就是响应头
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(bytes, headers, statusCode);
        // 关闭输入流
        is.close();
        return responseEntity;
    }





    // 实现客户端的上传功能（上传功能的依赖导入）
    // SpringMVC 中将上传的文件封装到 MultipartFile 对象中，通过此对象可以获取文件相关信息
    // 例如这里浏览器将上传的文件名设置为 photo，我们可以通过形参为 photo 的对象接收
    // 使用什么类型接收呢，springMVC 将文件封装到一个 MultipartFile 对象中，该对象中封装了 transferTo 方法用于上传
    // 要用上面的 springMVC 封装的 MultipartFile 对象，需要配置文件上传解析器
    @RequestMapping(value = "/testUp")
    public String testUp(MultipartFile photo) {
        System.out.println(photo.getName());
        System.out.println(photo.getOriginalFilename());
        return "success";
    }



}
