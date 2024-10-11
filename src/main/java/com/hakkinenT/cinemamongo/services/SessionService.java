package com.hakkinenT.cinemamongo.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakkinenT.cinemamongo.exceptions.customs.ResourceNotFoundException;
import com.hakkinenT.cinemamongo.models.entities.movies.Movie;
import com.hakkinenT.cinemamongo.models.entities.rooms.ScreeningRoom;
import com.hakkinenT.cinemamongo.models.entities.sessions.Session;
import com.hakkinenT.cinemamongo.models.entities.sessions.dto.SessionDTO;
import com.hakkinenT.cinemamongo.repositories.MovieRepository;
import com.hakkinenT.cinemamongo.repositories.ScreeningRoomRepository;
import com.hakkinenT.cinemamongo.repositories.SessionRepository;
import com.hakkinenT.cinemamongo.utils.converters.DateConverter;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ScreeningRoomRepository roomRepository;

    public SessionDTO insert(SessionDTO dto){

        Session session = creatSession(dto);

        session = sessionRepository.insert(session);

        return new SessionDTO(session);
    }

    private Session creatSession(SessionDTO dto){
        Session session = new Session();
        session.setPrice(dto.getPrice());
        session.setSessionClosed(false);
        setExhibitionDate(dto, session);
        setScreeningRoom(dto, session);
        setMovie(dto, session);

        return session;
    }

    private void setExhibitionDate(SessionDTO dto, Session session) {
        String exhibitionDate = localDateTimeToString(dto);
        session.setExhibitionDate(exhibitionDate);
    }

    private String localDateTimeToString(SessionDTO dto) {
        LocalDateTime dateTime = DateConverter.toLocalDateTime(dto.getExhibitionDate(), dto.getExhibitionHour());
        return DateConverter.localDateTimeToString(dateTime);

    }

    private void setScreeningRoom(SessionDTO dto, Session session) {
        ScreeningRoom room = roomRepository.findById(dto.getRoom().getRoomNumber()).orElseThrow(() -> new ResourceNotFoundException("Sala não encontrada"));

        session.setRoomNumber(room.getId());
        session.setCapacity(room.getCapacity());
    }

    private void setMovie(SessionDTO dto, Session session) {
        Movie movie = movieRepository
            .findById(dto.getMovie().getId())
            .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado!"));
        session.setMovie(movie);
    }
}
