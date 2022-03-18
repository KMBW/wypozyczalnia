package wypozyczalnia.application;

import wypozyczalnia.database.CSVRentingFileDatabase;
import wypozyczalnia.model.RentingPosition;

public class RentingPositionService {
    CSVRentingFileDatabase csvRentingFileDatabase;

    public RentingPositionService() {
        csvRentingFileDatabase = CSVRentingFileDatabase.getInstance("rentingPosition.csv");
    }

    public void rentCar(RentingPosition rentingPosition){
        //to sie uzupelni potem elo, zasady sprawdzajace dla naszego modelu biznesowego
        csvRentingFileDatabase.saveRentingPosition(rentingPosition);
    }
}
