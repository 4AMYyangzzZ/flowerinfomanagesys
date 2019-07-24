package com.bjsxt.servlet;

import com.bjsxt.pojo.Flower;
import com.bjsxt.pojo.Production;
import com.bjsxt.service.FlowerService;
import com.bjsxt.service.impl.FlowerServiceImpl;
import com.bjsxt.service.ProductionService;
import com.bjsxt.service.impl.ProductionServiceImpl;
import com.google.gson.Gson;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

public class FlowerServlet extends BaseServlet {
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        FlowerService flowerService=new FlowerServiceImpl();
//        List<Flower> list=flowerService.findAll();
        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        FlowerService flowerService = ac.getBean("flowerService", FlowerService.class);
        List<Flower> list = flowerService.findAll();
        Gson gson=new Gson();
        String str = gson.toJson(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(str);
    }

    public void findPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        ProductionService productionService = ac.getBean("productionService", ProductionService.class);
//        ProductionService productionService=new ProductionServiceImpl();
        List<Production> list=productionService.findAll();
        Gson gson=new Gson();
        String str = gson.toJson(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(str);
    }


    public void addFlower(HttpServletRequest request, HttpServletResponse response) throws Exception {
        FileItemFactory fileItemFactory=new DiskFileItemFactory();
        ServletFileUpload servletFileUpload=new ServletFileUpload(fileItemFactory);
        List<FileItem> list = servletFileUpload.parseRequest(request);
        String name="";
        Float price=0f;
        int productionId=-1;
        String flowerImage="";
        for (FileItem fileItem : list) {
            if (fileItem.isFormField()){
                if ("name".equals(fileItem.getFieldName())){
                    name=fileItem.getString("utf-8");
                }
                if ("price".equals(fileItem.getFieldName())){
                    price=Float.parseFloat(fileItem.getString());
                }
                if ("production".equals(fileItem.getFieldName())){
                    productionId=Integer.parseInt(fileItem.getString());
                }
            }else{
                if ("flower".equals(fileItem.getFieldName())){
                    File file=new File("d:/Test/images");
                    flowerImage=fileItem.getName();
                    if (!file.exists()){
                        file.mkdirs();
                    }
                    File uploadFile=new File(file,flowerImage);
                    fileItem.write(uploadFile);
                }
            }
        }
        StringBuilder image=new StringBuilder();
        image.append(UUID.randomUUID()+flowerImage.substring(flowerImage.lastIndexOf(".")));
        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        FlowerService flowerService = ac.getBean("flowerService", FlowerService.class);
        Flower flower=new Flower(name,price,productionId,image.toString(),flowerImage);
       boolean flag=flowerService.addFlower(flower);
       if (flag){
           request.getRequestDispatcher("/index.jsp").forward(request,response);
       }else {
           request.setAttribute("error","花卉添加失败");
           request.getRequestDispatcher("/addFlower.jsp").forward(request,response);
       }
    }

    public void findByCon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        int productionId=Integer.parseInt(request.getParameter("production"));
//        FlowerService flowerService=new FlowerServiceImpl();
        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        FlowerService flowerService = ac.getBean("flowerService", FlowerService.class);
        List<Flower> list=flowerService.findByCon(name,productionId);
        Gson gson=new Gson();
        String str = gson.toJson(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(str);
    }
    public void findImageById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int id=Integer.parseInt(request.getParameter("id"));
        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        FlowerService flowerService = ac.getBean("flowerService", FlowerService.class);
        List<Flower> list=flowerService.findImageById(id);

        File file=new File("D:/Test/images");
        String realName=list.get(0).getRealName();
        File downFile = new File(file,realName );

        InputStream is=new FileInputStream(downFile);
        OutputStream os = response.getOutputStream();
        realName=new String(realName.getBytes("utf-8"),"iso-8859-1");
        response.setHeader("Content-Disposition","attachment;filename="+realName);
        IOUtils.copy(is,os);
        Gson gson=new Gson();
        String str = gson.toJson(list);
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println(str);
    }

    public void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        FlowerService flowerService = ac.getBean("flowerService", FlowerService.class);
        List<Flower> list=flowerService.findImageById(id);

        File file=new File("D:/Test/images");
        String realName=list.get(0).getRealName();
        File downFile = new File(file,realName );

        InputStream is=new FileInputStream(downFile);
        OutputStream os = response.getOutputStream();
        realName=new String(realName.getBytes("utf-8"),"iso-8859-1");
        response.setHeader("Content-Disposition","attachment;filename="+realName);
        IOUtils.copy(is,os);
    }


}
