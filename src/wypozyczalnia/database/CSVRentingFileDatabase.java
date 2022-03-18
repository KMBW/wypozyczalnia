package wypozyczalnia.database;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import wypozyczalnia.model.RentingPosition;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVRentingFileDatabase {

    private static CSVRentingFileDatabase csvRentingFileDatabase;
    private String fileName;

    private CSVRentingFileDatabase(String fileName) {
        this.fileName = fileName;
    }

    public static CSVRentingFileDatabase getInstance(String fileName) {
        if(csvRentingFileDatabase == null) {
            csvRentingFileDatabase = new CSVRentingFileDatabase(fileName);
        }
        return csvRentingFileDatabase;
    }


    public void saveRentingPosition(RentingPosition position) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(position.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<RentingPosition>  loadAllRentingPositions(int id) {
        try (CSVReader reader = new CSVReader(new FileReader("file.csv"))) {
            List<String[]> r = reader.readAll();
            r.forEach(x -> System.out.println(Arrays.toString(x)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<RentingPosition> rentingPositions = r.stream()
                .map((p) -> new RentingPosition(p.))
                .collect(Collectors.toList());

        return new RentingPosition(r) {

        }
    }
}


