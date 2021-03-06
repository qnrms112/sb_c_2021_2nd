package com.jbg.exam.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reply {
	private int id;
	private String regDate;
	private String updateDate;
	private int memberId;
	private String relTypeCode;
	private int relId;
	private String body;
	private int repliceCount;
	private int goodreactionPoint;
	private int badreactionPoint;
	
	private String extra__writerName;
	private boolean extra__actorCanModify;
	private boolean extra__actorCanDelete;
	
	public String getForPrintType1RegDate() {
		return regDate.substring(2, 16).replace(" ","<br>");
	}
	
	public String getForPrintType1UpdateDate() {
		return updateDate.substring(2, 16).replace(" ","<br>");
	}
	
	public String getForPrintType2RegDate() {
		return regDate.substring(2, 16);
	}
	
	public String getForPrintType2UpdateDate() {
		return updateDate.substring(2, 16);
	}
	
	public String getforPrintBody() {
		return body.replaceAll("\n", "<br>");
	}
}