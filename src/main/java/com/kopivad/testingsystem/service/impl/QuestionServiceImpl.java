package com.kopivad.testingsystem.service.impl;

import com.kopivad.testingsystem.domain.Question;
import com.kopivad.testingsystem.repository.QuestionRepository;
import com.kopivad.testingsystem.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question getById(Long id) {
        return questionRepository.findById(id);
    }

    @Override
    public Question save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question update(Long id, Question question) {
        return questionRepository.update(id, question);
    }

    @Override
    public void delete(Long id) {
        questionRepository.delete(id);
    }
}
