<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/11 0011
  Time: 下午 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
      $(function () {
          $.ajax({
              type:"POST",
              url:"servlet/FlowerServlet?method=findAll",
              dataType:"text",
              success:function (result) {
                  alert(result);
                  $("#display").empty();
                  eval("var arr="+result);
                  for(var i=0;i<arr.length;i++){
                      $("#display").append("<tr>\n" +
                          "          <td>"+arr[i].id+"</td>\n" +
                          "          <td>"+arr[i].name+"</td>\n" +
                          "          <td>"+arr[i].price+"</td>\n" +
                          "          <td>"+arr[i].production.name+"</td>\n" +
                          "          <td>"+"<img src=servlet/FlowerServlet?method=findImageById&id="+arr[i].id+">"+"</td>\n" +
                          "          <td>"+"<a href=servlet/FlowerServlet?method=download&id="+arr[i].id+">"+"下载"+"</a>"+"</td>\n" +
                          "        </tr>");
                  }
              },
              error:function (xhr) {
                  alert(xhr.status+" "+xhr.statusText);
              }
          });
      });

      $.ajax({
          type:"POST",
          url:"servlet/FlowerServlet?method=findPro",
          dataType:"text",
          success:function (result) {
              // alert(result);
              $("#production").empty();
              eval("var arr="+result);
              for(var i=0;i<arr.length;i++){
                  $("#production").append("<option value=\""+arr[i].id+"\">"+arr[i].name+"</option>");
              }
          },
          error:function (xhr) {
              alert(xhr.status + " " + xhr.statusText);
          }
      });
      function check() {
          var name=$("#name").val();
          var price=$("#price").val();
          var production=$("#production").val();
          if (name=="" || price=="" || production==""){
              alert("请填写完整信息");
              return false;
          }else {
              return true;
          }
      }
      function sel() {
          var name=$("#name").val();
          var production=$("#production").val();
          $.ajax({
              type:"POST",
              url:"servlet/FlowerServlet?method=findByCon",
              data:{"name":name,"production":production},
              dataType:"Text",
              success:function (result) {
                  alert(result);
                  $("#display").empty();
                  eval("var arr="+result);
                  for(var i=0;i<arr.length;i++){
                      $("#display").append("<tr>\n" +
                          "          <td>"+arr[i].id+"</td>\n" +
                          "          <td>"+arr[i].name+"</td>\n" +
                          "          <td>"+arr[i].price+"</td>\n" +
                          "          <td>"+arr[i].production.name+"</td>\n" +
                          "          <td>"+"<img src=servlet/FlowerServlet?method=findImageById&id="+arr[i].id+">"+"</td>\n" +
                          "          <td>"+"<a href=servlet/FlowerServlet?method=download&id="+arr[i].id+">"+"下载"+"</a>"+"</td>\n" +
                          "        </tr>");
                  }
              },
              error:function (xhr) {
                  alert(xhr.status+" "+xhr.statusText);
              }
          });
      }
    </script>
  </head>
  <body>
  <div style="width: 60%;margin: 0 auto">
    花卉名称:<input type="text" name="name" id="name">
    原产地:<select name="production" id="production">
            </select>
    <input type="button" value="查询" onclick="sel()">
  </div>

  <hr>
  <div style="width: 90%;margin: 0 auto">
    <table cellspacing="0px" cellpadding="0px" border="1px" width="100%">
      <thead>
        <th>花卉编号</th>
        <th>花卉名称</th>
        <th>价格(元)</th>
        <th>原产地</th>
        <th>花卉图片</th>
      <th>操作</th>
      </thead>
      <tbody id="display">

      </tbody>
    </table>
  </div>
  <div style="width: 30%;margin: 0 auto">
    <a href="addFlower.jsp" style="text-decoration: none">添加花卉信息</a>
  </div>
  </body>
</html>
