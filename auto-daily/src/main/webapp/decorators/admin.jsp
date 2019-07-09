<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<title><dec:title default="Trang chủ" /></title>
	<!-- Custom fonts for this template-->
  <link rel="stylesheet" href="<c:url value='/template/admin/vendor/fontawesome-free/css/all.min.css' />" />

  <!-- Page level plugin CSS-->
  <link rel="stylesheet" href="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.css' />" />

  <!-- Custom styles for this template-->
  <link rel="stylesheet" href="<c:url value='/template/admin/css/sb-admin.css' />" />
   <link rel="stylesheet" href="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.min.js' /> ">
  <%-- <script src="<c:url value='/template/admin/vendor/bootstrap/bootstrap.min.js' />"></script> --%>
  <script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
  <script src="<c:url value='/template/paging/jquery.twbsPagination.js' />"></script>

</head>
<body id="page-top">
	<!-- header -->
    <%@ include file="/common/admin/header.jsp" %>
    <!-- header -->
   
		 <div id="wrapper">
		<!-- header -->
    	<%@ include file="/common/admin/menu.jsp" %>
    	<!-- header -->
    	<div id="content-wrapper">
		<dec:body/>
		</div>
    	</div>
		
		<!-- footer -->
    	<%@ include file="/common/admin/footer.jsp" %>
    	<!-- footer -->

		<a class="scroll-to-top rounded" href="#page-top"> <i
			class="fas fa-angle-up"></i>
		</a>
	
  <!-- Bootstrap core JavaScript-->
  
  <script src="<c:url value='/template/admin/vendor/jquery/jquery.min.js' />"></script>
 <script src="<c:url value='/template/admin/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>
  <!-- Core plugin JavaScript-->
 <script src="<c:url value='/template/admin/vendor/jquery-easing/jquery.easing.min.js' />"></script>
  <!-- Page level plugin JavaScript-->
   <script src="<c:url value='/template/admin/vendor/chart.js/Chart.min.js' />"></script>
   <script src="<c:url value='/template/admin/vendor/datatables/jquery.dataTables.js' />"></script>
   <script src="<c:url value='/template/admin/vendor/datatables/dataTables.bootstrap4.js' />"></script>

  <!-- Custom scripts for all pages-->
   <script src="<c:url value='/template/admin/js/sb-admin.min.js' />"></script>

  <!-- Demo scripts for this page-->
   <%-- <script src="<c:url value='/template/admin/js/demo/datatables-demo.js' />"></script> --%>
   <%-- <script src="<c:url value='/template/admin/js/demo/chart-area-demo.js' />"></script> --%>
	
	
	
	
</body>
</html>