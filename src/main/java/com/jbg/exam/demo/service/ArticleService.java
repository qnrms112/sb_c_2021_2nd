package com.jbg.exam.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbg.exam.demo.repository.ArticleRepository;
import com.jbg.exam.demo.util.Ut;
import com.jbg.exam.deom.vo.Article;
import com.jbg.exam.deom.vo.ResultData;

@Service
public class ArticleService {
	private ArticleRepository articleRepository;
	
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}
	

	public ResultData writeArticle(String title, String body) {
		articleRepository.writeArticle(title, body);
		int id = articleRepository.getLastInsertId();
	
		return ResultData.from("S-1", Ut.f("%d번 게시물이 생성되었습니다.", id), id);	
	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}

	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}

	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
	}
	
	
}
