package com.java.mockprojectspringboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Component
@Entity
@Table(name = "questions")

public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int quesId;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private int ans;
    private int chose;
    
    
    public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Question(int quesId, String title, String optionA, String optionB, String optionC, int ans, int chose,
			Category cate) {
		super();
		this.quesId = quesId;
		this.title = title;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.ans = ans;
		this.chose = chose;
		this.cate = cate;
	}

	@ManyToOne
    @JoinColumn(name = "cate_id")
    private Category cate;
    
 

	@Override
	public String toString() {
		return "Question [quesId=" + quesId + ", title=" + title + ", optionA=" + optionA + ", optionB=" + optionB
				+ ", optionC=" + optionC + ", ans=" + ans + ", chose=" + chose + ", cate=" + cate + "]";
	}

	public int getQuesId() {
		return quesId;
	}

	public void setQuesId(int quesId) {
		this.quesId = quesId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public int getAns() {
		return ans;
	}

	public void setAns(int ans) {
		this.ans = ans;
	}

	public int getChose() {
		return chose;
	}

	public void setChose(int chose) {
		this.chose = chose;
	}
    
	 public Category getCate() {
			return cate;
		}

		public void setCate(Category cate) {
			this.cate = cate;
		}


}