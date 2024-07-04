<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<%@ include file="/WEB-INF/views/header/header.jsp"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %>
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
	var now = new Date();
	var year = now.getFullYear();
	var month = String(now.getMonth() + 1).padStart(2, '0'); // 월은 0부터 시작하므로 1을 더함
	var day = String(now.getDate()).padStart(2, '0');
	var formattedDate = year + "-" + month + "-" + day;
	
	if($("#rgsde_startdt").val() == ''){
		$("#rgsde_startdt").val(formattedDate);
	}
	
	if($("#rgsde_enddt").val() == ''){
		$("#rgsde_enddt").val(formattedDate);
	}
})

function boardRegist(){
	window.location.href = '<%=contextPath %>/data/registBoardInfo.do';
}

function search(){
	$("#searchForm").attr("action", "<%=contextPath %>/data/selectBoardPage.do");
	form.submit();
}

function selectUserList(){
	window.location.href = '<%=contextPath %>/data/dataManagePage.do';
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
          <!-- :: 왼쪽 시작 :: -->
          <!--  
          <div class="line-content-bx fl-l per30">
              <div class="cm-btn-group align-r mt10 clearfix">
                <div class="fl-l">
                  <div class="cm-btn style3"><input type ="hidden" id ="v_user_id" value =''></div>
                  <div class="cm-btn style3"><input type ="hidden" id ="v_user_nm" value =''></div>
                  <div class="content-title"><p>사용자</p></div>
                </div>
              </div>
		            <div class="cm-table-bx style2 mt15">
            		<div class="table-wrap restrictions ht705">
		              <table id ="member">
		                <colgroup>
		                  <col style="width: 60px">  
		                  <col style="width: 80px">   
		                  <col style="width: auto">    
		                  <col style="width: 120px">  
		                </colgroup>  
		                <thead>
		                  <tr>
		                    <th>선택</th>
		                    <th>아이디</th>
		                    <th>이름</th>
		                    <th>사용유무</th>
		                    <th>등록일</th>
		                  </tr>
		                </thead>
		                <!--  -->	  
		                <!--          						               
		                <tbody>
		                	<c:choose>
		                		<c:when test="${not empty memberList}">
		                			<c:forEach items="${memberList}" var="m" varStatus="status">
		                				<tr>
		                					<td>
		                					<label for="chk${status.index}" class="cm-check style2">
					                            <input type="checkbox" name ="chk" id="chk${status.index}"/>
					                            <span></span>
					                            </label>
		                					</td>
		                					<td id="user_id${status.index}">${m.user_id}</td>
		                					<td id ="user_nm${status.index}">${m.user_nm}</td>
		                					<td><div class="cm-select style3">
		                						<select name ="use_yn" id ="use_yn" disabled>
		                							  <option value="Y" <c:if test ="${m.use_yn eq 'Y'}">selected</c:if>>사용</option>
		                							  <option value="N" <c:if test ="${m.use_yn eq 'N'}">selected</c:if>>미사용</option>		
		                						</select>
												</div>
		                					</td>
		                					<td>${m.rgsde}</td>
		                				</tr>
		                			</c:forEach>
								</c:when>
		                	</c:choose>
		                </tbody>
		              </table>
		            </div>
		            </div>
          </div>
          -->
          <!-- :: //왼쪽 끝 :: -->          
          <!-- :: 오른쪽 시작:: -->
          <div class="line-content-bx fl-r">
            <div class="fl-l">
              <div class="content-title"><p><%=title %></p></div> <!-- 게시판 관리 -->
            </div>
            <div class="fl-r">
              <div class="content-title"><p><c:if test ="${loginSession.user_id ne null}">
 				${loginSession.user_nm} <button type="button" id="logout" onclick="location.href='<%=contextPath %>/logout.do'">로그아웃</button>
 			</c:if></p></div> <!-- 게시판 관리 -->
            </div>
            <div class="cm-table-bx style1">
            <form id="searchForm">
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
                    <th>조회기간</th>
                    <td>
                      <div class="cm-date-bx clearfix">
						<div class="cm-date clearfix">
							<input type="text" class="datepicker" name="rgsde_startdt" id="rgsde_startdt" value="${param.rgsde_startdt }" placeholder="YYYY-MM-DD" maxlength="10" oninput="onInputHandlerFrom(this)">
						</div>
						<span>~</span>
						<div class="cm-date clearfix">
							<input type="text" class="datepicker" name="rgsde_enddt" id="rgsde_enddt" value="${param.rgsde_enddt }" placeholder="YYYY-MM-DD" maxlength="10" oninput="onInputHandlerFrom(this)">
						</div>
					</div>
                    </td>
                    <th>항목</th>
                    <td><div class="cm-select style2 per100">
                        <select name="gubun" id="gubun">
                          <option value="all" <c:if test="${param.gubun == 'all'}">selected</c:if>>전체</option>                          
                          <option value="1" <c:if test="${param.gubun == '1'}">selected</c:if>>공지사항</option>
                          <option value="2" <c:if test="${param.gubun == '2'}">selected</c:if>>자유게시판</option>
                        </select>
                      </div>
                    </td>
                    <th>검색어</th>
                    <td colspan="2"><div class="cm-select style2 per35">
						<select name="search_type" id="search_type">
						<option value="all" <c:if test="${param.search_type == 'all'}">selected</c:if>>전체</option>
						<option value="title" <c:if test="${param.search_type == 'title'}">selected</c:if>>제목</option>
						<option value="content" <c:if test="${param.search_type == 'content'}">selected</c:if>>내용</option>
						<option value="userNm" <c:if test="${param.search_type == 'userNm'}">selected</c:if>>작성자명</option>						
						</select>
                      </div>
                      <input type="text" class="cm-input per50" id="search_value" name="search_value" value="${param.search_value }">
                    </td>     
                    
                    <td colspan="2">                      
			            <div class="cm-btn-bx clearfix mt10">
			              <div class="fl-r">
			                <div class="cm-btn style3"><button onClick="search()">검색</button></div>
			              </div>
			            </div>                  
                    </td>                                          
                  </tr>  
                </tbody>
              </table>
              </form>
            </div>
              <div class="cm-btn-group align-r mt20 clearfix">
                
                <div class="fl-r">
                  <div class="cm-btn style3"><button onclick="boardRegist()">등록</button></div>
                  <div class="cm-btn style3"><button onclick="selectUserList()">사원관리</button></div>
                </div>
              </div>
		            <div class="cm-table-bx style2 mt5">
            		<div class="table-wrap restrictions">
			              <table id ="data">
			                <colgroup>
			                  <col style="width: 100px">
			                  <col style="width: 100px">
			                  <col style="width: auto">
			                  <col style="width: 100px">    
			                  <col style="width: 150px">    
			                  <col style="width: 50px">    
			                </colgroup>   
			                <thead>
			                  <tr> 
			                   	<th>번호</th>
			                   	<th>항목</th>
			                    <th>제목</th>
			                    <th>등록자</th>
			                    <th>등록일</th>
			                    <th>조회수</th>
			                   </tr>
			                </thead>            
			                <tbody>
                         		<c:forEach items="${boardList}" var="m" varStatus="status">
	                				<tr>
	                					<td>${status.index + 1}</td>
	                					<td><c:if test="${m.board_type == '1' }">공지사항</c:if>
	                						<c:if test="${m.board_type == '2' }">자유게시판</c:if>
	                					<td><a href="<%=contextPath %>/data/selectBoardDetailView.do?board_idno=${m.board_idno}">${m.title}</a></td>
	                					<td>${m.author}</td>
	                					<td>${m.rgsde}</td>
	                					<td>${m.view_count}</td>
	                				</tr>
	                			</c:forEach>
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