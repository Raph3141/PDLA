public class Database {
public String createTableUsers() {
    String createUser = "CREATE TABLE IF NOT EXISTS Users ("
            + "idUsers VARCHAR(20) PRIMARY KEY,"
            + "firstName VARCHAR(20) NOT NULL,"
            + "lastName VARCHAR(20) NOT NULL,"
            + "email VARCHAR(40) NOT NULL,"
            + "password VARCHAR(20) NOT NULL"
            + ")";
    return createUser;

    public String createTableHelp_Seeker () {
        String createHelp_Seeker = "CREATE TABLE IF NOT EXISTS Help_Seekers ("
                + "idUsers VARCHAR(20) REFERENCES Users(idUsers) ON DELETE CACASDE"
                + ")";
        return createHelp_Seeker;
    }

    public String createTableVolunteer () {
        String createVolunteer = "CREATE TABLE IF NOT EXISTS Volunteers ("
                + "idUsers VARCHAR(20) REFERENCES Users(idUsers) ON DELETE CACASDE"
                + ")";
        return createVolunteer;
    }
}