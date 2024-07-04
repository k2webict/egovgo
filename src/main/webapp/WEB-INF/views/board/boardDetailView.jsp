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
<script src="<%=contextPath %>/resources/js/common/common.js"></script>
<script>
function boardDelete(){
	$("#form").attr("action", "<%=contextPath %>/data/dataManageDelete.do");
	form.submit();
}

function boardUpdate(){
	$("#form").attr("action", "<%=contextPath %>/data/dataManageUpdate.do");
	form.submit();
}
</script>
<body>
  <div id="wrap">
    <!--상단-->

    <article id="mainWrap">
      <section id="mainContent">
        <div class="main-title">
          <p>게시판상세</p>
        </div>

        <div class="main-content-inner clearfix">
        <div class="line-bx clearfix">
          <!-- :: 오른쪽 시작:: -->
          <div class="line-bx-inner content-bx clearfix">
              <!-- :: 상세정보 검색  시작 :: -->
              <div class="content-title">
                  <div class="cm-btn-bx clearfix">
                    <div class="fl-l"><p>상세정보</p></div>
		              <div class="fl-r">
		                <div class="cm-btn style3"><a href="<%=contextPath %>/data/selectBoardPage.do"><button>목록</button></a></div>
		                <div class="cm-btn style3"><button onClick="boardUpdate()">수정</button></div>
		                <div class="cm-btn style6"><button onClick="boardDelete()">삭제</button></div>
		              </div>
		            </div> 
                </div>
                <div class="cm-table-bx style1">
                <form action="#" method="post" id="form">
                <input type="hidden" id="board_idno" name="board_idno" value="${boardMap.board_idno }"/>
		              <table>
		                <colgroup>
		                  <col style="width: 8%">
		                  <col style="width: 20%">
		                  <col style="width: 8%">
		                  <col style="width: 20%">
		                  <col style="width: 8%">
		                  <col style="width: auto">
		                </colgroup>
		                <tbody>
		                  <tr>
		                  	<th>작성자</th>
		                    <td>
		                      <input type="text" class="cm-input per100" disabled value="${boardMap.author }">
		                    </td>
		                    <th>등록일</th>
		                    <td>
		                      <input type="text" class="cm-input per100" disabled value="${boardMap.rgsde }">
		                    </td>
		                   <th>조회수</th>
		                    <td>
		                      <input type="text" class="cm-input per30" disabled value="${boardMap.view_count }">
		                    </td>
		                    <tr>
		                     <th>제목</th>
		                     <td colspan="6">
		                      <input type="text" class="cm-input per100" name="title" value="${boardMap.title }"> 
		                    </td>
		                    </tr>
		                    <tr>
		                     <th>내용</th>
		                     <td colspan="6">
		                      <textarea cols="120" rows="5" style="height: 118px;" name="content">${boardMap.content }</textarea> 
		                    </td>
		                    </tr>
		                </tbody>
		              </table>
		              </form>
		            </div>
          	</div>
          </div>
          <!-- //오른쪽 끝 -->
        </div>
      </section>
    </article>
  </div>


</body>