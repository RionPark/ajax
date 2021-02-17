package com.ajax.test.vo;

import java.util.List;

public class UserVO {

	private String ui_id;
	private String ui_pwd;
	private List<String> ui_genre;
	
	public String getUi_id() {
		return ui_id;
	}
	public void setUi_id(String ui_id) {
		this.ui_id = ui_id;
	}
	public String getUi_pwd() {
		return ui_pwd;
	}
	public void setUi_pwd(String ui_pwd) {
		this.ui_pwd = ui_pwd;
	}
	public List<String> getUi_genre() {
		return ui_genre;
	}
	public void setUi_genre(List<String> ui_genre) {
		this.ui_genre = ui_genre;
	}
	@Override
	public String toString() {
		return "UserVO [ui_id=" + ui_id + ", ui_pwd=" + ui_pwd + ", ui_genre=" + ui_genre + "]";
	}
	
}
