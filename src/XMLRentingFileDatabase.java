import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

class XMLRentingFileDatabase {

    private static XMLRentingFileDatabase xmlRentingFileDatabase;
    private String fileName;

    private XMLRentingFileDatabase(String fileName) {
        this.fileName = fileName;
    }

    public static XMLRentingFileDatabase getInstance(String fileName) {
        if(xmlRentingFileDatabase == null) {
            xmlRentingFileDatabase = new XMLRentingFileDatabase(fileName);
        }
        return xmlRentingFileDatabase;
    }


    public void saveRentingPosition(RentingPosition position) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(position.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class RentingPosition {

    private int id;
    private String carName;
    private LocalDateTime startRentDate;
    private LocalDateTime endtRentDate;
    private int cost;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public LocalDateTime getStartRentDate() {
        return startRentDate;
    }

    public void setStartRentDate(LocalDateTime startRentDate) {
        this.startRentDate = startRentDate;
    }

    public LocalDateTime getEndtRentDate() {
        return endtRentDate;
    }

    public void setEndtRentDate(LocalDateTime endtRentDate) {
        this.endtRentDate = endtRentDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "RentingPosition{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", startRentDate=" + startRentDate +
                ", endtRentDate=" + endtRentDate +
                ", cost=" + cost +
                '}';
    }
}