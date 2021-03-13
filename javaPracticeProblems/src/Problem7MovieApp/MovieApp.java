package Problem7MovieApp;

import java.util.Scanner;

//1. ask user for movie details
//create a movie object and add in the movie store
//display all movies
//2. sort movies by year of release and store in another array
//display the new sorted array
//3. ask user for movie rating
//search movies which are greater than or equal to this rating
//display those searched movies
//4. ask user for casting name
//search for the movies in which this casting is available
//display those searched movies
//5. ask user for the movie id
//search that id, if it exist ask user for new rating 
//update the rating for that movie id
//display that updated movie
//6. ask user for the movie id
//search that id, if it exist delete that movie
public class MovieApp {

	static Scanner in = new Scanner(System.in);
	static Movie[] movies = new Movie[1];
	static int moviesCount;

	public static void main(String[] args) {
		boolean flag = true;
		do {
			int id = 0;
			displayMenu();
			System.out.println("Enter Choice: ");
			int choice = in.nextInt();
			switch (choice) {
			case 1:
				Movie newMovie = getNewMovie();
				movies[moviesCount++] = newMovie;
				displayAllMovies(movies);
				break;
			case 2:
				Movie[] sortedMovies = sortMoviesByYear(movies);
				displayAllMovies(sortedMovies);
				break;
			case 3:
				System.out.println("Enter movie rating to be searched: ");
				float rating = in.nextFloat();
				Movie[] moviesByRating = searchMoviesByGivenRating(rating);
				displayAllMovies(moviesByRating);
				break;
			case 4:
				System.out.println("Enter casting name to be searched: ");
				in.nextLine();
				String cast = in.nextLine();
				Movie[] moviesByCasting = searchMoviesByCasting(cast);
				displayAllMovies(moviesByCasting);
				break;
			case 5:
				System.out.println("Enter movie id whose rating to be updated: ");
				id = in.nextInt();
				if (isPresent(id)) {
					Movie updatedMovie = updateRatingById(id);
					displayMovie(updatedMovie);
				} else
					System.out.println("Movie id doesn't exist in the system.");
				break;
			case 6:
				System.out.println("Enter movie id to be deleted: ");
				id = in.nextInt();
				if (isPresent(id))
					movies = deleteMovieById(id);
				else
					System.out.println("Movie id doesn't exist in the system.");
				break;
			case 7:
				System.out.println("System Exit......");
				flag = false;
				break;
			default:
				System.out.println("Incorrect Choice! Try Again");
			}
		} while (flag);
	}

	private static Movie getNewMovie() {
		if (movies.length == moviesCount)
			movies = resize();
		System.out.println("Enter movie id: ");
		int id = in.nextInt();
		in.nextLine();
		System.out.println("Enter movie name: ");
		String name = in.nextLine();
		System.out.println("Enter number of cast: ");
		short numberOfCast = in.nextShort();
		in.nextLine();
		String[] casting = new String[numberOfCast];
		System.out.println("Enter casts: ");
		for (int i = 0; i < numberOfCast; i++)
			casting[i] = in.nextLine();
		System.out.println("Enter movie year of release: ");
		short yearOfRelease = in.nextShort();
		System.out.println("Enter movie rating(1 to 5): ");
		float rating = in.nextFloat();
		return new Movie(id, name, casting, yearOfRelease, rating);
	}

	private static Movie[] resize() {
		Movie[] newarr = new Movie[moviesCount + 1];
		for (int i = 0; i < moviesCount; i++)
			newarr[i] = movies[i];
		return newarr;
	}

	private static boolean isPresent(int id) {
		for (int i = 0; i < moviesCount; i++)
			if (movies[i].getId() == id)
				return true;
		return false;
	}

	private static Movie[] sortMoviesByYear(Movie[] movies2) {
		Movie[] newarr = new Movie[moviesCount];
		for (int i = 0; i < moviesCount; i++)
			newarr[i] = movies2[i];
		for (int i = 0; i < moviesCount - 1; i++) {
			for (int j = 0; j < moviesCount - i - 1; j++) {
				if (newarr[j].getYearOfRelease() > newarr[j + 1].getYearOfRelease()) {
					Movie temp = newarr[j];
					newarr[j] = newarr[j + 1];
					newarr[j + 1] = temp;
				} else if (newarr[j].getYearOfRelease() == newarr[j + 1].getYearOfRelease()) {
					if (newarr[j].getName().compareTo(newarr[j + 1].getName()) > 0) {
						Movie temp = newarr[j];
						newarr[j] = newarr[j + 1];
						newarr[j + 1] = temp;
					}
				}
			}
		}
		return newarr;
	}

	private static Movie[] searchMoviesByGivenRating(float rating) {
		int count = 0;
		for (int i = 0; i < moviesCount; i++)
			if (movies[i].getRating() >= rating)
				count++;
		Movie[] newarr = new Movie[count];
		int j = 0;
		for (int i = 0; i < moviesCount; i++)
			if (movies[i].getRating() >= rating)
				newarr[j++] = movies[i];
		return newarr;
	}

	private static Movie[] searchMoviesByCasting(String cast) {
		int count = 0;
		for (int i = 0; i < moviesCount; i++) {
			for (int j = 0; j < movies[i].getCasting().length; j++) {
				if (movies[i].getCasting()[j].equals(cast))
					count++;
			}
		}
		Movie[] newarr = new Movie[count];
		int k = 0;
		for (int i = 0; i < moviesCount; i++) {
			for (int j = 0; j < movies[i].getCasting().length; j++) {
				if (movies[i].getCasting()[j].equals(cast))
					newarr[k++] = movies[i];
			}
		}
		return newarr;
	}

	private static Movie updateRatingById(int id) {
		for (int i = 0; i < moviesCount; i++) {
			if (movies[i].getId() == id) {
				System.out.println("Enter new rating to be updated: ");
				byte rating = in.nextByte();
				movies[i].setRating(rating);
				System.out.println("Movie rating got updated.");
				return movies[i];
			}
		}
		return null;
	}

	private static void displayAllMovies(Movie[] array) {
		for (int i = 0; i < array.length; i++)
			displayMovie(array[i]);
	}

	private static void displayMovie(Movie movie) {
		System.out.println("========================================");
		System.out.println("Movie id: " + movie.getId());
		System.out.println("Movie name: " + movie.getName());
		System.out.print("Movie casting: ");
		for (int i = 0; i < movie.getCasting().length - 1; i++)
			System.out.print(movie.getCasting()[i] + ", ");
		System.out.print(movie.getCasting()[movie.getCasting().length - 1]);
		System.out.println();
		System.out.println("Movie year of release: " + movie.getYearOfRelease());
		System.out.println("Movie rating: " + movie.getRating());
		System.out.println("========================================");
	}

	private static Movie[] deleteMovieById(int id) {
		Movie[] newarr = new Movie[moviesCount - 1];
		int j = 0;
		for (int i = 0; i < moviesCount; i++) {
			if (movies[i].getId() != id)
				newarr[j++] = movies[i];
		}
		moviesCount--;
		System.out.println("This movie got deleted.");
		return newarr;
	}

	private static void displayMenu() {
		System.out.println("---------------------------------------------------");
		System.out.println("1. Add new Movie in the system.");
		System.out.println("2. Sort movies based on year of release.");
		System.out.println("3. Display movie details by rating less than given rating.");
		System.out.println("4. Display movie details by given movie casting.");
		System.out.println("5. Update movie rating by given movie id.");
		System.out.println("6. Delete movie by given movie id.");
		System.out.println("7. Exit.");
		System.out.println("---------------------------------------------------");
	}
}
