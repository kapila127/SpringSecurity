<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
  <head>
    <title><tiles:getAsString name="title"/></title>
        <link href="/SpringMVCHibernate/resources/lib/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" >
        <script type="text/javascript"  src="/SpringMVCHibernate/resources/lib/jquery/jquery-1.11.1.js"></script>
         <script type="text/javascript"  src="/SpringMVCHibernate/resources/lib/bootstrap/js/bootstrap.min.js"></script>
        <script type='text/javascript' src="/SpringMVCHibernate/dwr/engine.js"></script>
        <script type='text/javascript' src="/SpringMVCHibernate/dwr/util.js"></script>
        <script type="text/javascript" src="/SpringMVCHibernate/dwr/interface/personController.js" ></script>
    
  </head>
  <body>
        <table>
      <tr>
        <td colspan="2">
          <tiles:insertAttribute name="header" />
        </td>
      </tr>
      <tr>
        <td>
          <tiles:insertAttribute name="menu" />
        </td>
        <td>
          <tiles:insertAttribute name="body" />
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <tiles:insertAttribute name="footer" />
        </td>
      </tr>
    </table>
  </body>
</html>