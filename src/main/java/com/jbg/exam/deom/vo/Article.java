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
	public String extra__writerName;
}