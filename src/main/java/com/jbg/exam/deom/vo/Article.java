package com.jbg.exam.deom.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {
	public int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	public String title;
	public String body;
	
	private String extra__writerName;
	private boolean extra__actorCanModify;
	private boolean extra__actorCanDelete;
	
	public String getRegDateForPrint() {
		return regDate.substring(2, 16);
	}
	
	public String getUpdateDateForPrint() {
		return updateDate.substring(2, 16);
	}
}


