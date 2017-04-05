<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
    <head>
        <title>Person Page</title>

        <style type="text/css">
            .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
            .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
            .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
            .tg .tg-4eph{background-color:#f9f9f9}
        </style>
        <link href="/SpringMVCHibernate/resources/lib/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" >
        <script type="text/javascript"  src="<c:url value='/resources/lib/jquery/jquery-1.11.1.js'/>"></script>
        <script type='text/javascript' src="<c:url value='/dwr/engine.js'/>"></script>
        <script type='text/javascript' src="<c:url value='/dwr/util.js'/>"></script>
        <script type="text/javascript" src="<c:url value='/dwr/interface/personController.js'/>" ></script>

    </head>
    <body>

	<c:url var="addAction" value="/person/add"></c:url>
	<c:url var="importAction" value="/person/importToPdf"></c:url>

	<form method="post" action="importToPdf" enctype="multipart/form-data">
		<table border="0">
			<div class="col-lg-11">
				<span>
					<tr>
						<td class="pull-right">Pick file 1:</td>
						<td class="pull-right"><input type="file" name="fileUpload"
							size="50" /></td>
					</tr>

					<tr>
						<td colspan="2" align="center"><input type="submit"	value="Upload" /></td>
					</tr>
                     
				</span>
			</div>
		</table>
		
	</form>

 <div class="modal fade" id="modal" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 style="color:red;"><span class="glyphicon glyphicon-lock"></span>Add person</h4>
        </div>
	<form:form action="${addAction}" commandName="person">
           
            <table>
                <c:if test="${!empty person.name}">
                    <tr>
                        <td>
                            <form:label path="id">
                                <spring:message text="ID"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="id" readonly="true" size="8"  disabled="true" />
                            <form:hidden path="id" />
                        </td> 
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <form:label path="name">
                            <spring:message text="Name"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="name" />
                    </td> 
                </tr>
                <tr>
                    <td>
                        <form:label path="country">
                            <spring:message text="Country"/>
                        </form:label>
                    </td>
                    <td>
                        <form:input path="country" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <c:if test="${!empty person.name}">
                            <input type="submit"
                                   value="<spring:message text="Edit Person"/>" />
                        </c:if>
                        <c:if test="${empty person.name}">
                            <input type="submit" class="pull-right"
                                   value="<spring:message text="Add Person"/>" />
                        </c:if>
                    </td>
                </tr>
            </table>
     </form:form>
     </div>
     <div class="modal-footer">
          <button type="submit" class="btn btn-default btn-default pull-left" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
      </div>
     </div>
     </div>
     </div>
        <h3>Persons List</h3>
        <c:if test="${!empty listPersons}">
            <table class="tg">
                <tr>
                    <th width="80">Person ID</th>
                    <th width="120">Person Name</th>
                    <th width="120">Person Country</th>
                    <th width="60">Edit</th>
                    <th width="60">Delete</th>
                </tr>
                <c:forEach items="${listPersons}" var="person">
                    <tr>
                        <td>${person.id}</td>
                        <td>${person.name}</td>
                        <td>${person.country}</td>
                        <td><a href="<c:url value='/person/edit/${person.id}' />" >Edit</a></td>
                        <td><a href="<c:url value='/person/remove/${person.id}' />" >Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    
  <script type="text/javascript" >
   $('#dwr').click(function(){
	   personController.testDwr(function(data){
		   alert(data);
	   });
   });
   $("#editbtn").click(function(){
		$('#modal').modal();
	});
  </script>
   
    
    </body>
</html>
