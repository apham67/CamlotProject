package myclassproject.umlclasses;

import com.enums.Places;

public class MyPlace extends Place {
    private String name;
    private Places template;

    public MyPlace(String name, Places template){
        this.name = name;
        this.template = template;
    } 
    
    
}
