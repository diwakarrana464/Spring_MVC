<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"  import="java.io.File"%>

    <table border="1" bgcolor="cyan">
  <tr><th>File Name </th><th> Download Here</th></tr>
  

  <%
  String file ;
  File folder = new File("D:/springfileUploads");
  
  File[] listOfFile =  folder.listFiles();
  
  for(int i = 0; i< listOfFile.length; i++){
	  
	  if (listOfFile[i].isFile()){
		 file = listOfFile[i].getName();
		 
		 %>
		 <tr><td><%=file %></td><td><a href="download.htm?file_name=<%=file%>">Download</a></td></tr>
		 <%
	  }
  }
  %>
  
</table>

    