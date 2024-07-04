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
<script src="../resources/js/dataManager/dataManagerList.js"></script> 
<script src="../resources/js/common/common.js"></script>
<script>


$(function() {
	
	selectBoardPage();
})
function selectBoardPage(){
	
	$('#selectBoard').on('click', function() {
		
		$("#selectBoardForm").attr("action", "<%=contextPath %>/data/selectBoardPage.do");
		$("#selectBoardForm").submit();
		
	})

	

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
                  <div class="content-title" id ="title"><p><%=title %></p></div> <!-- 사용자 관리 -->
                </div>
                 <div class="fl-r">
              <div class="content-title"><p><c:if test ="${loginSession.user_id ne null}">
 				${loginSession.user_nm} <button type="button" id="logout" onclick="location.href='<%=contextPath %>/logout.do'">로그아웃</button>
 			</c:if></p></div> <!-- 게시판 관리 -->
            </div>
            <div class="cm-table-bx style1" id ="topDiv">
             <form id="selectBoardForm" method="post">
              <table>
                <colgroup>
                  <col style="width: 8%">
                  <col style="width: 25%">
                  <col style="width: 7%">
                  <col style="width: 13%">
                  <col style="width: 8%">
                  <col style="width: 25%">
                  <col style="width: auto">
                </colgroup>
                <tbody>  
                  <tr>
                    <th>사용자 검색</th>
                    <td colspan="2"><div class="cm-select style2 per20">
						<select name="search_type" id="search_type">
						<option value="all">전체</option>
						<option value="title">이름</option>
						<option value="content">부서</option>
						<option value="content">아이디</option>
						<option value="content">핸드폰</option>
						<option value="content">이메일</option>
						</select>
                      </div>
                      <input type="text" class="cm-input per40" id="search_value">
                    </td>     
                    <td colspan="3">                      
			            <div class="cm-btn-bx clearfix mt10">
			              <div class="fl-r">
			                <div class="cm-btn style7"><button id ="selectDataManageList">검색</button></div>
			              </div>
			            </div>                  
                    </td>                                          
                  </tr>                              
                </tbody>
              </table>
              </form>
            </div>
          
              <div class="cm-btn-group align-r mt20 clearfix" id ="midDiv">
                
                <div class="fl-r">
                  <div class="cm-btn style3"><button id ="addnewUser" value ='I'>신규</button></div>
                  <div class="cm-btn style7"><button id ="selectAllUserList" value =''>전체검색</button></div>
             	  <div class="cm-btn style3"><button id ="selectUserStatusY" value ='Y'>재직자</button></div>
			      <div class="cm-btn style5"><button id ="selectUserStatusN" value ='N'>퇴사자</button></div>
			      <div class="cm-btn style7"><button><a href="<%=contextPath %>/data/selectBoardPage.do">게시판</a></button></div>
                </div>
              </div>
            
		            <div class="cm-table-bx style2 mt25" id="userDetailInfo">
            		<div class="table-wrap restrictions">
			              <table  id ="userList">
			                <colgroup>
			                  <col style="width: 70px">
			                  <col style="width: 120px">
			                  <col style="width: 120px">   
			                  <col style="width: 120px">    
			                  <col style="width: 160px">    
			                  <col style="width: 160px">  
			                  <col style="width: 200px">    
			                  <col style="width: 100px">    
			                  <col style="width: 100px">    
			                </colgroup>   
			                <thead>
			                  <tr> 
			                   	<th>번호</th>
			                    <th>아이디</th>
			                    <th>사원명</th>
			                    <th>부서</th>
			                    <th>직급</th>
			                    <th>핸드폰번호</th>
			                    <th>이메일</th>
			                    <th>재직여부</th>
			                    <th>관리자여부</th>
			                   </tr>
			                </thead>            
			                <tbody>
                          	<c:choose>
		                		<c:when test="${not empty userList}">
		                			<c:forEach items="${userList}" var="m" varStatus="status">
		                				<tr>
		                					<td>${status.count}</td>
		                					<td id="user_id${status.index}">${m.user_id}</td>
		                					<td id ="user_nm${status.index}">${m.user_nm}</td>
		                					<td >${m.dept_nm}</td>
		                					<td >${m.dept_position}</td>
		                					<td >${m.hp}</td>
		                					<td >${m.email}</td>
		                					<td>
		                					<c:if test ="${m.emp_status eq 'Y'}">재직중</c:if>
		                					<c:if test ="${m.emp_status eq 'N'}">퇴사	</c:if>	
		                					</td>
		                					<td>
		                					<c:if test ="${m.auth_yn eq 'Y'}">예</c:if>
		                					<c:if test ="${m.auth_yn eq 'N'}">아니요</c:if>	
		                					</td>
		                				</tr>
		                			</c:forEach>
								</c:when>
		                	</c:choose>				                
			                </tbody>
			              </table>
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