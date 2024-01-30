package org.example;

public class Staff {
    private String id;
    private String Vadim;
    private String Vsenko;
    private String Nikolaevich;
    private int Department; //Отдел
    private int ZP;

    public Staff() {

    }

    public String getId() {
        return id;
    }

    public String getVadim() {
        return Vadim;
    }

    public String getVsenko() {
        return Vsenko;
    }

    public String getNikolaevich() {
        return Nikolaevich;
    }

    public int getDepartment() {
        return Department;
    }

    public int getZP() {
        return ZP;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVadim(String vadim) {
        Vadim = vadim;
    }

    public void setVsenko(String vsenko) {
        Vsenko = vsenko;
    }

    public void setNikolaevich(String nikolaevich) {
        Nikolaevich = nikolaevich;
    }

    public void setDepartment(int department) {
        Department = department;
    }

    public void setZP(int ZP) {
        this.ZP = ZP;
    }

    public Staff(String vadim, String vsenko, String nikolaevich, int department, int ZP) {
        Vadim = vadim;
        Vsenko = vsenko;
        Nikolaevich = nikolaevich;
        Department = department;
        this.ZP = ZP;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id='" + id + '\'' +
                ", Vadim='" + Vadim + '\'' +
                ", Vsenko='" + Vsenko + '\'' +
                ", Nikolaevich='" + Nikolaevich + '\'' +
                ", Department=" + Department +
                ", ZP=" + ZP +
                '}';
    }
}
