<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/11 0011
  Time: 下午 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <base href="<%=request.getScheme()%>://<%=request.getServerName()%>:<%=request.getServerPort()%><%=request.getContextPath()%>">
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript">
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
    </script>
</head>
<body>
<h3 align="center">花卉信息</h3>
<div style="width: 30%;margin: 0 auto">
    <form action="servlet/FlowerServlet?method=addFlower"method="post" onsubmit="return check()" enctype="multipart/form-data">
        花卉名称:<input type="text" name="name" id="name"><br>
        花卉价格:<input type="text" name="price" id="price"><br>
        <%--原产地:<input type="text" name="production" id="production"><br>--%>
        原产地:<select name="production" id="production">
                    <option value=""></option>
                </select><br>
        &nbsp; &nbsp; &nbsp;<input type="submit" value="添加"> &nbsp;<input type="reset" value="重置">
    </form>
</div>
</body>
</html>
