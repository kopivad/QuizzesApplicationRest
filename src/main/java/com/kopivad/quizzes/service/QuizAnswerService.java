package com.kopivad.quizzes.service;

import com.kopivad.quizzes.domain.QuizAnswer;
import com.kopivad.quizzes.dto.QuizAnswerDto;
import org.springframework.core.io.Resource;

import java.util.List;

public interface QuizAnswerService {
    long save(QuizAnswerDto quizAnswerDto);

    List<QuizAnswer> findAllBySessionId(long sessionId);
}
