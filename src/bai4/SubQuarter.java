package bai4;

import java.util.ArrayList;
import java.util.List;

public class SubQuarter {

    List<Family> subQuarter;

    public SubQuarter() {
        this.subQuarter = new ArrayList<>();
    }

    public List<Family> getSubQuarter() {
        return subQuarter;
    }

    public void setSubQuarter(List<Family> subQuarter) {
        this.subQuarter = subQuarter;
    }

    public void addFamily(Family family) {
        this.subQuarter.add(family);
    }
}
