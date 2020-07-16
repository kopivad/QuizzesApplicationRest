package com.kopivad.quizzes.mapper;

import com.kopivad.quizzes.domain.QuizHistory;
import com.kopivad.quizzes.domain.QuizSession;
import com.kopivad.quizzes.domain.User;
import com.kopivad.quizzes.dto.QuizHistoryDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuizHistoryMapper {
    private final ModelMapper mapper;
    private final QuizAnswerMapper quizAnswerMapper;
    
    public QuizHistoryDto toDto(QuizHistory quizHistory) {
        return mapper.map(quizHistory, QuizHistoryDto.QuizHistoryDtoBuilder.class).build();
    }

    public QuizHistory toEntity(QuizHistoryDto quizHistoryDto) {
        return mapper.map(quizHistoryDto, QuizHistory.QuizHistoryBuilder.class).build();
    }

    @PostConstruct
    private void setupMapper() {
        mapper.createTypeMap(QuizHistory.class, QuizHistoryDto.QuizHistoryDtoBuilder.class)
                .addMappings(m -> m.skip(QuizHistoryDto.QuizHistoryDtoBuilder::userId))
                .addMappings(m -> m.skip(QuizHistoryDto.QuizHistoryDtoBuilder::sessionId))
                .setPostConverter(toDtoConverter());

        mapper.createTypeMap(QuizHistoryDto.class, QuizHistory.QuizHistoryBuilder.class)
                .addMappings(m -> m.skip(QuizHistory.QuizHistoryBuilder::user))
                .addMappings(m -> m.skip(QuizHistory.QuizHistoryBuilder::session))
                .setPostConverter(toEntityConverter());
    }

    private Converter<QuizHistoryDto, QuizHistory.QuizHistoryBuilder> toEntityConverter() {
        return context -> {
            QuizHistoryDto source = context.getSource();
            QuizHistory.QuizHistoryBuilder destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private Converter<QuizHistory, QuizHistoryDto.QuizHistoryDtoBuilder> toDtoConverter() {
        return context -> {
            QuizHistory source = context.getSource();
            QuizHistoryDto.QuizHistoryDtoBuilder destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    private void mapSpecificFields(QuizHistory source, QuizHistoryDto.QuizHistoryDtoBuilder destination) {
        destination.userId(source.getUser().getId()).build();
        destination.sessionId(source.getSession().getId()).build();
    }

    private void mapSpecificFields(QuizHistoryDto source, QuizHistory.QuizHistoryBuilder destination) {
        destination.user(User.builder().id(source.getUserId()).build());
        destination.session(QuizSession.builder().id(source.getSessionId()).build());
    }
}
