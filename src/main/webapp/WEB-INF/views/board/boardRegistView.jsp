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
<script src="../resources/js/common/common.js"></script>
<script>
function boardRegist(){
	$("#form").attr("action", "<%=contextPath %>/data/dataManageRegistForm.do");
	form.submit();
}
</script>
<body>
  <div id="wrap">
    <!--상단-->

    <article id="mainWrap">
      <section id="mainContent">
        <div class="main-title">
          <p>게시판등록</p>
        </div>

        <div class="main-content-inner clearfix">
        <div class="line-bx clearfix">
          <!-- :: 오른쪽 시작:: -->
          <div class="line-bx-inner content-bx clearfix">
              <!-- :: 상세정보 검색  시작 :: -->
              <div class="content-title">
                  <div class="cm-btn-bx clearfix">
                    <div class="fl-l"><p>등록하기</p></div>
		              <div class="fl-r">
		                <div class="cm-btn style3"><a href="<%=contextPath %>/data/selectBoardPage.do"><button>목록</button></a></div>
		                <div class="cm-btn style3"><button onclick="boardRegist()">등록</button></div>
		              </div>
		            </div> 
                </div>
                <div class="cm-table-bx style1">
                <form action="#" method="post" id="form">
		              <table>
		                <colgroup>
		                 <col style="width: 25%">
		                  <col style="width: 8%">
		                  <col style="width: auto">
		                </colgroup>
		                <tbody>
		                  <tr>
		                  	 <th>항목</th>
			                    <td colspan="3"><div class="cm-select style2 per100">
			                        <select name="board_type" id="board_type">
			                          <option value="1">공지사항</option>
			                          <option value="2">자유게시판</option>
			                        </select>
			                      </div>
			                    </td>
			               <tr/>
			               <tr>
		                     <th>제목</th>
		                     <td colspan="6">
		                      <input type="text" class="cm-input per100" name="title"> 
		                    </td>
		                    </tr>
		                    <tr>
		                     <th>내용</th>
		                     <td colspan="6">
		                      <textarea cols="120" rows="5" style="height: 118px;" name="content"></textarea> 
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