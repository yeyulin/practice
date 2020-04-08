package com.jvm.abstracts;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yeyulin
 * @description:
 * @date 2019/11/12 10:19
 * @since 2.0.7
 **/
@Component
public class InspectionSolverChooser implements ApplicationContextAware {
    private Map<String, InspectionSolver> chooseMap = new ConcurrentHashMap<>();
    public InspectionSolver choose(String type){
        return chooseMap.get(type);
    }
    @PostConstruct
    public void register(){
        Map<String, InspectionSolver> beansOfType = applicationContext.getBeansOfType(InspectionSolver.class);
        Collection<InspectionSolver> solvers = beansOfType.values();
        for (InspectionSolver solver : solvers) {
            String[] supports = solver.supports();
            for (String support : supports) {
                chooseMap.put(support,solver);
            }
        }
    }
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext=applicationContext;
    }
}
