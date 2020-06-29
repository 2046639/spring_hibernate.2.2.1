package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

//      UserService userService = context.getBean(UserService.class, CarService.class);
      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }


      //Создание пользователя и помещение его в таблицу
//      User harry = new User("Harry", "Potter", "email@mail.ru");
//      Car car1 = new Car("toyota", 123);
//      harry.setCar(car1);
//      userService.add(harry);

      User brad = new User("Brad", "Pitt", "pitt@mail.ru");
      Car car1 = new Car("lexus", 321);
      brad.setCar(car1);
      userService.add(brad);

      String carName = "lexus";
      int carSeries = 321;


//       Извлечение пользователя по имени машины и номеру
//      String carName = "toyota";
//      int carSeries = 123;
//
      User user = userService.getUserForCarNameAndSeries(carName, carSeries);
      System.out.println("User of car " + carName + " " + carSeries + " is: " + user.toString());

      context.close();
   }
}
