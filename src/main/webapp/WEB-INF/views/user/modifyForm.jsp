<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/assets/css/mysite.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">

</head>

<body>
	<div id="wrap">

		<!-- header -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		<!-- //header -->

		<div id="container" class="clearfix">
			<div id="aside">
				<h2>회원</h2>
				<ul>
					<li>회원정보</li>
					<li>로그인</li>
					<li>회원가입</li>
				</ul>
			</div>
			<!-- //aside -->

			<div id="content">
			
				<div id="content-head">
					<h3>회원정보</h3>
					<div id="location">
						<ul>
							<li>홈</li>
							<li>회원</li>
							<li class="last">회원정보</li>
						</ul>
					</div>
					<div class="clear"></div>
				</div>
				 <!-- //content-head -->
	
				<div id="user">
					<div id="modifyForm">
						<form action="${pageContext.request.contextPath}/user/modify" method="">
							<!-- 아이디랑 no를 input에다 숨겨서 안가져와도 되는 이유는? : 어차피 변경안할거고,no는 세션에서 계속 유지되는중. 이전값만 불러오면되기 때문! -->
							
							<!-- 아이디 -->
							<div class="form-group">
								<label class="form-text" for="input-uid">아이디</label> 
								<span class="text-large bold">${userVo.id}</span>
							</div>
	
							<!-- 비밀번호 -->
							<div class="form-group">
								<label class="form-text" for="input-pass">패스워드</label> 
								<input type="text" id="input-pass" name="password" value="${userVo.password}" placeholder="비밀번호를 입력하세요"	>
								<!-- 바뀐 값이 authUser에 있지만 이전 로그인값을 받는 이유는?: 수정폼에 불러와져야하기때문에 action=mform에 있는 루틴안에 있는 값을 불러와줌. auth~로 불러오면 아직 없기때문에 null값이 나옴. -->
								<!-- 파라미터로 불러오면 안되는 이유는? 저장되어있는 값들이 세션에 있기 때문에!그리고 처음부터 파라미터로 안불러와서 쓸 수 있는 파라미터도 없었다. -->
							</div>
	
							<!-- 이름 -->
							<div class="form-group">
								<label class="form-text" for="input-name">이름</label> 
								<input type="text" id="input-name" name="name" value="${userVo.name}" placeholder="이름을 입력하세요">
							</div>
							<!-- 성별 -->
							<div class="form-group">
								<span class="form-text">성별</span> 
								<label for="rdo-male">남</label> 
								<input type="radio" id="rdo-male" name="gender" value="male" checked="checked"> 
								
								<label for="rdo-female">여</label> 
								<input type="radio" id="rdo-female" name="gender" value="female" > 
	
							</div>
	
							<!-- 버튼영역 -->
							<div class="button-area">
								<button type="submit" id="btn-submit">회원정보수정</button>
							</div>
			
						</form>
					
					
					</div>
					<!-- //modifyForm -->
				</div>
				<!-- //user -->
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