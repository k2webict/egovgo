package ict.egovgo.domain;

import org.springframework.web.multipart.MultipartFile;

public class DataManageVO {
	
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String writer_nm;
	private String gubun;
	private String rgsde;
	private String updde;
	private MultipartFile uploadFile;	
	private String atch_path;					//서버에 저장될 경로
	private String atch_original_name;			//업로드 파일명
	private String atch_uuid;					//서버에 등록될 파일명
	private int board_idno;
	private String board_type;
	private String author;
	private int view_count;
	private String rgsde_startdt;
    private String rgsde_enddt;
    private String search_type;
    private String search_value;
	
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getWriter_nm() {
		return writer_nm;
	}
	public void setWriter_nm(String writer_nm) {
		this.writer_nm = writer_nm;
	}
	public String getGubun() {
		return gubun;
	}
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	public String getRgsde() {
		return rgsde;
	}
	public void setRgsde(String rgsde) {
		this.rgsde = rgsde;
	}
	public String getUpdde() {
		return updde;
	}
	public void setUpdde(String updde) {
		this.updde = updde;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getAtch_path() {
		return atch_path;
	}
	public void setAtch_path(String atch_path) {
		this.atch_path = atch_path;
	}
	public String getAtch_original_name() {
		return atch_original_name;
	}
	public void setAtch_original_name(String atch_original_name) {
		this.atch_original_name = atch_original_name;
	}
	public String getAtch_uuid() {
		return atch_uuid;
	}
	public void setAtch_uuid(String atch_uuid) {
		this.atch_uuid = atch_uuid;
	}
	public int getBoard_idno() {
		return board_idno;
	}
	public void setBoard_idno(int board_idno) {
		this.board_idno = board_idno;
	}
	public String getBoard_type() {
		return board_type;
	}
	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getView_count() {
		return view_count;
	}
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	public String getRgsde_startdt() {
		return rgsde_startdt;
	}
	public void setRgsde_startdt(String rgsde_startdt) {
		this.rgsde_startdt = rgsde_startdt;
	}
	public String getRgsde_enddt() {
		return rgsde_enddt;
	}
	public void setRgsde_enddt(String rgsde_enddt) {
		this.rgsde_enddt = rgsde_enddt;
	}
	public String getSearch_type() {
		return search_type;
	}
	public void setSearch_type(String search_type) {
		this.search_type = search_type;
	}
	public String getSearch_value() {
		return search_value;
	}
	public void setSearch_value(String search_value) {
		this.search_value = search_value;
	}
	@Override
	public String toString() {
		return "DataManageVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", writer_nm=" + writer_nm + ", gubun=" + gubun + ", rgsde=" + rgsde + ", updde=" + updde
				+ ", uploadFile=" + uploadFile + ", atch_path=" + atch_path + ", atch_original_name="
				+ atch_original_name + ", atch_uuid=" + atch_uuid + ", board_idno=" + board_idno + ", board_type="
				+ board_type + ", author=" + author + ", view_count=" + view_count + ", rgsde_startdt=" + rgsde_startdt
				+ ", rgsde_enddt=" + rgsde_enddt + ", search_type=" + search_type + ", search_value=" + search_value
				+ "]";
	}
	
	
}
