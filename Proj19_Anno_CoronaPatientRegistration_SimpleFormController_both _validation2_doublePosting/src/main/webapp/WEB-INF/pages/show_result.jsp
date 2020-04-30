<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

    
     <h1 style="color:red;text-align:center">Result page</h1>
    
     <b>result is :::  ${resMsg} </b>  <br>
     
     <b>Date is :::  ${sysDate} </b>  <br>
     
     <!--here param is one more Implicit  object but as param value we can pass only string value
     not array kind of things thats why we shoud think about session and all  --> 
      <b>result is :::  .${param.resMsg} </b>  <br>
     
     <a href="corona.htm">home</a>