<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>


<body>
	<div id="wrap">

		<!-- header -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>게시판</h2>
				<ul>
					<li><a href="">일반게시판</a></li>
					<li><a href="">댓글게시판</a></li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">

				<div id="content-head">
					<h3>일반게시판</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>게시판</li>
							<li class="last">일반게시판</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				<!-- //content-head -->
	
				<div id="board">
					<div id="list">
						<form action="" method="">
							<div class="form-group text-right">
								<input type="text">
								<button type="submit" id=btn_search>검색</button>
							</div>
						</form>
						<table >
							<thead>
								<tr>
									<th>번호</th>
									<th>제목</th>
									<th>글쓴이</th>
									<th>조회수</th>
									<th>작성일</th>
									<th>관리</th>
								</tr>
							</thead>
							<tbody>
								<!-- var이름이 blist이면 좀 안맞음. boardList는 여러개라서 괜찮은데 그중에 하나를 꺼내는거니까 blist보단 다른 이름을 지어주는게 좋다! -->
								<c:forEach items="${boardList}" var="bList">
									<tr class="last">
										<td>${bList.no}</td>
										<td class="text-left"><a href="${pageContext.request.contextPath}/board/read?no=${bList.no}">${bList.title}</a></td>
										<td>${bList.name}</td>
										<td>${bList.hit}</td>
										<td>${bList.reg_date}</td>
										<c:choose>
											
											<c:when test="${not empty authUser and authUser.no == bList.user_no}">
												<td><a href="${pageContext.request.contextPath}/board/delete?no=${bList.no}">[삭제]</a></td>
											</c:when>
											<c:otherwise>
												<td><a href=""></a></td>
											</c:otherwise>										
										</c:choose>										
									</tr>
								</c:forEach>
							</tbody>
						</table>
			
						<div id="paging">
							<ul>
								<li><a href="">◀</a></li>
								<li><a href="">1</a></li>
								<li><a href="">2</a></li>
								<li><a href="">3</a></li>
								<li><a href="">4</a></li>
								<li class="active"><a href="">5</a></li>
								<li><a href="">6</a></li>
								<li><a href="">7</a></li>
								<li><a href="">8</a></li>
								<li><a href="">9</a></li>
								<li><a href="">10</a></li>
								<li><a href="">▶</a></li>
							</ul>
							
							
							<div class="clear"></div>
						</div>
						<c:choose>
							<c:when test="${not empty authUser}">
								<a id="btn_write" href="${pageContext.request.contextPath}/board/writeform">글쓰기</a>
							</c:when>
							<c:otherwise>
							
							</c:otherwise>
						</c:choose>
					</div>
					<!-- //list -->
				</div>
				<!-- //board -->
			</div>
			<!-- //content  -->

		</div>
		<!-- //container  -->
		

		<!-- footer.jsp를 불러와라 -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		
		<!-- //footer -->
	</div>
	<!-- //wrap -->

</body>

</html>
