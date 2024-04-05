package myclassproject.main;

import myclassproject.questexample.QuestStory;

public class MainClass {

	//This is the start of your program
	public static void main(String[] args) {
		//Create an object of your story class.
		var story = new QuestStory();
		//Simply call run.
		story.Run();
	}

}
