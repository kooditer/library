package model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private ArrayList raamatud;

    public Database() {
        raamatud = new ArrayList<Raamat>();
    }

    public void addRaamat(Raamat raamat) {
        raamatud.add(raamat);
    }

    public List<Raamat> getRaamatud() {
        return raamatud;
    }
}
