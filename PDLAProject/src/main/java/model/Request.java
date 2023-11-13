package model;

public class Request {
    private final String idHelpSeeker;
    private String idVolunteer=null; //change value when request is accepted to know who took it
    private final String Date;
    private final String Location;
    private final String Description;

    public Request(String idHelpSeeker, String idVolunteer, String Date, String Location, String Description) {
        this.idHelpSeeker = idHelpSeeker;
        this.idVolunteer = idVolunteer;
        this.Date = Date;
        this.Location = Location;
        this.Description = Description;
    }

    public String getIdHelpSeeker() {return idHelpSeeker;}

    public String getIdVolunteer() {return idVolunteer;
    }

    public String getDate() {return Date;
    }

    public String getLocation() {return Location;
    }

    public String getDescription() {return Description;
    }

}
