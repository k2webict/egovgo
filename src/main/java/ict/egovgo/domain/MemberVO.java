package ict.egovgo.domain;

public class MemberVO {

	private String user_id;
	private String user_pw;
	private String user_nm;
	private String use_yn;
	private int pwd_error_co;
	private String rgsde;
	private String updde;
	private String dept_nm;
	private String hp;
	private String email;
	private String emp_status;
	private String dept_position;
	private String auth_yn;
	public String getUser_id() {
		return user_id;
	}
	public String getDept_position() {
		return dept_position;
	}
	public String getAuth_yn() {
		return auth_yn;
	}
	public void setAuth_yn(String auth_yn) {
		this.auth_yn = auth_yn;
	}
	public void setDept_position(String dept_position) {
		this.dept_position = dept_position;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_nm() {
		return user_nm;
	}
	@Override
	public String toString() {
		return "MemberVO [user_id=" + user_id + ", user_pw=" + user_pw + ", user_nm=" + user_nm + ", use_yn=" + use_yn
				+ ", pwd_error_co=" + pwd_error_co + ", rgsde=" + rgsde + ", updde=" + updde + ", dept_nm=" + dept_nm
				+ ", hp=" + hp + ", email=" + email + ", emp_status=" + emp_status + "]";
	}
	public void setUser_nm(String user_nm) {
		this.user_nm = user_nm;
	}
	public String getUse_yn() {
		return use_yn;
	}
	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}
	public int getPwd_error_co() {
		return pwd_error_co;
	}
	public void setPwd_error_co(int pwd_error_co) {
		this.pwd_error_co = pwd_error_co;
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
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmp_status() {
		return emp_status;
	}
	public void setEmp_status(String emp_status) {
		this.emp_status = emp_status;
	}
	
}
