<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="/WEB-INF/views/header/header.jsp"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%
	Date nowTime = new Date();
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat monthSf = new SimpleDateFormat("MM");
	SimpleDateFormat yearSf = new SimpleDateFormat("yyyy");
%>
  <script type="text/javascript">
	function loginValidation() {
		
		debugger;
		let v_user_id = $('#v_user_id').val();
		let v_user_pw = $('#v_user_pw').val();

		if (v_user_id == "") {
			alert("아이디를 입력해 주세요");
			$('#v_user_id').focus();
			return false;
		} else if (v_user_pw == "") {
			alert("패스워드를 입력해 주세요.");
			$('#v_user_pw').focus();
			return false;
		}
				
		$('#user_id').val(v_user_id);
		$('#user_pw').val(v_user_pw);
		
	}
  </script>
<body>
  <div id="wrap">
    <!--상단-->

    <article id="mainWrap">
      <section id="mainContent">
        <div class="main-title">
          <p>eGov Go!</p>
        </div>
        <div class="main-content-inner clearfix">
        <div class="setting-bx clearfix">
        
          <!-- :: 오른쪽 시작:: -->
          <div class="line-content-bx fl-r"id ="userDetailInfoDiv">
            <div class="fl-l">
                  <div class="content-title" id ="title"><p>Login</p></div>
                </div>
            <div class="cm-table-bx style1" id ="topDiv">



            </div>
          

            
		            <div class="cm-table-bx style2 mt25" id="userDetailInfo">
            		<div class="table-wrap restrictions">
            <form action="<%=contextPath %>/member/loginPost.do" id="login" name="login" method="post" onsubmit="return loginValidation();">
				<input type="hidden" id="user_id" name="user_id">
				<input type="hidden" id="user_pw" name="user_pw">
	
					<div class="user-box">
						<label>아이디 &nbsp; &nbsp;</label>
						<input type="text" id="v_user_id" name="v_user_id" required="">
					</div>
					<div class="user-box">
						<label>비밀번호 &nbsp;</label>
						<input type="password" id="v_user_pw" name="v_user_pw" required="">
					</div>
					<div>
						<input type="submit" value="로그인">
					</div>
			</form>
            		
			            </div>
			      </div>
          </div>
          </div>
          <!-- //오른쪽 끝 -->
                 
        </div>
      </section>
    </article>

  </div>


</body>
</html>



  
  
 




