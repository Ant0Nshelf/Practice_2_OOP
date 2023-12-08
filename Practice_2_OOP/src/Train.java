import java.util.ArrayList;
import java.util.List;

class Train {
    private String destination;
    private int trainNumber;
    private String departureTime;
    private int totalSeats;
    private int coupeSeats;
    private int reservedSeats;

    public Train(String destination, int trainNumber, String departureTime,
                 int totalSeats, int coupeSeats, int reservedSeats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.totalSeats = totalSeats;
        this.coupeSeats = coupeSeats;
        this.reservedSeats = reservedSeats;
    }

    public String getDestination() {
        return destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getCoupeSeats() {
        return coupeSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }
}

class TrainSchedule {
    private List<Train> trains = new ArrayList<>();

    public void addTrain(Train train) {
        trains.add(train);
    }

    public List<Train> getTrainsByDestination(String destination) {
        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination)) {
                result.add(train);
            }
        }
        return result;
    }

    public List<Train> getTrainsByDestinationAndTime(String destination, String afterTime) {
        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination) &&
                    train.getDepartureTime().compareTo(afterTime) > 0) {
                result.add(train);
            }
        }
        return result;
    }

    public List<Train> getTrainsWithGeneralSeats(String destination) {
        List<Train> result = new ArrayList<>();
        for (Train train : trains) {
            if (train.getDestination().equalsIgnoreCase(destination) &&
                    train.getTotalSeats() > 0) {
                result.add(train);
            }
        }
        return result;
    }
}