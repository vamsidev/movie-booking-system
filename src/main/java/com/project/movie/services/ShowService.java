package com.project.movie.services;

import java.util.List;
import java.util.Optional;

import com.project.movie.enums.SeatType;
import com.project.movie.exceptions.MovieDoesNotExists;
import com.project.movie.exceptions.ShowDoesNotExists;
import com.project.movie.exceptions.TheaterDoesNotExists;
import com.project.movie.repositories.MovieRepository;
import com.project.movie.repositories.ShowRepository;
import com.project.movie.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.movie.convertor.ShowConvertor;
import com.project.movie.entities.Movie;
import com.project.movie.entities.Show;
import com.project.movie.entities.ShowSeat;
import com.project.movie.entities.Theater;
import com.project.movie.entities.TheaterSeat;
import com.project.movie.request.ShowRequest;
import com.project.movie.request.ShowSeatRequest;

@Service
public class ShowService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private ShowRepository showRepository;

	public String addShow(ShowRequest showRequest) {
		Show show = ShowConvertor.showDtoToShow(showRequest);

		Optional<Movie> movieOpt = movieRepository.findById(showRequest.getMovieId());

		if (movieOpt.isEmpty()) {
			throw new MovieDoesNotExists();
		}

		Optional<Theater> theaterOpt = theaterRepository.findById(showRequest.getTheaterId());

		if (theaterOpt.isEmpty()) {
			throw new TheaterDoesNotExists();
		}

		Theater theater = theaterOpt.get();
		Movie movie = movieOpt.get();

		show.setMovie(movie);
		show.setTheater(theater);
		show = showRepository.save(show);

		movie.getShows().add(show);
		theater.getShowList().add(show);

		movieRepository.save(movie);
		theaterRepository.save(theater);

		return "Show has been added Successfully";
	}

	public String associateShowSeats(ShowSeatRequest showSeatRequest) throws ShowDoesNotExists {
		Optional<Show> showOpt = showRepository.findById(showSeatRequest.getShowId());

		if (showOpt.isEmpty()) {
			throw new ShowDoesNotExists();
		}

		Show show = showOpt.get();
		Theater theater = show.getTheater();

		List<TheaterSeat> theaterSeatList = theater.getTheaterSeatList();

		List<ShowSeat> showSeatList = show.getShowSeatList();

		for (TheaterSeat theaterSeat : theaterSeatList) {
			ShowSeat showSeat = new ShowSeat();
			showSeat.setSeatNo(theaterSeat.getSeatNo());
			showSeat.setSeatType(theaterSeat.getSeatType());

			if (showSeat.getSeatType().equals(SeatType.CLASSIC)) {
				showSeat.setPrice((showSeatRequest.getPriceOfClassicSeat()));
			} else {
				showSeat.setPrice(showSeatRequest.getPriceOfPremiumSeat());
			}

			showSeat.setShow(show);
			showSeat.setIsAvailable(Boolean.TRUE);
			showSeat.setIsFoodContains(Boolean.FALSE);

			showSeatList.add(showSeat);
		}

		showRepository.save(show);

		return "Show seats have been associated successfully";
	}
}
