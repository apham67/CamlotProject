package myclassproject.mystorygraph;

import java.util.List;

import static myclassproject.umlclasses.All.*;

import com.actions.*;
import com.sequences.*;
import com.storygraph.*;

import myclassproject.questexample.NodeLabels;

public class MyNodeBuilder extends NodeBuilder {
	public MyNodeBuilder(List<Node> list) {
		super(list);
	}

	/**
	 * Write a method for each node. 
	 * Use get to get a reference to the node using its label.
	 * The method adds Camelot actions that execute in order when visiting that node. 
	 * These methods must have a BuilderMethod annotation.
	 */
	@BuilderMethod
	public void rootActions() {
		var root = get(NodeLabels.root.toString());
		root.add(new CreateAll(List.of(cottage, town, city, blacksmith, storage, library, castle, greatHall, dinningHall, spookypath, sword, blueBook, bottle)))
				.add(new CreateCharacterSequence(myPlayer))
				.add(new CreateCharacterSequence(king))
				.add(new CreateCharacterSequence(merchant))
				.add(new CreateCharacterSequence(witch))
				.add(new SetPosition(myPlayer, city, "?"))
				.add(new SetPosition(king, city))
				.add(new SetPosition(merchant, blacksmith))
				.add(new SetPosition(witch, spookypath))
				.add(new SetPosition(sword, blacksmith))
				.add(new SetPosition(blueBook, storage))
				.add(new SetPosition(bottle, dinningHall))
				.add(new Face(bandit, player))
				.add(new Draw(bandit, sword))
				.add(new SetCameraFocus(myPlayer))
				.add(new ShowMenu());
	}

	@BuilderMethod
	public void castleBedroomActions() {
		var node = get(NodeLabels.castleBedroom.toString());
		node.add(new HideMenu())
			.add(new EnableInput());
	}

	@BuilderMethod
	public void talkToKingActions() {
		var node = get(NodeLabels.talkToKing.toString());
		node.add(new DialogSequence(myPlayer, king, List.of("Will you accept the quest?"),
				List.of("I will!", "I refuse!")));
	}

	@BuilderMethod
	public void agreeActions() {
		var node = get(NodeLabels.agree.toString());
		node.add(new HideDialog())
			.add(new Take(myPlayer, coins, king));
	}

	@BuilderMethod
	public void rejectActions() {
		var node = get(NodeLabels.reject.toString());
		node.add(new HideDialog())
			.add(new NarrationSequence("You are killed for rejecting the king."));
	}

	@BuilderMethod
	public void playAgainActions() {
		var node = get(NodeLabels.reset.toString());
		node.add(new HideNarration())
			.add(new FadeOut())
			.add(new SetPosition(myPlayer, city))
			.add(new ShowMenu())
			.add(new FadeIn());
	}

	@BuilderMethod
	public void goesToCityActions() {
		var node = get(NodeLabels.goesToCity.toString());
		node.add(new DisableInput())
			.add(new Exit(myPlayer, castleExit, true))
			.add(new Enter(myPlayer, cityDoor, true))
			.add(new EnableInput());
	}

	@BuilderMethod
	public void goesToBlacksmithActions() {
		var node = get(NodeLabels.goesToBlacksmith.toString());
		node.add(new DisableInput())
			.add(new Enter(myPlayer, blacksmithDoor, true))
			.add(new EnableInput())
			.add(new SetPosition(witch, library));
	}

	@BuilderMethod
	public void pickUpSwordActions() {
		var node = get(NodeLabels.pickUpSword.toString());
		node.add(new DisableInput())
			.add(new Pickup(myPlayer, sword, table))
			.add(new DisableInput())
			.add(new Give(myPlayer, coins, merchant))
			.add(new EnableInput())
			.add(new ListSequence(player, List.of(sword)));
	}

	@BuilderMethod
	public void talksToMerchantActions() {
		var node = get(NodeLabels.talksToMerchant.toString());
		node.add(new DialogSequence(myPlayer, merchant, List.of("Would you like to buy this sword for 5 coins?"),
				List.of("I will buy this sword.")));
	}

	@BuilderMethod
	public void buySwordActions() {
		var node = get(NodeLabels.buySword.toString());
		node.add(new DisableInput())
			.add(new Give(myPlayer, coins, merchant))
			.add(new EnableInput())
			.add(new Take(myPlayer, sword, merchant))
			.add(new ListSequence(player, List.of(sword)));
	}

	@BuilderMethod
	public void backAtCityAfterBlacksmithActions() {
		var node = get(NodeLabels.backAtCityAfterBlacksmith.toString());
		node.add(new DisableInput())
			.add(new Exit(myPlayer, blacksmithExitDoor, true))
			.add(new Enter(myPlayer, cityDoor, true))
			.add(new EnableInput());
	}

	@BuilderMethod
	public void libraryActions() {
		var node = get(NodeLabels.library.toString());
		node.add(new DisableInput())
			.add(new Enter(myPlayer, libraryEntranceDoor, true))
			.add(new EnableInput());
	}

	@BuilderMethod
	public void attackWitchAtLibActions() {
		var node = get(NodeLabels.attackWitchAtLib.toString());
		node.add(new DisableInput())
			.add(new Face(myPlayer, witch))
			.add(new Draw(myPlayer, sword))
			.add(new Attack(myPlayer, witch, true))
			.add(new EnableInput());
	}

	

}

