<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>  
    <script type="text/javascript">     
    //<![CDATA[    
        CKEDITOR.replace('content',{toolbar:'Full', skin : 'kama'});    
    //]]>     
    </script>    
    <title>jCuckoo 's ckedit page</title>  
  </head>  
  <body>  
    <textarea class="ckeditor" cols="80" id="content" name="content" rows="10">     
     CKEditor Test......(此处的内容会在编辑器中显示)</textarea>     
  </body>  
</html>