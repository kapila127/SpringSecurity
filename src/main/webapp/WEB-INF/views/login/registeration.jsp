<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  style="width: 0px;background: bisque;">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel='stylesheet' href="<c:url value='/resources/lib/bootstrap/css/bootstrap.min.css'/>"/>
        <title>User Registeration</title>
    </head>
    <body>
        <script type="text/javascript"  src="<c:url value='/resources/lib/jquery/jquery-1.11.1.js'/>"></script>
        <script type="text/javascript"  src="<c:url value='/resources/lib/bootstrap/js/bootstrap.min.js'/>"></script>
        <script type="text/javascript"  src="<c:url value='dwr/interface/onlineExamController.js'/>"></script>
        
        <div class="container">

            <spring:url value="/users" var="userActionUrl" />
            <h4>Please Register to login</h4>



            <form:form id="login" cssClass="form-horizontal" method="post"  modelAttribute="User"  action="${userActionUrl}">
<div class="container-fluid">
<div class="row">
<div class="panel panel-default">
<div class="col-md-6">
<div class="panel-body"> 
              
                <spring:bind path="UserName">
                    <div class="form-group">
                        <label class="col-sm-6 control-label">User Name</label>
                        <div class="col-sm-6">
                            <form:input path="UserName" type="text" class="form-control" id="UserName" placeholder="Enter User Name" />
                        </div>
                    </div>
                </spring:bind>

                <spring:bind path="Password">
                    <div class="form-group">
                        <label class="col-sm-6 control-label">Enter Password</label>
                        <div class="col-sm-6">
                            <form:input path="Password" class="form-control"  id="Password" placeholder="Enter Password" />
                        </div>
                    </div>
                </spring:bind>
                
   </div>
    </div>
    <div class="panel-body"> 
    <div class="col-md-6">
                <spring:bind path="Password">
                    <div class="form-group">
                        <label class="col-sm-6 control-label">Confirm Password</label>
                        <div class="col-sm-6">
                            <form:input path="Password" class="form-control"  id="Password" placeholder="Re-Enter Password" />
                        </div>
                    </div>
                </spring:bind>	
              </div>
              </div>
               <div class="form-group">
                    <div class="col-sm-offset-6 col-sm-6">
                        <button type="submit" class="btn-lg btn-primary pull-right">Submit</button>
                    </div>
                </div>	
             </div>		  
            </div> 
                <h2>Already register</h2>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-0">
                        <button type="button" class="btn-lg btn-primary pull-left" onclick="login()">login</button>
                    </div>
                </div>
                <script type="text/javascript" >
                    function  login()
                    {
                        $.ajax({
                            url: 'login/',
                            type: 'GET',
                            success: function(data, textStatus, jqXHR) {
                           $("#login").html(data);
                            }
                              
                        });
              $("h4").hide();
          }
                </script>
        </div>
            </form:form>
            </div>
        	
    </body>
</html>
<script type="text/javascript">

    $("#").click(function() {


    });
</script>