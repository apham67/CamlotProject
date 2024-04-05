package myclassproject.umlclasses;

import com.entities.Character;
import com.entities.Furniture;
import com.entities.Item;
import com.entities.Place;
import com.enums.BodyTypes;
import com.enums.Clothing;
import com.enums.Colors;
import com.enums.FurnitureTypes;
import com.enums.HairStyle;
import com.enums.Items;
import com.enums.Places;

public final class All {
	public static final Character player = new MyCharacter("Player", BodyTypes.D, Clothing.Peasant, HairStyle.Short, Colors.Black, 6);
	public static final Character bandit = new MyCharacter("Bandit", BodyTypes.F, Clothing.Bandit, HairStyle.Bald, Colors.Black, 4);
	public static final Place cottage = new MyPlace("Home", Places.Cottage);
	public static final Place town = new MyPlace("Town", Places.City);
	public static final Item sword = new MyItem("Sword", Items.Sword);
	public static final Furniture cottageDoor = new MyFurniture(cottage, FurnitureTypes.Door);
	public static final Furniture table = new MyFurniture(cottage, FurnitureTypes.Table);
	public static final Furniture chair = new MyFurniture(cottage, FurnitureTypes.Chair);
	public static final Furniture cityDoor = new MyFurniture(town, FurnitureTypes.RedHouseDoor);
	public static final Furniture cityExit = new MyFurniture(town, FurnitureTypes.NorthEnd);
	
	//     cottage, town, city, blacksmith, storage, library, castle, greatHall, sword, blueBook, bottle


	//create our objects !!!!!!!!

	public static final Character myPlayer = new MyCharacter("Knight", BodyTypes.B, Clothing.HeavyArmour, HairStyle.Short, Colors.Black, 6);
	public static final Character king = new MyCharacter("King", BodyTypes.D, Clothing.King, HairStyle.Short_Full, Colors.Grey, 4);
	public static final Character merchant = new MyCharacter("Merchant", BodyTypes.F, Clothing.Merchant, HairStyle.Bald, Colors.Black, 4);
	public static final Character witch = new MyCharacter("Witch", BodyTypes.H, Clothing.Witch, HairStyle.Long, Colors.Red, 4);
	public static final Place city = new MyPlace("Town", Places.City);
	public static final Place blacksmith = new MyPlace("Blacksmith", Places.Blacksmith);
	public static final Place storage = new MyPlace("Storage", Places.Storage);
	public static final Place library = new MyPlace("Library", Places.Library);
	public static final Place castle = new MyPlace("Library", Places.CastleBedroom);
	public static final Place greatHall = new MyPlace("GreatHall", Places.GreatHall);
	public static final Furniture castleExit = new MyFurniture(castle, FurnitureTypes.Door);
	public static final Furniture blacksmithDoor = new MyFurniture(city, FurnitureTypes.BrownHouseDoor);
	public static final Furniture blacksmithExitDoor = new MyFurniture(blacksmith, FurnitureTypes.Door);
	public static final Furniture storageDoor = new MyFurniture(city, FurnitureTypes.RedHouseDoor);
	public static final Furniture storageExitDoor = new MyFurniture(storage, FurnitureTypes.Door);
	public static final Furniture libraryEntranceDoor = new MyFurniture(library, FurnitureTypes.GreenHouseDoor);
	public static final Furniture chest = new MyFurniture(storage, FurnitureTypes.Chest);
	public static final Furniture westEnd = new MyFurniture(city, FurnitureTypes.WestEnd);
	public static final Furniture eastEnd = new MyFurniture(city, FurnitureTypes.EastEnd);
	public static final Furniture blueHouseDoor = new MyFurniture(city, FurnitureTypes.BlueHouseDoor);
	public static final Furniture leftDoor = new MyFurniture(greatHall, FurnitureTypes.LeftDoor);
	public static final Item blueBook = new MyItem("BlueBook", Items.BlueBook);
	public static final Item bottle = new MyItem("Bottle", Items.Bottle);






