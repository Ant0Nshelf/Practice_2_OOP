import java.util.List;

public class Main {
    public static void main(String[] args) {
        TrainSchedule schedule = new TrainSchedule();

        // Додавання декількох поїздів до розкладу
        schedule.addTrain(new Train("Київ", 101, "08:00", 200, 50, 150));
        schedule.addTrain(new Train("Львів", 102, "09:30", 150, 30, 120));
        schedule.addTrain(new Train("Одеса", 103, "10:45", 180, 40, 140));

        // Вивід списку поїздів за різними критеріями
        System.out.println("Поїзди до Львова:");
        List<Train> trainsToLviv = schedule.getTrainsByDestination("Львів");
        printTrainList(trainsToLviv);

        System.out.println("\nПоїзди до Львова після 09:00:");
        List<Train> trainsToLvivAfterNine = schedule.getTrainsByDestinationAndTime("Львів", "09:00");
        printTrainList(trainsToLvivAfterNine);

        System.out.println("\nПоїзди з загальними місцями до Києва:");
        List<Train> trainsToKyivWithGeneralSeats = schedule.getTrainsWithGeneralSeats("Київ");
        printTrainList(trainsToKyivWithGeneralSeats);
    }

    private static void printTrainList(List<Train> trains) {
        for (Train train : trains) {
            System.out.println("Поїзд " + train.getTrainNumber() +
                    " до " + train.getDestination() +
                    " відправляється о " + train.getDepartureTime());
        }
    }
}
