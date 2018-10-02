package com.virtualpairprogrammers.services;


import java.util.List;
import com.virtualpairprogrammers.dao.CarDAO;
import com.virtualpairprogrammers.domain.Car;
import com.virtualpairprogrammers.genericclass.Reference;

public class CarService
{
    private CarDAO carDAO;

    public CarService() {
        this.carDAO = new CarDAO();
    }


    public boolean addcar(Car car, Reference<List<Car>> carlist)
    {
        boolean result = this.carDAO.addcar(car);
        carlist.get().add(car);
        return result;
    }

    public boolean removecar(int id_car, Reference<List<Car>> carlist){
        boolean result =  this.carDAO.removecar(id_car);

        for( Car itemcar : carlist.get()) {
            if(itemcar.getId_car() == id_car)
            {
                carlist.get().remove(itemcar);
                break;
            }
        }
        return result;
    }



    public List<Car> getAllCarModel(String username,boolean force) {
        return this.carDAO.getAllCarModel(username,force);
    }

    public Car getCar(int id_car,boolean force){
        return this.carDAO.getCar(id_car,force);
    }
}

