package myclassproject.questexample;

import com.storygraph.Graph;
import com.storygraph.Story;

public class QuestStory extends Story {

	@Override
	public Graph getGraph() {
		return new QuestGraph();
	}


}
