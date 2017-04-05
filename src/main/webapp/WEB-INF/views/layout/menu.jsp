<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<ul style="list-style:none;line-height:28px;">

	<li>
		<a href="exportToExcel" >Export To Excel</a>
	</li>

	<li>
		  <a  href="exportToPdf"> Export To Pdf</a> 
	</li>

	<li>
		  <input type="button" id="myBtn" class="btn submit"  data-toggle="modal" data-target="#modal" value="Add Person"/>
	</li>
</ul>
<script type="text/javascript">
$("#myBtn").click(function(){
	$('#modal').modal();
});
</script>