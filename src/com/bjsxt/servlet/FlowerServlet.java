package com.bjsxt.servlet;

import com.bjsxt.pojo.Flower;
import com.bjsxt.pojo.Production;
import com.bjsxt.service.FlowerService;
import com.bjsxt.service.impl.FlowerServiceImpl;
import com.bjsxt.service.ProductionService;
import com.bjsxt.service.impl.ProductionServiceImpl;
import com.google.gson.Gson;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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


    public void addFlower(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
       Float price=Float.parseFloat(request.getParameter("price"));
       int productionId=Integer.parseInt(request.getParameter("production"));
//        FlowerService flowerService=new FlowerServiceImpl();
        WebApplicationContext ac = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        FlowerService flowerService = ac.getBean("flowerService", FlowerService.class);
        Flower flower=new Flower(name,price,productionId);
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


}
