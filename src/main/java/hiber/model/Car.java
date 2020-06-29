package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars") // Это зависимая таблица
public class Car {
    //Хорошо бы добавить// public class Car implements Serializable
    // private static final long serialVersionUID = -5527566248002296042L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "name")//можно не указывать Column name, если оно совпадает с названием столбца в таблице
    private String name;

    @Column(name = "series")
    private Integer series;

    //mappedBy = "car" - это указание на поле главного класса User и его переменную car

    // В подчиненном классе, который не владеет связью в аннотации небходимо указать настройку mappedBy
//    @OneToOne (optional=false, mappedBy="car")
    @OneToOne(mappedBy = "car")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car() {
    }

    public Car(Long carId, String name, Integer series) {
        this.carId = carId;
        this.name = name;
        this.series = series;
    }
    //
    public Car(String name, Integer series) {
        this.name = name;
        this.series = series;
    }
    //

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", name='" + name + '\'' +
                ", series=" + series +
                "}";
    }


}
