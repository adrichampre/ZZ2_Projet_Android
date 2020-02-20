package fr.isima.tp_squelette_spacex.ws;

import fr.isima.tp_squelette_spacex.model.Launch;
import fr.isima.tp_squelette_spacex.model.Rocket;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface SpaceXService{
    @GET("launches")
    Call<List<Launch>> listLaunches();

    @GET("rockets")
    Call<List<Rocket>> listRockets();
}