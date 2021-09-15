package com.java.mockprojectspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name = "questions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToOne
    @JoinColumn(name = "cate_id")
    private Category cate;


    @Override
    public String toString() {
        return "Question [quesId=" + quesId + ", title=" + title + ", optionA=" + optionA + ", optionB=" + optionB + ", optionC=" + optionC + ", ans=" + ans + ", chose=" + chose + "]";
    }

}