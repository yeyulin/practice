package com.uml;

/**
 * @author yeyulin
 * @description:
 * @date 2020/1/17 15:09
 * @since 2.2
 **/
public class Store {
    private Bus bus;
    private Cycle cycle;

    public Store() {
        this.bus = new Bus();
        this.cycle = new Cycle();
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Cycle getCycle() {
        return cycle;
    }

    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }
    public boolean checkBusNumber(Bus bus){
        return true;
    }
    public boolean checkCycleNumber(Cycle cycle){
        return true;
    }
    public Bus getSUV(){
        bus=new SUV();
        return bus;
    }
}
