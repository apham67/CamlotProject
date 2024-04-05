package myclassproject.umlclasses;

import com.entities.Character;
import com.enums.BodyTypes;
import com.enums.Clothing;
import com.enums.HairStyle;
import com.enums.Colors;

public class MyCharacter extends Character {
    private String name;
    private BodyTypes bodyTypes;
    private Clothing clothing;
    private HairStyle hairStyle;
    private Colors hairColor;
    private int skinColor;

    public MyCharacter(String name){
        this.name = name;
    }

    public MyCharacter(String name, BodyTypes bodyTypes){
        this.name = name;
        this.bodyTypes = bodyTypes;
    }

    public MyCharacter(String name, BodyTypes bodyTypes, Clothing clothing, HairStyle hairStyle, Colors hairColor, int skinColor){
        this.name = name; 
        this.bodyTypes = bodyTypes;
        this.clothing = clothing;
        this.hairStyle = hairStyle;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
    }

    public Clothing getClothing(){
        return clothing;
    }

    public int getSkinColor(){
        return skinColor;
    }

    public HairStyle getHairStyle(){
        return hairStyle;
    }

    public Colors getHairColor(){
        return hairColor;
    }


}
