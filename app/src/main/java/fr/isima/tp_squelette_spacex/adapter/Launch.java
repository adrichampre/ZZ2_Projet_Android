package fr.isima.tp_squelette_spacex.adapter;

import java.io.Serializable;

public class Launch implements Serializable {

    public String mission_name;
    public LaunchInfoRocket rocket;
    public Long launch_date_unix;
    public Links links;
}
