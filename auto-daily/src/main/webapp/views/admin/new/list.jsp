<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/common/taglib.jsp" %>
<title>Trang chủ</title>
</head>
<body>
<div class="card mb-3">
			<form id="formSubmit" method="get" action="<c:url value="/admin-new" />">
          <div class="card-header">
            <i class="fas fa-table"></i>
            Danh sách bài viết</div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table table-bordered" width="100%" cellspacing="0">
                <thead>
                  <tr>
                    <th>Tiêu đề</th>
                    <th>Mô tả ngắn</th>
                    <th>Nội dung</th>
                    <th>Thể Loại</th>
                    <th>Hình ảnh</th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${model.listResult}">
                  <tr>
                    <td>${item.title}</td>
                    <td>${item.shortDescription}</td>
                    <td>${item.content}</td>
                    <td>${item.categoryId}</td>
                    <td>${item.thumbnail}</td>
                  </tr>
                  </c:forEach>
                </tbody>
              </table>
            </div>
          </div>
          <ul class="pagination" id="pagination"></ul>
          <input type="hidden" value="" id="type" name="type"/>
          <input type="hidden" value="" id="page" name="page"/>
          <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
          <input type="hidden" value="" id="sortName" name="sortName"/>
          <input type="hidden" value="" id="sortBy" name="sortBy"/>
         
<script>
 jQuery(document).ready(function($){
	 var currentPage = ${model.page};
	 var maxPageItem = ${model.maxPageItem};
	 var totalPage = ${model.totalPage};
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPage,
            visiblePages: 2,
            startPage : currentPage,
            onPageClick: function (event, page) {
               if(currentPage != page){
            	   $('#page').val(page);
            	   $('#maxPageItem').val(maxPageItem);
            	   $('#sortName').val('title');
            	   $('#sortBy').val('desc');
            	   $('#type').val('list');
            	   $('#formSubmit').submit();
               }
            }
        });
    });
</script>
          </form>
        </div>  
</body>
</html>