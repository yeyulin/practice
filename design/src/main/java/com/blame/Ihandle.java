package com.blame;

public abstract class Ihandle {
    protected  Ihandle nextIhandle;
    private Long level;
    public Ihandle(Long level) {
        this.level = level;
    }

    protected boolean islevel(Long money){
        if(this.level>=money){
            return true;
        }
        return false;
    }
    protected void setNextHandle(Ihandle ihandle){
        this.nextIhandle =ihandle;
    }
    protected abstract void handle(Whoring whoring);

    /**
     * 处理请求
     * @param whoring
     */
    public void handleMessage(Whoring whoring){
        if(this.islevel(whoring.getMoney())){
            this.handle(whoring);
        }else{
            if(this.nextIhandle!=null){
                this.nextIhandle.handleMessage(whoring);
            }else{
                System.out.println("责任链结束");
            }
        }
    }
}
