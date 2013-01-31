package fr.lipn.sts.syntax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import edu.stanford.nlp.ling.TaggedWord;

public class DepPair {
	Vector<Dependency> d1;
	Vector<Dependency> d2;
	
	HashMap<Dependency, Vector<DepAlignment>> alMap; //maps deps to a list of possible (scored) alignments
	
	public DepPair(Vector<Dependency> d1, Vector<Dependency> d2){
		this.d1=d1; this.d2=d2;
		alMap = new HashMap<Dependency, Vector<DepAlignment>>();
	}

	public void setPOStags(ArrayList<TaggedWord> tSentence,
			ArrayList<TaggedWord> tSentence1) {
		
		for(Dependency d : d1) {
			int hp = d.head.getPosition()-1;
			if(hp >= 0){
				d.head.setPOS(tSentence.get(hp).tag());
			}	
			int tp = d.dependent.getPosition()-1;
			d.dependent.setPOS(tSentence.get(tp).tag());
		}
		
		for(Dependency d : d2) {
			int hp = d.head.getPosition()-1;
			if(hp >= 0){
				d.head.setPOS(tSentence.get(hp).tag());
			}	
			int tp = d.dependent.getPosition()-1;
				
			d.dependent.setPOS(tSentence.get(tp).tag());
		}
		
	}
	
	//TODO: calculate dependency alignments (formula dep_sim)
	
	

}