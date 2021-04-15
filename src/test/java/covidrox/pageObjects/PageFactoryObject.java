package covidrox.pageObjects;

import org.openqa.selenium.WebDriver;

public class PageFactoryObject {

   PopularCinemasPage popularCinemasPage;
   MovieDetailsPage movieDetailsPage;
   UpcomingCinemasPage upcomingCinemasPage;


    /*** Getters ***/

    public PopularCinemasPage getPopularCinemasPage() {
        return popularCinemasPage;
    }

    public MovieDetailsPage getMovieDetailsPage() {
        return movieDetailsPage;
    }

    public UpcomingCinemasPage getUpcomingCinemasPage() {
        return upcomingCinemasPage;
    }




    public PageFactoryObject(WebDriver driver){

        popularCinemasPage = new PopularCinemasPage(driver);
        movieDetailsPage = new MovieDetailsPage(driver);
        upcomingCinemasPage = new UpcomingCinemasPage(driver);

    }





}
