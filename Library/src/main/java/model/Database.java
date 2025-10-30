package model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Database {
    private List<Raamat> raamatud;

    public Database() {
        raamatud = new LinkedList<Raamat>();
    }

    public void addRaamat(Raamat raamat) {
        raamatud.add(raamat);
    }

    public List<Raamat> getRaamatud() {
        return raamatud;
    }

    public void kustutaRaamat(int index) {
        raamatud.remove(index);
    }
}
