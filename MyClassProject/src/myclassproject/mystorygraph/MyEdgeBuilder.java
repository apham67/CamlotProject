package myclassproject.mystorygraph;
 
import static myclassproject.umlclasses.All.*;
 
 
import java.util.List;
 
import com.playerInput.*;
import com.playerInput.PlayerInteraction.Icons;
import com.storygraph.BuilderMethod;
import com.storygraph.Edge;
import com.storygraph.NodeBuilder;
import com.storygraph.Node;
 
import java.util.List;
import com.actions.*;
import com.sequences.*;
import com.storygraph.*;
 
import myclassproject.questexample.ChoiceLabels;
import myclassproject.questexample.NodeLabels;
 
public class MyEdgeBuilder extends NodeBuilder {
                /**
                * Initializes the list of story graph nodes.
                * @param list A list of all story graph nodes.
                */
                public MyEdgeBuilder(List<Node> list) {
                                super(list);
                }
 
                /**
                * Write a method for each node.
                 * Use get to get a reference to the node using its label.
                * The method should add the edges of the node one by one.
                 * These methods must have a BuilderMethod annotation.
                */
                //@BuilderMethod
                //public void rootEdges() {
                                //Example:
                                //var root = get(MyNodeLabels.root.toString());
                                //var choice = new MenuChoice(MenuChoice.Options.Start);
                                //var nextNode = get(MyNodeLabels.atCottage.toString());
                                //root.add(new Edge(choice, nextNode));
                //}
               
                @BuilderMethod
                public void rootEdges() {
                                var node = get(MyNodeLabels.root.toString());
                                var choice = new MenuChoice(MenuChoice.Options.Start);
                                var nextNode = get(MyNodeLabels.castleBedroom.toString());
                                node.add(new Edge(choice, nextNode));
                }
                @BuilderMethod
                public void castleBedroomEdge() {
                                var node = get(MyNodeLabels.castleBedroom.toString());
                                var choice = new PlayerInteraction(MyChoiceLabels.KingApproach.toString(), king, Icons.talk,
                                                                "King gives player a quest");
                                var nextNode = get(MyNodeLabels.talkToKing.toString());
                                node.add(new Edge(choice, nextNode));
                }
               
                @BuilderMethod
                public void talkToKingEdges() {
                                var node = get(MyNodeLabels.talkToKing.toString());
                                               
                                var choice1 = new DialogChoice("I agree to your orders");
                                var nextNode1 = get(MyNodeLabels.agree.toString());
                                node.add(new Edge(choice1, nextNode1));
 
                                var choice2 = new DialogChoice("I regect your orders");
                                var nextNode2 = get(MyNodeLabels.reject.toString());
                                node.add(new Edge(choice2, nextNode2));
                }
                               
                @BuilderMethod
                public void rejectEdge() {
                                //Figure out what to do for this
                                //make sure to do this part of the chart
                                var node = get(MyNodeLabels.reject.toString());
                                var choice = new PlayerInteraction(MyChoiceLabels.AttackKnight.toString(), myPlayer, Icons.die(myPlayer), "You have been killed");
                                var nextNode = get(MyNodeLabels.root.toString());
                                node.add(new Edge(choice, nextNode));
               
                }
               
                @BuilderMethod //figure out what goes where the idk is, what do we reference as player
                public void agreeEdge() {
                                var node = get(MyNodeLabels.agree.toString());
                                var choice = new PlayerInteraction(MyChoiceLabels.GoToCity.toString(), castleExit, Icons.exit, "Go to City");
                                var nextNode = get(MyNodeLabels.goesToCity.toString());
                                node.add(new Edge(choice, nextNode));
                }
                @BuilderMethod
                public void goesToCityEdge() {
                                var node = get(MyNodeLabels.goesToCity.toString());
                               
                                var choice1 = new PlayerInteraction(MyChoiceLabels.GoToBlacksmith.toString(), blacksmithDoor, Icons.door, "Go to Blacksmith to prepare for witch");
                                var nextNode1 = get(MyNodeLabels.goesToBlacksmith.toString());
                                node.add(new Edge(choice1, nextNode1));
                               
                                var choice2 = new PlayerInteraction(MyChoiceLabels.GoToStorage.toString(), storageDoor, Icons.door, "Go to Storage to prepare for witch");
                                var nextNode2 = get(MyNodeLabels.goesToStorage.toString());
                                node.add(new Edge(choice2, nextNode2));
                }
               
                @BuilderMethod
                public void goesToBlacksmithEdge() {
                                var node = get(MyNodeLabels.goesToBlacksmith.toString());
                               
                                var choice1 = new PlayerInteraction(MyChoiceLabels.WalkAroundShop.toString(), sword, Icons.sword, "Picking up sword");
                                var nextNode1 = get(MyNodeLabels.pickUpSword.toString());
                                node.add(new Edge(choice1, nextNode1));
                               
                                var choice2 = new PlayerInteraction(MyChoiceLabels.TalkToMerchant.toString(), merchant, Icons.listen, "You should buy the sword! It is a great weapon!");
                                var nextNode2 = get(MyNodeLabels.talksToMerchant.toString());
                                node.add(new Edge(choice2, nextNode2));
                }
                @BuilderMethod
                public void pickUpSwordEdge() {
                                var node = get(MyNodeLabels.pickUpSword.toString());
                                var choice = new PlayerInteraction(ChoiceLabels.TakeOutCoinsToBuy1.toString(), merchant, Icons.coins, "Paying the merchant");
                                var nextNode = get(MyNodeLabels.buySword.toString());
                                node.add(new Edge(choice, nextNode));
                }
               
                @BuilderMethod
                public void talksToMerchantEdge() {
                                var node = get(MyNodeLabels.talksToMerchant.toString());
                                var choice = new PlayerInteraction(myPlayer, MyChoiceLabels.TakeOutCoinsToBuy2.toString(), merchant, Icons.coins);
                                var nextNode = get(MyNodeLabels.buySword.toString());
                                node.add(new Edge(choice, nextNode));
                               
                }
                //should there be a node to receive sword
               
                @BuilderMethod
                public void buySwordEdge() {
                                var node = get(MyNodeLabels.buySword.toString());
                                var choice = new PlayerInteraction(MyChoiceLabels.PickUpSword.toString(), sword, Icons.sword, "Your weapon...a sword");
                                var nextNode = get(MyNodeLabels.exitBlacksmith.toString());
                                node.add(new Edge(choice, nextNode));		
                }
               
                @BuilderMethod
                public void exitBlacksmithEdge() {
                                var node = get(MyNodeLabels.exitBlacksmith.toString());
                               
                                var choice = new PlayerInteraction(MyChoiceLabels.ToCityAfterBlacksmith.toString(), blacksmithExitDoor, Icons.exit, "Exit the blacksmith");
                                var nextNode = get(MyNodeLabels.backAtCityAfterBlacksmith.toString());
                                node.add(new Edge(choice, nextNode));
                }
               
                public void backAtCityAfterBlacksmithEdge() {
                                var node = get(MyNodeLabels.backAtCityAfterBlacksmith.toString());
                               
                                var choice = new PlayerInteraction(MyChoiceLabels.GoToLibrary.toString(), libraryEntranceDoor, Icons.door, "I think the witch might be in the library");
                                var nextNode = get(MyNodeLabels.library.toString());
                                node.add(new Edge(choice, nextNode));
                }
               
               
                @BuilderMethod
                public void libraryEdge() {
                                var node = get(MyNodeLabels.library.toString());
                               
                                var choice = new PlayerInteraction(MyChoiceLabels.AttackWitchAtLibrary.toString(), blacksmithdoor, Icons.door, "");
                                var nextNode = get(MyNodeLabels.attackWitchAtLib.toString());
                                node.add(new Edge(choice, nextNode));
                }
                //below need to implement the right side of the graph
                @BuilderMethod
                public void goesToStorageEdge() {
                                var node = get(MyNodeLabels.goesToStorage.toString());
                                var choice = new PlayerInteraction(MyChoiceLabels.OpenChest.toString(), chest, Icons.usekey, "Go open the chest");
                                var nextNode = get(MyNodeLabels.openBlueChest.toString());
                                node.add(new Edge(choice, nextNode));
                }
                //below are rest of nodes haven't done
				@BuilderMethod
                public void openBlueChestEdge() {
								var node = get(MyNodeLabels.openBlueChest.toString());
								var choice = new PlayerInteraction(MyChoiceLabels.PickUpBook.toString(), blueBook, Icons.book, "Picks up book from chest");
								var nextNode = get(MyNodeLabels.takeBook.toString());
								node.add(new Edge(choice, nextNode));
				}
                
				@BuilderMethod
                public void takeBookEdge() {
								var node = get(MyNodeLabels.takeBook.toString());
								var choice = new PlayerInteraction(MyChoiceLabels.ToCityAfterChest.toString(), storageExitDoor, Icons.door, "Exit storage and go back to city");
								var nextNode = get(MyNodeLabels.backToCityAfterChest.toString());
								node.add(new Edge(choice, nextNode));
				}

				@BuilderMethod
				public void backToCityAfterChestEdge() {
					var node = get(MyNodeLabels.backToCityAfterChest.toString());
					var choice = new PlayerInteraction(MyChoiceLabels.GoToWestEnd.toString(), westEnd, Icons.forest, "Enters west end");
					var nextNode = get(MyNodeLabels.westEnd.toString());
					node.add(new Edge(choice, nextNode));
				}
                
				@BuilderMethod
				public void westEndEdge() {
					var node = get(MyNodeLabels.westEnd.toString());
					var choice1 = new PlayerInteraction(MyChoiceLabels.GoToBlueHouse.toString(), blueHouseDoor, Icons.door, "Enters Blue House");
					var nextNode1 = get(MyNodeLabels.blueHouse.toString());
					node.add(new Edge(choice1, nextNode1));

					var choice2 = new PlayerInteraction(MyChoiceLabels.OpenBlueBook.toString(), blueBook, Icons.research, "Opens and inpects the blue book");
					var nextNode2 = get(MyNodeLabels.openBlueBook.toString());
					node.add(new Edge(choice2, nextNode2));
				}
                
				@BuilderMethod
				public void blueHouseEdge() {
					var node = get(MyNodeLabels.blueHouse.toString());
					var choice = new PlayerInteraction(MyChoiceLabels.GoToDiningHall.toString(), leftDoor, Icons.door, "Enters the dinning hall");
					var nextNode = get(MyNodeLabels.diningRoom.toString());
					node.add(new Edge(choice, nextNode));
				}
                
				@BuilderMethod
				public void diningRoomEdge() {
					var node = get(MyNodeLabels.diningRoom.toString());
					var choice = new PlayerInteraction(MyChoiceLabels.DrinkWater.toString(), bottle, Icons.drink, "Thirsty so drinks bottle from dinning room");
					var nextNode = get(MyNodeLabels.dieFromWater.toString());
					node.add(new Edge(choice, nextNode));
				}
                
				@BuilderMethod
				public void dieFromWaterEdge() {
					var node = get(MyNodeLabels.dieFromWater.toString());
					var choice = new PlayerInteraction(MyChoiceLabels.TryAgainWater.toString(), myPlayer, Icons.die(myPlayer), "You have been poissoned");
                    var nextNode = get(MyNodeLabels.root.toString());
					node.add(new Edge(choice, nextNode));
				}
                
				@BuilderMethod
				public void openBlueBook() {
					var node = get(MyNodeLabels.openBlueBook.toString());
					var choice = new PlayerInteraction(MyChoiceLabels.GoToForest.toString(), eastEnd, Icons.forest, "Exits East end to get to forest");
					var nextNode = get(MyNodeLabels.forestPath.toString());
					node.add(new Edge(choice, nextNode));
				}
               
				@BuilderMethod
				public void forestPathEdge() {
					var node = get(MyNodeLabels.forestPath.toString());
					var choice = new PlayerInteraction(MyChoiceLabels.GoToSpooky.toString(), eastEnd, Icons.forest, "Continue East to get to spooky path");
					var nextNode = get(MyNodeLabels.spookyPath.toString());
					node.add(new Edge(choice, nextNode));
				}
               
				@BuilderMethod
				public void spookyPathEdge() {
					var node = get(MyNodeLabels.spookyPath.toString());
					var choice = new PlayerInteraction(MyChoiceLabels.AttackWitchAtSpooky.toString(), sword, Icons.draw, "Draws sword and attact witch");
					var nextNode = get(MyNodeLabels.attackWitchAtSpooky.toString());
					node.add(new Edge(choice, nextNode));
				}
                
				@BuilderMethod
				public void attackWitchAtSpookyEdge() {
					var node = get(MyNodeLabels.attackWitchAtSpooky.toString());
					var choice = new PlayerInteraction(MyChoiceLabels.PlayAgainSpooky.toString(), witch, Icons.hurt, "The witch dies. Player win.");
					var nextNode = get(MyNodeLabels.root.toString());
					node.add(new Edge(choice, nextNode));
				}
}


Reply


Forward
Attendee panel closed
