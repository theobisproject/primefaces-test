package org.primefaces.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

@ManagedBean
public class CheckboxView {

    private List<SelectItem> cars;
    private String[] selectedCars;

    @PostConstruct
    public void init() {

        initCars(false);
    }

    private void initCars(final boolean disableGermanCars) {
        cars = new ArrayList<>();
        SelectItem[] germanCars = new SelectItem[] {
                new SelectItem("BMW", "BMW"),
                new SelectItem("Mercedes", "Mercedes"),
                new SelectItem("Volkswagen", "Volkswagen")
        };
        if (disableGermanCars) {
            for (SelectItem i : germanCars) {
                i.setDisabled(true);
            }
        }

        SelectItem[] americanCars = new SelectItem[]{
                new SelectItem("Chrysler", "Chrysler"),
                new SelectItem("GM", "GM"),
                new SelectItem("Ford", "Ford")
        };

        cars.addAll(Arrays.asList(germanCars));
        cars.addAll(Arrays.asList(americanCars));
    }

    public void disableGermanCars() {
        initCars(true);
    }

    public List<SelectItem> getCars() {
        return cars;
    }

    public void setCars(List<SelectItem> cars) {
        this.cars = cars;
    }

    public String[] getSelectedCars() {
        return selectedCars;
    }

    public void setSelectedCars(String[] selectedCars) {
        this.selectedCars = selectedCars;
    }
}
